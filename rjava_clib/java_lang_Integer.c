#include "java_lang_Integer.h"
#include <stdio.h>
#include <stdlib.h>

void java_lang_Integer_rjinit_int(void* this_parameter, int i) {
    ((java_lang_Integer*)this_parameter) -> internal = i;
    ((RJava_Common_Instance*)this_parameter) -> class_struct = &java_lang_Integer_class_instance;
}

java_lang_Integer* java_lang_Integer_valueOf_int(int i) {
    java_lang_Integer* ret = (java_lang_Integer*) malloc(sizeof(java_lang_Integer));
    java_lang_Integer_rjinit_int(ret, i);
    return ret;
}

java_lang_String* java_lang_Integer_toString(void* this_parameter) {
    char* ret = (char*) malloc(sizeof(char) * 50);
    sprintf(ret, "%d", ((java_lang_Integer*)this_parameter) -> internal);
    return newStringConstant(ret);
}

int java_lang_Integer_intValue(void* this_parameter) {
    return ((java_lang_Integer*)this_parameter) -> internal;
}

java_lang_Integer* newIntegerConstant(int i) {
    java_lang_Integer* ret = (java_lang_Integer*) malloc(sizeof(java_lang_Integer));
    java_lang_Integer_rjinit_int(ret, i);
    return ret;
}