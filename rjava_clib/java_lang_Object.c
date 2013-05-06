#include "java_lang_Object.h"
#include <stdio.h>
#include <stdlib.h>

inline void java_lang_Object_rjinit(void* this_parameter) {
    // init instance mutex
    pthread_mutex_init(&(((RJava_Common_Instance*)this_parameter) -> instance_mutex), NULL);
    // set class
    ((RJava_Common_Instance*)this_parameter) -> class_struct = &java_lang_Object_class_instance;
    return;
}

inline java_lang_String* java_lang_Object_toString(void* this_parameter) {
    char* buffer = (char*)malloc(sizeof(char) * 100);
    sprintf(buffer, "Object:%p", this_parameter);
    return newStringConstant(buffer);
}