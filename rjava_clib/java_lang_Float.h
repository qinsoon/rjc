#ifndef JAVA_LANG_FLOAT_H
#define JAVA_LANG_FLOAT_H

#include "java_lang_Object.h"
#include "java_lang_String.h"
#include "rjava_crt.h"

typedef struct java_lang_Float {
	java_lang_Object instance_header;
	float internal;
} java_lang_Float;

typedef struct java_lang_Float_class {
	java_lang_Object_class class_header;
} java_lang_Float_class;

java_lang_Float_class java_lang_Float_class_instance;

inline float java_lang_Float_parseFloat_java_lang_String(java_lang_String* str);
inline java_lang_Float* java_lang_Float_valueOf_float(float f);

inline void java_lang_Float_rjinit_float(void* this_parameter, float f);

inline java_lang_Float* newFloatConstant(float f);

#endif