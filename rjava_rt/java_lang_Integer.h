#ifndef JAVA_LANG_INTEGER_H
#define JAVA_LANG_INTEGER_H

#include "java_lang_Object.h"
#include "java_lang_String.h"
#include "rjava_crt.h"
#include <stdio.h>
#include <stdlib.h>

typedef struct java_lang_Integer {
    java_lang_Object instance_header;
    int32_t internal;
} java_lang_Integer;

typedef struct java_lang_Integer_class {
    java_lang_Object_class class_header;
} java_lang_Integer_class;

java_lang_Integer_class java_lang_Integer_class_instance;

RJAVA_ALWAYS_INLINE void java_lang_Integer_rjinit_int32_t(void* this_parameter, int32_t i);

RJAVA_ALWAYS_INLINE void java_lang_Integer_rjinit_int32_t(void* this_parameter, int32_t i) {
    ((java_lang_Integer*)this_parameter) -> internal = i;
    ((RJava_Common_Instance*)this_parameter) -> class_struct = &java_lang_Integer_class_instance;
}

RJAVA_ALWAYS_INLINE java_lang_Integer* java_lang_Integer_valueOf_int32_t(int32_t i) {
    java_lang_Integer* ret = (java_lang_Integer*) malloc(sizeof(java_lang_Integer));
    java_lang_Integer_rjinit_int32_t(ret, i);
    return ret;
}

RJAVA_ALWAYS_INLINE java_lang_String* java_lang_Integer_toString(void* this_parameter) {
    char* ret = (char*) malloc(sizeof(char) * 50);
    sprintf(ret, "%"PRId32, ((java_lang_Integer*)this_parameter) -> internal);
    return newStringConstant(ret);
}

RJAVA_ALWAYS_INLINE int32_t java_lang_Integer_intValue(void* this_parameter) {
    return ((java_lang_Integer*)this_parameter) -> internal;
}

RJAVA_ALWAYS_INLINE java_lang_Integer* newIntegerConstant(int32_t i) {
    java_lang_Integer* ret = (java_lang_Integer*) malloc(sizeof(java_lang_Integer));
    java_lang_Integer_rjinit_int32_t(ret, i);
    return ret;
}

RJAVA_ALWAYS_INLINE int32_t java_lang_Integer_parseInt_java_lang_String(java_lang_String* str) {
    return (int32_t)(atol(to_c_char_array(str)));
}

RJAVA_ALWAYS_INLINE java_lang_String* java_lang_Integer_toHexString_int32_t(int32_t i) {
    char* str = (char*) malloc(sizeof(100));
    sprintf(str, "0x%016" PRIxPTR, i);
    return newStringConstant(str);
}

java_lang_String* java_lang_Integer_toString_noinline(void* this_parameter);

#endif
