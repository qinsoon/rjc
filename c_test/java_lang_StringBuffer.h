#ifndef JAVA_LANG_STRINGBUFFER_H
#define JAVA_LANG_STRINGBUFFER_H

typedef struct java_lang_StringBuffer{
char* internal;
int curr_buffer_size;
} java_lang_StringBuffer;

#define JAVA_LANG_STRINGBUFFER_INIT_SIZE 1024

void java_lang_StringBuffer_rjinit(java_lang_StringBuffer* this_parameter);
void java_lang_StringBuffer_append_java_lang_Object(java_lang_StringBuffer* this_parameter, char * str);
void java_lang_StringBuffer_append_int(java_lang_StringBuffer* this_parameter, int i);
char* java_lang_StringBuffer_toString(java_lang_StringBuffer* this_parameter);

#endif
