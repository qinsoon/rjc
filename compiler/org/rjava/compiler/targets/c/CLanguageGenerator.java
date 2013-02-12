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
import org.rjava.compiler.targets.CodeGenerator;
import org.rjava.compiler.util.Tree;
import org.rjava.compiler.util.TreeBreadthFirstIterator;

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
    public static final String INCLUDE_STDBOOL = "#include <stdbool.h>";
    public static final String RJAVA_LIB_INCLUDE_FILE = "rjava_lib.h";
    public static final String RJAVA_LIB_SOURCE_FILE = "rjava_lib.c";
    public static final String RJAVA_LIB_INCLUDE = "#include \"" + RJAVA_LIB_INCLUDE_FILE + "\"";
    public static final String[] RJAVA_LIB = {
        "java_io_PrintStream",
        "java_lang_Object",
        "java_lang_System",
        "java_lang_StringBuffer",
        "java_lang_String",
        "java_lang_Integer"
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
    // void rjava_debug_print_header(void* this_class);
    public static final String RJAVA_DEBUG_PRINT_HEADER = "rjava_debug_print_header";
    
    // array implements: an array is a void* that points to a structure (in memory) like this
    // --------------------------------------------------
    // | int length | long ele_size | actual array .....|
    // --------------------------------------------------
    // void* rjava_new_array(int length, long ele_size);
    public static final String RJAVA_NEW_ARRAY = "rjava_new_array";
    // void* rjava_access_array(void* array, int index);
    public static final String RJAVA_ACCESS_ARRAY = "rjava_access_array";
    // int rjava_length_of_array(void* array);
    public static final String RJAVA_LENGTH_OF_ARRAY = "rjava_length_of_array";
    // void* rjava_c_array_to_rjava_array(int length, long ele_size, void* c_array);
    public static final String RJAVA_C_ARRAY_TO_RJAVA_ARRAY = "rjava_c_array_to_rjava_array";
    
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
    RClass currentRClass;
    
    List<String> translatedCSource = new ArrayList<String>();
    List<String> translatedCHeader = new ArrayList<String>();
    String mainSource = "";
    String mainObj = "";
   
    Map<String, StringBuilder> classInitMap = new HashMap<String, StringBuilder>();
    
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

    /**
     * A Java Class will become a C header and a C source file. The source file is generated here. 
     * @param klass
     * @param source
     * @throws RJavaError
     */
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
        outInc.append(INCLUDE_STDBOOL + NEWLINE);
        
        outInc.append(NEWLINE);
        
        // generating code for each method
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

    /**
     * A Java Class will become a C header and a C source file. The header is generated here. 
     * @param klass
     * @param source
     * @throws RJavaError
     */
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
        outMain.append("typedef struct " + name.get(klass) + " " + name.get(klass) + SEMICOLON + NEWLINE);
        outMain.append("struct " + name.get(klass) + " {" + NEWLINE);
        
        // we contain a struct for its super class object
        // if this class doesnt have super class, we use common instance struct
        if (klass.hasSuperClass()) {
            outMain.append(commentln("contains super instance struct"));
            outMain.append(name.get(klass.getSuperClass()) + " " + EMBED_SUPER_OBJECT + SEMICOLON + NEWLINE);
        } else {
            outMain.append(commentln("contains common instance struct"));
            outMain.append(COMMON_INSTANCE_STRUCT + " " + EMBED_SUPER_OBJECT + SEMICOLON + NEWLINE);
        }
        
        /*
         * Generating instance field
         */
        outMain.append(commentln("instance fields"));
        for (RField field : klass.getFields()) {
            if (!field.isStatic())
                outMain.append(name.getWithPointerIfProper(field.getType()) + " " + name.get(field) + SEMICOLON + NEWLINE);
        }
        outMain.append("}" + SEMICOLON + NEWLINE);
        
        /*
         * Generating class struct (e.g. org_rjava_test_poly_Animal_class)
         */
        outMain.append("typedef struct " + name.get(klass) + CLASS_STRUCT_SUFFIX + " {" + NEWLINE);
        if (klass.hasSuperClass()) {
            // contain a struct for its super class
            outMain.append(commentln("contains super class struct"));
            outMain.append(name.get(klass.getSuperClass()) + CLASS_STRUCT_SUFFIX + " " + EMBED_SUPER_CLASS + SEMICOLON + NEWLINE);
            
            // and set its header to super class
            StringBuilder classInitTemp = new StringBuilder();
            classInitTemp.append(RJAVA_INIT_HEADER + "(&");
            classInitTemp.append(name.get(klass) + CLASS_STRUCT_INSTANCE_SUFFIX + ",&" + name.get(klass.getSuperClass()) + CLASS_STRUCT_INSTANCE_SUFFIX);
            classInitTemp.append("," + SIZE_OF + "(" + name.get(klass.getSuperClass()) + CLASS_STRUCT_SUFFIX + "))" + SEMICOLON + NEWLINE);
            addToClassInitMap(klass.getName(), classInitTemp.toString());
        } else {
            // contains common class struct
            outMain.append(commentln("contains common class struct"));
            outMain.append(COMMON_CLASS_STRUCT + " " + EMBED_SUPER_CLASS + SEMICOLON + NEWLINE);
            
            // this class has no super class, thus we initialize super and interface to NULL
            StringBuilder classInitTemp = new StringBuilder();
            // super_class = NULL
            classInitTemp.append("((" + COMMON_CLASS_STRUCT + "*)(&" + name.get(klass) + CLASS_STRUCT_INSTANCE_SUFFIX + "))");
            classInitTemp.append(" -> " + SUPER_CLASS + " = NULL" + SEMICOLON + NEWLINE);
            // interfaces = NULL
            classInitTemp.append("((" + COMMON_CLASS_STRUCT + "*)(&" + name.get(klass) + CLASS_STRUCT_INSTANCE_SUFFIX + "))");
            classInitTemp.append(" -> " + INTERFACE_LIST + " = NULL" + SEMICOLON + NEWLINE);
            addToClassInitMap(klass.getName(), classInitTemp.toString());
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
                StringBuilder classInitTemp = new StringBuilder();
                classInitTemp.append("((" + name.get(target) + CLASS_STRUCT_SUFFIX + "*)");
                classInitTemp.append("(&" + name.get(klass) + CLASS_STRUCT_INSTANCE_SUFFIX + "))");
                classInitTemp.append(" -> " + method.getName() + " = " + name.get(method) + SEMICOLON + NEWLINE);
                addToClassInitMap(klass.getName(), classInitTemp.toString());
            }
        }
        outMain.append("} " + name.get(klass) + CLASS_STRUCT_SUFFIX + SEMICOLON + NEWLINE);
        
        // global variable
        outMain.append(commentln("class instance"));
        outMain.append(name.get(klass) + CLASS_STRUCT_SUFFIX + " ");
        outMain.append(name.get(klass) + CLASS_STRUCT_INSTANCE_SUFFIX + SEMICOLON + NEWLINE);
        // generate other global fields (static field)
        outMain.append(commentln("static field (global)"));
        for (RField field : klass.getFields()) {
            if (field.isStatic()) {
                outMain.append(name.getWithPointerIfProper(field.getType()) + " " + name.get(field) + SEMICOLON + NEWLINE);
            }                
        }
        
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
     * generating class init code for RClass:klass on interface:myInterface. 
     * @param klass
     * @param myInterface
     * @param rewrite true if we add such interface, otherwise change the old interface pointer
     */
    private void getInterfaceInitCode(RClass klass, RClass myInterface, boolean rewrite) {
        StringBuilder classInitTemp = new StringBuilder();
        
        // create the C interface for this klass
        String tempInterfaceVar = name.get(myInterface) + "_implemented_on_" + name.get(klass); 
        classInitTemp.append(name.get(myInterface) + INTERFACE_STRUCT_SUFFIX + "* " + tempInterfaceVar + " = ");
        classInitTemp.append(MALLOC + "(sizeof(" + name.get(myInterface) + INTERFACE_STRUCT_SUFFIX + "))" + SEMICOLON + NEWLINE);
        
        // link its function pointers
        for (RMethod interfaceMethod : myInterface.getMethods()) {
            classInitTemp.append(tempInterfaceVar + " -> " + interfaceMethod.getName());
            classInitTemp.append(" = " + name.get(klass.getImplenetingMethodOfAnInterfaceMethod(interfaceMethod)) + SEMICOLON + NEWLINE);
        }

        if (rewrite) {
            // rewrite
            // void rjava_alter_interface(void* interface, char* name, RJava_Common_Class* class);
            classInitTemp.append(RJAVA_ALTER_INTERFACE + "(" + tempInterfaceVar + ",\"" + name.get(myInterface) + "\",");
            classInitTemp.append("(" + COMMON_CLASS_STRUCT + "*)&" + name.get(klass) + CLASS_STRUCT_INSTANCE_SUFFIX + ")" + SEMICOLON + NEWLINE);
        }else {
            // add this interface to class
            // void rjava_add_interface_to_class(void* interface, int interface_size, char* name, RJava_Common_Class* class);
            classInitTemp.append(RJAVA_ADD_INTERFACE_TO_CLASS + "(" + tempInterfaceVar + "," + SIZE_OF + "(" + name.get(myInterface) + "),");
            classInitTemp.append("\"" + name.get(myInterface)+ "\",");
            classInitTemp.append("(" + COMMON_CLASS_STRUCT + "*)&" + name.get(klass) + CLASS_STRUCT_INSTANCE_SUFFIX + ")" + SEMICOLON + NEWLINE);
        }
        
        addToClassInitMap(klass.getName(), classInitTemp.toString());
    }
    
    private String getFunctionPointerForMethod(RMethod method) {
       StringBuilder out = new StringBuilder();
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

    private String getSource(String origin, String ext) {
        String ret = origin.replace(RJavaCompiler.currentTask.getPath(), "");
        ret = ret.replace(Constants.RJAVA_EXT, ext);
        ret = ret.replaceAll("/", "_");
        return ret;
    }
    
    
    public String getMethodSignature(RMethod method) {
        StringBuilder out = new StringBuilder();
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
        
        //out.append("#define RJAVA_STR char *" + NEWLINE);
        out.append("#endif" + NEWLINE);
        
        out.append("#ifndef RJAVA_APP_H" + NEWLINE);
        out.append("#define RJAVA_APP_H" + NEWLINE);
        
        // helper methods
        out.append("void " + RJAVA_CLASS_INIT + "()" + SEMICOLON + NEWLINE);
        out.append("void " + RJAVA_ADD_INTERFACE_TO_CLASS + "(void* interface, int interface_size, char* name, RJava_Common_Class* class)" + SEMICOLON + NEWLINE);
        out.append("void* " + RJAVA_GET_INTERFACE + "(" + INTERFACE_LIST_NODE + "* list, char* name)" + SEMICOLON + NEWLINE);
        out.append("void " + RJAVA_INIT_HEADER + "(void* this_class, void* super_class, int super_class_init)" + SEMICOLON + NEWLINE);
        out.append("void " + RJAVA_DEBUG_PRINT_HEADER + "(char* name, void* this_class)" + SEMICOLON + NEWLINE);
        out.append("void* " + RJAVA_NEW_ARRAY + "(int length, long ele_size)" + SEMICOLON + NEWLINE);
        out.append("void* " + RJAVA_ACCESS_ARRAY + "(void* array, int index)" + SEMICOLON + NEWLINE);
        out.append("int " + RJAVA_LENGTH_OF_ARRAY + "(void* array)" + SEMICOLON + NEWLINE);
        out.append("void* " + RJAVA_C_ARRAY_TO_RJAVA_ARRAY + "(int length, long ele_size, void* c_array)" + SEMICOLON + NEWLINE);
        out.append("#endif" + NEWLINE);
        
        writeTo(out.toString(), Constants.OUTPUT_DIR + RJAVA_LIB_INCLUDE_FILE);
        
        // generating lib source - for class init()
        StringBuilder libSource = new StringBuilder();
        libSource.append(RJAVA_LIB_INCLUDE + NEWLINE);
        libSource.append(INCLUDE_STDIO + NEWLINE);
        libSource.append(INCLUDE_STDLIB + NEWLINE);
        libSource.append(INCLUDE_STDBOOL + NEWLINE);
        for (String app : translatedCHeader) {
            libSource.append("#include \"" + app + "\"" + NEWLINE);
        }
        // void rjava_class_init()
        libSource.append("void " + RJAVA_CLASS_INIT + "() {" + NEWLINE);
        libSource.append(getClassInitMethodBody());
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
        libSource.append("void " + RJAVA_INIT_HEADER + "(void* this_class, void* super_class, int super_class_size) {" + NEWLINE);
        libSource.append(RJAVA_INIT_HEADER_SOURCE);
        libSource.append("}" + NEWLINE);
        libSource.append("void " + RJAVA_DEBUG_PRINT_HEADER + "(char* name, void* this_class) {" + NEWLINE);
        libSource.append(RJAVA_DEBUG_PRINT_HEADER_SOURCE);
        libSource.append("}" + NEWLINE);
        libSource.append("void* " + RJAVA_NEW_ARRAY + "(int length, long ele_size) {" + NEWLINE);
        libSource.append(RJAVA_NEW_ARRAY_SOURCE);
        libSource.append("}" + NEWLINE);
        libSource.append("void* " + RJAVA_ACCESS_ARRAY + "(void* array, int index) {" + NEWLINE);
        libSource.append(RJAVA_ACCESS_ARRAY_SOURCE);
        libSource.append("}" + NEWLINE);
        libSource.append("int " + RJAVA_LENGTH_OF_ARRAY + "(void* array) {" + NEWLINE);
        libSource.append(RJAVA_LENGTH_OF_ARRAY_SOURCE);
        libSource.append("}" + NEWLINE);
        libSource.append("void* " + RJAVA_C_ARRAY_TO_RJAVA_ARRAY + "(int length, long ele_size, void* c_array) {" + NEWLINE);
        libSource.append(RJAVA_C_ARRAY_TO_RJAVA_ARRAY_SOURCE);
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
        
        // avoid adding include for current class
        if (!name.javaNameToCName(currentRClass.getName()).equals(refName))
            referencedClasses.add(refName);
    }
    
    private void addToClassInitMap(String rClassName, String initStmt) {
        if (classInitMap.containsKey(rClassName)) {
            StringBuilder value = classInitMap.get(rClassName);
            value.append(initStmt);
            classInitMap.put(rClassName, value);
        } else {
            StringBuilder newValue = new StringBuilder();
            newValue.append(initStmt);
            classInitMap.put(rClassName, newValue);
        }
    }
    
    private String getClassInitMethodBody() {
        StringBuilder body = new StringBuilder();
        
        // init c struct for those classes
        for (Tree<RClass> root : SemanticMap.hierarchy.getRoots()) {
            TreeBreadthFirstIterator<RClass> iter = root.getBreadthFirstIterator();
            while (iter.hasNext()) {
                RClass current = iter.next();
                //System.out.println("Generating class init statements for " + current.getName());
                body.append(commentln("init for " + name.get(current)));
                body.append(classInitMap.get(current.getName()).toString());
                body.append("\n\n");
            }
        }
        
        // calling <clinit> for those classes
        body.append(commentln("calling <clinit> for RJava classes"));
        for (Tree<RClass> root : SemanticMap.hierarchy.getRoots()) {
            TreeBreadthFirstIterator<RClass> iter = root.getBreadthFirstIterator();
            while(iter.hasNext()) {
                RClass current = iter.next();
                if (current.getCLInitMethod() != null) {
                    body.append(name.get(current.getCLInitMethod()) + "();\n");
                }
            }
        }
        
        return body.toString();
    }

    // void rjava_add_interface_to_class(void* interface, int interface_size, char* name, RJava_Common_Class* class);
    private static final String RJAVA_ADD_INTERFACE_TO_CLASS_SOURCE = 
            INTERFACE_LIST_NODE + "* newNode = " + MALLOC + "(" + SIZE_OF + "(" + INTERFACE_LIST_NODE + "));" + NEWLINE +
            "newNode->" + INTERFACE_LIST_NODE_ATTR_ADDR + "=interface;" + NEWLINE +
            "newNode->" + INTERFACE_LIST_NODE_ATTR_SIZE + "=interface_size;" + NEWLINE +
            "newNode->" + INTERFACE_LIST_NODE_ATTR_NAME + "=" + MALLOC + "(strlen(name)+1);" + NEWLINE +
            "strcpy(newNode->" + INTERFACE_LIST_NODE_ATTR_NAME + ",name);" + NEWLINE +
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
            "    return;" + NEWLINE + 
            "  }" + NEWLINE +
            "  iter = iter->" + INTERFACE_LIST_NODE_ATTR_NEXT + SEMICOLON + NEWLINE +
            "} while (iter != NULL);" + NEWLINE + 
            "printf(\"didnt find interface(%s)\\n\", name);" + NEWLINE + 
            "exit(1);" + NEWLINE;
    
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
    
    // void rjava_init_header(void* this_class, void* super_class, int super_class_size);
    private static final String RJAVA_INIT_HEADER_SOURCE = 
            "memcpy(this_class, super_class, super_class_size);" + NEWLINE + 
    		"((RJava_Common_Class*)this_class) -> super_class = (RJava_Common_Class*)super_class;" + NEWLINE + 
    		"if (((RJava_Common_Class*)super_class) -> interfaces == NULL) {" + NEWLINE + 
    		"  ((RJava_Common_Class*)this_class) -> interfaces = NULL;" + NEWLINE +
    		"  return;" + NEWLINE + 
    		"}" + NEWLINE +
    
    		"RJava_Interface_Node* newListHead = NULL;" + NEWLINE + 
    		"RJava_Interface_Node* newListIter = NULL;" + NEWLINE + 
    		"RJava_Interface_Node* oldListIter = ((RJava_Common_Class*)super_class) -> interfaces;" + NEWLINE +
    		"RJava_Interface_Node* prevNewListNode = NULL;" + NEWLINE + 
    
    		"for (; oldListIter != NULL; oldListIter = oldListIter->next) {" + NEWLINE + 
    		"  newListIter = (RJava_Interface_Node*) malloc(sizeof(RJava_Interface_Node));" + NEWLINE + 
    		"  newListIter->name = malloc(strlen(oldListIter->name)+1);" + NEWLINE +
    		"  strcpy(newListIter->name, oldListIter->name);" + NEWLINE + 

    		"  newListIter->address = malloc(oldListIter->interface_size);" + NEWLINE + 
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
    
    // void rjava_debug_print_header(char* name, void* this_class);
    private static final String RJAVA_DEBUG_PRINT_HEADER_SOURCE =
            "printf(\"%s:\\n\", name);" + NEWLINE +
            "printf(\" super:%d\\n\", ((RJava_Common_Class*)this_class)->super_class != NULL);" + NEWLINE + 
            "if (((RJava_Common_Class*)this_class)->interfaces == NULL) {" + NEWLINE + 
            "  printf(\" interfaces:none\\n\");" + NEWLINE + 
            "  return;" + NEWLINE + 
            "} " + NEWLINE + 
            "RJava_Interface_Node* iter = ((RJava_Common_Class*)this_class)->interfaces;" + NEWLINE +
            "for (; iter != NULL; iter = iter->next) {" + NEWLINE +
            "  printf(\" interface:%s\\n\", iter->name);" + NEWLINE +
            "}" + NEWLINE;
    
    // void* rjava_new_array(int length, long ele_size);
    public static final String RJAVA_NEW_ARRAY_SOURCE = 
            "void* ret = " + MALLOC + "(sizeof(int) + sizeof(long) + ele_size * length);" + NEWLINE +
            "*((int*)ret) = length;" + NEWLINE + 
            "*((long*)(ret + sizeof(int))) = ele_size;" + NEWLINE +
            "return ret;" + NEWLINE;
    
    // void* rjava_access_array(void* array, int index);
    public static final String RJAVA_ACCESS_ARRAY_SOURCE = 
            "long ele_size = *((long*)(array + sizeof(int)));" + NEWLINE +
            "return (array + sizeof(int) + sizeof(long) + ele_size * index);" + NEWLINE;
    
    // int rjava_length_of_array(void* array);
    public static final String RJAVA_LENGTH_OF_ARRAY_SOURCE = 
            "return *((int*)array);" + NEWLINE;
    
    // void* rjava_c_array_to_rjava_array(int length, long ele_size, void* c_array);
    public static final String RJAVA_C_ARRAY_TO_RJAVA_ARRAY_SOURCE = 
            "void* ret = rjava_new_array(length, ele_size);" + NEWLINE +
            "void* src_ptr = c_array;" + NEWLINE +
            "void* dst_ptr = ret + sizeof(int) + sizeof(long);" + NEWLINE +
            "int i = 0;" + NEWLINE +
            "for (; i < length; i = i + 1) {" + NEWLINE +
            "  memcpy(dst_ptr, src_ptr, ele_size);" + NEWLINE +
            "  dst_ptr = dst_ptr + ele_size;" + NEWLINE + 
            "  src_ptr = src_ptr + ele_size;" + NEWLINE +
            "}" + NEWLINE +
            "return ret;" + NEWLINE;
}
