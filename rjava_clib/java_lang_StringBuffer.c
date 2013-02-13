#include "java_lang_StringBuffer.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "rjava_crt.h"

void java_lang_StringBuffer_rjinit(java_lang_StringBuffer* this_parameter) {
  this_parameter->internal = (char *) malloc (JAVA_LANG_STRINGBUFFER_INIT_SIZE);
  this_parameter->internal[0] = '\0';
  this_parameter->curr_buffer_size = JAVA_LANG_STRINGBUFFER_INIT_SIZE;
}

void java_lang_StringBuffer_append_java_lang_Object(java_lang_StringBuffer* this_parameter, void* obj) {
    char *str;
    
    if (obj == NULL)
        str = "NULL";
    
    else{
        str = (char*) malloc(sizeof(char) * 1000);
        strcpy(str, ((java_lang_Object_class*)(((RJava_Common_Instance*)obj) -> class_struct)) -> toString(obj) -> internal);
    }
  if ((strlen(str) + strlen(this_parameter->internal)) + 1> this_parameter->curr_buffer_size) {
    char* old = this_parameter->internal;
    this_parameter->internal = (char *) malloc (this_parameter->curr_buffer_size * 2);
    this_parameter->curr_buffer_size = this_parameter->curr_buffer_size * 2;
    strcpy(this_parameter->internal, old);
  }

  strcat(this_parameter->internal, str);
}

void java_lang_StringBuffer_append_int(java_lang_StringBuffer* this_parameter, int i) {
    char iStr[50];
    sprintf (iStr, "%d", i);
    java_lang_StringBuffer_append_java_lang_Object(this_parameter, newStringConstant(iStr));
}

java_lang_String* java_lang_StringBuffer_toString(java_lang_StringBuffer* this_parameter) {
  return newStringConstant(this_parameter->internal);
}
