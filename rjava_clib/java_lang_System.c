#include "java_lang_System.h"
#include "boehm-gc/include/gc.h"
#include <stdio.h>

void java_lang_System_gc() {
    GC_gcollect();
}

void java_lang_System_exit_int32_t(int32_t exit_code) {
    exit(exit_code);
}