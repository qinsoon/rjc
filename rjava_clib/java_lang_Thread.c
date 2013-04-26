#include "java_lang_Thread.h"
#include <execinfo.h>
#include <stdio.h>
#include <stdlib.h>

void java_lang_Thread_dumpStack() {
    void* array[20];
    size_t size;
    
    size = backtrace(array, 20);
    
    printf("RJava stack dump:\n");
    backtrace_symbols_fd(array, size, 2);
}