package org.rjava.compiler.targets.c.runtime;

import static org.rjava.compiler.targets.c.CLanguageGenerator.MALLOC;
import static org.rjava.compiler.targets.c.CLanguageGenerator.NEWLINE;
import static org.rjava.compiler.targets.c.CLanguageGenerator.SEMICOLON;
import static org.rjava.compiler.targets.c.CLanguageGenerator.SIZE_OF;

import java.util.ArrayList;
import java.util.List;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.targets.c.CLanguageGenerator;
import org.rjava.compiler.util.HelperMethod;
import org.rjava.compiler.util.HelperVariable;

import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.COMMON_CLASS_STRUCT;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.EMBED_SUPER_CLASS;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.SUPER_CLASS;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.INTERFACE_LIST;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.CLASS_STRUCT_SUFFIX;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.CLASS_NAME;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.POINTER_TO_CLASS_STRUCT;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.EMBED_SUPER_OBJECT;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.COMMON_INSTANCE_STRUCT;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.INTERFACE_LIST_NODE;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.INTERFACE_STRUCT_SUFFIX;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.INTERFACE_LIST_NODE_ATTR_NAME;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.INTERFACE_LIST_NODE_ATTR_ADDR;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.INTERFACE_LIST_NODE_ATTR_NEXT;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.INTERFACE_LIST_NODE_ATTR_SIZE;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.MUTEX_TYPE;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.INSTANCE_MUTEX;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.COND_VAR_TYPE;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.INSTANCE_COND_VAR;
import static org.rjava.compiler.targets.c.runtime.CLanguageRuntime.CLASS_MUTEX;

public class RuntimeHelpers {

    /*
     * helper methods
     */
    public static final List<HelperMethod> CRT_HELPERS = new ArrayList<HelperMethod>();
    
    /**
     * init rjava class (application classes)
     * void rjava_class_init()
     */
    public static final HelperMethod CLASS_INIT;
    /**
     * init rjava c runtime classes (mostly library classes)
     * void rjava_lib_init()
     */
    public static final HelperMethod LIB_INIT;
    
    /**
     * add an interface (instance) to class, used during crt initialization
     * void rjava_add_interface_to_class(void* interface, int interface_size, char* name, RJava_Common_Class* class);
     */
    public static final HelperMethod ADD_INTERFACE_TO_CLASS;
    /**
     * change one interface that is already attached to a class, used when subclass overrides a interface method from super class
     * void rjava_alter_interface(void* interface, char* name, RJava_Common_Class* class);
     */
    public static final HelperMethod ALTER_INTERFACE;
    /**
     * get one interface from a class, used when invokeinterface happens
     * void* rjava_get_interface(RJava_Interface_Node* list, char* name);
     */
    public static final HelperMethod GET_INTERFACE;
    /**
     * init rjava c header for the class (copying stuff from its super_class, and set correct super_class)
     * void rjava_init_header(void* this_class, void* super_class, int super_class_size);
     */
    public static final HelperMethod INIT_HEADER;
    /**
     * print the header of a class (debug use)
     * void rjava_debug_print_header(void* this_class, char* name);
     */
    public static final HelperMethod DEBUG_PRINT_HEADER;
    /**
     * assert
     * void rjava_assert(bool cond);
     */
    public static final HelperMethod ASSERT;
    /**
     * implements instanceof bytecode
     * bool rjava_instanceof(void* instance, void* class_struct);
     */
    public static final HelperMethod INSTANCEOF;
    /**
     * install signal handler to allow thread suspend
     * void rjava_init_thread_suspending();
     */
    public static final HelperMethod INIT_THREAD_SUSPENDING;
    
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
    public static final HelperMethod NEW_ARRAY;
    /**
     * used to implement array access (e.g. array[0])
     * inline void* rjava_access_array(void* array, int index);
     */
    public static final HelperMethod ACCESS_ARRAY;
    /**
     * used to implement array.length
     * inline int rjava_length_of_array(void* array);
     */
    public static final HelperMethod LENGTH_OF_ARRAY;
    /**
     * used to implement new multiarray
     * inline void* rjava_new_multiarray(int[] dimensions, int dimension_size, long ele_size);
     */
    public static final HelperMethod NEW_MULTIARRAY;
    
    /**
     * wrap c array into an rjava c array (add header), this method is not used at the moment
     * void* rjava_c_array_to_rjava_array(int length, long ele_size, void* c_array);
     */
    public static final HelperMethod C_ARRAY_TO_RJAVA_ARRAY;
    /**
     * wrap arguments array into rjava array (add header), this is called at the beginning of main method, generated by intrinsics
     * void* rjava_init_args(int argc, char** args)
     */
    public static final HelperMethod INIT_ARGS;
    
    static {
        /**
         * assert
         * void rjava_assert(bool cond, char* str);
         */
        ASSERT = new HelperMethod("rjava_assert", "void", new HelperVariable[]{new HelperVariable("bool", "cond"), new HelperVariable("char*", "str")});
        final String RJAVA_ASSERT_SOURCE  = 
                "if (!cond) {" + NEWLINE + 
                "  printf(\"RJava C assertion failed: %s\\n\", str);" + NEWLINE + 
                "  java_lang_Thread_dumpStack();" + NEWLINE +
                "  exit(1);" + NEWLINE +
                "}" + NEWLINE;    
        ASSERT.setSource(RJAVA_ASSERT_SOURCE);
        
        /**
         * init rjava class (application classes)
         * void rjava_class_init()
         */
        CLASS_INIT = new HelperMethod("rjava_class_init", HelperMethod.RETURN_VOID, null);
        
        /**
         * init rjava c runtime classes (mostly library classes)
         * void rjava_lib_init()
         */
        LIB_INIT = new HelperMethod("rjava_lib_init", HelperMethod.RETURN_VOID, null); 
        
        /**
         * add an interface (instance) to class, used during crt initialization
         * void rjava_add_interface_to_class(void* interface, int interface_size, char* name, RJava_Common_Class* class);
         */
        ADD_INTERFACE_TO_CLASS = new HelperMethod("rjava_add_interface_to_class", HelperMethod.RETURN_VOID, new HelperVariable[]{
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
        ADD_INTERFACE_TO_CLASS.setSource(RJAVA_ADD_INTERFACE_TO_CLASS_SOURCE);
        
        /**
         * change one interface that is already attached to a class, used when subclass overrides a interface method from super class
         * void rjava_alter_interface(void* interface, char* name, RJava_Common_Class* class);
         */
        ALTER_INTERFACE = new HelperMethod("rjava_alter_interface", HelperMethod.RETURN_VOID, new HelperVariable[]{
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
        ALTER_INTERFACE.setSource(RJAVA_ALTER_INTERFACE_SOURCE);
        
        /**
         * get one interface from a class, used when invokeinterface happens
         * void* rjava_get_interface(RJava_Interface_Node* list, char* name);
         */
        GET_INTERFACE = new HelperMethod("rjava_get_interface", "void*", new HelperVariable[]{
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
        GET_INTERFACE.setSource(RJAVA_GET_INTERFACE_SOURCE);
        
        /**
         * init rjava c header for the class (copying stuff from its super_class, and set correct super_class)
         * void rjava_init_header(void* this_class, void* super_class, int super_class_size);
         */
        INIT_HEADER = new HelperMethod("rjava_init_header", HelperMethod.RETURN_VOID, new HelperVariable[]{
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
        INIT_HEADER.setSource(RJAVA_INIT_HEADER_SOURCE);
        
        /**
         * print the header of a class (debug use)
         * void rjava_debug_print_header(void* this_class, char* name);
         */
        DEBUG_PRINT_HEADER = new HelperMethod("rjava_debug_print_header", HelperMethod.RETURN_VOID, new HelperVariable[]{
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
        DEBUG_PRINT_HEADER.setSource(RJAVA_DEBUG_PRINT_HEADER_SOURCE);
        
        /**
         * implements instanceof bytecode
         * bool rjava_instanceof(void* instance, void* class_struct);
         */
        INSTANCEOF = new HelperMethod("rjava_instanceof", "bool", new HelperVariable[]{
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
        INSTANCEOF.setSource(RJAVA_INSTANCEOF_SOURCE);
        
        /**
         * install signal handler to allow thread suspend
         * void rjava_init_thread_suspending();
         */
        INIT_THREAD_SUSPENDING = new HelperMethod("rjava_init_thread_suspending", "void", null);
        
        /**
         * used to implement array.length
         * inline int rjava_length_of_array(void* array);
         */
        LENGTH_OF_ARRAY = new HelperMethod("rjava_length_of_array", "int", new HelperVariable[]{
                                                        new HelperVariable("void*", "array")
        });
        final String RJAVA_LENGTH_OF_ARRAY_SOURCE = 
                "return *((int*)array);" + NEWLINE;
        LENGTH_OF_ARRAY.setSource(RJAVA_LENGTH_OF_ARRAY_SOURCE);
        LENGTH_OF_ARRAY.setInline(true);
        
        /**
         * used to implement array access (e.g. array[0])
         * inline void* rjava_access_array(void* array, int index);
         */
        ACCESS_ARRAY = new HelperMethod("rjava_access_array", "void*", new HelperVariable[]{
                                                     new HelperVariable("void*", "array"),
                                                     new HelperVariable("int", "index")
        });
        final String RJAVA_ACCESS_ARRAY_SOURCE = 
                (RJavaCompiler.getGeneratorOptions().allowArrayBoundCheck() ?
                        (
                        CLanguageGenerator.commentln("bounds check") + NEWLINE +
                        "int length = " + invoke(LENGTH_OF_ARRAY, new String[]{"array"}) + SEMICOLON + NEWLINE +
                        "if (index >= length || index < 0) {" + NEWLINE +
                        "char* str = (char*)" + CLanguageGenerator.MALLOC + "(1000)" + SEMICOLON + NEWLINE +
                        "sprintf(str, \"index(%d) out of bounds(%d)\", index, length)" + SEMICOLON + NEWLINE +
                        invoke(ASSERT, new String[]{"false", "str"}) + SEMICOLON + NEWLINE
                        + "}" + NEWLINE) 
                        : 
                        "") +
                "long ele_size = *((long*)(array + sizeof(int)));" + NEWLINE +
                "return (array + sizeof(int) + sizeof(long) + ele_size * index);" + NEWLINE;
        ACCESS_ARRAY.setSource(RJAVA_ACCESS_ARRAY_SOURCE);
        ACCESS_ARRAY.setInline(true);
        
        /**
         * used to implement newarray
         * void* rjava_new_array(int length, long ele_size);
         */
        NEW_ARRAY = new HelperMethod("rjava_new_array", "void*", new HelperVariable[]{
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
        NEW_ARRAY.setSource(RJAVA_NEW_ARRAY_SOURCE);
        
        /**
         * used to implement new multiarray
         * void* rjava_new_multiarray(int[] dimensions, int dimension_size, long ele_size);
         */
        NEW_MULTIARRAY = new HelperMethod("rjava_new_multiarray", "void*", new HelperVariable[]{
                                                       new HelperVariable("int*", "dimensions"),
                                                       new HelperVariable("int", "dimension_size"),
                                                       new HelperVariable("long", "ele_size")
        });
        final String RJAVA_NEW_MULTIARRAY_SOURCE = 
                "if (dimension_size == 1)" + NEWLINE +
                "return " + invoke(NEW_ARRAY, new String[]{"dimensions[0]", "ele_size"}) + ";" + NEWLINE +
                "void* ret = " + invoke(NEW_ARRAY, new String[]{"dimensions[0]", "sizeof(void*)"}) + ";" + NEWLINE +
                "int i = 0;" + NEWLINE +
                "for (; i < dimensions[0]; i++) {" + NEWLINE +
                " *((char**)" + invoke(ACCESS_ARRAY, new String[]{"ret", "i"}) + ") = (char*) rjava_new_multiarray(&dimensions[1], dimension_size - 1, ele_size);" + NEWLINE +
                "}" + NEWLINE + 
                "return ret;" + NEWLINE;
        NEW_MULTIARRAY.setSource(RJAVA_NEW_MULTIARRAY_SOURCE);
        
        /**
         * wrap c array into an rjava c array (add header), this method is not used at the moment
         * void* rjava_c_array_to_rjava_array(int length, long ele_size, void* c_array);
         */
        C_ARRAY_TO_RJAVA_ARRAY = new HelperMethod("rjava_c_array_to_rjava_array", "void*", new HelperVariable[]{
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
        C_ARRAY_TO_RJAVA_ARRAY.setSource(RJAVA_C_ARRAY_TO_RJAVA_ARRAY_SOURCE);
        
        /**
         * wrap arguments array into rjava array (add header)
         * void* rjava_init_args(int argc, char** args)
         */
        INIT_ARGS = new HelperMethod("rjava_init_args", "void*", new HelperVariable[]{
                                                  new HelperVariable("int", "argc"),
                                                  new HelperVariable("char**", "args")
        });
        final String RJAVA_INIT_ARGS_SOURCE = 
                "void* ret = " + invoke(NEW_ARRAY, new String[]{"argc-1", "sizeof(java_lang_String*)"}) + ";" + NEWLINE + 
                "int i = 0;" + NEWLINE + 
                "for (; i < argc - 1; i = i + 1) {" + NEWLINE +
                "  *((java_lang_String**)rjava_access_array(ret,i)) = newStringConstant(args[i+1]);" + NEWLINE +
                "}" + NEWLINE +
                "return ret;" + NEWLINE;
        INIT_ARGS.setSource(RJAVA_INIT_ARGS_SOURCE);
        
        // the order matters
        CRT_HELPERS.add(ASSERT);
        CRT_HELPERS.add(ADD_INTERFACE_TO_CLASS);
        CRT_HELPERS.add(ALTER_INTERFACE);
        CRT_HELPERS.add(GET_INTERFACE);
        CRT_HELPERS.add(INIT_HEADER);
        CRT_HELPERS.add(DEBUG_PRINT_HEADER);
        CRT_HELPERS.add(NEW_ARRAY);
        CRT_HELPERS.add(LENGTH_OF_ARRAY);
        CRT_HELPERS.add(ACCESS_ARRAY);
        CRT_HELPERS.add(INIT_ARGS);
        CRT_HELPERS.add(NEW_MULTIARRAY);
        CRT_HELPERS.add(C_ARRAY_TO_RJAVA_ARRAY);
        CRT_HELPERS.add(INSTANCEOF);
        CRT_HELPERS.add(INIT_THREAD_SUSPENDING);
    }
    
    /**
     * get the signature of a helper method (including method descriptor, return type, method name, and parameters)
     * @param method
     * @return
     */
    public static String signature(HelperMethod method) {
        String ret = "";
        
        ret += (method.isInline() ? CLanguageRuntime.ALWAYS_INLINE + " ": "");
        ret += (method.getMethodDescriptor().equals("") ? "" : method.getMethodDescriptor() + " ");
        ret += method.getReturnType() + " " + method.getMethodName() + "(";
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
    public static String invoke(HelperMethod method, String[] args) {
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
}
