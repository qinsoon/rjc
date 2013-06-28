#ifndef JAVA_LANG_THREAD_H
#define JAVA_LANG_THREAD_H

#include "java_lang_Object.h"
#include "java_lang_Runnable.h"
#include "java_lang_String.h"
#include <pthread.h>

typedef struct java_lang_Thread java_lang_Thread;

struct java_lang_Thread {
    java_lang_Object instance_header;
    
    /* we extract run() from worker, but we also keep worker here since it is the first parameter to pass */
    void (*start_function)(void*);
    void* worker;
    
    java_lang_String* name;
    int64_t thread_id;
    
    pthread_t internal_thread;
};

typedef struct java_lang_Thread_class {
    java_lang_Object_class class_header;
    
    void (*run) (void*);
    void (*start) (void*);
    void (*join) (void*);
    void (*join_int64_t) (void*, int64_t);
    void (*join_int64_t_int32_t) (void*, int64_t, int32_t);
} java_lang_Thread_class;

java_lang_Thread_class java_lang_Thread_class_instance;

/* thread creation */
// static:
void java_lang_Thread_dumpStack();                                                      //done
java_lang_Thread* java_lang_Thread_currentThread();                                     //done
// non-static:
void java_lang_Thread_rjinit_java_lang_Runnable(void* this_parameter, void* runnable);  //done
void java_lang_Thread_run(void* this_parameter);                                        //done
void java_lang_Thread_start(void* this_parameter);                                      //done

/* synchronizaion */
// static:
bool java_lang_holdsLock_java_lang_Object(java_lang_Object* obj);
bool java_lang_Thread_interrupted();
void java_lang_Thread_sleep_int64_t(int64_t millis);                        //done
void java_lang_Thread_sleep_int64_t_int32_t(int64_t millis, int32_t nanos); //done
void java_lang_Thread_yield();                                              //done
// non-static:
void java_lang_Thread_interrupt(void* this_parameter);
void java_lang_Thread_join(void* this_parameter);                           //done
void java_lang_Thread_join_int64_t(void* this_parameter, int64_t millis);   //done
void java_lang_Thread_join_int64_t_int32_t(void* this_parameter, int64_t millis, int32_t nanos);//done

/* misc */
java_lang_String* java_lang_Thread_getName(void* this_parameter); //done
int64_t java_lang_Thread_getId(void* this_parameter);             //done

/* runtime helper */
// called at the end of main method, make sure all threads joined before main() quits
void rjava_join_all_threads();
// called at the beginning of main method, add current thread as a RJava thread (main thread)
void rjava_add_main_thread();

// used to create thread and record those threads
pthread_mutex_t thread_create_lock;

#endif