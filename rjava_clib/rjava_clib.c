#include "rjava_clib.h"
#include "rjava_crt.h"
#include <stdio.h>

void rjava_lib_init() {
    /* init for java_lang_Object */
    ((RJava_Common_Class*)(&java_lang_Object_class_instance)) -> super_class = NULL;
    ((RJava_Common_Class*)(&java_lang_Object_class_instance)) -> interfaces = NULL;
    pthread_mutex_init( &(((RJava_Common_Class*)(&java_lang_Object_class_instance)) -> class_mutex), NULL);
    ((java_lang_Object_class*)(&java_lang_Object_class_instance)) -> toString = java_lang_Object_toString;
#ifdef DEBUG_TARGET
        ((RJava_Common_Class*)(&java_lang_Object_class_instance)) -> class_name = "java_lang_Object";
#endif
    
    /* init for java_lang_Integer */
    rjava_init_header(&java_lang_Integer_class_instance, &java_lang_Object_class_instance, sizeof(java_lang_Object_class));
    ((java_lang_Object_class*)(&java_lang_Integer_class_instance)) -> toString = java_lang_Integer_toString;
#ifdef DEBUG_TARGET
    ((RJava_Common_Class*)(&java_lang_Integer_class_instance)) -> class_name = "java_lang_Integer";
#endif
    
    /* init for java_lang_Float */
    rjava_init_header(&java_lang_Float_class_instance, &java_lang_Object_class_instance, sizeof(java_lang_Object_class));
#ifdef DEBUG_TARGET
        ((RJava_Common_Class*)(&java_lang_Float_class_instance)) -> class_name = "java_lang_Float";
#endif
    //((java_lang_Object_class*)(&java_lang_Float_class_instance)) -> toString = java_lang_Float_toString;
    
    /* init for java_lang_Boolean */
    rjava_init_header(&java_lang_Boolean_class_instance, &java_lang_Object_class_instance, sizeof(java_lang_Object_class));
#ifdef DEBUG_TARGET
        ((RJava_Common_Class*)(&java_lang_Boolean_class_instance)) -> class_name = "java_lang_Boolean";
#endif
    ((java_lang_Object_class*)(&java_lang_Boolean_class_instance)) -> toString = java_lang_Boolean_toString;
    
    /* init for java_lang_String */
    rjava_init_header(&java_lang_String_class_instance, &java_lang_Object_class_instance, sizeof(java_lang_Object_class));
#ifdef DEBUG_TARGET
        ((RJava_Common_Class*)(&java_lang_String_class_instance)) -> class_name = "java_lang_String";
#endif
    ((java_lang_Object_class*)(&java_lang_String_class_instance)) -> toString = java_lang_String_toString;
    
    /* init for java_lang_Class */
    rjava_init_header(&java_lang_Class_class_instance, &java_lang_Object_class_instance, sizeof(java_lang_Object_class));
#ifdef DEBUG_TARGET
        ((RJava_Common_Class*)(&java_lang_Class_class_instance)) -> class_name = "java_lang_Class";
#endif
    
    /* init for java_lang_Throwable */
    rjava_init_header(&java_lang_Throwable_class_instance, &java_lang_Object_class_instance, sizeof(java_lang_Object_class));
#ifdef DEBUG_TARGET
        ((RJava_Common_Class*)(&java_lang_Throwable_class_instance)) -> class_name = "java_lang_Throwable";
#endif
    
    /* init for java_lang_Exception */
    rjava_init_header(&java_lang_Exception_class_instance, &java_lang_Throwable_class_instance, sizeof(java_lang_Throwable_class));
#ifdef DEBUG_TARGET
        ((RJava_Common_Class*)(&java_lang_Exception_class_instance)) -> class_name = "java_lang_Exception";
#endif
    
    /* init for java_lang_ClassNotFoundException */
    rjava_init_header(&java_lang_ClassNotFoundException_class_instance, &java_lang_Exception_class_instance, sizeof(java_lang_Exception_class));
#ifdef DEBUG_TARGET
        ((RJava_Common_Class*)(&java_lang_ClassNotFoundException_class_instance)) -> class_name = "java_lang_ClassNotFoundException";
#endif
    
    /* init for java_lang_Thread */
    rjava_init_header(&java_lang_Thread_class_instance, &java_lang_Object_class_instance, sizeof(java_lang_Object_class));
#ifdef DEBUG_TARGET
        ((RJava_Common_Class*)(&java_lang_Thread_class_instance)) -> class_name = "java_lang_Thread";
#endif
    java_lang_Runnable* java_lang_Runnable_implemented_on_java_lang_Thread = malloc(sizeof(java_lang_Runnable));
    java_lang_Runnable_implemented_on_java_lang_Thread -> run = java_lang_Thread_run;
    rjava_add_interface_to_class(java_lang_Runnable_implemented_on_java_lang_Thread, sizeof(java_lang_Runnable), "java_lang_Runnable", (RJava_Common_Class*)&java_lang_Thread_class_instance);
}