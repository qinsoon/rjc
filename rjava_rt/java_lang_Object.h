#ifndef JAVA_LANG_OBJECT_H
#define JAVA_LANG_OBJECT_H

#include "rjava_crt.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct java_lang_String java_lang_String;

typedef struct java_lang_Object {
    RJava_Common_Instance instance_header;
} java_lang_Object;

typedef struct java_lang_Object_class {
    RJava_Common_Class class_header;
    
    java_lang_String* (*toString)(void* this_parameter);
} java_lang_Object_class;

struct java_lang_String {
    java_lang_Object instance_header;
    
    int16_t* internal;
    int count;
};

typedef struct java_lang_String_class {
    java_lang_Object_class class_header;
} java_lang_String_class;

java_lang_String_class java_lang_String_class_instance;

/* synchronization */
void java_lang_Object_wait(void* this_parameter);
void java_lang_Object_wait_int64_t(void* this_parameter, int64_t timeout);
void java_lang_Object_wait_int64_t_int32_t(void* this_parameter, int64_t timeout, int nanos);
void java_lang_Object_notify(void* this_parameter);
void java_lang_Object_notifyAll(void* this_parameter);
int32_t java_lang_Object_hashCode(void* this_parameter);

java_lang_Object_class java_lang_Object_class_instance;

RJAVA_ALWAYS_INLINE void java_lang_Object_rjinit(void* this_parameter) {
    // init instance mutex
    pthread_mutex_init(&(((RJava_Common_Instance*)this_parameter) -> instance_mutex), NULL);
    pthread_cond_init(&(((RJava_Common_Instance*)this_parameter) -> instance_cond), NULL);
    return;
}

RJAVA_ALWAYS_INLINE java_lang_String* java_lang_Object_toString(void* this_parameter) {
    char* buffer = (char*)malloc(sizeof(char) * 100);
    sprintf(buffer, "Object:%p", this_parameter);
    
    // hand RJAVA_ALWAYS_INLINE newStringConstant(buffer) here
    java_lang_String* ret = (java_lang_String*) malloc(sizeof(java_lang_String));
    
    ret->count = strlen(buffer);
    ret->internal = (int16_t*) malloc(ret->count * sizeof(int16_t));
    int i = 0;
    for (; i < ret->count; i++)
        ret->internal[i] = (int16_t)buffer[i];
    
    (((RJava_Common_Instance*)this_parameter)->class_struct) = &java_lang_String_class_instance;
    
    return ret;
}

java_lang_String* java_lang_Object_toString_noinline (void* this_parameter);

#endif
