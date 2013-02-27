package org.rjava.compiler.targets.c.runtime;

import static org.rjava.compiler.targets.c.CLanguageGenerator.NEWLINE;
import static org.rjava.compiler.targets.c.CLanguageGenerator.MALLOC;
import static org.rjava.compiler.targets.c.CLanguageGenerator.SIZE_OF;
import static org.rjava.compiler.targets.c.CLanguageGenerator.SEMICOLON;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.rjava.compiler.Constants;
import org.rjava.compiler.exception.RJavaError;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.targets.CodeStringBuilder;
import org.rjava.compiler.targets.c.CLanguageGenerator;
import org.rjava.compiler.targets.c.CLanguageNameGenerator;
import org.rjava.compiler.util.HelperMethod;
import org.rjava.compiler.util.HelperVariable;
import org.rjava.compiler.util.Tree;
import org.rjava.compiler.util.TreeBreadthFirstIterator;

public class CLanguageRuntime {
    public static final int DEFAULT_MALLOC      = 0;
    public static final int GC_MALLOC           = 1;
    public static final int DL_MALLOC           = 2;
    public static final int GC_MALLOC_PREBUILT  = 3;

    public static final int MEMORY_MANAGEMENT_SCHEME = GC_MALLOC_PREBUILT;
    
    CLanguageGenerator generator;
    CLanguageNameGenerator name;
    
    public CLanguageRuntime(CLanguageGenerator generator) {
        this.generator = generator;
        name = new CLanguageNameGenerator(generator);
        
        // atomic ops lib
        final boolean ATOMIC_OPS_PREBUILT = true;
        if (ATOMIC_OPS_PREBUILT) {
            MAKE_SUBTASK.put("libatomic_ops.a", "libatomic_ops.a:\n" +
                "\tcp prebuilt/libatomic_ops.a libatomic_ops.a\n");
        } else MAKE_SUBTASK.put("boehm-gc/libatomic_ops/src/atomic_ops.a", "boehm-gc/libatomic_ops/src/atomic_ops.a:\n" +
        		"\tcd boehm-gc/libatomic_ops;./configure;make\n");
        
        // malloc lib
        switch (MEMORY_MANAGEMENT_SCHEME) {
        case DEFAULT_MALLOC: 
            CLanguageGenerator.MALLOC = "malloc";
            break;
        case GC_MALLOC:
            CLanguageGenerator.MALLOC = "GC_malloc";
            EXTRA_INCLUDE.add("#include \"boehm-gc/include/gc.h\"");
            MAKE_SUBTASK.put("boehm-gc.a", "boehm-gc.a:\n" +
                    "\tcd boehm-gc;autoreconf -vif;automake --add-missing;./configure;make -f Makefile.direct\n" +
            		"\tcp boehm-gc/gc.a boehm-gc.a\n");
            break;
        case GC_MALLOC_PREBUILT:
            CLanguageGenerator.MALLOC = "GC_malloc";
            EXTRA_INCLUDE.add("#include \"boehm-gc/include/gc.h\"");
            MAKE_SUBTASK.put("boehm-gc.a", "boehm-gc.a:\n" +
                    "\tcp prebuilt/boehm-gc.a boehm-gc.a\n");
            break;
        case DL_MALLOC:
            CLanguageGenerator.MALLOC = "malloc";
            MAKE_SUBTASK.put("dlmalloc.o", "dlmalloc.o:\n\tgcc -O3 -c -o dlmalloc.o dlmalloc.c\n");
            break;
        }
    }
    
    /*
     * RJava's C implementation helpers
     */
    public static final String INCLUDE_STDIO = "#include <stdio.h>";
    public static final String INCLUDE_STDLIB = "#include <stdlib.h>";
    public static final String INCLUDE_STDBOOL = "#include <stdbool.h>";
    public static final String INCLUDE_INTTYPES = "#include <inttypes.h>";
    public static final String RJAVA_LIB_INCLUDE_FILE  = "rjava_clib.h";
    public static final String RJAVA_LIB_SOURCE_FILE = "rjava_clib.c";
    public static final String RJAVA_LIB_INCLUDE = "#include \"" + RJAVA_LIB_INCLUDE_FILE + "\"";
    public static final String RJAVA_RUNTIME_INCLUDE_FILE = "rjava_crt.h";
    public static final String RJAVA_RUNTIME_SOURCE_FILE = "rjava_crt.c";
    public static final String RJAVA_RUNTIME_INCLUDE = "#include \"" + RJAVA_RUNTIME_INCLUDE_FILE + "\"";
    public static final String[] RJAVA_LIB = {
        "java_io_PrintStream",
        "java_lang_Object",
        "java_lang_System",
        "java_lang_StringBuffer",
        "java_lang_String",
        "java_lang_Integer",
    };
    public static final HashMap<String, String> RJAVA_RUNTIME_DEFINE = new HashMap<String, String>();
    static {
        RJAVA_RUNTIME_DEFINE.put("byte", "char");
    }
    public static final ArrayList<String> EXTRA_INCLUDE = new ArrayList<String>();
    static {
        EXTRA_INCLUDE.add(INCLUDE_INTTYPES);
    }
    public static final HashMap<String, String> MAKE_SUBTASK = new HashMap<String, String>();
    public static final String RJAVA_LIB_DIR = "rjava_clib/";
    
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
    
    /*
     * helper methods
     */
    public static final List<HelperMethod> CRT_HELPERS = new ArrayList<HelperMethod>();
    
    /**
     * init rjava class (application classes)
     * void rjava_class_init()
     */
    public static final HelperMethod HELPER_RJAVA_CLASS_INIT;
    /**
     * init rjava c runtime classes (mostly library classes)
     * void rjava_lib_init()
     */
    public static final HelperMethod HELPER_RJAVA_LIB_INIT;
    
    /**
     * add an interface (instance) to class, used during crt initialization
     * void rjava_add_interface_to_class(void* interface, int interface_size, char* name, RJava_Common_Class* class);
     */
    public static final HelperMethod HELPER_RJAVA_ADD_INTERFACE_TO_CLASS;
    /**
     * change one interface that is already attached to a class, used when subclass overrides a interface method from super class
     * void rjava_alter_interface(void* interface, char* name, RJava_Common_Class* class);
     */
    public static final HelperMethod HELPER_RJAVA_ALTER_INTERFACE;
    /**
     * get one interface from a class, used when invokeinterface happens
     * void* rjava_get_interface(RJava_Interface_Node* list, char* name);
     */
    public static final HelperMethod HELPER_RJAVA_GET_INTERFACE;
    /**
     * init rjava c header for the class (copying stuff from its super_class, and set correct super_class)
     * void rjava_init_header(void* this_class, void* super_class, int super_class_size);
     */
    public static final HelperMethod HELPER_RJAVA_INIT_HEADER;
    /**
     * print the header of a class (debug use)
     * void rjava_debug_print_header(void* this_class, char* name);
     */
    public static final HelperMethod HELPER_RJAVA_DEBUG_PRINT_HEADER;
    
    /*
     *  array implements: an array is a void* that points to a structure (in memory) like this
     *   --------------------------------------------------
     *   | int length | long ele_size | actual array .....|
     *   --------------------------------------------------
     */
    /**
     * used to implement newarray
     * inline void* rjava_new_array(int length, long ele_size);
     */
    public static final HelperMethod HELPER_RJAVA_NEW_ARRAY;
    /**
     * used to implement array access (e.g. array[0])
     * inline void* rjava_access_array(void* array, int index);
     */
    public static final HelperMethod HELPER_RJAVA_ACCESS_ARRAY;
    /**
     * used to implement array.length
     * inline int rjava_length_of_array(void* array);
     */
    public static final HelperMethod HELPER_RJAVA_LENGTH_OF_ARRAY;
    
    /**
     * wrap c array into an rjava c array (add header), this method is not used at the moment
     * void* rjava_c_array_to_rjava_array(int length, long ele_size, void* c_array);
     */
    public static final HelperMethod HELPER_RJAVA_C_ARRAY_TO_RJAVA_ARRAY;
    /**
     * wrap arguments array into rjava array (add header), this is called at the beginning of main method, generated by intrinsics
     * void* rjava_init_args(int argc, char** args)
     */
    public static final HelperMethod HELPER_RJAVA_INIT_ARGS;
    
    static {
        /**
         * init rjava class (application classes)
         * void rjava_class_init()
         */
        HELPER_RJAVA_CLASS_INIT = new HelperMethod("rjava_class_init", HelperMethod.RETURN_VOID, null);
        
        /**
         * init rjava c runtime classes (mostly library classes)
         * void rjava_lib_init()
         */
        HELPER_RJAVA_LIB_INIT = new HelperMethod("rjava_lib_init", HelperMethod.RETURN_VOID, null); 
        
        /**
         * add an interface (instance) to class, used during crt initialization
         * void rjava_add_interface_to_class(void* interface, int interface_size, char* name, RJava_Common_Class* class);
         */
        HELPER_RJAVA_ADD_INTERFACE_TO_CLASS = new HelperMethod("rjava_add_interface_to_class", HelperMethod.RETURN_VOID, new HelperVariable[]{
                                                               new HelperVariable("void*", "interface"),
                                                               new HelperVariable("int", "interface_size"),
                                                               new HelperVariable("char*", "name"),
                                                               new HelperVariable(COMMON_CLASS_STRUCT + "*", "class")
        });
        final String RJAVA_ADD_INTERFACE_TO_CLASS_SOURCE = 
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
        HELPER_RJAVA_ADD_INTERFACE_TO_CLASS.setSource(RJAVA_ADD_INTERFACE_TO_CLASS_SOURCE);
        
        /**
         * change one interface that is already attached to a class, used when subclass overrides a interface method from super class
         * void rjava_alter_interface(void* interface, char* name, RJava_Common_Class* class);
         */
        HELPER_RJAVA_ALTER_INTERFACE = new HelperMethod("rjava_alter_interface", HelperMethod.RETURN_VOID, new HelperVariable[]{
                                                        new HelperVariable("void*", "interface"),
                                                        new HelperVariable("char*", "name"),
                                                        new HelperVariable(COMMON_CLASS_STRUCT + "*", "class")
        });
        final String RJAVA_ALTER_INTERFACE_SOURCE = 
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
        HELPER_RJAVA_ALTER_INTERFACE.setSource(RJAVA_ALTER_INTERFACE_SOURCE);
        
        /**
         * get one interface from a class, used when invokeinterface happens
         * void* rjava_get_interface(RJava_Interface_Node* list, char* name);
         */
        HELPER_RJAVA_GET_INTERFACE = new HelperMethod("rjava_get_interface", "void*", new HelperVariable[]{
                                                      new HelperVariable(INTERFACE_LIST_NODE + "*", "list"),
                                                      new HelperVariable("char*", "name")
        });
        final String RJAVA_GET_INTERFACE_SOURCE = 
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
        HELPER_RJAVA_GET_INTERFACE.setSource(RJAVA_GET_INTERFACE_SOURCE);
        
        /**
         * init rjava c header for the class (copying stuff from its super_class, and set correct super_class)
         * void rjava_init_header(void* this_class, void* super_class, int super_class_size);
         */
        HELPER_RJAVA_INIT_HEADER = new HelperMethod("rjava_init_header", HelperMethod.RETURN_VOID, new HelperVariable[]{
                                                    new HelperVariable("void*", "this_class"),
                                                    new HelperVariable("void*", "super_class"),
                                                    new HelperVariable("int", "super_class_size")
        });
        final String RJAVA_INIT_HEADER_SOURCE = 
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
                "  newListIter = (RJava_Interface_Node*)" + CLanguageGenerator.MALLOC + "(sizeof(RJava_Interface_Node));" + NEWLINE + 
                "  newListIter->name = " + CLanguageGenerator.MALLOC + "(strlen(oldListIter->name)+1);" + NEWLINE +
                "  strcpy(newListIter->name, oldListIter->name);" + NEWLINE + 

                "  newListIter->address = " + CLanguageGenerator.MALLOC + "(oldListIter->interface_size);" + NEWLINE + 
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
        HELPER_RJAVA_INIT_HEADER.setSource(RJAVA_INIT_HEADER_SOURCE);
        
        /**
         * print the header of a class (debug use)
         * void rjava_debug_print_header(void* this_class, char* name);
         */
        HELPER_RJAVA_DEBUG_PRINT_HEADER = new HelperMethod("rjava_debug_print_header", HelperMethod.RETURN_VOID, new HelperVariable[]{
                                                           new HelperVariable("void*", "this_class"),
                                                           new HelperVariable("char*", "name")
        });
        final String RJAVA_DEBUG_PRINT_HEADER_SOURCE =
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
        HELPER_RJAVA_DEBUG_PRINT_HEADER.setSource(RJAVA_DEBUG_PRINT_HEADER_SOURCE);
        
        /**
         * used to implement newarray
         * void* rjava_new_array(int length, long ele_size);
         */
        HELPER_RJAVA_NEW_ARRAY = new HelperMethod("rjava_new_array", "void*", new HelperVariable[]{
                                                  new HelperVariable("int", "length"),
                                                  new HelperVariable("long", "ele_size")
        });
        final String RJAVA_NEW_ARRAY_SOURCE = 
                "void* ret = " + MALLOC + "(sizeof(int) + sizeof(long) + ele_size * length);" + NEWLINE +
                "*((int*)ret) = length;" + NEWLINE + 
                "*((long*)(ret + sizeof(int))) = ele_size;" + NEWLINE +
                "return ret;" + NEWLINE;
        HELPER_RJAVA_NEW_ARRAY.setSource(RJAVA_NEW_ARRAY_SOURCE);
        HELPER_RJAVA_NEW_ARRAY.setMethodDescriptor("inline");
        
        /**
         * used to implement array access (e.g. array[0])
         * inline void* rjava_access_array(void* array, int index);
         */
        HELPER_RJAVA_ACCESS_ARRAY = new HelperMethod("rjava_access_array", "void*", new HelperVariable[]{
                                                     new HelperVariable("void*", "array"),
                                                     new HelperVariable("int", "index")
        });
        final String RJAVA_ACCESS_ARRAY_SOURCE = 
                "long ele_size = *((long*)(array + sizeof(int)));" + NEWLINE +
                "return (array + sizeof(int) + sizeof(long) + ele_size * index);" + NEWLINE;
        HELPER_RJAVA_ACCESS_ARRAY.setSource(RJAVA_ACCESS_ARRAY_SOURCE);
        HELPER_RJAVA_ACCESS_ARRAY.setMethodDescriptor("inline");
        
        /**
         * used to implement array.length
         * inline int rjava_length_of_array(void* array);
         */
        HELPER_RJAVA_LENGTH_OF_ARRAY = new HelperMethod("rjava_length_of_array", "void*", new HelperVariable[]{
                                                        new HelperVariable("void*", "array")
        });
        final String RJAVA_LENGTH_OF_ARRAY_SOURCE = 
                "return *((int*)array);" + NEWLINE;
        HELPER_RJAVA_LENGTH_OF_ARRAY.setSource(RJAVA_LENGTH_OF_ARRAY_SOURCE);
        HELPER_RJAVA_LENGTH_OF_ARRAY.setMethodDescriptor("inline");
        
        /**
         * wrap c array into an rjava c array (add header), this method is not used at the moment
         * void* rjava_c_array_to_rjava_array(int length, long ele_size, void* c_array);
         */
        HELPER_RJAVA_C_ARRAY_TO_RJAVA_ARRAY = new HelperMethod("rjava_c_array_to_rjava_array", "void*", new HelperVariable[]{
                                                               new HelperVariable("int", "length"),
                                                               new HelperVariable("long", "ele_size"),
                                                               new HelperVariable("void*", "c_array")
        });
        final String RJAVA_C_ARRAY_TO_RJAVA_ARRAY_SOURCE = 
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
        HELPER_RJAVA_C_ARRAY_TO_RJAVA_ARRAY.setSource(RJAVA_C_ARRAY_TO_RJAVA_ARRAY_SOURCE);
        
        /**
         * wrap arguments array into rjava array (add header)
         * void* rjava_init_args(int argc, char** args)
         */
        HELPER_RJAVA_INIT_ARGS = new HelperMethod("rjava_init_args", "void*", new HelperVariable[]{
                                                  new HelperVariable("int", "argc"),
                                                  new HelperVariable("char**", "args")
        });
        final String RJAVA_INIT_ARGS_SOURCE = 
                "void* ret = " + invokeHelper(HELPER_RJAVA_NEW_ARRAY, new String[]{"argc-1", "sizeof(java_lang_String*)"}) + ";" + NEWLINE + 
                "int i = 0;" + NEWLINE + 
                "for (; i < argc - 1; i = i + 1) {" + NEWLINE +
                "  *((java_lang_String**)rjava_access_array(ret,i)) = newStringConstant(args[i+1]);" + NEWLINE +
                "}" + NEWLINE +
                "return ret;" + NEWLINE;
        HELPER_RJAVA_INIT_ARGS.setSource(RJAVA_INIT_ARGS_SOURCE);
        
        
        CRT_HELPERS.add(HELPER_RJAVA_ADD_INTERFACE_TO_CLASS);
        CRT_HELPERS.add(HELPER_RJAVA_ALTER_INTERFACE);
        CRT_HELPERS.add(HELPER_RJAVA_GET_INTERFACE);
        CRT_HELPERS.add(HELPER_RJAVA_INIT_HEADER);
        CRT_HELPERS.add(HELPER_RJAVA_DEBUG_PRINT_HEADER);
        CRT_HELPERS.add(HELPER_RJAVA_NEW_ARRAY);
        CRT_HELPERS.add(HELPER_RJAVA_ACCESS_ARRAY);
        CRT_HELPERS.add(HELPER_RJAVA_LENGTH_OF_ARRAY);
        CRT_HELPERS.add(HELPER_RJAVA_INIT_ARGS);
    }
    
    public void generateCRuntime() throws RJavaError {
        // generating lib include
        CodeStringBuilder out = new CodeStringBuilder();
        out.append("#ifndef RJAVA_LIB_H" + NEWLINE);
        out.append("#define RJAVA_LIB_H" + NEWLINE);
        for (String inc : EXTRA_INCLUDE) {
            out.append(inc + NEWLINE);
        }
        out.append(NEWLINE);
        
        out.append(CLanguageGenerator.commentln("defines"));
        for (String key : RJAVA_RUNTIME_DEFINE.keySet()) {
            out.append("#define " + key + " " + RJAVA_RUNTIME_DEFINE.get(key) + NEWLINE);
        }
        out.append(NEWLINE);
        
        // class struct and interface list forward declaration
        out.append("typedef struct " + COMMON_CLASS_STRUCT + " " + COMMON_CLASS_STRUCT + SEMICOLON + NEWLINE);
        out.append("typedef struct " + INTERFACE_LIST_NODE + " " + INTERFACE_LIST_NODE + SEMICOLON + NEWLINE);
        out.append(NEWLINE);
        
        // interface list
        out.append("struct " + INTERFACE_LIST_NODE + " {" + NEWLINE);
        out.increaseIndent();
        out.append("char* " + INTERFACE_LIST_NODE_ATTR_NAME + SEMICOLON + NEWLINE);
        out.append("void* " + INTERFACE_LIST_NODE_ATTR_ADDR + SEMICOLON + NEWLINE);
        out.append("int " + INTERFACE_LIST_NODE_ATTR_SIZE + SEMICOLON + NEWLINE);
        out.append(INTERFACE_LIST_NODE + "* " + INTERFACE_LIST_NODE_ATTR_NEXT + SEMICOLON + NEWLINE);
        out.decreaseIndent();
        out.append("}" + SEMICOLON + NEWLINE);
        out.append(NEWLINE);
        
        out.append("struct " + COMMON_CLASS_STRUCT + " {" + NEWLINE);
        out.increaseIndent();
        out.append(COMMON_CLASS_STRUCT + "* " + SUPER_CLASS + SEMICOLON + NEWLINE);
        out.append(INTERFACE_LIST_NODE + "* " + INTERFACE_LIST + SEMICOLON + NEWLINE);
        out.decreaseIndent();
        out.append("}" + SEMICOLON + NEWLINE);
        out.append(NEWLINE);
        
        // instance struct
        out.append("typedef struct " + COMMON_INSTANCE_STRUCT + " {" + NEWLINE);
        out.appendWithIndent("void* " + POINTER_TO_CLASS_STRUCT + SEMICOLON + NEWLINE);
        out.append("} " + COMMON_INSTANCE_STRUCT + SEMICOLON + NEWLINE);
        
        out.append(NEWLINE);
        
        //out.append("#define RJAVA_STR char *" + NEWLINE);
        out.append("#endif" + NEWLINE);
        
        out.append("#ifndef RJAVA_APP_H" + NEWLINE);
        out.append("#define RJAVA_APP_H" + NEWLINE);
        
        // helper methods
        out.append(signatureHelper(HELPER_RJAVA_CLASS_INIT) + SEMICOLON + NEWLINE);
        for (HelperMethod method : CRT_HELPERS)
            out.append(signatureHelper(method) + SEMICOLON + NEWLINE);        
        
        out.append("#endif" + NEWLINE);
        
        generator.writeTo(out.toString(), Constants.OUTPUT_DIR + RJAVA_RUNTIME_INCLUDE_FILE);
        
        // generating runtime source - for class init()
        CodeStringBuilder crtSource = new CodeStringBuilder();
        crtSource.append(RJAVA_RUNTIME_INCLUDE + NEWLINE);
        crtSource.append(RJAVA_LIB_INCLUDE + NEWLINE);
        crtSource.append(INCLUDE_STDIO + NEWLINE);
        crtSource.append(INCLUDE_STDLIB + NEWLINE);
        crtSource.append(INCLUDE_STDBOOL + NEWLINE);
        for (String app : generator.getTranslatedCHeader()) {
            crtSource.append("#include \"" + app + "\"" + NEWLINE);
        }
        crtSource.append(NEWLINE);
        
        // void rjava_class_init()
        crtSource.append(signatureHelper(HELPER_RJAVA_CLASS_INIT) + " {" + NEWLINE);
        crtSource.increaseIndent();
        crtSource.append(invokeHelper(HELPER_RJAVA_LIB_INIT, null) + SEMICOLON + NEWLINE);
        crtSource.append(getClassInitMethodBody());
        crtSource.decreaseIndent();
        crtSource.append("}" + NEWLINE);
        
        // runtime helpers
        for (HelperMethod method : CRT_HELPERS) {
            crtSource.append(signatureHelper(method) + " {" + NEWLINE);
            crtSource.appendWithIndent(method.getSource());
            crtSource.append("}" + NEWLINE);
        }
        generator.writeTo(crtSource.toString(), Constants.OUTPUT_DIR + RJAVA_RUNTIME_SOURCE_FILE);
        
        // copy lib files
        try {
            FileUtils.copyDirectory(new File(RJAVA_LIB_DIR), new File(Constants.OUTPUT_DIR), false);
            Runtime.getRuntime().exec("chmod -R 777 " + Constants.OUTPUT_DIR);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RJavaError("Error when copying lib files: " + e.getMessage());
        }
        
        /*
         *  generate makefile
         */
        CodeStringBuilder makeFile = new CodeStringBuilder();
        
        // add dependencies
        makeFile.append("all: ");
        for (String lib : MAKE_SUBTASK.keySet())
            makeFile.append(lib + " ");
        makeFile.append(NEWLINE);
        
        String fileList = "";
        for (String c : generator.getTranslatedCSource())
            fileList += c + " ";
        for (String l : RJAVA_LIB)
            fileList += l + ".c ";
        fileList += RJAVA_RUNTIME_SOURCE_FILE + " ";
        fileList += RJAVA_LIB_SOURCE_FILE + " ";
        for (String link : MAKE_SUBTASK.keySet())
            fileList += link + " ";
        
        makeFile.append("\tgcc -O3 -o " + generator.getMainObj() + " ");
        makeFile.append(fileList);
        makeFile.append(" -I .");
        makeFile.append(NEWLINE);
        
        // build static libs
        for (String lib : MAKE_SUBTASK.keySet()) {
            makeFile.append(MAKE_SUBTASK.get(lib));
        }
        
        generator.writeTo(makeFile.toString(), Constants.OUTPUT_DIR + "Makefile");
    }
    
    private String getClassInitMethodBody() {
        CodeStringBuilder body = new CodeStringBuilder();
        
        // init c struct for those classes
        for (Tree<RClass> root : SemanticMap.hierarchy.getRoots()) {
            TreeBreadthFirstIterator<RClass> iter = root.getBreadthFirstIterator();
            while (iter.hasNext()) {
                RClass current = iter.next();
                //System.out.println("Generating class init statements for " + current.getName());
                body.append(CLanguageGenerator.commentln("init for " + name.get(current)));
                body.append(generator.getClassInitMap().get(current.getName()).toString());
                body.append("\n\n");
            }
        }
        
        // calling <clinit> for those classes
        body.append(CLanguageGenerator.commentln("calling <clinit> for RJava classes"));
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
    
    /**
     * get the signature of a helper method (including method descriptor, return type, method name, and parameters)
     * @param method
     * @return
     */
    public static String signatureHelper(HelperMethod method) {
        String ret = method.getMethodDescriptor() + " " + method.getReturnType() + " " + method.getMethodName() + "(";
        ArrayList<HelperVariable> args = method.getParameters();
        for (int i = 0; i < args.size(); i++) {
            ret += args.get(i).getType() + " " + args.get(i).getName();
            if (i != args.size() - 1)
                ret += ", ";
        }
        ret += ")";
        return ret;
    }
    
    /**
     * get the invoke expression of a helper method
     * @param method
     * @param args
     * @return
     */
    public static String invokeHelper(HelperMethod method, String[] args) {
        assert (args.length == method.getParameters().size());
        
        String ret = method.getMethodName() + "(";
        if (args != null)
            for (int i = 0; i < args.length; i++) {
                ret += args[i];
                if (i != args.length - 1)
                    ret += ", ";
            }
        ret += ")";
        return ret;
    }
}
