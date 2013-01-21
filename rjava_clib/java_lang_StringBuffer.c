#include "java_lang_StringBuffer.h"
#include <stdio.h>

void java_lang_StringBuffer_rjinit(java_lang_StringBuffer* this_parameter) {
  this_parameter->internal = (char *) malloc (JAVA_LANG_STRINGBUFFER_INIT_SIZE);
  this_parameter->internal[0] = '\0';
  this_parameter->curr_buffer_size = JAVA_LANG_STRINGBUFFER_INIT_SIZE;
}

void java_lang_StringBuffer_append(java_lang_StringBuffer* this_parameter, char * str) {
  if ((strlen(str) + strlen(this_parameter->internal)) + 1> this_parameter->curr_buffer_size) {
    char* old = this_parameter->internal;
    this_parameter->internal = (char *) malloc (this_parameter->curr_buffer_size * 2);
    this_parameter->curr_buffer_size = this_parameter->curr_buffer_size * 2;
    strcpy(this_parameter->internal, old);
  }

  strcat(this_parameter->internal, str);
}

char* java_lang_StringBuffer_toString(java_lang_StringBuffer* this_parameter) {
  return this_parameter->internal;
}
