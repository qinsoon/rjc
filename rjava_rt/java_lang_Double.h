#ifndef JAVA_LANG_DOUBLE_H
#define JAVA_LANG_DOUBLE_H

#include "java_lang_Object.h"
#include "java_lang_String.h"
#include "rjava_crt.h"
#include <stdio.h>
#include <stdlib.h>

typedef struct java_lang_Double {
    java_lang_Object instance_header;
    double internal;
} java_lang_Double;

typedef struct java_lang_Double_class {
    java_lang_Object_class class_header;
} java_lang_Double_class;

java_lang_Double_class java_lang_Double_class_instance;

RJAVA_ALWAYS_INLINE double java_lang_Double_parseDouble_java_lang_String(java_lang_String* str) {
    return atof(to_c_char_array(str));
}

RJAVA_ALWAYS_INLINE void java_lang_Double_rjinit_double(void* this_parameter, double d) {
    ((java_lang_Double*)this_parameter) -> internal = d;
    ((RJava_Common_Instance*)this_parameter) -> class_struct = &java_lang_Double_class_instance;
}

RJAVA_ALWAYS_INLINE java_lang_Double* newDoubleConstant(double d) {
    java_lang_Double* ret = (java_lang_Double*) malloc(sizeof(java_lang_Double));
    java_lang_Double_rjinit_double(ret, d);
    return ret;
}

RJAVA_ALWAYS_INLINE java_lang_Double* java_lang_Double_valueOf_double(double d) {
    return newDoubleConstant(d);
}

#endif
