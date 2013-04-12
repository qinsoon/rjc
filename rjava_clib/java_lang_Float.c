#include "java_lang_Float.h"
#include <stdio.h>
#include <stdlib.h>

inline float java_lang_Float_parseFloat_java_lang_String(java_lang_String* str) {
	return atof(str->internal);
}

inline void java_lang_Float_rjinit_float(void* this_parameter, float f) {
    ((java_lang_Float*)this_parameter) -> internal = f;
    ((RJava_Common_Instance*)this_parameter) -> class_struct = &java_lang_Float_class_instance;
}

inline java_lang_Float* newFloatConstant(float f) {
    java_lang_Float* ret = (java_lang_Float*) malloc(sizeof(java_lang_Float));
    java_lang_Float_rjinit_float(ret, f);
    return ret;
}

inline java_lang_Float* java_lang_Float_valueOf_float(float f) {
    return newFloatConstant(f);
}

