#ifndef JAVA_LANG_STRING_H
#define JAVA_LANG_STRING_H

#include <stdbool.h>
#include <string.h>

#include "java_lang_Object.h"
#include "rjava_crt.h"

#define RJAVA_STR java_lang_String*

RJAVA_ALWAYS_INLINE void java_lang_String_rjinit(void* this_parameter, const char* str) {
    java_lang_String* this_str = (java_lang_String*) this_parameter;

    this_str->count = strlen(str);
    this_str->internal = (int16_t*) malloc(this_str->count * sizeof(int16_t));
    int i = 0;
    for (; i < this_str->count; i++)
        this_str->internal[i] = (int16_t)str[i];
    
    (((RJava_Common_Instance*)this_parameter)->class_struct) = &java_lang_String_class_instance;
}

// only used by lib implementation
RJAVA_ALWAYS_INLINE void java_lang_String_rjinit_from_int16_tarray(void* this_parameter, int length, int16_t* array) {
    java_lang_String* this_str = (java_lang_String*) this_parameter;
    
    this_str->count = length;
    this_str->internal = (int16_t*) malloc(length * sizeof(int16_t));
    memcpy(this_str->internal, array, length * sizeof(int16_t));
    
    (((RJava_Common_Instance*)this_parameter)->class_struct) = &java_lang_String_class_instance;
}

RJAVA_ALWAYS_INLINE void java_lang_String_rjinit_java_lang_String(void* this_parameter, java_lang_String* str) {
    java_lang_String* this_str = (java_lang_String*) this_parameter;
    
    this_str->internal = (int16_t*) malloc(str->count * sizeof(int16_t));
    this_str->count = str->count;
    memcpy(this_str->internal, str->internal, str->count * sizeof(int16_t));
    
    (((RJava_Common_Instance*)this_parameter)->class_struct) = &java_lang_String_class_instance;
}

RJAVA_ALWAYS_INLINE bool java_lang_String_equals_java_lang_Object(void* this_parameter, void* another) {
    java_lang_String* this_str = (java_lang_String*) this_parameter;
    
    if (!rjava_instanceof(another, &java_lang_String_class_instance))
        return false;
    
    java_lang_String* another_str = (java_lang_String*) another;

    if (this_str->count != another_str->count)
        return false;
    
    int i = 0;
    for (; i < this_str->count; i++)
        if (this_str->internal[i] != another_str->internal[i])
            return false;
    
    return true;
}

// only used by lib implementation
RJAVA_ALWAYS_INLINE bool java_string_equals_c_string(java_lang_String* java_str, const char* c_str) {
    if (strlen(c_str) != java_str->count)
        return false;
    
    int i = 0;
    for (; i < java_str->count; i++)
        if (java_str->internal[i] != c_str[i])
            return false;
    
    return true;
}

// only used by lib implementation
RJAVA_ALWAYS_INLINE char* to_c_char_array(java_lang_String* str) {
    char* c_str = (char*) malloc(str->count + 1);
    int i = 0;
    for (; i < str->count; i++)
        c_str[i] = (char) str->internal[i];
    c_str[str->count] = '\0';
    return c_str;
}

// only used by lib implementation
RJAVA_ALWAYS_INLINE int16_t* from_c_char_array(char* str) {
    int16_t* ret = (int16_t*) malloc(strlen(str) * sizeof(int16_t));
    
    int i =0;
    for (; i < strlen(str); i++)
        ret[i] = (int16_t) str[i];
    
    return ret;
}

// only used by lib implementation
RJAVA_ALWAYS_INLINE void print_int16_tarray_as_str(int16_t* arr, int count) {
    int i = 0;
    for (;i < count; i++)
        printf("%c", (char)arr[i]);
}


RJAVA_ALWAYS_INLINE java_lang_String* java_lang_String_toString(void* this_parameter) {
    return (java_lang_String*) this_parameter;
}

java_lang_String* java_lang_String_toString_noinline(void* this_parameter);

RJAVA_ALWAYS_INLINE java_lang_String* newStringConstant(const char* string) {
    java_lang_String* ret = (java_lang_String*) malloc(sizeof(java_lang_String));
    java_lang_String_rjinit(ret, string);
    return ret;
}

// so we can use it in C++ code
java_lang_String* newStringConstant_noinline(const char* string);

RJAVA_ALWAYS_INLINE int16_t java_lang_String_charAt_int32_t(void* this_parameter, int32_t index) {
    java_lang_String* this_str = (java_lang_String*) this_parameter;
    
    if (index >= this_str->count || index < 0) {
        char* errmsg = (char*) malloc(1000);
        sprintf(errmsg, "index(%d) out of range (%d) in String.charAt()", index, this_str->count);
        rjava_assert(false, errmsg);
    }
    return this_str->internal[index];
}

RJAVA_ALWAYS_INLINE int32_t java_lang_String_length(void* this_parameter) {
    java_lang_String* this_str = (java_lang_String*) this_parameter;
    return (int32_t) this_str->count;
}

RJAVA_ALWAYS_INLINE byte* java_lang_String_getBytes(void* this_parameter) {
    java_lang_String* this_str = (java_lang_String*) this_parameter;
    long ele_size = sizeof(int16_t);
    byte* ret = (byte*) rjava_c_array_to_rjava_array(this_str->count, ele_size, this_str->internal);
    return ret;
}

java_lang_String* java_lang_String_substring_int32_t(void* this_parameter, int32_t index);
java_lang_String* java_lang_String_substring_int32_t_int32_t(void* this_parameter, int32_t start, int32_t end);

int32_t java_lang_String_indexOf_int32_t_int32_t(void* this_parameter, int32_t ch, int32_t from);

RJAVA_ALWAYS_INLINE int32_t java_lang_String_indexOf_int32_t(void* this_parameter, int32_t ch) {
    return java_lang_String_indexOf_int32_t_int32_t(this_parameter, ch, 0);
}

java_lang_String* java_lang_String_toLowerCase(void* this_parameter);

#endif
