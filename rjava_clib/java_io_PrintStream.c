#include <stdio.h>
#include "java_io_PrintStream.h"

void java_io_PrintStream_println(java_io_PrintStream* this_parameter, char* str) {
  printf("%s\n", str);
}
