#ifndef JAVA_LANG_BOOLEAN_H
#define JAVA_LANG_BOOLEAN_H

#include "java_lang_Object.h"
#include "rjava_crt.h"
#include "java_lang_String.h"
#include <stdio.h>

typedef struct java_lang_Boolean {
    java_lang_Object instance_header;
    bool internal;
} java_lang_Boolean;

typedef struct java_lang_Boolean_class {
    java_lang_Object_class class_header;
} java_lang_Boolean_class;

java_lang_Boolean_class java_lang_Boolean_class_instance;

RJAVA_ALWAYS_INLINE void java_lang_Boolean_rjinit_bool(void* this_parameter, bool i) {
	((java_lang_Boolean*)this_parameter) -> internal = i;
	((RJava_Common_Instance*)this_parameter) -> class_struct = &java_lang_Boolean_class_instance;
}

RJAVA_ALWAYS_INLINE java_lang_Boolean* newBooleanConstant(bool i) {
	java_lang_Boolean* ret = (java_lang_Boolean*) malloc(sizeof(java_lang_Boolean));
	java_lang_Boolean_rjinit_bool(ret, i);
	return ret;
}

RJAVA_ALWAYS_INLINE java_lang_Boolean* java_lang_Boolean_parseBoolean_java_lang_String(java_lang_String* str) {
	if (java_string_equals_c_string(str, "true")) {
		return newBooleanConstant(true);
	} else {
		return newBooleanConstant(false);
	}
}

RJAVA_ALWAYS_INLINE java_lang_String* java_lang_Boolean_toString(void* this_parameter) {
	if (((java_lang_Boolean*) this_parameter) -> internal == true)
		return newStringConstant("true");
	else return newStringConstant("false");
}

java_lang_String* java_lang_Boolean_toString_noinline (void* this_parameter);

#endif
