#include "java_lang_Object.h"
#include <stdio.h>
#include <stdlib.h>

inline void java_lang_Object_rjinit(void* this_parameter) {
    ((RJava_Common_Instance*)this_parameter) -> class_struct = &java_lang_Object_class_instance;
    return;
}

inline java_lang_String* java_lang_Object_toString(void* this_parameter) {
    char* buffer = (char*)malloc(sizeof(char) * 100);
    sprintf(buffer, "Object:%p", this_parameter);
    return newStringConstant(buffer);
}