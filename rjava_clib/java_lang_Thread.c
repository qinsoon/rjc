#include "java_lang_Thread.h"
#include <execinfo.h>
#include <stdio.h>
#include <stdlib.h>
#include <sched.h>

// record all the created threads
#define MAX_THREADS 1024
pthread_t rjava_pthreads[MAX_THREADS];
java_lang_Thread* rjava_threads[MAX_THREADS];
int rjava_thread_count = 0;

// this is a hack to add main thread as a RJava thread (but it is already launched)
void rjava_add_main_thread() {
    // main thread should always be the first thread
    internal_assert(rjava_thread_count == 0, "We have RJava thread before adding main thread, its a problem");
    
    // this will increase thread_count, add RJava thread to array
    java_lang_Thread* rjava_main = (java_lang_Thread*) malloc(sizeof(java_lang_Thread));
    java_lang_Thread_rjinit_java_lang_String(rjava_main, "Main Thread");
    
    // we will need to add pthread to array
    pthread_t main_thread = pthread_self();
    rjava_pthreads[0] = main_thread;
}

void java_lang_Thread_dumpStack() {
    void* array[20];
    size_t size;
    
    size = backtrace(array, 20);
    
    printf("RJava stack dump:\n");
    backtrace_symbols_fd(array, size, 2);
}

void java_lang_Thread_rjinit_java_lang_String(void* this_parameter, java_lang_String* name) {
    java_lang_Thread_rjinit_java_lang_Runnable_java_lang_String(this_parameter, NULL, name);
}

void java_lang_Thread_rjinit_java_lang_Runnable(void* this_parameter, void* runnable) {
    // name
    char* str = (char*) malloc(20);
    sprintf(str, "Thread-%d", rjava_thread_count);
    java_lang_String* name = newStringConstant(str);
    
    java_lang_Thread_rjinit_java_lang_Runnable_java_lang_String(this_parameter, runnable, name);
}

void java_lang_Thread_rjinit_java_lang_Runnable_java_lang_String(void* this_parameter, void* runnable, java_lang_String* name) {
    java_lang_Thread* t = (java_lang_Thread*)this_parameter;
    
    // get the interface first
    if (runnable != NULL) {
        RJava_Interface_Node* interface_list = ((RJava_Common_Class*)(((RJava_Common_Instance*)runnable) -> class_struct)) -> interfaces;
        java_lang_Runnable* runnable_interface = (java_lang_Runnable*)rjava_get_interface(interface_list, "java_lang_Runnable");
        t -> start_function = runnable_interface -> run;
        t -> worker = runnable;
    }
    
    /* get thread id and name */
    pthread_mutex_lock(&thread_create_lock);
    // thread id
    t -> thread_id = rjava_thread_count;
    // thread name
    t -> name = name;
    // rjava thread
    rjava_threads[rjava_thread_count] = t;
    // increase count
    rjava_thread_count++;
    pthread_mutex_unlock(&thread_create_lock);
    
    (((RJava_Common_Instance*)this_parameter) -> class_struct) = &java_lang_Thread_class_instance;
}

void java_lang_Thread_run(void* this_parameter) {
    java_lang_Thread* t = (java_lang_Thread*) this_parameter;
    if (t -> start_function != NULL) {
        // record the thread
        rjava_pthreads[t->thread_id] = t->internal_thread;
            
        t -> start_function(t -> worker);
    } else {
        internal_assert(false, "start function not set");
    }    
}

void* thread_run_trampoline(void* ptr) {
    java_lang_Thread_run(ptr);
}

/* assertion */
void internal_assert(bool cond, const char* msg) {
    if (!cond) {
        printf("%s\n", msg);
        java_lang_Thread_dumpStack();
        exit(1);
    }
}

void java_lang_Thread_start(void* this_parameter) {
    java_lang_Thread* t = (java_lang_Thread*) this_parameter;
    internal_assert(rjava_thread_count < MAX_THREADS, "Trying to create more threads than MAX_THREADS");
    
    // creating thread
    pthread_create(
               &(t->internal_thread), NULL,
               thread_run_trampoline,
               this_parameter);
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

void rjava_join_all_threads() {
    int i = 0;
    for (; i < rjava_thread_count; i++)
        pthread_join(rjava_pthreads[i], NULL);
}

void java_lang_Thread_join(void* this_parameter) {
    java_lang_Thread* t = (java_lang_Thread*) this_parameter;
    pthread_join(t->internal_thread, NULL);
}

/* as parameters to timer thread */
struct timer_struct {
    pthread_t pthread_to_join;
    int64_t nanosec_to_wait;
};

/* sleep for nanosec, and then cancel a thread */
void* internal_timer_thread_func(void* param) {
    struct timer_struct* parsed_param = (struct timer_struct*) param;
    usleep(parsed_param->nanosec_to_wait/1000);
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

void java_lang_Thread_join_int64_t(void* this_parameter, int64_t millis) {
    internal_wait_and_cancel(((java_lang_Thread*)this_parameter) -> internal_thread, millis * 1000000);
    java_lang_Thread_join(this_parameter);
}

void java_lang_Thread_join_int64_t_int32_t(void* this_parameter, int64_t millis, int32_t nanos) {
    internal_wait_and_cancel(((java_lang_Thread*)this_parameter) -> internal_thread, millis * 1000000 + nanos);
}

void java_lang_Thread_sleep_int64_t(int64_t millis) {
    usleep(millis*1000);
}

void java_lang_Thread_sleep_int64_t_int32_t(int64_t millis, int32_t nanos) {
    usleep(millis*1000 + nanos/1000);
}

void java_lang_Thread_yield() {
    sched_yield();
}

java_lang_String* java_lang_Thread_getName(void* this_parameter) {
    return ((java_lang_Thread*)this_parameter) -> name;
}

int64_t java_lang_Thread_getId(void* this_parameter) {
    return ((java_lang_Thread*)this_parameter) -> thread_id;
}