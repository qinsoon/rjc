#ifndef JAVA_LANG_DOUBLE_H
#define JAVA_LANG_DOUBLE_H

#include "java_lang_Object.h"
#include "java_lang_String.h"
#include "rjava_crt.h"

typedef struct java_lang_Double {
    java_lang_Object instance_header;
    double internal;
} java_lang_Double;

typedef struct java_lang_Double_class {
    java_lang_Object_class class_header;
} java_lang_Double_class;

java_lang_Double_class java_lang_Double_class_instance;

inline double java_lang_Double_parseDouble_java_lang_String(java_lang_String* str);
inline java_lang_Double* java_lang_Double_valueOf_double(double d);
inline void java_lang_Double_rjinit_double(void* this_parameter, double d);
inline java_lang_Double* newDoubleConstant(double d);

#endif