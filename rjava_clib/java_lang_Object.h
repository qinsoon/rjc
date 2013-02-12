#ifndef JAVA_LANG_OBJECT_H
#define JAVA_LANG_OBJECT_H

#include "rjava_crt.h"

typedef struct java_lang_Object {
    RJava_Common_Instance instance_header;
} java_lang_Object;

typedef struct java_lang_Object_class {
    RJava_Common_Class class_header;
    
    char* (*toString)(void* this_parameter);
} java_lang_Object_class;

void java_lang_Object_rjinit(void* this_parameter);
char* java_lang_Object_toString(void* this_parameter);

java_lang_Object_class java_lang_Object_class_instance;

#endif