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
import org.rjava.compiler.semantics.representation.stmt.RRetStmt;
import org.rjava.compiler.semantics.representation.stmt.RReturnStmt;
import org.rjava.compiler.semantics.representation.stmt.RReturnVoidStmt;
import org.rjava.compiler.targets.CodeGenerator;
import org.rjava.compiler.targets.CodeStringBuilder;
import org.rjava.compiler.targets.GeneratorOptions;
import org.rjava.compiler.targets.c.runtime.CLanguageRuntime;
import org.rjava.compiler.targets.c.runtime.RuntimeHelpers;
import org.rjava.compiler.util.Tree;
import org.rjava.compiler.util.TreeBreadthFirstIterator;

import soot.Local;
import soot.Value;
import soot.jimple.StaticFieldRef;
import soot.jimple.internal.AbstractStmt;
import soot.jimple.internal.JAssignStmt;

public class CLanguageGenerator extends CodeGenerator {
    public static final boolean OUTPUT_JIMPLE_TO_CONSOLE = false;
    public static final List<String> OUTPUT_CLASS = new ArrayList<String>();
    static {
        //OUTPUT_CLASS.add("org.mmtk.utility.alloc.LargeObjectAllocator");
    }
    
    public static final boolean OUTPUT_C_TO_CONSOLE = false;
    public static final boolean OUTPUT_JIMPLE_WITH_C = true; // as comments
    public static final boolean OUTPUT_JIMPLE_SOURCE = false; // as *.jimple
    
    /*
     * Java spec
     */
    public static final String JAVA_INT = "int32_t";
    public static final String JAVA_LONG = "int64_t";
    public static final String JAVA_SHORT = "int16_t";
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
    
    public static final String C_GLOBAL_VAR_PREFIX = "var_";
    
    public static final String METHOD_SOURCE_SUFFIX = "_methods";
    
    /*
     * stylish
     */
    public static final String INCOMPLETE_IMPLEMENTATION = "***Incomplete Implementation***";
    
    protected CLanguageNameGenerator name = new CLanguageNameGenerator(this);
    protected CLanguageIntrinsicGenerator intrinsic = new CLanguageIntrinsicGenerator(this);
    protected CLanguageRuntime runtime = new CLanguageRuntime(this);
    
    protected RClass currentRClass;
    protected RMethod currentRMethod;
    protected boolean generatingType = false;   // if we are generating type, when referencing other class, we dont include their methods header
    
    protected List<String> translatedCSource = new ArrayList<String>();
    protected List<String> translatedCHeader = new ArrayList<String>();
    protected String mainSource = "";
    protected String mainObj;
   
    protected Map<String, CodeStringBuilder> classInitMap = new HashMap<String, CodeStringBuilder>();
    
    protected Set<String> referencedClasses;
    protected Set<String> referencedMethodClasses;
    
    public CLanguageGenerator() {
        
    }

    @Override
    public void translate(RClass klass)
	    throws RJavaWarning, RJavaError {
        if (OUTPUT_JIMPLE_TO_CONSOLE && OUTPUT_CLASS.contains(klass.getName())) {
            RJavaCompiler.debug("Methods for " + klass.getName());
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
        }
        
        if (OUTPUT_JIMPLE_SOURCE) {
            CodeStringBuilder str = new CodeStringBuilder();
            str.append(klass.getName() + NEWLINE);
            for (RMethod method : klass.getMethods()) {
                str.append(method + "{" + NEWLINE);
                str.increaseIndent();
                str.append("Locals:" + NEWLINE);
                for (RLocal local : method.getLocals()) {
                    str.append(local + NEWLINE);
                }
                str.append("Locals end. + NEWLINE");
                for (RStatement stmt : method.getBody()) {
                    str.append(stmt + NEWLINE);
                }
                str.decreaseIndent();
                str.append("}" + NEWLINE + NEWLINE);
            }
            
            writeTo(str.toString(), RJavaCompiler.outputDir + klass.getName() + ".jimple");
        }
        
        currentRClass = klass;
        
        /*
         * One RJava class org.rjava.A would become several C files
         */
        if (!klass.isInterface()) {
            generateIntrinsic(klass);
            /*
             * A non-interface class org.rjava.A will become org_rjava_A.h, which includes:
             * 1. instance declaration 'struct org_rjava_A', including instance fields
             * 2. class declaration 'struct org_rjava_A_class', including virtual methods (function pointer) 
             * 3. class instance org_rjava_A_class_instance
             * 4. global variables, starting with prefix 'var_'
             */
            generateTypeHeader(klass);
            /*
             * The declarations of methods will become org_rjava_A_methods.h, which includes (in this order)
             * 1. includes related with 2
             * 2. all method declarations
             * 3. includes related with 4
             * 4. inline method definition
             * Note: includes are separated into 2 parts to avoid possible circular includes
             */
            generateMethodHeader(klass);
            /*
             * The definitions of non-inline methods will become org_rjava_A_methods.c
             */
            generateCode(klass);
        } else {
            generateIntrinsic(klass);
            generateInterfaceHeader(klass);
            generateInterfaceBody(klass);
        }
        return;
    }

    /**
     * A Java interface will still need <clinit> to initialize its constants (static final fields)
     * @param klass
     * @throws RJavaError 
     */
    private void generateInterfaceBody(RClass klass) throws RJavaError {
        RMethod clinit = klass.getCLInitMethod();
        
        if (clinit != null) {
            resetReferenceSet();
            
            CodeStringBuilder outInc = new CodeStringBuilder();
            CodeStringBuilder outMain = new CodeStringBuilder();
    
            // get code source
            String cCodeSource = getSource(klass.getName(), ".c");
            
            // include its own header
            outInc.append("#include \"" + getSource(klass.getName(), ".h") + "\"" + NEWLINE);
            // include c std
            for (String cStd : CLanguageRuntime.C_STD_LIB_HEADER) {
                outInc.append(CLanguageRuntime.includeStandardHeader(cStd) + NEWLINE);
            }
            
            outMain.append(NEWLINE);
            
            // generating code for each method           
            outMain.append(commentln(clinit.getKlass().getName() + "." + clinit.getName() + "()"));
            outMain.append(getMethodSignature(clinit, false) + " {" + NEWLINE);
            
            outMain.increaseIndent();
            outMain.appendNoIndent(getMethodBody(clinit));
            outMain.decreaseIndent();
            
            outMain.append("}" + NEWLINE + NEWLINE);
            
            // get referenced
            for (String reference : referencedClasses) {
                outInc.append("#include \"" + reference + ".h\"" + NEWLINE);
            }
            for (String reference : referencedMethodClasses) {
                outInc.append(CLanguageRuntime.includeNonStandardHeader(reference) + ".h" + NEWLINE);
            }
            
            if (OUTPUT_C_TO_CONSOLE) {
                RJavaCompiler.debug("Code output to: " + cCodeSource);
                RJavaCompiler.debug(outInc.toString() + outMain.toString());
            }
            
            writeTo(outInc.toString() + outMain.toString(), RJavaCompiler.outputDir + cCodeSource);
            translatedCSource.add(cCodeSource);
            SemanticMap.interfacesThatNeedInit.add(klass);
        }
    }

    /**
     * A Java interface will become a normal RJava-C-Class, its name will be the C-style class name (no extra suffix)
     * A interface struct contains only function pointers. Constants become global variables
     * @param klass
     * @throws RJavaError
     */
    private void generateInterfaceHeader(RClass klass) throws RJavaError {
        resetReferenceSet();
        
        CodeStringBuilder outInc = new CodeStringBuilder();
        CodeStringBuilder outMain = new CodeStringBuilder();
        
        String cHeaderSource = getSource(klass.getName(), ".h");
        
        // include guard
        outInc.append("#ifndef " + name.get(klass).toUpperCase() + "_H" + NEWLINE);
        outInc.append("#define " + name.get(klass).toUpperCase() + "_H" + NEWLINE);
        
        // include rjava lib
        outInc.append(CLanguageRuntime.includeNonStandardHeader(CLanguageRuntime.RJAVA_CRT + ".h") + NEWLINE);
        
        outMain.append(NEWLINE);
        
        /*
         * Generate interface struct (e.g. org_rjava_test_poly_DoArithmetic_interface)
         * it only has function pointers;
         */
        runtime.addTypedef(name.get(klass));
        outMain.append("struct " + name.get(klass) + CLanguageRuntime.INTERFACE_STRUCT_SUFFIX + " {" + NEWLINE);
        outMain.increaseIndent();
        outMain.append(commentln("function pointers"));
        for (RMethod method : klass.getMethods()) {
            if (!method.isStatic())
                outMain.append(getFunctionPointerForMethod(method) + SEMICOLON + NEWLINE);
        }
        outMain.decreaseIndent();
        outMain.append("} " + SEMICOLON + NEWLINE);
        
        /*
         * generate static final fields
         * 
         */
        for (RField field : klass.getFields()) {
            outMain.append(name.getWithPointerIfProper(field.getType()) + " " + name.get(field) + SEMICOLON + NEWLINE);
        }
        
        /*
         * clinit (if applicable)
         */
        if (klass.getCLInitMethod() != null) {
            outMain.append(getMethodSignature(klass.getCLInitMethod(), true) + SEMICOLON + NEWLINE);
        }
        
        outMain.append("#endif");
        
        // get referenced
        for (String reference : referencedClasses) {
            outInc.append("#include \"" + reference + ".h\"" + NEWLINE);
        }
        
        if (OUTPUT_C_TO_CONSOLE) {
            RJavaCompiler.debug("Header output to: " + cHeaderSource);
            RJavaCompiler.debug(outInc.toString() + outMain.toString());
        }
        
        writeTo(outInc.toString() + outMain.toString(), RJavaCompiler.outputDir + cHeaderSource);
        
        translatedCHeader.add(cHeaderSource);
    }

    protected void generateIntrinsic(RClass klass) {
        // translate intrinsic types, e.g. java.lang.String/Integer, or org.vmmagic.unboxed.Address
        for (RType type : SemanticMap.getAllTypes().values()) {
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
     * @throws RJavaError
     */
    private void generateCode(RClass klass) throws RJavaError {
        resetReferenceSet();
        boolean containsMain = false;
        
        CodeStringBuilder outInc = new CodeStringBuilder();
        CodeStringBuilder outMain = new CodeStringBuilder();

        // get code source
        String cCodeSource = getSource(klass.getName(), METHOD_SOURCE_SUFFIX + ".c");
        
        // include its own header
        outInc.append("#include \"" + getSource(klass.getName(), METHOD_SOURCE_SUFFIX + ".h") + "\"" + NEWLINE);
        // include c std
        for (String cStd : CLanguageRuntime.C_STD_LIB_HEADER) {
            outInc.append(CLanguageRuntime.includeStandardHeader(cStd) + NEWLINE);
        }
        
        outMain.append(NEWLINE);
        
        // generating code for each method
        for (RMethod method : klass.getMethods()) {
            // we already had inline function body in the header
            if (method.isHeuristicInlined() || method.hasInlineAnnotation())
                continue;
            
            // native method will have external implementation
            if (method.isNative())
                continue;
            
            if (method.isMainMethod()) {
                outMain.append(MAIN_METHOD_SIGNATURE + " {" + NEWLINE);
                outMain.increaseIndent();
                // calling class_init();
                outMain.append(RuntimeHelpers.invoke(RuntimeHelpers.CLASS_INIT, null) + SEMICOLON + NEWLINE);
                containsMain = true;
            } else {
                outMain.append(commentln(method.getKlass().getName() + "." + method.getName() + "()"));
                outMain.append(getMethodSignature(method, false) + " {" + NEWLINE);
                outMain.increaseIndent();
            }
            
            outMain.appendNoIndent(getMethodBody(method));
            
            outMain.decreaseIndent();
            outMain.append("}" + NEWLINE + NEWLINE);
        }
        
        // get referenced
        for (String reference : referencedClasses) {
            outInc.append("#include \"" + reference + ".h\"" + NEWLINE);
        }
        for (String reference : referencedMethodClasses) {
            outInc.append(CLanguageRuntime.includeNonStandardHeader(reference + ".h") + NEWLINE);
        }
        
        if (OUTPUT_C_TO_CONSOLE) {
            RJavaCompiler.debug("Code output to: " + cCodeSource);
            RJavaCompiler.debug(outInc.toString() + outMain.toString());
        }
        
        writeTo(outInc.toString() + outMain.toString(), RJavaCompiler.outputDir + cCodeSource);
        translatedCSource.add(cCodeSource);
        if (containsMain) {
            mainSource = cCodeSource;
            setMainObj(name.get(klass));
        }
    }

    /**
     * A Java Class will become a C header and a C source file. The header is generated here. 
     * @param klass
     * @throws RJavaError
     */
    private void generateTypeHeader(RClass klass) throws RJavaError {
        generatingType = true;
        
        resetReferenceSet();
        
        CodeStringBuilder outInc = new CodeStringBuilder();
        CodeStringBuilder outMain = new CodeStringBuilder();
        
        String cHeaderSource = getSource(klass.getName(), ".h");
        
        // include guard
        outInc.append("#ifndef " + name.get(klass).toUpperCase() + "_H" + NEWLINE);
        outInc.append("#define " + name.get(klass).toUpperCase() + "_H" + NEWLINE);
        
        // include rjava lib
        outInc.append(CLanguageRuntime.includeNonStandardHeader(CLanguageRuntime.RJAVA_CRT + ".h") + NEWLINE);
        outInc.append(CLanguageRuntime.includeNonStandardHeader(CLanguageRuntime.RJAVA_LIB + ".h") + NEWLINE);
        
        outMain.append(NEWLINE);
        
        /*
         * Generate instance struct (e.g. org_rjava_test_poly_Animal)
         */
        runtime.addTypedef(name.get(klass));
        outMain.append("struct " + name.get(klass) + " {" + NEWLINE);
        outMain.increaseIndent();
        
        // we contain a struct for its super class object
        // if this class doesnt have super class, we use common instance struct
        if (klass.hasSuperClass()) {
            outMain.append(commentln("contains super instance struct"));
            outMain.append(name.getStruct(klass.getSuperClass()) + " " + CLanguageRuntime.EMBED_SUPER_OBJECT + SEMICOLON + NEWLINE);
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
                outMain.append(getInstanceFieldDeclaration(field) + SEMICOLON + NEWLINE);
        }
        
        outMain.decreaseIndent();
        outMain.append("}" + SEMICOLON + NEWLINE);
        outMain.append(NEWLINE);
        
        /*
         * Generating class struct (e.g. org_rjava_test_poly_Animal_class)
         */
        outMain.append("struct " + name.get(klass) + CLanguageRuntime.CLASS_STRUCT_SUFFIX + " {" + NEWLINE);
        outMain.increaseIndent();
        
        if (klass.hasSuperClass()) {
            // contain a struct for its super class
            outMain.append(commentln("contains super class struct"));
            outMain.append(name.get(klass.getSuperClass()) + CLanguageRuntime.CLASS_STRUCT_SUFFIX + " " + CLanguageRuntime.EMBED_SUPER_CLASS + SEMICOLON + NEWLINE);
            
            // calling rjava_init_header()
            CodeStringBuilder classInitTemp = new CodeStringBuilder();
            String thisClass = "&" + name.get(klass) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX;
            String superClass = "&" + name.get(klass.getSuperClass()) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX;
            String superClassSize = SIZE_OF + "(" + name.get(klass.getSuperClass()) + CLanguageRuntime.CLASS_STRUCT_SUFFIX + ")";
            classInitTemp.append(RuntimeHelpers.invoke(RuntimeHelpers.INIT_HEADER, new String[]{thisClass, superClass, superClassSize}) + SEMICOLON + NEWLINE);
            
            // class_name
            if (RJavaCompiler.debugTarget) {
                classInitTemp.append("((" + CLanguageRuntime.COMMON_CLASS_STRUCT + "*)(&" + name.get(klass) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX + "))");
                classInitTemp.append(" -> " + CLanguageRuntime.CLASS_NAME + " = \"" + name.get(klass) + "\"" + SEMICOLON + NEWLINE);
            }
            
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
            // class_name
            if (RJavaCompiler.debugTarget) {
                classInitTemp.append("((" + CLanguageRuntime.COMMON_CLASS_STRUCT + "*)(&" + name.get(klass) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX + "))");
                classInitTemp.append(" -> " + CLanguageRuntime.CLASS_NAME + " = \"" + name.get(klass) + "\"" + SEMICOLON + NEWLINE);
            }
            
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
                classInitTemp.append(" -> " + name.getFunctionPointerName(method) + " = " + name.get(method) + SEMICOLON + NEWLINE);
                addToClassInitMap(klass.getName(), classInitTemp.toString());
            }
        }
        
        outMain.decreaseIndent();
        outMain.append("} " + SEMICOLON + NEWLINE);
        
        outMain.append(NEWLINE);
        
        // class_instance as global variable
        outMain.append(commentln("class instance"));
        outMain.append(name.get(klass) + CLanguageRuntime.CLASS_STRUCT_SUFFIX + " ");
        outMain.append(name.get(klass) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX + SEMICOLON + NEWLINE);
        outMain.append(NEWLINE);
        
        // generate global fields (static field)
        outMain.append(commentln("static field (global)"));
        for (RField field : klass.getFields()) {
            //if (field.isStatic() && !field.isFinal()) {
            if (field.isStatic()) {
                outMain.append(name.getWithPointerIfProper(field.getType()) + " " + name.get(field) + SEMICOLON + NEWLINE);
            }
        }
        outMain.append(NEWLINE);
        
        // generate constants (static final)
        /*outMain.append(commentln("constants"));
        Map<RField, String> constantValues = getConstantValues(klass);
        if (constantValues != null)
            for (RField f : constantValues.keySet())
                outMain.append("#define " + name.get(f) + " " + constantValues.get(f) + NEWLINE);
        outMain.append(NEWLINE);*/
        
        outMain.append("#endif");
        
        // get referenced
        for (String reference : referencedClasses) {
            outInc.append("#include \"" + reference + ".h\"" + NEWLINE);
        }
        
        if (OUTPUT_C_TO_CONSOLE) {
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
        
        writeTo(outInc.toString() + outMain.toString(), RJavaCompiler.outputDir + cHeaderSource);
        
        translatedCHeader.add(cHeaderSource);
        
        generatingType = false;
    }
    
    private void generateMethodHeader(RClass klass) throws RJavaError {
        resetReferenceSet();
        
        CodeStringBuilder outInc = new CodeStringBuilder();
        CodeStringBuilder outMain = new CodeStringBuilder();
        
        String cHeaderSource = getSource(klass.getName(), METHOD_SOURCE_SUFFIX + ".h");
        
        // include guard
        outInc.append("#ifndef " + name.get(klass).toUpperCase() + METHOD_SOURCE_SUFFIX.toUpperCase() + "_H" + NEWLINE);
        outInc.append("#define " + name.get(klass).toUpperCase() + METHOD_SOURCE_SUFFIX.toUpperCase() + "_H" + NEWLINE);
        
        // include its own type
        outInc.append(CLanguageRuntime.includeNonStandardHeader(getSource(klass.getName(), ".h")) + NEWLINE);
        
        outMain.append(NEWLINE);

        // functions
        outMain.append(commentln("function declarations"));
        for (RMethod method : klass.getMethods()) {
            if (!method.isMainMethod()) {
                outMain.append(getMethodSignature(method, true) + SEMICOLON + NEWLINE);
            }
        }
        outMain.append(NEWLINE);
        
        // get referenced
        for (String reference : referencedClasses) {
            outInc.append("#include \"" + reference + ".h\"" + NEWLINE);
        }
        
        Set<String> oldReferencedClasses = new HashSet<String>();
        oldReferencedClasses.addAll(referencedClasses);
        resetReferenceSet();
        
        // put inline function definition in the header
        CodeStringBuilder outMain2 = new CodeStringBuilder();
        outMain2.append(commentln("inline function definitions"));
        for (RMethod method : klass.getMethods()) {
            if (method.isNative())
                continue;
            
            if (!method.isMainMethod() && method.isHeuristicInlined() || method.hasInlineAnnotation()) {
                outMain2.append(getMethodSignature(method, true) + "{" + NEWLINE);
                outMain2.increaseIndent();
                outMain2.append(getMethodBody(method));
                outMain2.decreaseIndent();
                outMain2.append("}" + NEWLINE + NEWLINE);
            }
        }
        outMain2.append("#endif");
        
        CodeStringBuilder outInc2 = new CodeStringBuilder();
        for (String reference : referencedClasses) {
            if (!oldReferencedClasses.contains(reference))
                outInc2.append(CLanguageRuntime.includeNonStandardHeader(reference + ".h") + NEWLINE);
        }
        for (String reference : referencedMethodClasses) {
            outInc2.append(CLanguageRuntime.includeNonStandardHeader(reference + ".h") + NEWLINE);
        }
        
        if (OUTPUT_C_TO_CONSOLE) {
            RJavaCompiler.debug("Header output to: " + cHeaderSource);
            RJavaCompiler.debug(outInc.toString() + outMain.toString() + outInc2.toString() + outMain2.toString());
        }
        
        writeTo(outInc.toString() + outMain.toString() + outInc2.toString() + outMain2.toString(), RJavaCompiler.outputDir + cHeaderSource);
        
        translatedCHeader.add(cHeaderSource);
    }

    /**
     * fetch constant values, returns pairs of <value_name, value>. So we will #define value_name value
     * @param klass
     * @return
     */
    @Deprecated
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
        
        String tempInterfaceVar = name.get(myInterface) + "_implemented_on_" + name.get(klass); 
        
        // create the C interface for this klass
        // we have already allocated the interface before, thus we skip
        classInitTemp.append(name.get(myInterface) + CLanguageRuntime.INTERFACE_STRUCT_SUFFIX + "* " + tempInterfaceVar + " = ");
        classInitTemp.append(MALLOC + "(sizeof(" + name.get(myInterface) + CLanguageRuntime.INTERFACE_STRUCT_SUFFIX + "))" + SEMICOLON + NEWLINE);
        
        // link its function pointers
        for (RMethod interfaceMethod : myInterface.getMethods()) {
            if (interfaceMethod.isClassInitializer() || interfaceMethod.isConstructor())
                continue;
            
            classInitTemp.append(tempInterfaceVar + " -> " + name.getFunctionPointerName(interfaceMethod));
            classInitTemp.append(" = " + name.get(klass.getImplementingMethodOfAnInterfaceMethod(interfaceMethod)) + SEMICOLON + NEWLINE);
        }

        if (rewrite) {
            // rewrite
            // void rjava_alter_interface(void* interface, char* name, RJava_Common_Class* class);
            String tempClassVar = "(" + CLanguageRuntime.COMMON_CLASS_STRUCT + "*)&" + name.get(klass) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX;
            String tempInterfaceName = "\"" + name.get(myInterface) + "\"";
            classInitTemp.append(RuntimeHelpers.invoke(RuntimeHelpers.ALTER_INTERFACE, new String[]{tempInterfaceVar, tempInterfaceName, tempClassVar}) + SEMICOLON + NEWLINE);
        }else {
            // add this interface to class
            // void rjava_add_interface_to_class(void* interface, int interface_size, char* name, RJava_Common_Class* class);
            String interfaceSize = SIZE_OF + "(" + name.get(myInterface) + ")";
            String tempInterfaceName = "\"" + name.get(myInterface) + "\"";
            String tempClassVar = "(" + CLanguageRuntime.COMMON_CLASS_STRUCT + "*)&" + name.get(klass) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX;
            classInitTemp.append(RuntimeHelpers.invoke(RuntimeHelpers.ADD_INTERFACE_TO_CLASS, 
                    new String[]{tempInterfaceVar, interfaceSize, tempInterfaceName, tempClassVar}) + SEMICOLON + NEWLINE);
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
       out.append("(*" + name.getFunctionPointerNameFromSootMethod(method.internal()) + ") ");
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
    
    public String getInstanceFieldDeclaration(RField field) {
        if (!RJavaCompiler.OPT_OBJECT_INLINING || !field.isInlinable())
            return (name.getWithPointerIfProper(field.getType()) + " " + name.get(field));
        else return name.get(field.getType()) + " " + name.get(field);
    }
    
    /**
     * 
     * @param method
     * @param declaration true if this is for method declaration (otherwise definition)
     * @return
     */
    public String getMethodSignature(RMethod method, boolean declaration) {
        CodeStringBuilder out = new CodeStringBuilder();
        
        // inline if needed
        if (declaration && (method.isHeuristicInlined() || method.hasInlineAnnotation()))
            out.append(CLanguageRuntime.ALWAYS_INLINE + " ");
        
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
    
    public String getMethodBody(RMethod method) throws RJavaError {
        String prologue = "";
        if (RJavaCompiler.LOG_FUNCTION_EXECUTION) {
            prologue = RuntimeHelpers.invoke(RuntimeHelpers.DEBUG_LOG_FUNC_EXEC, new String[]{"__func__"}) + SEMICOLON + NEWLINE;
        }
        
        if (method.isIntrinsic())
            return prologue + method.getCode();
        
        currentRMethod = method;
        
        try {
            CodeStringBuilder out = new CodeStringBuilder();
            out.increaseIndent();
            
            CLanguageStatementGenerator stmt = new CLanguageStatementGenerator(this);
            out.append(commentln("locals"));
            for (RLocal local : method.getLocals()) {
                out.append(stmt.get(local) + SEMICOLON + NEWLINE);
            }
            out.append(NEWLINE);
            out.append(commentln("stmts"));
            
            if (method.isSynchronized()) {
                if (!method.isStatic()) {
                    // lock on instance monitor
                    out.append("pthread_mutex_lock(&(((" + CLanguageRuntime.COMMON_INSTANCE_STRUCT + "*) " + THIS_PARAMETER + ") -> " + CLanguageRuntime.INSTANCE_MUTEX + "))" + SEMICOLON + NEWLINE);
                } else {
                    // lock on class monitor
                    out.append("pthread_mutex_lock(&(((" + CLanguageRuntime.COMMON_CLASS_STRUCT + "*)(&" + name.get(method.getKlass()) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX + ")) -> " + CLanguageRuntime.CLASS_MUTEX + "))" + SEMICOLON + NEWLINE);
                }
            }     
            
            boolean firstStmt = true;
            for (RStatement rStmt : method.getBody()) {
                if (OUTPUT_JIMPLE_WITH_C)
                    out.append(commentln("[" + rStmt.internal().getClass().toString() + "]" + rStmt.toString()));
    
                
                if (rStmt.isIntrinsic())
                    out.append(rStmt.getCode() + SEMICOLON + NEWLINE);
                else {
                    // if this method is a constructor, we set class_struct for this instance first
                    /*if (firstStmt && method.isConstructor()) {
                        out.append("((" + CLanguageRuntime.COMMON_INSTANCE_STRUCT + "*)" + THIS_PARAMETER + ") -> " + CLanguageRuntime.POINTER_TO_CLASS_STRUCT + " = &" + name.get(method.getKlass()) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX + SEMICOLON + NEWLINE);
                        firstStmt = false;
                    }*/
                    
                    // if this method is synchronized, then we need to unlock mutex before returning
                    if (method.isSynchronized() && (rStmt instanceof RRetStmt || rStmt instanceof RReturnStmt || rStmt instanceof RReturnVoidStmt)) {
                        // unlock mutex
                        if (!method.isStatic()) {
                            // unlock on instance monitor
                            out.append("pthread_mutex_unlock(&(((" + CLanguageRuntime.COMMON_INSTANCE_STRUCT + "*) " + THIS_PARAMETER + ") -> " + CLanguageRuntime.INSTANCE_MUTEX + "))" + SEMICOLON + NEWLINE);
                        } else {
                            // unlock on class monitor
                            out.append("pthread_mutex_unlock(&(((" + CLanguageRuntime.COMMON_CLASS_STRUCT + "*)(&" + name.get(method.getKlass()) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX + ")) -> " + CLanguageRuntime.CLASS_MUTEX + "))" + SEMICOLON + NEWLINE);
                        }
                    }
                    
                    out.append(stmt.get(rStmt) + SEMICOLON + NEWLINE);
                    
                    // if we called super constructor, then will need to set class_struct back
                    /*if (method.isConstructor() && rStmt.containsInvokeExpr() && rStmt.getInvokeExpr().isCallingSuperConstructor())
                        out.append("((" + CLanguageRuntime.COMMON_INSTANCE_STRUCT + "*)" + THIS_PARAMETER + ") -> " + CLanguageRuntime.POINTER_TO_CLASS_STRUCT + " = &" + name.get(method.getKlass()) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX + SEMICOLON + NEWLINE);
                        */
                    
                    // if this stmt creates new object, we need its class
                    if (rStmt.isObjectCreation()) {
                        JAssignStmt sootStmt = (JAssignStmt) rStmt.internal();
                        String classStruct = codeGetClassStruct(name.fromSootLocal((Local) ((JAssignStmt)sootStmt).getLeftOp()));
                        String classStructInstance = name.get(rStmt.getCreatedObjectClass()) + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX;
                        out.append(classStruct + " = &" + classStructInstance + SEMICOLON + NEWLINE);
                    }
                }            
            }
    
            return prologue + out.toString();
        } finally {
            currentRMethod = null;
        }
    }
    
    public static String codeGetClassStruct(String instance) {
        return "((" + CLanguageRuntime.COMMON_INSTANCE_STRUCT + "*)" + instance + ") -> " + CLanguageRuntime.POINTER_TO_CLASS_STRUCT;
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
        runtime.copyJavaLibrary();
        runtime.generateGNUMakefile();
    }
    
    protected void resetReferenceSet() {
        referencedClasses = new HashSet<String>();
        referencedMethodClasses = new HashSet<String>();
    }
    
    /**
     * current compiling class is referencing another class
     * @param klass
     */    
    public void referencing(RClass klass) {
        if (!currentRClass.equals(klass)) {
            // we need to reference this klass
            String typeHeader = name.javaNameToCName(klass.getName());
            referencedClasses.add(CodeGenerator.escapeDollarInFileName(typeHeader));
        }
    }
    
    public void referencing(RType type) {
        referencing(RClass.fromClassName(type.getClassName()));
    }
    
    public void referencing(RMethod method) {
        RClass declaringClass = method.getKlass();
        if (!currentRClass.equals(declaringClass)) {
            if (SemanticMap.isApplicationClass(declaringClass.getName())) {
                String methodHeader = null;
                if (method.getKlass().isInterface()) {
                    methodHeader = name.javaNameToCName(declaringClass.getName());
                    referencedClasses.add(CodeGenerator.escapeDollarInFileName(methodHeader));
                } else {
                    methodHeader = name.javaNameToCName(declaringClass.getName()) + METHOD_SOURCE_SUFFIX;
                    referencedMethodClasses.add(CodeGenerator.escapeDollarInFileName(methodHeader));
                }
            }
        }
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
        if (this.mainObj != null) {
            RJavaCompiler.warning("trying overwrite mainObj from " + this.mainObj + " to " + mainObj + ", ignored!");
            return;
        }
        
        this.mainObj = mainObj;
    }

    public Map<String, CodeStringBuilder> getClassInitMap() {
        return classInitMap;
    }

    public CLanguageIntrinsicGenerator getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(CLanguageIntrinsicGenerator intrinsic) {
        this.intrinsic = intrinsic;
    }

    @Override
    public void processCommandlineOptions(String arg) throws RJavaError, RJavaWarning {
        if (arg.contains("-target:mm=")) {
            String mm = arg.replaceAll("-target:mm=", "");
            if (mm.equals("boehm"))
                CLanguageRuntime.memoryManagement = CLanguageRuntime.GC_MALLOC;
            else if (mm.equals("boehm-prebuilt"))
                CLanguageRuntime.memoryManagement = CLanguageRuntime.GC_MALLOC_PREBUILT;
            else if (mm.equals("malloc"))
                CLanguageRuntime.memoryManagement = CLanguageRuntime.DEFAULT_MALLOC;
            else throw new RJavaError("Unrecognized memory management: " + mm);
        }
    }

    @Override
    public void init() {
        CLanguageRuntime.lateCLInit();
        this.mainObj = RJavaCompiler.namedOutput;
    }
    
    public RClass getClassContext() {
        return currentRClass;
    }
    
    public RMethod getMethodContext() {
        return currentRMethod;
    }
}
