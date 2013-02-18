package org.rjava.compiler.targets.c;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.rjava.compiler.Constants;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.exception.RJavaError;
import org.rjava.compiler.exception.RJavaWarning;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RField;
import org.rjava.compiler.semantics.representation.RLocal;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.RType;
import org.rjava.compiler.semantics.representation.stmt.RAssignStmt;
import org.rjava.compiler.targets.CodeGenerator;
import org.rjava.compiler.targets.CodeStringBuilder;
import org.rjava.compiler.targets.c.runtime.CLanguageRuntime;
import org.rjava.compiler.util.Tree;
import org.rjava.compiler.util.TreeBreadthFirstIterator;

import soot.Value;
import soot.jimple.StaticFieldRef;
import soot.jimple.internal.JAssignStmt;

public class CLanguageGenerator extends CodeGenerator {
    /*
     * C keyword / reserves
     */
    public static final String NEWLINE = "\n";
    public static final String SEMICOLON = ";";
    public static final String VOID = "void";
    public static final String POINTER = "*";
    public static final String FIELD_POINTER = "->";
    public static final String THIS_LOCAL = "this";
    public static final String RETURN = "return";
    public static String MALLOC = "malloc";       // may use gcmalloc instead
    public static final String SIZE_OF = "sizeof";

    public static final String MAIN_METHOD_SIGNATURE = "int main (int argc, char** parameter0)";
    
    /*
     * RJava's C Naming
     */
    public static final String FORMAL_PARAMETER = "parameter";
    public static final String THIS_PARAMETER = "this_parameter";
    public static final String RJAVA_INIT = "rjinit";
    public static final String RJAVA_CLINIT = "rjclinit";
    
    /*
     * stylish
     */
    public static final String INCOMPLETE_IMPLEMENTATION = "***Incomplete Implementation***";
    
    CLanguageNameGenerator name = new CLanguageNameGenerator(this);
    CLanguageIntrinsicGenerator intrinsic = new CLanguageIntrinsicGenerator(this);
    CLanguageRuntime runtime = new CLanguageRuntime(this);
    
    String cHeaderSource;
    String cCodeSource;
    RClass currentRClass;
    
    List<String> translatedCSource = new ArrayList<String>();
    List<String> translatedCHeader = new ArrayList<String>();
    String mainSource = "";
    String mainObj = "";
   
    Map<String, CodeStringBuilder> classInitMap = new HashMap<String, CodeStringBuilder>();
    
    Set<String> referencedClasses;

    @Override
    public void translate(RClass klass, String source)
	    throws RJavaWarning, RJavaError {
        if (RJavaCompiler.DEBUG)
            for (RMethod method : klass.getMethods()) {
                RJavaCompiler.debug(method + "{");
                RJavaCompiler.debug("Locals:");
                for (RLocal local : method.getLocals()) {
                    RJavaCompiler.debug(local);
                }
                RJavaCompiler.debug("Locals end. ");
                for (RStatement stmt : method.getBody()) {
                    RJavaCompiler.debug("  " + stmt);
                }
                RJavaCompiler.debug("}");
            }
        
        currentRClass = klass;
        if (!klass.isInterface()) {
            generateIntrinsic(klass, source);
            generateHeader(klass, source);
            generateCode(klass, source);
        } else {
            generateInterface(klass, source);
        }
    }

    /**
     * A Java interface will become a normal RJava-C-Class, its name will be the C-style class name (no extra suffix)
     * A interface struct contains only function pointers. Constants become global variables (not finished yet)
     * @param klass
     * @param source
     * @throws RJavaError
     */
    private void generateInterface(RClass klass, String source) throws RJavaError {
        referencedClasses = new HashSet<String>();
        
        CodeStringBuilder outInc = new CodeStringBuilder();
        CodeStringBuilder outMain = new CodeStringBuilder();
        
        cHeaderSource = getSource(source, ".h");
        
        // include guard
        outInc.append("#ifndef " + name.get(klass).toUpperCase() + "_H" + NEWLINE);
        outInc.append("#define " + name.get(klass).toUpperCase() + "_H" + NEWLINE);
        
        // include rjava lib
        outInc.append(CLanguageRuntime.RJAVA_RUNTIME_INCLUDE + NEWLINE);
        
        outMain.append(NEWLINE);
        
        /*
         * Generate interface struct (e.g. org_rjava_test_poly_DoArithmetic_interface)
         * it only has function pointers;
         */
        outMain.append("typedef struct " + name.get(klass) + CLanguageRuntime.INTERFACE_STRUCT_SUFFIX + " {" + NEWLINE);
        outMain.increaseIndent();
        outMain.append(commentln("function pointers"));
        for (RMethod method : klass.getMethods()) {
            outMain.append(getFunctionPointerForMethod(method) + SEMICOLON + NEWLINE);
        }
        outMain.decreaseIndent();
        outMain.append("} " + name.get(klass) + CLanguageRuntime.INTERFACE_STRUCT_SUFFIX + SEMICOLON + NEWLINE);
        
        // TODO: generate other global fields
        
        outMain.append("#endif");
        
        // get referenced
        for (String reference : referencedClasses) {
            outInc.append("#include \"" + reference + ".h\"" + NEWLINE);
        }
        
        if (RJavaCompiler.DEBUG) {
            RJavaCompiler.debug("Header output to: " + cHeaderSource);
            RJavaCompiler.debug(outInc.toString() + outMain.toString());
        }
        
        writeTo(outInc.toString() + outMain.toString(), Constants.OUTPUT_DIR + cHeaderSource);
        
        translatedCHeader.add(cHeaderSource);
    }

    private void generateIntrinsic(RClass klass, String source) {
        // translate intrinsic types, e.g. java.lang.String/Integer, or org.vmmagic.unboxed.Address
        for (RType type : SemanticMap.types.values()) {
            intrinsic.generate(type);
        }
        
        // translate intrinsic statement
        for (RMethod method : klass.getMethods()) {
            intrinsic.generate(method);
            
            if (!method.isIntrinsic()) {
                for (RStatement stmt : method.getBody()) {
                    intrinsic.generate(stmt);
                }
            }
        }
    }

    /**
     * A Java Class will become a C header and a C source file. The source file is generated here. 
     * @param klass
     * @param source
     * @throws RJavaError
     */
    private void generateCode(RClass klass, String source) throws RJavaError {
        referencedClasses = new HashSet<String>();
        boolean containsMain = false;
        
        CodeStringBuilder outInc = new CodeStringBuilder();
        CodeStringBuilder outMain = new CodeStringBuilder();

        // get code source
        cCodeSource = getSource(source, ".c");
        
        // include its own header
        outInc.append("#include \"" + cHeaderSource + "\"" + NEWLINE);
        // include c std
        outInc.append(CLanguageRuntime.INCLUDE_STDIO + NEWLINE);
        outInc.append(CLanguageRuntime.INCLUDE_STDLIB + NEWLINE);
        outInc.append(CLanguageRuntime.INCLUDE_STDBOOL + NEWLINE);
        
        outMain.append(NEWLINE);
        
        // generating code for each method
        for (RMethod method : klass.getMethods()) {
            if (method.isMainMethod()) {
                outMain.append(MAIN_METHOD_SIGNATURE + " {" + NEWLINE);
                outMain.increaseIndent();
                // calling class_init();
                outMain.append(CLanguageRuntime.RJAVA_CLASS_INIT + "()" + SEMICOLON + NEWLINE);
                containsMain = true;
            } else {
                outMain.append(getMethodSignature(method) + " {" + NEWLINE);
                outMain.increaseIndent();
            }
            
            if (method.isIntrinsic()) {
                outMain.append(method.getCode());
            } else outMain.appendNoIndent(getMethodBody(method));
            
            outMain.decreaseIndent();
            outMain.append("}" + NEWLINE + NEWLINE);
        }
        
        // get referenced
        for (String reference : referencedClasses) {
            outInc.append("#include \"" + reference + ".h\"" + NEWLINE);
        }
        
        if (RJavaCompiler.DEBUG) {
            RJavaCompiler.debug("Code output to: " + cCodeSource);
            RJavaCompiler.debug(outInc.toString() + outMain.toString());
        }
        
        writeTo(outInc.toString() + outMain.toString(), Constants.OUTPUT_DIR + cCodeSource);
        translatedCSource.add(cCodeSource);
        if (containsMain) {
            mainSource = cCodeSource;
            mainObj = name.get(klass);
        }
    }

    /**
     * A Java Class will become a C header and a C source file. The header is generated here. 
     * @param klass
     * @param source
     * @throws RJavaError
     */
    private void generateHeader(RClass klass, String source) throws RJavaError {
        referencedClasses = new HashSet<String>();
        
        CodeStringBuilder outInc = new CodeStringBuilder();
        CodeStringBuilder outMain = new CodeStringBuilder();
        
        cHeaderSource = getSource(source, ".h");
        
        // include guard
        outInc.append("#ifndef " + name.get(klass).toUpperCase() + "_H" + NEWLINE);
        outInc.append("#define " + name.get(klass).toUpperCase() + "_H" + NEWLINE);
        
        // include rjava lib
        outInc.append(CLanguageRuntime.RJAVA_RUNTIME_INCLUDE + NEWLINE);
        outInc.append(CLanguageRuntime.RJAVA_LIB_INCLUDE + NEWLINE);
        
        outMain.append(NEWLINE);
        /*
         * Generate instance struct (e.g. org_rjava_test_poly_Animal)
         */
        outMain.append("typedef struct " + name.get(klass) + " " + name.get(klass) + SEMICOLON + NEWLINE);
        outMain.append("struct " + name.get(klass) + " {" + NEWLINE);
        outMain.increaseIndent();
        
        // we contain a struct for its super class object
        // if this class doesnt have super class, we use common instance struct
        if (klass.hasSuperClass()) {
            outMain.append(commentln("contains super instance struct"));
            outMain.append(name.get(klass.getSuperClass()) + " " + CLanguageRuntime.EMBED_SUPER_OBJECT + SEMICOLON + NEWLINE);
        } else {
            outMain.append(commentln("contains common instance struct"));
            outMain.append(CLanguageRuntime.COMMON_INSTANCE_STRUCT + " " + CLanguageRuntime.EMBED_SUPER_OBJECT + SEMICOLON + NEWLINE);
        }
        outMain.append(NEWLINE);
        
        /*
         * Generating instance field
         */
        outMain.append(commentln("instance fields"));
        for (RField field : klass.getFields()) {
            if (!field.isStatic())
                outMain.append(name.getWithPointerIfProper(field.getType()) + " " + name.get(field) + SEMICOLON + NEWLINE);
        }
        
        outMain.decreaseIndent();
        outMain.append("}" + SEMICOLON + NEWLINE);
        outMain.append(NEWLINE);
        
        /*
         * Generating class struct (e.g. org_rjava_test_poly_Animal_class)
         */
        outMain.append("typedef struct " + name.get(klass) + CLanguageRuntime.CLASS_STRUCT_SUFFIX + " {" + NEWLINE);
        outMain.increaseIndent();
        
        if (klass.hasSuperClass()) {
            // contain a struct for its super class
            outMain.append(commentln("contains super class struct"));
            outMain.append(name.get(klass.getSuperClass()) + CLanguageRuntime.CLASS_STRUCT_SUFFIX + " " + CLanguageRuntime.EMBED_SUPER_CLASS + SEMICOLON + NEWLINE);
            
            // and set its header to super class
            CodeStringBuilder classInitTemp = new CodeStringBuilder();
            classInitTemp.append(CLanguageRuntime.RJAVA_INIT_HEADER + "(&");
            classInitTemp.append(name.get(klass) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX + ",&" + name.get(klass.getSuperClass()) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX);
            classInitTemp.append("," + SIZE_OF + "(" + name.get(klass.getSuperClass()) + CLanguageRuntime.CLASS_STRUCT_SUFFIX + "))" + SEMICOLON + NEWLINE);
            addToClassInitMap(klass.getName(), classInitTemp.toString());
        } else {
            // contains common class struct
            outMain.append(commentln("contains common class struct"));
            outMain.append(CLanguageRuntime.COMMON_CLASS_STRUCT + " " + CLanguageRuntime.EMBED_SUPER_CLASS + SEMICOLON + NEWLINE);
            
            // this class has no super class, thus we initialize super and interface to NULL
            CodeStringBuilder classInitTemp = new CodeStringBuilder();
            // super_class = NULL
            classInitTemp.append("((" + CLanguageRuntime.COMMON_CLASS_STRUCT + "*)(&" + name.get(klass) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX + "))");
            classInitTemp.append(" -> " + CLanguageRuntime.SUPER_CLASS + " = NULL" + SEMICOLON + NEWLINE);
            // interfaces = NULL
            classInitTemp.append("((" + CLanguageRuntime.COMMON_CLASS_STRUCT + "*)(&" + name.get(klass) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX + "))");
            classInitTemp.append(" -> " + CLanguageRuntime.INTERFACE_LIST + " = NULL" + SEMICOLON + NEWLINE);
            addToClassInitMap(klass.getName(), classInitTemp.toString());
        }
        outMain.append(NEWLINE);
        
        outMain.append(commentln("function pointers"));
        for (RMethod method : klass.getMethods()) {
            // if a method is 
            // 1. not static
            // 2. not overriden (declared in super class)
            // 3. not constructor (this is implementation policy, which may be changed later)
            // then we put it in the class struct
            if (!method.isStatic() && !method.isOverridingMethod() && !method.isConstructor()) {
                outMain.append(getFunctionPointerForMethod(method) + SEMICOLON + NEWLINE);
            }
            // for virtual non-contructor method, we link their function ptr in class struct
            if (!method.isStatic() && !method.isConstructor()) {
                RClass target = RClass.whoOwnsMethodInTypeHierarchy(method.getKlass(), method);
                // we need to type cast the class instance to its super most class instance, and then set function ptr
                CodeStringBuilder classInitTemp = new CodeStringBuilder();
                classInitTemp.append("((" + name.get(target) + CLanguageRuntime.CLASS_STRUCT_SUFFIX + "*)");
                classInitTemp.append("(&" + name.get(klass) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX + "))");
                classInitTemp.append(" -> " + method.getName() + " = " + name.get(method) + SEMICOLON + NEWLINE);
                addToClassInitMap(klass.getName(), classInitTemp.toString());
            }
        }
        
        outMain.decreaseIndent();
        outMain.append("} " + name.get(klass) + CLanguageRuntime.CLASS_STRUCT_SUFFIX + SEMICOLON + NEWLINE);
        
        outMain.append(NEWLINE);
        
        // global variable
        outMain.append(commentln("class instance"));
        outMain.append(name.get(klass) + CLanguageRuntime.CLASS_STRUCT_SUFFIX + " ");
        outMain.append(name.get(klass) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX + SEMICOLON + NEWLINE);
        outMain.append(NEWLINE);
        
        // generate other global fields (static field)
        outMain.append(commentln("static field (global)"));
        for (RField field : klass.getFields()) {
            if (field.isStatic() && !field.isFinal()) {
                outMain.append(name.getWithPointerIfProper(field.getType()) + " " + name.get(field) + SEMICOLON + NEWLINE);
            }
        }
        outMain.append(NEWLINE);
        
        // generate constants (static final)
        outMain.append(commentln("constants"));
        Map<RField, String> constantValues = getConstantValues(klass);
        if (constantValues != null)
            for (RField f : constantValues.keySet())
                outMain.append("#define " + name.get(f) + " " + constantValues.get(f) + NEWLINE);
        outMain.append(NEWLINE);
        
        // functions
        outMain.append(commentln("function definitions"));
        for (RMethod method : klass.getMethods()) {
            if (!method.isMainMethod()) {
                outMain.append(getMethodSignature(method) + SEMICOLON + NEWLINE);
            }
        }
        
        outMain.append("#endif");
        
        // get referenced
        for (String reference : referencedClasses) {
            outInc.append("#include \"" + reference + ".h\"" + NEWLINE);
        }
        
        if (RJavaCompiler.DEBUG) {
            RJavaCompiler.debug("Header output to: " + cHeaderSource);
            RJavaCompiler.debug(outInc.toString() + outMain.toString());
        }
        
        // check if the class implements any interface. If so, we will init those interfaces in class_init()
        if (klass.hasInterfaces()) {
            for(RClass myInterface : klass.getInterfaces()) {
                getInterfaceInitCode(klass, myInterface, false);
            }
        }
        if (klass.hasInheritedInterfaces()) {
            for(RClass myInterface : klass.getInheritedInterfaces()) {
                if (klass.hasOverridingMethodsFromInterface(myInterface)) {
                    getInterfaceInitCode(klass, myInterface, true);
                }
            }
        }
        
        writeTo(outInc.toString() + outMain.toString(), Constants.OUTPUT_DIR + cHeaderSource);
        
        translatedCHeader.add(cHeaderSource);
    }

    /**
     * fetch constant values, returns pairs of <value_name, value>. So we will #define value_name value
     * @param klass
     * @return
     */
    private Map<RField, String> getConstantValues(RClass klass) {
        HashMap<RField, String> ret = new HashMap<RField, String>();
        
        for (RField f : klass.getFields())
            if (f.isFinal() && f.isStatic())
                ret.put(f, INCOMPLETE_IMPLEMENTATION);
        
        if (ret.size() == 0)
            return null;
                
        for (RStatement stmt: klass.getCLInitMethod().getBody()) {
            if (stmt instanceof RAssignStmt) {
                JAssignStmt sootStmt = ((RAssignStmt) stmt).internal();
                for (RField f : ret.keySet()) {
                    if (sootStmt.getLeftOp() instanceof soot.jimple.StaticFieldRef && f.getName().equals(((StaticFieldRef) sootStmt.getLeftOp()).getField().getName())) {
                        ret.put(f, name.fromSootValue(sootStmt.getRightOp()));
                        stmt.setIntrinsic(true);
                        stmt.setCode(comment("constant definition for " + f.getName()));
                    }
                }
            }
        }
        
        return ret;
    }

    /**
     * generating class init code for RClass:klass on interface:myInterface. 
     * @param klass
     * @param myInterface
     * @param rewrite true if we add such interface, otherwise change the old interface pointer
     */
    private void getInterfaceInitCode(RClass klass, RClass myInterface, boolean rewrite) {
        CodeStringBuilder classInitTemp = new CodeStringBuilder();
        
        // create the C interface for this klass
        String tempInterfaceVar = name.get(myInterface) + "_implemented_on_" + name.get(klass); 
        classInitTemp.append(name.get(myInterface) + CLanguageRuntime.INTERFACE_STRUCT_SUFFIX + "* " + tempInterfaceVar + " = ");
        classInitTemp.append(MALLOC + "(sizeof(" + name.get(myInterface) + CLanguageRuntime.INTERFACE_STRUCT_SUFFIX + "))" + SEMICOLON + NEWLINE);
        
        // link its function pointers
        for (RMethod interfaceMethod : myInterface.getMethods()) {
            classInitTemp.append(tempInterfaceVar + " -> " + interfaceMethod.getName());
            classInitTemp.append(" = " + name.get(klass.getImplenetingMethodOfAnInterfaceMethod(interfaceMethod)) + SEMICOLON + NEWLINE);
        }

        if (rewrite) {
            // rewrite
            // void rjava_alter_interface(void* interface, char* name, RJava_Common_Class* class);
            classInitTemp.append(CLanguageRuntime.RJAVA_ALTER_INTERFACE + "(" + tempInterfaceVar + ",\"" + name.get(myInterface) + "\",");
            classInitTemp.append("(" + CLanguageRuntime.COMMON_CLASS_STRUCT + "*)&" + name.get(klass) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX + ")" + SEMICOLON + NEWLINE);
        }else {
            // add this interface to class
            // void rjava_add_interface_to_class(void* interface, int interface_size, char* name, RJava_Common_Class* class);
            classInitTemp.append(CLanguageRuntime.RJAVA_ADD_INTERFACE_TO_CLASS + "(" + tempInterfaceVar + "," + SIZE_OF + "(" + name.get(myInterface) + "),");
            classInitTemp.append("\"" + name.get(myInterface)+ "\",");
            classInitTemp.append("(" + CLanguageRuntime.COMMON_CLASS_STRUCT + "*)&" + name.get(klass) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX + ")" + SEMICOLON + NEWLINE);
        }
        
        addToClassInitMap(klass.getName(), classInitTemp.toString());
    }
    
    /**
     * generate function pointer to RMethod
     * @param method
     * @return
     */
    private String getFunctionPointerForMethod(RMethod method) {
       CodeStringBuilder out = new CodeStringBuilder();
       // return
       out.append(name.getWithPointerIfProper(method.getReturnType()) + " ");
       // function ptr name
       out.append("(*" + method.getName() + ") ");
       // parameter list
       out.append("(");
       out.append(VOID + POINTER + " " + THIS_PARAMETER);
       for (int i = 0; i < method.getParameters().size(); i++) {
           out.append(", ");
           out.append(name.getWithPointerIfProper(method.getParameters().get(i)) + " " + FORMAL_PARAMETER + i);   
       }
       out.append(")");
       return out.toString();
    }

    /**
     * Generate source path for compiled file
     * @param origin source stored in CompilationTask
     * @param ext new extension for compiled file
     * @return
     */
    private String getSource(String origin, String ext) {
        String ret = origin.replace(RJavaCompiler.currentTask.getPath(), "");
        ret = ret.replace(Constants.RJAVA_EXT, ext);
        ret = ret.replaceAll("/", "_");
        return ret;
    }   
    
    public String getMethodSignature(RMethod method) {
        CodeStringBuilder out = new CodeStringBuilder();
        if (method.shouldBeInlined())
            out.append("inline ");
        out.append(name.getWithPointerIfProper(method.getReturnType()) + " ");
        out.append(name.get(method) + " (");
        // if not static, the first parameter will be 'this'
        if (!method.isStatic()) {
            out.append(VOID + POINTER + " " + THIS_PARAMETER); 
            if (method.getParameters().size() > 0)
                out.append(", ");
        }
        for (int i = 0; i < method.getParameters().size(); i++) {
            out.append(name.getWithPointerIfProper(method.getParameters().get(i)) + " " + FORMAL_PARAMETER + i);
            if (i < method.getParameters().size() - 1)
                out.append(", ");
        }
        out.append(")");
        return out.toString();
    }
    
    public String getMethodBody(RMethod method) {
        CodeStringBuilder out = new CodeStringBuilder();
        out.increaseIndent();
        
        CLanguageStatementGenerator stmt = new CLanguageStatementGenerator(this);
        out.append(commentln("locals"));
        for (RLocal local : method.getLocals()) {
            out.append(stmt.get(local) + SEMICOLON + NEWLINE);
        }
        out.append(NEWLINE);
        out.append(commentln("stmts"));
        for (RStatement rStmt : method.getBody()) {
            if (rStmt.isIntrinsic())
                out.append(rStmt.getCode());
            else {
                if (method.isConstructor() && rStmt.isReturnStmt()) 
                    out.append("((" + CLanguageRuntime.COMMON_INSTANCE_STRUCT + "*)" + THIS_LOCAL + ") -> " + CLanguageRuntime.POINTER_TO_CLASS_STRUCT + " = &" + name.get(method.getKlass()) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX + SEMICOLON + NEWLINE);
                out.append(stmt.get(rStmt));
            }
            
            out.appendNoIndent(SEMICOLON + NEWLINE);
        }
        return out.toString();
    }
    
    public static String commentln(String s) {
        return "/* " + s + " */" + NEWLINE;
    }
    
    public static String comment(String s) {
        return "//" + s;
    }

    @Override
    public void postTranslationWork() throws RJavaWarning, RJavaError {
        runtime.generateCRuntime();
    }
    
    public void referencing(String refName) {
        if (refName.startsWith("java_") || refName.startsWith("javax_"))
            return;
        
        // avoid adding include for current class
        if (!name.javaNameToCName(currentRClass.getName()).equals(refName))
            referencedClasses.add(refName);
    }
    
    private void addToClassInitMap(String rClassName, String initStmt) {
        if (classInitMap.containsKey(rClassName)) {
            CodeStringBuilder value = classInitMap.get(rClassName);
            value.append(initStmt);
            classInitMap.put(rClassName, value);
        } else {
            CodeStringBuilder newValue = new CodeStringBuilder();
            newValue.append(initStmt);
            classInitMap.put(rClassName, newValue);
        }
    }

    public List<String> getTranslatedCSource() {
        return translatedCSource;
    }

    public List<String> getTranslatedCHeader() {
        return translatedCHeader;
    }

    public String getMainObj() {
        return mainObj;
    }

    public void setMainObj(String mainObj) {
        this.mainObj = mainObj;
    }

    public Map<String, CodeStringBuilder> getClassInitMap() {
        return classInitMap;
    }
}
