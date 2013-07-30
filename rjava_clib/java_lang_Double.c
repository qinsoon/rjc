#include "java_lang_Double.h"
#include <stdio.h>
#include <stdlib.h>

inline double java_lang_Double_parseDouble_java_lang_String(java_lang_String* str) {
    return atof(str->internal);
}

inline void java_lang_Double_rjinit_double(void* this_parameter, double d) {
    ((java_lang_Double*)this_parameter) -> internal = d;
    ((RJava_Common_Instance*)this_parameter) -> class_struct = &java_lang_Double_class_instance;
}

inline java_lang_Double* newDoubleConstant(double d) {
    java_lang_Double* ret = (java_lang_Double*) malloc(sizeof(java_lang_Double));
    java_lang_Double_rjinit_double(ret, d);
}

inline java_lang_Double* java_lang_Double_valueOf_double(double d) {
    return newDoubleConstant(d);
}