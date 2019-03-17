#ifndef JAVA_LANG_STRINGBUFFER_H
#define JAVA_LANG_STRINGBUFFER_H

#include "java_lang_Object.h"
#include "java_lang_String.h"
#include "rjava_crt.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct java_lang_StringBuffer{
    java_lang_Object instance_header;
    
    int16_t* internal;
    int curr_buffer_used;
    int curr_buffer_size;
} java_lang_StringBuffer;

typedef struct java_lang_StringBuffer_class {
    java_lang_Object_class class_header;
} java_lang_StringBuffer_class;

java_lang_StringBuffer_class java_lang_StringBuffer_class_instance;

#define JAVA_LANG_STRINGBUFFER_INIT_SIZE 1024

RJAVA_ALWAYS_INLINE void java_lang_StringBuffer_rjinit(java_lang_StringBuffer* this_parameter) {
    this_parameter->internal = (int16_t *) malloc (JAVA_LANG_STRINGBUFFER_INIT_SIZE * sizeof(int16_t));
    this_parameter->curr_buffer_size = JAVA_LANG_STRINGBUFFER_INIT_SIZE;
    this_parameter->curr_buffer_used = 0;
}

java_lang_StringBuffer* java_lang_StringBuffer_append_java_lang_Object(java_lang_StringBuffer* this_parameter, void* obj);

RJAVA_ALWAYS_INLINE void java_lang_StringBuffer_rjinit_java_lang_String(java_lang_StringBuffer* this_parameter, java_lang_String* str) {
    java_lang_StringBuffer_rjinit(this_parameter);
    java_lang_StringBuffer_append_java_lang_Object(this_parameter, str);
}

RJAVA_ALWAYS_INLINE java_lang_StringBuffer* java_lang_StringBuffer_append_java_lang_String(java_lang_StringBuffer* this_parameter, java_lang_String* str) {
    return java_lang_StringBuffer_append_java_lang_Object(this_parameter, str);
}

RJAVA_ALWAYS_INLINE java_lang_StringBuffer* java_lang_StringBuffer_append_int32_t(java_lang_StringBuffer* this_parameter, int32_t i) {
    char iStr[50];
    sprintf (iStr, "%"PRId32, i);
    return java_lang_StringBuffer_append_java_lang_Object(this_parameter, newStringConstant(iStr));
}

RJAVA_ALWAYS_INLINE java_lang_StringBuffer* java_lang_StringBuffer_append_int64_t(java_lang_StringBuffer* this_parameter, int64_t i) {
    char iStr[50];
    sprintf (iStr, "%"PRId64, i);
    return java_lang_StringBuffer_append_java_lang_Object(this_parameter, newStringConstant(iStr));
}

RJAVA_ALWAYS_INLINE java_lang_StringBuffer* java_lang_StringBuffer_append_double(java_lang_StringBuffer* this_parameter, double d) {
    char iStr[50];
    sprintf (iStr, "%f", d);
    return java_lang_StringBuffer_append_java_lang_String(this_parameter, newStringConstant(iStr));
}

RJAVA_ALWAYS_INLINE java_lang_StringBuffer* java_lang_StringBuffer_append_char(java_lang_StringBuffer* this_parameter, char c) {
    char iStr[1]; iStr[0] = c;
    return java_lang_StringBuffer_append_java_lang_String(this_parameter, newStringConstant(iStr));
}

RJAVA_ALWAYS_INLINE java_lang_String* java_lang_StringBuffer_toString(java_lang_StringBuffer* this_parameter) {
    java_lang_String* ret = (java_lang_String*) malloc(sizeof(java_lang_String));
    java_lang_String_rjinit_from_int16_tarray(ret, this_parameter->curr_buffer_used, this_parameter->internal);
    return ret;
}


#endif
