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
import org.rjava.compiler.RJavaCompiler;
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
    
    /*
     * RJava's C implementation helpers
     */
    // include c standard lib
    public static final String[] C_STD_LIB_HEADER = {
        "stdio.h",
        "stdlib.h",
        "stdbool.h",
        "inttypes.h",
        "pthread.h"
    };
    // rjava's java.lang lib
    public static final String RJAVA_LIB = "rjava_clib";
    // rjava runtime (including some defines and helpers)
    public static final String RJAVA_CRT = "rjava_crt";
    // runtime define before include (an ugly hack) because we need to define GC_THREADS before including boehm gc header
    public static final HashMap<String, String> RJAVA_RUNTIME_DEFINE_BEFORE_INCLUDE = new HashMap<String, String>();
    static {
        if (MEMORY_MANAGEMENT_SCHEME == GC_MALLOC || MEMORY_MANAGEMENT_SCHEME == GC_MALLOC_PREBUILT)
            RJAVA_RUNTIME_DEFINE_BEFORE_INCLUDE.put("GC_THREADS", "");
    }
    // runtime define
    public static final HashMap<String, String> RJAVA_RUNTIME_DEFINE = new HashMap<String, String>();
    static {
        RJAVA_RUNTIME_DEFINE.put("byte", "char");
        
        if (RJavaCompiler.debugTarget) {
            // allow external source code to know it is debug mode
            RJAVA_RUNTIME_DEFINE.put("DEBUG_TARGET", "1");
            
            // allow programmatically insert gdb breakpoint
            RJAVA_RUNTIME_DEFINE.put("GDB_BREAKPOINT", "asm volatile(\"int3;\")");
        }
        
        if (MEMORY_MANAGEMENT_SCHEME == GC_MALLOC || MEMORY_MANAGEMENT_SCHEME == GC_MALLOC_PREBUILT) {
            RJAVA_RUNTIME_DEFINE.put("malloc", "GC_malloc");
        }
    }
    public static final ArrayList<String> EXTRA_INCLUDE = new ArrayList<String>();
    public static final HashMap<String, String> MAKE_SUBTASK = new HashMap<String, String>();
    public static final String RJAVA_LIB_DIR = "rjava_clib/";
    
    static {
        
        // atomic ops lib
        final boolean ATOMIC_OPS_PREBUILT = true;
        
        if (ATOMIC_OPS_PREBUILT) {
            if (RJavaCompiler.m32) {
                MAKE_SUBTASK.put("libatomic_ops-32.a", "libatomic_ops-32.a:\n" +
                        "\tcp prebuilt/libatomic_ops-32.a libatomic_ops-32.a\n");
            }
            else {
                MAKE_SUBTASK.put("libatomic_ops.a", "libatomic_ops.a:\n" +
                        "\tcp prebuilt/libatomic_ops.a libatomic_ops.a\n");               
            }
        } else RJavaCompiler.incompleteImplementationError();
        
        // malloc lib
        switch (MEMORY_MANAGEMENT_SCHEME) {
        case DEFAULT_MALLOC: 
            CLanguageGenerator.MALLOC = "malloc";
            break;
        case GC_MALLOC:
            CLanguageGenerator.MALLOC = "GC_malloc";
            EXTRA_INCLUDE.add(includeNonStandardHeader("boehm-gc/include/gc.h"));
            // FIXME: make it work for -m32 -> ./configure "CFLAGS=-m32" "LDFLAGS=-m32"
            MAKE_SUBTASK.put("boehm-gc.a", "boehm-gc.a:\n" +
                    "\tcd boehm-gc;autoreconf -vif;automake --add-missing;./configure;make -f Makefile.direct\n" +
                    "\tcp boehm-gc/gc.a boehm-gc.a\n");
            break;
        case GC_MALLOC_PREBUILT:
            CLanguageGenerator.MALLOC = "GC_malloc";
            EXTRA_INCLUDE.add(includeNonStandardHeader("boehm-gc/include/gc.h"));
            if (RJavaCompiler.m32) {
                MAKE_SUBTASK.put("boehm-gc-32.a", "boehm-gc-32.a:\n" +
                    "\tcp prebuilt/boehm-gc-32.a boehm-gc-32.a\n");
            }else MAKE_SUBTASK.put("boehm-gc.a", "boehm-gc.a:\n" +
                    "\tcp prebuilt/boehm-gc.a boehm-gc.a\n");
            break;
        case DL_MALLOC:
            CLanguageGenerator.MALLOC = "malloc";
            MAKE_SUBTASK.put("dlmalloc.o", "dlmalloc.o:\n\tgcc -O3 -c -o dlmalloc.o dlmalloc.c\n");
            break;
        }
    }
    
    /*
     * RJava's C Object
     */
    // related with dyanmic dispatching
    /* rjava class */
    public static final String COMMON_CLASS_STRUCT = "RJava_Common_Class";
    public static final String EMBED_SUPER_CLASS  = "class_header";
    public static final String SUPER_CLASS = "super_class";
    public static final String INTERFACE_LIST = "interfaces";
    public static final String CLASS_STRUCT_SUFFIX = "_class";
    public static final String CLASS_STRUCT_INSTANCE_SUFFIX = "_class_instance";
    public static final String CLASS_NAME = "class_name";
    /* rjava instance/object */
    public static final String POINTER_TO_CLASS_STRUCT = "class_struct";    // in object, pointing to its class
    public static final String EMBED_SUPER_OBJECT = "instance_header";
    public static final String COMMON_INSTANCE_STRUCT = "RJava_Common_Instance";
    /* interface */
    public static final String INTERFACE_LIST_NODE = "RJava_Interface_Node";
    public static final String INTERFACE_STRUCT_SUFFIX = "";
    public static final String INTERFACE_LIST_NODE_ATTR_NAME = "name";
    public static final String INTERFACE_LIST_NODE_ATTR_ADDR = "address";
    public static final String INTERFACE_LIST_NODE_ATTR_NEXT = "next";
    public static final String INTERFACE_LIST_NODE_ATTR_SIZE = "interface_size";
    /* mutex */
    public static final String MUTEX_TYPE = "pthread_mutex_t";
    public static final String INSTANCE_MUTEX = "instance_mutex";
    public static final String CLASS_MUTEX = "class_mutex";
    
    public static final String COND_VAR_TYPE = "pthread_cond_t";
    public static final String INSTANCE_COND_VAR = "instance_cond";
    
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
    /**
     * assert
     * void rjava_assert(bool cond);
     */
    public static final HelperMethod HELPER_RJAVA_ASSERT;
    /**
     * implements instanceof bytecode
     * bool rjava_instanceof(void* instance, void* class_struct);
     */
    public static final HelperMethod HELPER_RJAVA_INSTANCEOF;
    
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
     * used to implement new multiarray
     * inline void* rjava_new_multiarray(int[] dimensions, int dimension_size, long ele_size);
     */
    public static final HelperMethod HELPER_RJAVA_NEW_MULTIARRAY;
    
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
         * assert
         * void rjava_assert(bool cond, char* str);
         */
        HELPER_RJAVA_ASSERT = new HelperMethod("rjava_assert", "void", new HelperVariable[]{new HelperVariable("bool", "cond"), new HelperVariable("char*", "str")});
        final String RJAVA_ASSERT_SOURCE  = 
                "if (!cond) {" + NEWLINE + 
                "  printf(\"RJava C assertion failed: %s\\n\", str);" + NEWLINE + 
                "  java_lang_Thread_dumpStack();" + NEWLINE +
                "  exit(1);" + NEWLINE +
                "}" + NEWLINE;    
        HELPER_RJAVA_ASSERT.setSource(RJAVA_ASSERT_SOURCE);
        
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
        
                "((RJava_Common_Class*)this_class) -> interfaces = newListHead;" + NEWLINE +
                "pthread_mutex_init(&(((RJava_Common_Class*)this_class) -> " + CLASS_MUTEX + "), NULL);" + NEWLINE;
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
         * implements instanceof bytecode
         * bool rjava_instanceof(void* instance, void* class_struct);
         */
        HELPER_RJAVA_INSTANCEOF = new HelperMethod("rjava_instanceof", "bool", new HelperVariable[]{
                                                                new HelperVariable("void*", "instance"),
                                                                new HelperVariable("void*", "class_struct")
        });
        final String RJAVA_INSTANCEOF_SOURCE = 
                "if (" +
                "((" + COMMON_INSTANCE_STRUCT + "*) instance) -> " + POINTER_TO_CLASS_STRUCT + " == class_struct" +
                ")" + NEWLINE +
                "return 1" + SEMICOLON + NEWLINE +
                COMMON_CLASS_STRUCT + "* super_struct = ((" + COMMON_CLASS_STRUCT + "*)(((" + COMMON_INSTANCE_STRUCT + "*) instance) -> " + POINTER_TO_CLASS_STRUCT + ")) -> " + SUPER_CLASS + SEMICOLON + NEWLINE +
                "while(super_struct != NULL) {" + NEWLINE +
                "  if (super_struct == class_struct) return 1" + SEMICOLON + NEWLINE +
                "  super_struct = super_struct -> " + SUPER_CLASS + SEMICOLON + NEWLINE +
                "}" + NEWLINE +
                "return 0" + SEMICOLON + NEWLINE;
        HELPER_RJAVA_INSTANCEOF.setSource(RJAVA_INSTANCEOF_SOURCE);
        
        /**
         * used to implement array.length
         * inline int rjava_length_of_array(void* array);
         */
        HELPER_RJAVA_LENGTH_OF_ARRAY = new HelperMethod("rjava_length_of_array", "int", new HelperVariable[]{
                                                        new HelperVariable("void*", "array")
        });
        final String RJAVA_LENGTH_OF_ARRAY_SOURCE = 
                "return *((int*)array);" + NEWLINE;
        HELPER_RJAVA_LENGTH_OF_ARRAY.setSource(RJAVA_LENGTH_OF_ARRAY_SOURCE);
        HELPER_RJAVA_LENGTH_OF_ARRAY.setMethodDescriptor("inline");
        
        /**
         * used to implement array access (e.g. array[0])
         * inline void* rjava_access_array(void* array, int index);
         */
        HELPER_RJAVA_ACCESS_ARRAY = new HelperMethod("rjava_access_array", "void*", new HelperVariable[]{
                                                     new HelperVariable("void*", "array"),
                                                     new HelperVariable("int", "index")
        });
        final String RJAVA_ACCESS_ARRAY_SOURCE = 
                (RJavaCompiler.getGeneratorOptions().allowArrayBoundCheck() ?
                        (
                        CLanguageGenerator.commentln("bounds check") + NEWLINE +
                        "int length = " + invokeHelper(HELPER_RJAVA_LENGTH_OF_ARRAY, new String[]{"array"}) + SEMICOLON + NEWLINE +
                        "if (index >= length || index < 0) {" + NEWLINE +
                        "char* str = (char*)" + CLanguageGenerator.MALLOC + "(1000)" + SEMICOLON + NEWLINE +
                        "sprintf(str, \"index(%d) out of bounds(%d)\", index, length)" + SEMICOLON + NEWLINE +
                        invokeHelper(HELPER_RJAVA_ASSERT, new String[]{"false", "str"}) + SEMICOLON + NEWLINE
                        + "}" + NEWLINE) 
                        : 
                        "") +
                "long ele_size = *((long*)(array + sizeof(int)));" + NEWLINE +
                "return (array + sizeof(int) + sizeof(long) + ele_size * index);" + NEWLINE;
        HELPER_RJAVA_ACCESS_ARRAY.setSource(RJAVA_ACCESS_ARRAY_SOURCE);
        HELPER_RJAVA_ACCESS_ARRAY.setMethodDescriptor("inline");
        
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
                // zeroing the array
                "int i = 0;" + NEWLINE + 
                "for(; i < length; i++)" + NEWLINE +
                "  *(char**)(rjava_access_array(ret, i)) = NULL;" + NEWLINE +
                "return ret;" + NEWLINE;
        HELPER_RJAVA_NEW_ARRAY.setSource(RJAVA_NEW_ARRAY_SOURCE);
        HELPER_RJAVA_NEW_ARRAY.setMethodDescriptor("inline");
        
        /**
         * used to implement new multiarray
         * inline void* rjava_new_multiarray(int[] dimensions, int dimension_size, long ele_size);
         */
        HELPER_RJAVA_NEW_MULTIARRAY = new HelperMethod("rjava_new_multiarray", "void*", new HelperVariable[]{
                                                       new HelperVariable("int*", "dimensions"),
                                                       new HelperVariable("int", "dimension_size"),
                                                       new HelperVariable("long", "ele_size")
        });
        final String RJAVA_NEW_MULTIARRAY_SOURCE = 
                "if (dimension_size == 1)" + NEWLINE +
                "return " + invokeHelper(HELPER_RJAVA_NEW_ARRAY, new String[]{"dimensions[0]", "ele_size"}) + ";" + NEWLINE +
                "void* ret = " + invokeHelper(HELPER_RJAVA_NEW_ARRAY, new String[]{"dimensions[0]", "sizeof(void*)"}) + ";" + NEWLINE +
                "int i = 0;" + NEWLINE +
                "for (; i < dimensions[0]; i++) {" + NEWLINE +
                " *((char**)" + invokeHelper(HELPER_RJAVA_ACCESS_ARRAY, new String[]{"ret", "i"}) + ") = (char*) rjava_new_multiarray(&dimensions[1], dimension_size - 1, ele_size);" + NEWLINE +
                "}" + NEWLINE + 
                "return ret;" + NEWLINE;
        HELPER_RJAVA_NEW_MULTIARRAY.setSource(RJAVA_NEW_MULTIARRAY_SOURCE);
        HELPER_RJAVA_NEW_MULTIARRAY.setMethodDescriptor("inline");
        
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
        CRT_HELPERS.add(HELPER_RJAVA_NEW_MULTIARRAY);
        CRT_HELPERS.add(HELPER_RJAVA_C_ARRAY_TO_RJAVA_ARRAY);
        CRT_HELPERS.add(HELPER_RJAVA_ASSERT);
        CRT_HELPERS.add(HELPER_RJAVA_INSTANCEOF);
    }
    
    
    CLanguageGenerator generator;
    CLanguageNameGenerator name;
    
    public CLanguageRuntime(CLanguageGenerator generator) {
        this.generator = generator;
        name = new CLanguageNameGenerator(generator);
    }    
    
    public void generateCRuntime() throws RJavaError {
        /*
         *  generating crt header
         */
        CodeStringBuilder out = new CodeStringBuilder();
        out.append("#ifndef RJAVA_CRT_H" + NEWLINE);
        out.append("#define RJAVA_CRT_H" + NEWLINE);
        
        out.append(CLanguageGenerator.commentln("c std lib"));
        for (String inc : C_STD_LIB_HEADER) {
            out.append(includeStandardHeader(inc) + NEWLINE);
        }
        
        out.append(CLanguageGenerator.commentln("some defines prior to include"));
        for (String key : RJAVA_RUNTIME_DEFINE_BEFORE_INCLUDE.keySet()) {
            out.append("#define " + key + " " + RJAVA_RUNTIME_DEFINE_BEFORE_INCLUDE.get(key) + NEWLINE);
        }
        out.append(NEWLINE);
        
        out.append(CLanguageGenerator.commentln("extra header"));
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
        out.append(MUTEX_TYPE + " " + CLASS_MUTEX + SEMICOLON + NEWLINE);
        if (RJavaCompiler.debugTarget)
            out.append("char* " + CLASS_NAME + SEMICOLON + NEWLINE);
        out.decreaseIndent();
        out.append("}" + SEMICOLON + NEWLINE);
        out.append(NEWLINE);
        
        // instance struct
        out.append("typedef struct " + COMMON_INSTANCE_STRUCT + " {" + NEWLINE);
        out.increaseIndent();
        out.append("void* " + POINTER_TO_CLASS_STRUCT + SEMICOLON + NEWLINE);
        out.append(MUTEX_TYPE + " " + INSTANCE_MUTEX + SEMICOLON + NEWLINE);
        out.append(COND_VAR_TYPE + " " + INSTANCE_COND_VAR + SEMICOLON + NEWLINE);
        out.decreaseIndent();
        out.append("} " + COMMON_INSTANCE_STRUCT + SEMICOLON + NEWLINE);
        
        out.append(NEWLINE);
        
        // helper methods
        out.append(signatureHelper(HELPER_RJAVA_CLASS_INIT) + SEMICOLON + NEWLINE);
        for (HelperMethod method : CRT_HELPERS)
            out.append(signatureHelper(method) + SEMICOLON + NEWLINE);        
        
        out.append("#endif" + NEWLINE);
        
        generator.writeTo(out.toString(), RJavaCompiler.outputDir + RJAVA_CRT + ".h");
        
        /*
         *  generating runtime source - for class init()
         */
        CodeStringBuilder crtSource = new CodeStringBuilder();
        crtSource.append(includeNonStandardHeader(RJAVA_CRT + ".h") + NEWLINE);
        crtSource.append(includeNonStandardHeader(RJAVA_LIB + ".h") + NEWLINE);
        for (String app : generator.getTranslatedCHeader()) {
            crtSource.append(includeNonStandardHeader(app) + NEWLINE);
        }
        crtSource.append(NEWLINE);
        
        // void rjava_class_init()
        crtSource.append(signatureHelper(HELPER_RJAVA_CLASS_INIT) + " {" + NEWLINE);
        crtSource.increaseIndent();
        crtSource.append("GC_init()" + SEMICOLON + NEWLINE);        // init boehm gc
        crtSource.append(invokeHelper(HELPER_RJAVA_LIB_INIT, null) + SEMICOLON + NEWLINE);
        crtSource.append(getClassInitMethodBody());
        crtSource.decreaseIndent();
        crtSource.append("}" + NEWLINE);
        
        // runtime helpers
        for (HelperMethod method : CRT_HELPERS) {
            crtSource.append(NEWLINE);
            crtSource.append(CLanguageGenerator.commentln(signatureHelper(method)));
            crtSource.append(signatureHelper(method) + " {" + NEWLINE);
            crtSource.appendWithIndent(method.getSource());
            crtSource.append("}" + NEWLINE);
        }
        generator.writeTo(crtSource.toString(), RJavaCompiler.outputDir + RJAVA_CRT + ".c");
    }

    public void copyJavaLibrary() throws RJavaError {
        // copy lib files
        try {
            FileUtils.copyDirectory(new File(RJAVA_LIB_DIR), new File(RJavaCompiler.outputDir), false);
            Runtime.getRuntime().exec("chmod -R 777 " + RJavaCompiler.outputDir);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RJavaError("Error when copying lib files: " + e.getMessage());
        }
    }

    public void generateGNUMakefile() throws RJavaError {
        final String C_FLAGS = "-I . " + (RJavaCompiler.debugTarget ? "-g" : "-O3") + " -lpthread " + (RJavaCompiler.m32 ? "-m32" : "");
        /*
         *  generate makefile
         */
        CodeStringBuilder makeFile = new CodeStringBuilder();
        
        makeFile.append("# Make file generated by RJava Compiler" + NEWLINE);
        makeFile.append(NEWLINE);
        
        makeFile.append("ifneq (,)" + NEWLINE);
        makeFile.append("This makefile requires GNU Make." + NEWLINE);
        makeFile.append("endif" + NEWLINE);
        makeFile.append(NEWLINE);

        // are we generating library?
        boolean library = (generator.getMainObj() == null);
        
        // general settings/flags
        makeFile.append(library ? "PROGRAM = lib" : "PROGRAM = " + generator.getMainObj());
        makeFile.append(NEWLINE);
        makeFile.append("C_FILES := $(wildcard *.c)" + NEWLINE);
        makeFile.append("OBJS := $(patsubst %.c, %.o, $(C_FILES))" + NEWLINE);
        makeFile.append("CC = gcc" + NEWLINE);
        makeFile.append("CFLAGS = " + C_FLAGS + NEWLINE);
        makeFile.append("LDFLAGS = " + NEWLINE);
        makeFile.append(NEWLINE);
        
        makeFile.append("all: $(PROGRAM)" + NEWLINE);
        makeFile.append(NEWLINE);
        
        // main obj
        makeFile.append("$(PROGRAM): .depend $(OBJS) ");
        String libs = "";
        for (String lib : MAKE_SUBTASK.keySet())
            libs += lib + " ";
        makeFile.append(libs + NEWLINE);
        makeFile.append("\t$(CC) $(CFLAGS) $(OBJS) " + libs + "$(LDFLAGS) ");
        makeFile.append(library ? "-c -fPIC" : "-o $(PROGRAM)");
        makeFile.append(NEWLINE);
        makeFile.append(NEWLINE);
        
        // generating dependency
        makeFile.append("depend: .depend" + NEWLINE);
        makeFile.append(NEWLINE);
        
        makeFile.append(".depend: cmd = gcc -MM -MF depend $(var); cat depend >> .depend;" + NEWLINE);
        makeFile.append(".depend:" + NEWLINE);
        makeFile.append("\t@echo \"Generating dependencies...\"" + NEWLINE);
        makeFile.append("\t$(foreach var, $(C_FILES), $(cmd))" + NEWLINE);
        makeFile.append("\t@rm -f depend" + NEWLINE);
        makeFile.append(NEWLINE);
        
        makeFile.append("-include .depend" + NEWLINE);
        makeFile.append(NEWLINE);
        
        // compiling all c files
        makeFile.append("%.o: %.c" + NEWLINE);
        makeFile.append("\t$(CC) $(CFLAGS) -c $< -o $@" + NEWLINE);
        makeFile.append(NEWLINE);
        
        makeFile.append("%: %.c" + NEWLINE);
        makeFile.append("\t$(CC) $(CFLAGS) -o $@ $<" + NEWLINE);
        makeFile.append(NEWLINE);
        
        // clean
        makeFile.append("clean:" + NEWLINE);
        makeFile.append("\trm -f .depend *.o" + NEWLINE);
        makeFile.append(NEWLINE);
        
        makeFile.append(".PHONY: clean depend" + NEWLINE);

        // library build
        for (String lib : MAKE_SUBTASK.keySet()) {
            makeFile.append(MAKE_SUBTASK.get(lib));
        }
        
        generator.writeTo(makeFile.toString(), RJavaCompiler.outputDir + "Makefile");
    }
    
    private String getClassInitMethodBody() {
        CodeStringBuilder body = new CodeStringBuilder();
        
        // init c struct for those classes
        for (Tree<RClass> root : SemanticMap.hierarchy.getRoots()) {
            TreeBreadthFirstIterator<RClass> iter = root.getBreadthFirstIterator();
            while (iter.hasNext()) {
                RClass current = iter.next();
                if (generator.getClassInitMap().containsKey(current.getName())) {
                    body.append(CLanguageGenerator.commentln("init for " + name.get(current, false)));
                    body.append(generator.getClassInitMap().get(current.getName()).toString());
                    body.append("\n\n");
                }
            }
        }
        
        // calling <clinit> for those classes        
        body.append(CLanguageGenerator.commentln("calling <clinit> for RJava classes"));
        for (RClass klass : SemanticMap.dependencyGraph.getClassInitializationOrder()) {
            System.out.print("will init [" + klass + "]");
            if (klass.getCLInitMethod() != null) {
                body.append(name.get(klass.getCLInitMethod()) + "();\n");
                System.out.println();
            }
            else System.out.println(": no <clinit>");
        }

        return body.toString();
    }
    
    /**
     * get the signature of a helper method (including method descriptor, return type, method name, and parameters)
     * @param method
     * @return
     */
    public static String signatureHelper(HelperMethod method) {
        String ret = (method.getMethodDescriptor().equals("") ? "" : method.getMethodDescriptor() + " ") + method.getReturnType() + " " + method.getMethodName() + "(";
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
        assert (args == null || args.length == method.getParameters().size());
        
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
    
    /**
     * #include <header>
     * @param header
     * @return
     */
    public static String includeStandardHeader(String header) {
        return "#include <" + header + ">";
    }
    
    /**
     * #include "header"
     * @param header
     * @return
     */
    public static String includeNonStandardHeader(String header) {
        return "#include \"" + header + "\"";
    }
}
