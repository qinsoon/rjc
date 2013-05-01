#ifndef JAVA_LANG_THREAD_H
#define JAVA_LANG_THREAD_H

#include "java_lang_Object.h"
#include "java_lang_Runnable.h"
#include <pthread.h>

typedef struct java_lang_Thread java_lang_Thread;

struct java_lang_Thread {
    java_lang_Object instance_header;
    
    void (*start_function)(void);
    pthread_t internal_thread;
};

typedef struct java_lang_Thread_class {
    java_lang_Object_class class_header;
    
    void (*run) (void);
    void (*start) (void);
} java_lang_Thread_class;

java_lang_Thread_class java_lang_Thread_class_instance;

void java_lang_Thread_rjinit_java_lang_Runnable(void* this_parameter, void* runnable);
void java_lang_Thread_run(void* this_parameter);
void java_lang_Thread_start(void* this_parameter);
void java_lang_Thread_dumpStack();

#endif