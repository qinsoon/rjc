#ifndef JAVA_LANG_OBJECT_H
#define JAVA_LANG_OBJECT_H

#include "rjava_crt.h"

typedef struct java_lang_String java_lang_String;

typedef struct java_lang_Object {
    RJava_Common_Instance instance_header;
} java_lang_Object;

typedef struct java_lang_Object_class {
    RJava_Common_Class class_header;
    
    java_lang_String* (*toString)(void* this_parameter);
} java_lang_Object_class;

inline void java_lang_Object_rjinit(void* this_parameter);
inline java_lang_String* java_lang_Object_toString(void* this_parameter);

java_lang_Object_class java_lang_Object_class_instance;

#endif