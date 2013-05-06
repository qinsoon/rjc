#include "java_lang_Thread.h"
#include <execinfo.h>
#include <stdio.h>
#include <stdlib.h>

// record all the created threads
#define MAX_THREADS 1024
pthread_t rjava_pthreads[MAX_THREADS];
java_lang_Thread* rjava_threads[MAX_THREADS];
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
    internal_assert(rjava_thread_count < MAX_THREADS, "Trying to create more threads than MAX_THREADS");
    
    // creating thread
    pthread_create(
               &(t->internal_thread), NULL,
               thread_run_trampoline,
               this_parameter);
    // record the thread
    rjava_pthreads[rjava_thread_count] = t->internal_thread;
    rjava_threads[rjava_thread_count] = this_parameter;
    rjava_thread_count++;
}

java_lang_Thread* java_lang_Thread_currentThread() {
    pthread_t current_pthread = pthread_self();
    int i = 0;
    for (; i < rjava_thread_count; i++)
        if (rjava_pthreads[i] == current_pthread)
            return rjava_threads[i];
    
    internal_assert(false, "couldn't find current thread");
    return NULL;
}

/* assertion */
void internal_assert(bool cond, const char* msg) {
    if (!cond) {
        printf("%s\n", msg);
        java_lang_Thread_dumpStack();
        exit(1);
    }
}

void rjava_join_all_threads() {
    int i = 0;
    for (; i < rjava_thread_count; i++)
        pthread_join(rjava_pthreads[i], NULL);
}

void java_lang_Thread_join(void* this_parameter) {
    java_lang_Thread* t = (java_lang_Thread*) this_parameter;
    pthread_join(t->internal_thread, NULL);
}

void java_lang_Thread_join_int64_t(void* this_parameter, int64_t millis) {
    internal_wait_and_cancel(((java_lang_Thread*)this_parameter) -> internal_thread, millis * 1000000);
    java_lang_Thread_join(this_parameter);
}

void java_lang_Thread_sleep_int64_t(int64_t millis) {
    usleep(millis*1000);
}

/* as parameters to timer thread */
struct timer_struct {
    pthread_t pthread_to_join;
    int64_t nanosec_to_wait;
};

/* sleep for nanosec, and then cancel a thread */
void* internal_timer_thread_func(void* param) {
    struct timer_struct* parsed_param = (struct timer_struct*) param;
    int32_t usec_to_sleep = parsed_param->nanosec_to_wait / 1000;
    usleep(usec_to_sleep);
    pthread_cancel(parsed_param->pthread_to_join);
    pthread_exit(NULL);
}

/* create a timer, the timer thread will wait for nanosec and cancel the pthread */
void internal_wait_and_cancel(pthread_t pthread, int64_t nanosec) {
    struct timer_struct* param = (struct timer_struct*) malloc(sizeof(struct timer_struct));
    param->pthread_to_join = pthread;
    param->nanosec_to_wait = nanosec;
    
    pthread_t timer_thread;
    pthread_create(&timer_thread, NULL, internal_timer_thread_func, (void*)param);
}

