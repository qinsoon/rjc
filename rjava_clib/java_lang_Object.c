#include "java_lang_Object.h"
#include <stdio.h>
#include <stdlib.h>
#include <mach/clock.h>
#include <mach/mach.h>

inline void java_lang_Object_rjinit(void* this_parameter) {
    // init instance mutex
    pthread_mutex_init(&(((RJava_Common_Instance*)this_parameter) -> instance_mutex), NULL);
    pthread_cond_init(&(((RJava_Common_Instance*)this_parameter) -> instance_cond), NULL);
    // set class
    ((RJava_Common_Instance*)this_parameter) -> class_struct = &java_lang_Object_class_instance;
    return;
}

inline java_lang_String* java_lang_Object_toString(void* this_parameter) {
    char* buffer = (char*)malloc(sizeof(char) * 100);
    sprintf(buffer, "Object:%p", this_parameter);
    return newStringConstant(buffer);
}

/* synchronization */
void java_lang_Object_wait(void* this_parameter) {
    pthread_cond_wait(\
                      &(((RJava_Common_Instance*)this_parameter) -> instance_cond),\
                      &(((RJava_Common_Instance*)this_parameter) -> instance_mutex)\
                      );
}

void java_lang_Object_wait_int64_t(void* this_parameter, int64_t timeout) {
    java_lang_Object_wait_int64_t_int32_t(this_parameter, timeout, 0);
}

void java_lang_Object_wait_int64_t_int32_t(void* this_parameter, int64_t timeout, int nanos) {
    struct timespec timeout_abstime;
    
    /* this part of code is macos specific */
    clock_serv_t cclock;
    mach_timespec_t mts;
    host_get_clock_service(mach_host_self(), CALENDAR_CLOCK, &cclock);
    clock_get_time(cclock, &mts);
    mach_port_deallocate(mach_task_self(), cclock);
    
    timeout_abstime.tv_sec = mts.tv_sec;
    timeout_abstime.tv_nsec = mts.tv_nsec + timeout * 1000000 + nanos;
    /* macos specific code end */
    
    pthread_cond_timedwait(\
                           &(((RJava_Common_Instance*)this_parameter) -> instance_cond),\
                           &(((RJava_Common_Instance*)this_parameter) -> instance_mutex),\
                           &timeout_abstime\
                           );
}

void java_lang_Object_notify(void* this_parameter) {
    pthread_cond_signal(&(((RJava_Common_Instance*)this_parameter) -> instance_cond));
}

void java_lang_Object_notifyAll(void* this_parameter) {
    pthread_cond_broadcast(&(((RJava_Common_Instance*)this_parameter) -> instance_cond));
}