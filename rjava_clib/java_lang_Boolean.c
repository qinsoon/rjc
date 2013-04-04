#include "java_lang_Boolean.h"
#include "java_lang_String.h"
#include <stdio.h>

inline void java_lang_Boolean_rjinit_bool(void* this_parameter, bool i) {
	((java_lang_Boolean*)this_parameter) -> internal = i;
	((RJava_Common_Instance*)this_parameter) -> class_struct = &java_lang_Boolean_class_instance;
}

inline java_lang_Boolean* java_lang_Boolean_parseBoolean_java_lang_String(java_lang_String* str) {
	if (strcmp(str->internal, "true") == 0) {
		return newBooleanConstant(true);
	} else {
		return newBooleanConstant(false);
	}
}

inline java_lang_String* java_lang_Boolean_toString(void* this_parameter) {
	if (((java_lang_Boolean*) this_parameter) -> internal == true) 
		return newStringConstant("true");
	else return newStringConstant("false");
}

inline java_lang_Boolean* newBooleanConstant(bool i) {
	java_lang_Boolean* ret = (java_lang_Boolean*) malloc(sizeof(java_lang_Boolean));
	java_lang_Boolean_rjinit_bool(ret, i);
	return ret;
}