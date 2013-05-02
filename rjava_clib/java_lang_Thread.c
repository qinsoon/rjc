#include "java_lang_Thread.h"
#include <execinfo.h>
#include <stdio.h>
#include <stdlib.h>

// record all the created threads
#define MAX_THREADS 1024
pthread_t rjava_threads[MAX_THREADS];
int rjava_thread_count = 0;

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
    t -> start_function = runnable_interface -> run;

    (((RJava_Common_Instance*)this_parameter) -> class_struct) = &java_lang_Thread_class_instance;
}

void java_lang_Thread_run(void* this_parameter) {
    java_lang_Thread* t = (java_lang_Thread*) this_parameter;
    if (t -> start_function != NULL) {
        t -> start_function();
    }
}

void* thread_run_trampoline(void* ptr) {
    java_lang_Thread_run(ptr);
}

void java_lang_Thread_start(void* this_parameter) {
    java_lang_Thread* t = (java_lang_Thread*) this_parameter;
    if (rjava_thread_count >= MAX_THREADS) {
        printf("Trying to create more threads when reaching MAX_THREADS (%d) \n", MAX_THREADS);
        java_lang_Thread_dumpStack();
        exit(1);
    }
    
    // creating thread
    pthread_create(
               &(t->internal_thread), NULL,
               thread_run_trampoline,
               this_parameter);
    // record the thread
    rjava_threads[rjava_thread_count] = t->internal_thread;
    rjava_thread_count++;
}

void rjava_join_all_threads() {
    int i = 0;
    for (; i < rjava_thread_count; i++)
        pthread_join(rjava_threads[i], NULL);
}