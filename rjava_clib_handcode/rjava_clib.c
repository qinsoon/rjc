#include "rjava_clib.h"
#include "rjava_crt.h"
#include <stdio.h>

void rjava_lib_init() {
    /* init for java_lang_Object */
    ((RJava_Common_Class*)(&java_lang_Object_class_instance)) -> super_class = NULL;
    ((RJava_Common_Class*)(&java_lang_Object_class_instance)) -> interfaces = NULL;
    ((java_lang_Object_class*)(&java_lang_Object_class_instance)) -> toString = java_lang_Object_toString;

    /* init for java_lang_Integer */
    rjava_init_header(&java_lang_Integer_class_instance, &java_lang_Object_class_instance, sizeof(java_lang_Object_class));
    ((java_lang_Object_class*)(&java_lang_Integer_class_instance)) -> toString = java_lang_Integer_toString;
    
    /* init for java_lang_String */
    rjava_init_header(&java_lang_String_class_instance, &java_lang_Object_class_instance, sizeof(java_lang_Object_class));
    ((java_lang_Object_class*)(&java_lang_String_class_instance)) -> toString = java_lang_String_toString;
    
    /* init for java_lang_Class */
    rjava_init_header(&java_lang_Class_class_instance, &java_lang_Object_class_instance, sizeof(java_lang_Object_class));
    
    /* init for java_lang_Throwable */
    rjava_init_header(&java_lang_Throwable_class_instance, &java_lang_Object_class_instance, sizeof(java_lang_Throwable_class));
}