#ifndef JAVA_LANG_SYSTEM_H
#define JAVA_LANG_SYSTEM_H

#include "java_io_PrintStream.h"

java_io_PrintStream* var_java_lang_System_out;

void java_lang_System_gc();
void java_lang_System_exit_int32_t(int32_t exit_code);
int64_t java_lang_System_currentTimeMillis();
int64_t java_lang_System_nanoTime();

#endif