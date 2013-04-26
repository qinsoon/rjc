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
    java_lang_String_rjinit(ret, string);    
    return ret;
}

inline char java_lang_String_charAt_int32_t(void* this_parameter, int32_t index) {
    return ((java_lang_String*)this_parameter) -> internal[index];
}

inline void java_lang_String_rjinit(void* this_parameter, char* str) {
    strcpy(((java_lang_String*) this_parameter) -> internal, str);
    (((RJava_Common_Instance*)this_parameter) -> class_struct) = &java_lang_String_class_instance;
}

inline void java_lang_String_rjinit_java_lang_String(void* this_parameter, java_lang_String* str) {
    strcpy(((java_lang_String*) this_parameter) -> internal, str -> internal);
    (((RJava_Common_Instance*)this_parameter) -> class_struct) = &java_lang_String_class_instance;
}

inline int32_t java_lang_String_length(void* this_parameter) {
    return (int32_t) strlen(((java_lang_String*)this_parameter)->internal);
}

inline byte* java_lang_String_getBytes(void* this_parameter) {
    java_lang_String* param = (java_lang_String*) this_parameter;
    int length = strlen(param->internal);
    long ele_size = sizeof(byte);
    byte* ret = (byte*) rjava_c_array_to_rjava_array(length, ele_size, param->internal);
    return ret;
}

java_lang_String* java_lang_String_substring_int32_t(void* this_parameter, int32_t start) {
    return java_lang_String_substring_int32_t_int32_t(this_parameter, start, java_lang_String_length(this_parameter));
}

java_lang_String* java_lang_String_substring_int32_t_int32_t(void* this_parameter, int32_t start, int32_t end) {
    char* str = ((java_lang_String*)this_parameter)->internal;
    int substr_len = end - start;
    char* substr = (char*) malloc(substr_len + 1);
    strncpy(substr, str + start, substr_len);
    substr[substr_len] = '\0';
    return newStringConstant(substr);
}


inline int32_t java_lang_String_indexOf_int32_t(void* this_parameter, int32_t ch) {
    return java_lang_String_indexOf_int32_t_int32_t(this_parameter, ch, 0);
}

inline int32_t java_lang_String_indexOf_int32_t_int32_t(void* this_parameter, int32_t ch, int32_t from) {
    char* orig = (((java_lang_String*)this_parameter)->internal);
    char* str = orig + from;
    char *found = strchr(str, ch);
    if (found)
        return (found - orig);
    else return -1;
}

java_lang_String* java_lang_String_toLowerCase(void* this_parameter) {
    char* old_str = ((java_lang_String*)this_parameter)->internal;
    char* lower = (char*) malloc(strlen(old_str) + 1);
    int i = 0;
    for (; i < strlen(old_str); i++) {
        lower[i] = tolower(old_str[i]);
    }
    lower[i] = '\0';
    return newStringConstant(lower);
}