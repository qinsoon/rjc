package org.rjava.compiler.targets.c;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
import org.rjava.compiler.semantics.representation.stmt.RIdentityStmt;
import org.rjava.compiler.semantics.representation.stmt.RInvokeStmt;
import org.rjava.compiler.targets.CodeGenerator;

import soot.SootClass;

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
    public static final String MALLOC = "malloc";       // may use gcmalloc instead
    public static final String SIZE_OF = "sizeof";
    
    /*
     * RJava's C implementation helpers
     */
    public static final String INCLUDE_STDIO = "#include <stdio.h>";
    public static final String INCLUDE_STDLIB = "#include <stdlib.h>";
    public static final String RJAVA_LIB_INCLUDE_FILE = "rjava_lib.h";
    public static final String RJAVA_LIB_SOURCE_FILE = "rjava_lib.c";
    public static final String RJAVA_LIB_INCLUDE = "#include \"" + RJAVA_LIB_INCLUDE_FILE + "\"";
    public static final String[] RJAVA_LIB = {
        "java_io_PrintStream",
        "java_lang_Object",
        "java_lang_System",
        "java_lang_StringBuffer"
    };
    public static final String RJAVA_LIB_DIR = "rjava_clib/";
    public static final String MAIN_METHOD_SIGNATURE = "int main (int argc, char** parameter0)";
    
    // helper methods:
    // void rjava_class_init()
    public static final String RJAVA_CLASS_INIT = "rjava_class_init";
    // void rjava_add_interface_to_class(void* interface, int interface_size, char* name, RJava_Common_Class* class);
    // source at the end of this file
    public static final String RJAVA_ADD_INTERFACE_TO_CLASS = "rjava_add_interface_to_class";
    // void rjava_alter_interface(void* interface, char* name, RJava_Common_Class* class);
    public static final String RJAVA_ALTER_INTERFACE = "rjava_alter_interface";
    // void* rjava_get_interface(RJava_Interface_Node* list, char* name);
    public static final String RJAVA_GET_INTERFACE = "rjava_get_interface";
    // void rjava_init_header(void* this_class, void* super_class);
    public static final String RJAVA_INIT_HEADER = "rjava_init_header";
    
    /*
     * RJava's C Naming
     */
    public static final String FORMAL_PARAMETER = "parameter";
    public static final String THIS_PARAMETER = "this_parameter";
    public static final String RJAVA_INIT = "rjinit";
    public static final String RJAVA_CLINIT = "rjclinit";
    
    /*
     * RJava's C Object
     */
    // related with dyanmic dispatching
    public static final String POINTER_TO_CLASS_STRUCT = "class_struct";    // in object, pointing to its class
    public static final String EMBED_SUPER_OBJECT = "instance_header";
    public static final String EMBED_SUPER_CLASS  = "class_header";
    public static final String SUPER_CLASS = "super_class";
    public static final String INTERFACE_LIST = "interfaces";
    public static final String CLASS_STRUCT_SUFFIX = "_class";
    public static final String INTERFACE_STRUCT_SUFFIX = "";
    public static final String CLASS_STRUCT_INSTANCE_SUFFIX = "_class_instance";
    public static final String COMMON_CLASS_STRUCT = "RJava_Common_Class";
    public static final String COMMON_INSTANCE_STRUCT = "RJava_Common_Instance";
    public static final String INTERFACE_LIST_NODE = "RJava_Interface_Node";
    public static final String INTERFACE_LIST_NODE_ATTR_NAME = "name";
    public static final String INTERFACE_LIST_NODE_ATTR_ADDR = "address";
    public static final String INTERFACE_LIST_NODE_ATTR_NEXT = "next";
    public static final String INTERFACE_LIST_NODE_ATTR_SIZE = "interface_size";
    
    public static final String INCOMPLETE_IMPLEMENTATION = "***Incomplete Implementation***";
    
    CLanguageNameGenerator name = new CLanguageNameGenerator(this);
    CLanguageIntrinsicGenerator intrinsic = new CLanguageIntrinsicGenerator();
    
    String cHeaderSource;
    String cCodeSource;
    
    List<String> translatedCSource = new ArrayList<String>();
    List<String> translatedCHeader = new ArrayList<String>();
    String mainSource = "";
    String mainObj = "";
    
    StringBuilder classInit = new StringBuilder();
    
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
        
        if (!klass.isInterface()) {
            generateIntrinsic(klass, source);
            generateHeader(klass, source);
            generateCode(klass, source);
        } else {
            generateInterface(klass, source);
        }
    }

    private void generateInterface(RClass klass, String source) throws RJavaError {
        referencedClasses = new HashSet<String>();
        
        StringBuilder outInc = new StringBuilder();
        StringBuilder outMain = new StringBuilder();
        
        cHeaderSource = getSource(source, ".h");
        
        // include guard
        outInc.append("#ifndef " + name.get(klass).toUpperCase() + "_H" + NEWLINE);
        outInc.append("#define " + name.get(klass).toUpperCase() + "_H" + NEWLINE);
        
        // include rjava lib
        outInc.append(RJAVA_LIB_INCLUDE + NEWLINE);
        
        /*
         * Generate interface struct (e.g. org_rjava_test_poly_DoArithmetic_interface)
         * it only has function pointers;
         */
        outMain.append("typedef struct " + name.get(klass) + INTERFACE_STRUCT_SUFFIX + " {" + NEWLINE);
        outMain.append(commentln("function pointers"));
        for (RMethod method : klass.getMethods()) {
            outMain.append(getFunctionPointerForMethod(method) + SEMICOLON + NEWLINE);
        }
        outMain.append("} " + name.get(klass) + INTERFACE_STRUCT_SUFFIX + SEMICOLON + NEWLINE);
        
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

    private void generateCode(RClass klass, String source) throws RJavaError {
        referencedClasses = new HashSet<String>();
        boolean containsMain = false;
        
        StringBuilder outInc = new StringBuilder();
        StringBuilder outMain = new StringBuilder();

        // get code source
        cCodeSource = getSource(source, ".c");
        
        // include its own header
        outInc.append("#include \"" + cHeaderSource + "\"" + NEWLINE);
        // include c std
        outInc.append(INCLUDE_STDIO + NEWLINE);
        outInc.append(INCLUDE_STDLIB + NEWLINE);
        
        outInc.append(NEWLINE);
        
        for (RMethod method : klass.getMethods()) {
            if (method.isMainMethod()) {
                outMain.append(MAIN_METHOD_SIGNATURE + " {" + NEWLINE);
                // calling class_init();
                outMain.append(RJAVA_CLASS_INIT + "()" + SEMICOLON + NEWLINE);
                containsMain = true;
            } else {
                outMain.append(getMethodSignature(method) + " {" + NEWLINE);
            }
            
            if (method.isIntrinsic()) {
                outMain.append(method.getCode());
            } else outMain.append(getMethodBody(method));
            
            outMain.append("}" + NEWLINE);
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

    private void generateHeader(RClass klass, String source) throws RJavaError {
        referencedClasses = new HashSet<String>();
        
        StringBuilder outInc = new StringBuilder();
        StringBuilder outMain = new StringBuilder();
        
        cHeaderSource = getSource(source, ".h");
        
        // include guard
        outInc.append("#ifndef " + name.get(klass).toUpperCase() + "_H" + NEWLINE);
        outInc.append("#define " + name.get(klass).toUpperCase() + "_H" + NEWLINE);
        
        // include rjava lib
        outInc.append(RJAVA_LIB_INCLUDE + NEWLINE);
        
        /*
         * Generate instance struct (e.g. org_rjava_test_poly_Animal)
         */
        outMain.append("typedef struct " + name.get(klass) + " {" + NEWLINE);
        // we contain a struct for its super class object
        // if this class doesnt have super class, we use common instance struct
        if (klass.hasSuperClass()) {
            outMain.append(commentln("contains super instance struct"));
            outMain.append(name.get(klass.getSuperClass()) + " " + EMBED_SUPER_OBJECT + SEMICOLON + NEWLINE);
        } else {
            outMain.append(commentln("contains common instance struct"));
            outMain.append(COMMON_INSTANCE_STRUCT + " " + EMBED_SUPER_OBJECT + SEMICOLON + NEWLINE);
        }
        
        outMain.append(commentln("instance fields"));
        for (RField field : klass.getFields()) {
            outMain.append(name.get(field.getType()) + " " + name.get(field) + SEMICOLON + NEWLINE);
        }
        outMain.append("} " + name.get(klass) + SEMICOLON + NEWLINE);
        
        /*
         * Generating class struct (e.g. org_rjava_test_poly_Animal_class)
         */
        outMain.append("typedef struct " + name.get(klass) + CLASS_STRUCT_SUFFIX + " {" + NEWLINE);
        if (klass.hasSuperClass()) {
            // contain a struct for its super class
            outMain.append(commentln("contains super class struct"));
            outMain.append(name.get(klass.getSuperClass()) + CLASS_STRUCT_SUFFIX + " " + EMBED_SUPER_CLASS + SEMICOLON + NEWLINE);
            // init super class in class_init()
            classInit.append("((" + COMMON_CLASS_STRUCT + "*)(&" + name.get(klass) + CLASS_STRUCT_INSTANCE_SUFFIX + "))");
            classInit.append(" -> " + SUPER_CLASS + " = (" + COMMON_CLASS_STRUCT + "*)" + "&" + name.get(klass.getSuperClass()) + CLASS_STRUCT_INSTANCE_SUFFIX);
            classInit.append(SEMICOLON + NEWLINE);
        } else {
            // contains common class struct
            outMain.append(commentln("contains common class struct"));
            outMain.append(COMMON_CLASS_STRUCT + " " + EMBED_SUPER_CLASS + SEMICOLON + NEWLINE);
            classInit.append("((" + COMMON_CLASS_STRUCT + "*)(&" + name.get(klass) + CLASS_STRUCT_INSTANCE_SUFFIX + "))");
            classInit.append(" -> " + SUPER_CLASS + " = NULL" + SEMICOLON + NEWLINE);
        }
        
        // init class interfaces to null
        classInit.append("((" + COMMON_CLASS_STRUCT + "*)(&" + name.get(klass) + CLASS_STRUCT_INSTANCE_SUFFIX + "))");
        classInit.append(" -> " + INTERFACE_LIST + " = NULL" + SEMICOLON + NEWLINE);
        // set header to its super class instruct
        if (klass.hasSuperClass()) {
            classInit.append(RJAVA_INIT_HEADER + "(&");
            classInit.append(name.get(klass) + CLASS_STRUCT_INSTANCE_SUFFIX + ",&" + name.get(klass.getSuperClass()) + CLASS_STRUCT_INSTANCE_SUFFIX + ")" + SEMICOLON + NEWLINE);
        }
        
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
                classInit.append("((" + name.get(target) + CLASS_STRUCT_SUFFIX + "*)");
                classInit.append("(&" + name.get(klass) + CLASS_STRUCT_INSTANCE_SUFFIX + "))");
                classInit.append(" -> " + method.getName() + " = " + name.get(method) + SEMICOLON + NEWLINE);
            }
        }
        outMain.append("} " + name.get(klass) + CLASS_STRUCT_SUFFIX + SEMICOLON + NEWLINE);
        
        // global variable
        outMain.append(commentln("class instance"));
        outMain.append(name.get(klass) + CLASS_STRUCT_SUFFIX + " ");
        outMain.append(name.get(klass) + CLASS_STRUCT_INSTANCE_SUFFIX + SEMICOLON + NEWLINE);
        // TODO: generate other global fields
        
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
                // create the C interface for this klass
                String tempInterfaceVar = name.get(myInterface) + "_implemented_on_" + name.get(klass); 
                classInit.append(name.get(myInterface) + INTERFACE_STRUCT_SUFFIX + "* " + tempInterfaceVar + " = ");
                classInit.append(MALLOC + "(sizeof(" + name.get(myInterface) + INTERFACE_STRUCT_SUFFIX + "))" + SEMICOLON + NEWLINE);
                
                // link its function pointers
                for (RMethod interfaceMethod : myInterface.getMethods()) {
                    classInit.append(tempInterfaceVar + " -> " + interfaceMethod.getName());
                    classInit.append(" = " + name.get(klass.getImplenetingMethodOfAnInterfaceMethod(interfaceMethod)) + SEMICOLON + NEWLINE);
                }
                
                // add this interface to class
                // void rjava_add_interface_to_class(void* interface, int interface_size, char* name, RJava_Common_Class* class);
                classInit.append(RJAVA_ADD_INTERFACE_TO_CLASS + "(" + tempInterfaceVar + "," + SIZE_OF + "(" + name.get(myInterface) + "),");
                classInit.append("\"" + name.get(myInterface)+ "\",");
                classInit.append("(" + COMMON_CLASS_STRUCT + "*)&" + name.get(klass) + CLASS_STRUCT_INSTANCE_SUFFIX + ")" + SEMICOLON + NEWLINE);
            }
        }
        if (klass.hasInheritedInterfaces()) {
            for(RClass myInterface : klass.getInheritedInterfaces()) {
                //if (klass.isOverridingMethodsFrom(myInterface)) {
                    
                //}
            }
        }
        
        writeTo(outInc.toString() + outMain.toString(), Constants.OUTPUT_DIR + cHeaderSource);
        
        translatedCHeader.add(cHeaderSource);
    }
    
    private String getFunctionPointerForMethod(RMethod method) {
       StringBuilder out = new StringBuilder();
       // return
       out.append(name.get(method.getReturnType()) + " ");
       // function ptr name
       out.append("(*" + method.getName() + ") ");
       // parameter list
       out.append("(");
       out.append(VOID + POINTER + " " + THIS_PARAMETER);
       for (int i = 0; i < method.getParameters().size(); i++) {
           out.append(", ");
           out.append(name.get(method.getParameters().get(i)) + " " + FORMAL_PARAMETER + i);   
       }
       out.append(")");
       return out.toString();
    }

    private String getSource(String origin, String ext) {
        String ret = origin.replace(RJavaCompiler.currentTask.getPath(), "");
        ret = ret.replace(Constants.RJAVA_EXT, ext);
        ret = ret.replaceAll("/", "_");
        return ret;
    }
    
    
    public String getMethodSignature(RMethod method) {
        StringBuilder out = new StringBuilder();
        out.append(name.get(method.getReturnType()) + " ");
        out.append(name.get(method) + " (");
        // if not static, the first parameter will be 'this'
        if (!method.isStatic()) {
            out.append(VOID + POINTER + " " + THIS_PARAMETER); 
        }
        for (int i = 0; i < method.getParameters().size(); i++) {
            if (!method.isStatic())
                out.append(", ");
            out.append(name.getWithPointerIfProper(method.getParameters().get(i)) + " " + FORMAL_PARAMETER + i);                        
        }
        out.append(")");
        return out.toString();
    }
    
    public String getMethodBody(RMethod method) {
        StringBuilder out = new StringBuilder();
        CLanguageStatementGenerator stmt = new CLanguageStatementGenerator(this);
        out.append(commentln("locals"));
        for (RLocal local : method.getLocals()) {
            out.append(stmt.get(local) + SEMICOLON + NEWLINE);
        }
        out.append(commentln("stmts"));
        for (RStatement rStmt : method.getBody()) {
            if (rStmt.isIntrinsic())
                out.append(rStmt.getCode());
            else {
                if (method.isConstructor() && rStmt.isReturnStmt()) 
                    out.append("((" + COMMON_INSTANCE_STRUCT + "*)" + THIS_LOCAL + ") -> " + POINTER_TO_CLASS_STRUCT + " = &" + name.get(method.getKlass()) + CLASS_STRUCT_INSTANCE_SUFFIX + SEMICOLON + NEWLINE);
                out.append(stmt.get(rStmt));
            }
            
            out.append(SEMICOLON + NEWLINE);
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
        // generating lib include
        StringBuilder out = new StringBuilder();
        out.append("#ifndef RJAVA_LIB_H" + NEWLINE);
        out.append("#define RJAVA_LIB_H" + NEWLINE);
        for (String lib : RJAVA_LIB) {
            out.append("#include \"" + lib + ".h\"" + NEWLINE);
        }
        
        // class struct and interface list forward declaration
        out.append("typedef struct " + COMMON_CLASS_STRUCT + " " + COMMON_CLASS_STRUCT + SEMICOLON + NEWLINE);
        out.append("typedef struct " + INTERFACE_LIST_NODE + " " + INTERFACE_LIST_NODE + SEMICOLON + NEWLINE);
        
        // interface list
        out.append("struct " + INTERFACE_LIST_NODE + " {" + NEWLINE);
        out.append("char* " + INTERFACE_LIST_NODE_ATTR_NAME + SEMICOLON + NEWLINE);
        out.append("void* " + INTERFACE_LIST_NODE_ATTR_ADDR + SEMICOLON + NEWLINE);
        out.append("int " + INTERFACE_LIST_NODE_ATTR_SIZE + SEMICOLON + NEWLINE);
        out.append(INTERFACE_LIST_NODE + "* " + INTERFACE_LIST_NODE_ATTR_NEXT + SEMICOLON + NEWLINE);
        out.append("}" + SEMICOLON + NEWLINE);
        
        out.append("struct " + COMMON_CLASS_STRUCT + " {" + NEWLINE);
        out.append(COMMON_CLASS_STRUCT + "* " + SUPER_CLASS + SEMICOLON + NEWLINE);
        out.append(INTERFACE_LIST_NODE + "* " + INTERFACE_LIST + SEMICOLON + NEWLINE);
        out.append("}" + SEMICOLON + NEWLINE);
        
        // instance struct
        out.append("typedef struct " + COMMON_INSTANCE_STRUCT + " {" + NEWLINE);
        out.append("void* " + POINTER_TO_CLASS_STRUCT + SEMICOLON + NEWLINE);
        out.append("} " + COMMON_INSTANCE_STRUCT + SEMICOLON + NEWLINE);
        
        out.append("#define RJAVA_STR char *" + NEWLINE);
        out.append("#endif" + NEWLINE);
        
        out.append("#ifndef RJAVA_APP_H" + NEWLINE);
        out.append("#define RJAVA_APP_H" + NEWLINE);
        
        // helper methods
        out.append("void " + RJAVA_CLASS_INIT + "()" + SEMICOLON + NEWLINE);
        out.append("void " + RJAVA_ADD_INTERFACE_TO_CLASS + "(void* interface, int interface_size, char* name, RJava_Common_Class* class)" + SEMICOLON + NEWLINE);
        out.append("void* " + RJAVA_GET_INTERFACE + "(" + INTERFACE_LIST_NODE + "* list, char* name)" + SEMICOLON + NEWLINE);
        out.append("void " + RJAVA_INIT_HEADER + "(void* this_class, void* super_class)" + SEMICOLON + NEWLINE);
        out.append("#endif" + NEWLINE);
        
        writeTo(out.toString(), Constants.OUTPUT_DIR + RJAVA_LIB_INCLUDE_FILE);
        
        // generating lib source - for class init()
        StringBuilder libSource = new StringBuilder();
        libSource.append(RJAVA_LIB_INCLUDE + NEWLINE);
        libSource.append(INCLUDE_STDIO + NEWLINE);
        libSource.append(INCLUDE_STDLIB + NEWLINE);
        for (String app : translatedCHeader) {
            libSource.append("#include \"" + app + "\"" + NEWLINE);
        }
        // void rjava_class_init()
        libSource.append("void " + RJAVA_CLASS_INIT + "() {" + NEWLINE);
        libSource.append(classInit.toString());
        libSource.append("}" + NEWLINE);
        // void rjava_add_interface_to_class(void* interface, char* name, RJava_Common_Class* class);
        libSource.append("void " + RJAVA_ADD_INTERFACE_TO_CLASS + "(void* interface, int interface_size, char* name, " + COMMON_CLASS_STRUCT + "* class) {" + NEWLINE);
        libSource.append(RJAVA_ADD_INTERFACE_TO_CLASS_SOURCE);
        libSource.append("}" + NEWLINE);
        // void rjava_alter_interface(void* interface, char* name, RJava_Common_Class* class);
        libSource.append("void " + RJAVA_ALTER_INTERFACE + "(void* interface, char* name, " + COMMON_CLASS_STRUCT + "* class) {" + NEWLINE);
        libSource.append(RJAVA_ALTER_INTERFACE_SOURCE);
        libSource.append("}" + NEWLINE);
        // RJava_Interface_Node* rjava_get_interface(RJava_Interface_Node* list, char* name);
        libSource.append("void* " + RJAVA_GET_INTERFACE + "(" + INTERFACE_LIST_NODE + "* list, char* name) {" + NEWLINE);
        libSource.append(RJAVA_GET_INTERFACE_SOURCE);
        libSource.append("}" + NEWLINE);
        libSource.append("void " + RJAVA_INIT_HEADER + "(void* this_class, void* super_class) {" + NEWLINE);
        libSource.append(RJAVA_INIT_HEADER_SOURCE);
        libSource.append("}" + NEWLINE);
        writeTo(libSource.toString(), Constants.OUTPUT_DIR + RJAVA_LIB_SOURCE_FILE);
        
        // copy lib files
        try {
            FileUtils.copyDirectory(new File(RJAVA_LIB_DIR), new File(Constants.OUTPUT_DIR), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // generate makefile
        StringBuilder makeFile = new StringBuilder();
        makeFile.append("all: ");
        String fileList = "";
        for (String c : translatedCSource)
            fileList += c + " ";
        for (String l : RJAVA_LIB)
            fileList += l + ".c ";
        fileList += "rjava_lib.c ";
        
        makeFile.append(NEWLINE);
        makeFile.append("\tgcc -o " + mainObj + " ");
        makeFile.append(fileList);
        makeFile.append(" -I .");
        writeTo(makeFile.toString(), Constants.OUTPUT_DIR + "Makefile");
    }
    
    public void referencing(String refName) {
        if (refName.startsWith("java_") || refName.startsWith("javax_"))
            return;
        referencedClasses.add(refName);
    }

    // void rjava_add_interface_to_class(void* interface, int interface_size, char* name, RJava_Common_Class* class);
    private static final String RJAVA_ADD_INTERFACE_TO_CLASS_SOURCE = 
            INTERFACE_LIST_NODE + "* newNode = " + MALLOC + "(" + SIZE_OF + "(" + INTERFACE_LIST_NODE + "));" + NEWLINE +
            "newNode->" + INTERFACE_LIST_NODE_ATTR_ADDR + "=interface;" + NEWLINE +
            "newNode->" + INTERFACE_LIST_NODE_ATTR_SIZE + "=interface_size;" + NEWLINE +
            "newNode->" + INTERFACE_LIST_NODE_ATTR_NAME + "=name;" + NEWLINE +
            "newNode->" + INTERFACE_LIST_NODE_ATTR_NEXT + "=NULL;" + NEWLINE +
            
            INTERFACE_LIST_NODE + "* last = class->" + INTERFACE_LIST + ";" + NEWLINE +
            "if (class->" + INTERFACE_LIST + " == NULL) " + NEWLINE +
            "  class->" + INTERFACE_LIST + "=newNode;" + NEWLINE +
            "else {" + NEWLINE +
            "  while(last->" + INTERFACE_LIST_NODE_ATTR_NEXT + "!=NULL)" + NEWLINE +
            "    last = last->" + INTERFACE_LIST_NODE_ATTR_NEXT + ";" + NEWLINE +
            "  last->" + INTERFACE_LIST_NODE_ATTR_NEXT + "=newNode;" + NEWLINE +
            "}" + NEWLINE;
    
    // void rjava_alter_interface(void* interface, char* name, RJava_Common_Class* class);
    private static final String RJAVA_ALTER_INTERFACE_SOURCE = 
            INTERFACE_LIST_NODE + "* iter = class->" + INTERFACE_LIST + SEMICOLON + NEWLINE +
            "do {" + NEWLINE + 
            "  if (strcmp(iter->" + INTERFACE_LIST_NODE_ATTR_NAME + ", name) == 0) {" + NEWLINE + 
            "    iter->" + INTERFACE_LIST_NODE_ATTR_ADDR + " = interface;" + NEWLINE +
            "    return;" +
            "  }" +
            "  iter = iter->" + INTERFACE_LIST_NODE_ATTR_NEXT + SEMICOLON + NEWLINE +
            "} while (iter != NULL);" + NEWLINE;
    
    // RJava_Interface_Node* rjava_get_interface(RJava_Interface_Node* list, char* name);
    private static final String RJAVA_GET_INTERFACE_SOURCE = 
            INTERFACE_LIST_NODE + "* interface = list;" + NEWLINE +
            "while(1) {" + NEWLINE +
            "  if (strcmp(interface->" + INTERFACE_LIST_NODE_ATTR_NAME + ", name) == 0)" + NEWLINE +
            "    return interface->" + INTERFACE_LIST_NODE_ATTR_ADDR + ";" + NEWLINE +
            "  else {" + NEWLINE +
            "    if (interface->" + INTERFACE_LIST_NODE_ATTR_NEXT + " != NULL)" + NEWLINE +
            "      interface = interface->" + INTERFACE_LIST_NODE_ATTR_NEXT + ";" + NEWLINE +
            "    else {" + NEWLINE +
            "      printf(\"Error when resolving interface invoke: %s\", name);" + NEWLINE +
            "      exit(1);" + NEWLINE +
            "    }" + NEWLINE +
            "  }" + NEWLINE +
            "}" + NEWLINE;
    
    // void rjava_init_header(void* this_class, void* super_class);
    private static final String RJAVA_INIT_HEADER_SOURCE = "" +
    		"((RJava_Common_Class*)this_class) -> super_class = (RJava_Common_Class*)super_class;" + NEWLINE + 
    		"if (((RJava_Common_Class*)super_class) -> interfaces == NULL) {" + NEWLINE + 
    		"  ((RJava_Common_Class*)this_class) -> interfaces = NULL;" + NEWLINE +
    		"  return;" + NEWLINE + 
    		"}" + NEWLINE +
    
    		"RJava_Interface_Node* newListHead = NULL;" + NEWLINE + 
    		"RJava_Interface_Node* newListIter = NULL;" + NEWLINE + 
    		"RJava_Interface_Node* oldListIter = ((RJava_Common_Class*)super_class) -> interfaces;" + NEWLINE +
    		"RJava_Interface_Node* prevNewListNode = NULL;" + NEWLINE + 
    
    		"for (; oldListIter->next != NULL; oldListIter = oldListIter->next) {" + NEWLINE + 
    		"  newListIter = (RJava_Interface_Node*) malloc(sizeof(RJava_Interface_Node));" + NEWLINE + 
    		"  strcpy(newListIter->name, oldListIter->name);" + NEWLINE + 

    		"  newListIter->address = malloc(sizeof(oldListIter->interface_size));" + NEWLINE + 
    		"  memcpy(newListIter->address, oldListIter->address, oldListIter->interface_size);" + NEWLINE + 

    		"  newListIter->interface_size = oldListIter->interface_size;" + NEWLINE + 
        
    		"  if (prevNewListNode == NULL) {" + NEWLINE + 
            "    // first node" + NEWLINE + 
            "    newListHead = newListIter;" + NEWLINE + 
            "  } else {" + NEWLINE + 
            "    prevNewListNode->next = newListIter;" + NEWLINE + 
            "  }" + NEWLINE + 
        
            "  prevNewListNode = newListIter;" + NEWLINE + 
            "}" + NEWLINE +
    
            "((RJava_Common_Class*)this_class) -> interfaces = newListHead;" + NEWLINE;
}
