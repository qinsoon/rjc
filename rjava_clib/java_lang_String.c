#include "java_lang_String.h"
#include <stdlib.h>

inline bool java_lang_String_equals_java_lang_Object(void* this_parameter, void* another) {
    if (strcmp(((java_lang_String*)this_parameter)->internal, (((java_lang_Object_class*)((RJava_Common_Instance*)another)->class_struct) -> toString(another)) -> internal) == 0) {
        return true;
    } else return false;
}

inline java_lang_String* java_lang_String_toString(void* this_parameter) {
    return this_parameter;
}

inline java_lang_String* newStringConstant(char* string) {
    java_lang_String* ret = (java_lang_String*) malloc(sizeof(java_lang_String));
    
    strcpy(ret->internal, string);
    
    ((RJava_Common_Instance*)ret) -> class_struct = &java_lang_String_class_instance;
    
    return ret;
}

inline char java_lang_String_charAt_int(void* this_parameter, int index) {
    return ((java_lang_String*)this_parameter) -> internal[index];
}