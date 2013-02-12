#include <stdio.h>
#include "java_io_PrintStream.h"

void java_io_PrintStream_println_java_lang_String(java_io_PrintStream* this_parameter, java_lang_String* str) {
  printf("%s\n", str->internal);
}

void java_io_PrintStream_print_java_lang_String(java_io_PrintStream* this_parameter, java_lang_String *str) {
    printf("%s", str->internal);
}
void java_io_PrintStream_println(java_io_PrintStream* this_parameter){
    printf("\n");
}
