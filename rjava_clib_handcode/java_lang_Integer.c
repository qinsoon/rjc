#include "java_lang_Integer.h"
#include <stdio.h>
#include <stdlib.h>

inline void java_lang_Integer_rjinit_int32_t(void* this_parameter, int32_t i) {
    ((java_lang_Integer*)this_parameter) -> internal = i;
    ((RJava_Common_Instance*)this_parameter) -> class_struct = &java_lang_Integer_class_instance;
}

inline java_lang_Integer* java_lang_Integer_valueOf_int32_t(int32_t i) {
    java_lang_Integer* ret = (java_lang_Integer*) malloc(sizeof(java_lang_Integer));
    java_lang_Integer_rjinit_int32_t(ret, i);
    return ret;
}

inline java_lang_String* java_lang_Integer_toString(void* this_parameter) {
    char* ret = (char*) malloc(sizeof(char) * 50);
    sprintf(ret, "%"PRId32, ((java_lang_Integer*)this_parameter) -> internal);
    return newStringConstant(ret);
}

inline int32_t java_lang_Integer_intValue(void* this_parameter) {
    return ((java_lang_Integer*)this_parameter) -> internal;
}

inline java_lang_Integer* newIntegerConstant(int32_t i) {
    java_lang_Integer* ret = (java_lang_Integer*) malloc(sizeof(java_lang_Integer));
java_lang_Integer_rjinit_int32_t(ret, i);
    return ret;
}