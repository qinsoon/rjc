#include "java_lang_StringBuffer.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>



inline void java_lang_StringBuffer_rjinit(java_lang_StringBuffer* this_parameter) {
  this_parameter->internal = (char *) malloc (JAVA_LANG_STRINGBUFFER_INIT_SIZE);
  this_parameter->internal[0] = '\0';
  this_parameter->curr_buffer_size = JAVA_LANG_STRINGBUFFER_INIT_SIZE;
}

inline void java_lang_StringBuffer_rjinit_java_lang_String(java_lang_StringBuffer* this_parameter, java_lang_String* str) {
    java_lang_StringBuffer_rjinit(this_parameter);
    java_lang_StringBuffer_append_java_lang_Object(this_parameter, str);
}

java_lang_StringBuffer* java_lang_StringBuffer_append_java_lang_String(java_lang_StringBuffer* this_parameter, java_lang_String* str) {
    return java_lang_StringBuffer_append_java_lang_Object(this_parameter, str);
}

java_lang_StringBuffer* java_lang_StringBuffer_append_java_lang_Object(java_lang_StringBuffer* this_parameter, void* obj) {
    char *str;
    
    if (obj == NULL)
        str = "NULL";
    
    else{
        str = (char*) malloc(sizeof(char) * 1000);
        strcpy(str, ((java_lang_Object_class*)(((RJava_Common_Instance*)obj) -> class_struct)) -> toString(obj) -> internal);
    }
    int size_needed = (strlen(str) + strlen(this_parameter->internal)) + 1;
    if (size_needed > this_parameter->curr_buffer_size) {
        char* old = this_parameter->internal;
        int new_size = this_parameter->curr_buffer_size * 2;
        while (new_size < size_needed) {
            new_size = new_size * 2;
        }
        this_parameter->internal = (char *) malloc (size_needed);
        this_parameter->curr_buffer_size = size_needed;
        strcpy(this_parameter->internal, old);
    }
    
    strcat(this_parameter->internal, str);
    
    return this_parameter;
}

inline java_lang_StringBuffer* java_lang_StringBuffer_append_int32_t(java_lang_StringBuffer* this_parameter, int32_t i) {
    char iStr[50];
    sprintf (iStr, "%"PRId32, i);
    java_lang_StringBuffer_append_java_lang_Object(this_parameter, newStringConstant(iStr));
}

inline java_lang_StringBuffer* java_lang_StringBuffer_append_int64_t(java_lang_StringBuffer* this_parameter, int64_t i) {
    char iStr[50];
    sprintf (iStr, "%"PRId64, i);
    java_lang_StringBuffer_append_java_lang_Object(this_parameter, newStringConstant(iStr));
}

inline java_lang_StringBuffer* java_lang_StringBuffer_append_double(java_lang_StringBuffer* this_parameter, double d) {
    char iStr[50];
    sprintf (iStr, "%f", d);
    java_lang_StringBuffer_append_java_lang_String(this_parameter, newStringConstant(iStr));
}

inline java_lang_String* java_lang_StringBuffer_toString(java_lang_StringBuffer* this_parameter) {
  return newStringConstant(this_parameter->internal);
}
