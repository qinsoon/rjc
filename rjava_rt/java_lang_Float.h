#ifndef JAVA_LANG_FLOAT_H
#define JAVA_LANG_FLOAT_H

#include "java_lang_Object.h"
#include "java_lang_String.h"
#include "rjava_crt.h"
#include <stdio.h>
#include <stdlib.h>

typedef struct java_lang_Float {
	java_lang_Object instance_header;
	float internal;
} java_lang_Float;

typedef struct java_lang_Float_class {
	java_lang_Object_class class_header;
} java_lang_Float_class;

java_lang_Float_class java_lang_Float_class_instance;

RJAVA_ALWAYS_INLINE float java_lang_Float_parseFloat_java_lang_String(java_lang_String* str) {
	return atof(to_c_char_array(str));
}

RJAVA_ALWAYS_INLINE void java_lang_Float_rjinit_float(void* this_parameter, float f) {
    ((java_lang_Float*)this_parameter) -> internal = f;
    ((RJava_Common_Instance*)this_parameter) -> class_struct = &java_lang_Float_class_instance;
}

RJAVA_ALWAYS_INLINE java_lang_Float* newFloatConstant(float f) {
    java_lang_Float* ret = (java_lang_Float*) malloc(sizeof(java_lang_Float));
    java_lang_Float_rjinit_float(ret, f);
    return ret;
}

RJAVA_ALWAYS_INLINE java_lang_Float* java_lang_Float_valueOf_float(float f) {
    return newFloatConstant(f);
}


#endif
