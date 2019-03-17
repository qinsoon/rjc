#ifndef JAVA_LANG_LONG_H
#define JAVA_LANG_LONG_H

#include "java_lang_Object.h"
#include "java_lang_String.h"
#include "rjava_crt.h"
#include <stdio.h>
#include <stdlib.h>

typedef struct java_lang_Long {
    java_lang_Object instance_header;
    int64_t internal;
} java_lang_Long;

typedef struct java_lang_Long_class {
    java_lang_Object_class class_header;
} java_lang_Long_class;

java_lang_Long_class java_lang_Long_class_instance;

RJAVA_ALWAYS_INLINE void java_lang_Long_rjinit_int64_t(void* this_parameter, int64_t i);

RJAVA_ALWAYS_INLINE void java_lang_Long_rjinit_int64_t(void* this_parameter, int64_t i) {
    ((java_lang_Long*)this_parameter) -> internal = i;
    ((RJava_Common_Instance*)this_parameter) -> class_struct = &java_lang_Long_class_instance;
}

RJAVA_ALWAYS_INLINE java_lang_Long* java_lang_Long_valueOf_int64_t(int64_t i) {
    java_lang_Long* ret = (java_lang_Long*) malloc(sizeof(java_lang_Long));
    java_lang_Long_rjinit_int64_t(ret, i);
    return ret;
}

RJAVA_ALWAYS_INLINE java_lang_String* java_lang_Long_toString(void* this_parameter) {
    char* ret = (char*) malloc(sizeof(char) * 100);
    sprintf(ret, "%"PRId64, ((java_lang_Long*)this_parameter) -> internal);
    return newStringConstant(ret);
}

RJAVA_ALWAYS_INLINE int64_t java_lang_Long_longValue(void* this_parameter) {
    return ((java_lang_Long*)this_parameter) -> internal;
}

RJAVA_ALWAYS_INLINE java_lang_Long* newLongConstant(int64_t i) {
    java_lang_Long* ret = (java_lang_Long*) malloc(sizeof(java_lang_Long));
    java_lang_Long_rjinit_int64_t(ret, i);
    return ret;
}

RJAVA_ALWAYS_INLINE int64_t java_lang_Long_parseLong_java_lang_String(java_lang_String* str) {
    return (int64_t)(atol(to_c_char_array(str)));
}

RJAVA_ALWAYS_INLINE java_lang_String* java_lang_Long_toHexString_int64_t(int64_t i) {
    char* str = (char*) malloc(sizeof(100));
    sprintf(str, "0x%016" PRIxPTR, i);
    return newStringConstant(str);
}

//java_lang_String* java_lang_Long_toString_noinline(void* this_parameter);

#endif
