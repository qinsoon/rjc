#ifndef JAVA_IO_PRINTSTREAM_H
#define JAVA_IO_PRINTSTREAM_H

#include "java_lang_String.h"

typedef struct java_io_PrintStream {
} java_io_PrintStream;

void java_io_PrintStream_println_java_lang_String(java_io_PrintStream* this_parameter, java_lang_String *str);
void java_io_PrintStream_print_java_lang_String(java_io_PrintStream* this_parameter, java_lang_String *str);
void java_io_PrintStream_println(java_io_PrintStream* this_parameter);

#endif