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

void java_lang_Thread_rjinit_java_lang_Runnable(void* this_parameter, void* runnable) {
    java_lang_Thread* t = (java_lang_Thread*)this_parameter;
    
    // get the interface first
    RJava_Interface_Node* interface_list = ((RJava_Common_Class*)(((RJava_Common_Instance*)runnable) -> class_struct)) -> interfaces;
    java_lang_Runnable* runnable_interface = (java_lang_Runnable*)rjava_get_interface(interface_list, "java_lang_Runnable");
    if (runnable_interface != NULL)
        printf("found runnable_interface\n");
    t -> start_function = runnable_interface -> run;
    if (runnable_interface -> run == NULL)
        printf("but runnable_interface is NULL\n");

    (((RJava_Common_Instance*)this_parameter) -> class_struct) = &java_lang_Thread_class_instance;
}

void java_lang_Thread_run(void* this_parameter) {
    java_lang_Thread* t = (java_lang_Thread*) this_parameter;
    if (t -> start_function != NULL) {
        printf("invoking runnable->run()\n");
        t -> start_function();
    }
}

void* thread_run_trampoline(void* ptr) {
    printf("new thread executing..\n");
    java_lang_Thread_run(ptr);
}

void java_lang_Thread_start(void* this_parameter) {
    java_lang_Thread* t = (java_lang_Thread*) this_parameter;
    printf("creating pthread\n");
    pthread_create(
               &(t->internal_thread), NULL,
               thread_run_trampoline,
               this_parameter);
    pthread_join(t->internal_thread, NULL);
}