#include "java_lang_Object.h"
#include "java_lang_String.h"
#include <time.h>
#include <sys/time.h>
#ifdef __OS_MACOSX_
#include <mach/clock.h>
#include <mach/mach.h>
#endif

java_lang_String* java_lang_Object_toString_noinline(void* this_parameter) {
    return java_lang_Object_toString(this_parameter);
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
    struct timespec ts;
    
#ifdef __OS_MACOSX_ // OS X does not have clock_gettime, use clock_get_time
    clock_serv_t cclock;
    mach_timespec_t mts;
    host_get_clock_service(mach_host_self(), CALENDAR_CLOCK, &cclock);
    clock_get_time(cclock, &mts);
    mach_port_deallocate(mach_task_self(), cclock);
    ts.tv_sec = mts.tv_sec;
    ts.tv_nsec = mts.tv_nsec;
    
#else
    clock_gettime(CLOCK_REALTIME, &ts);
#endif
    
    ts.tv_nsec = ts.tv_nsec + timeout * 1000000LL + nanos;
    
    pthread_cond_timedwait(\
                           &(((RJava_Common_Instance*)this_parameter) -> instance_cond),\
                           &(((RJava_Common_Instance*)this_parameter) -> instance_mutex),\
                           &ts\
                           );
}

void java_lang_Object_notify(void* this_parameter) {
    pthread_cond_signal(&(((RJava_Common_Instance*)this_parameter) -> instance_cond));
}

void java_lang_Object_notifyAll(void* this_parameter) {
    pthread_cond_broadcast(&(((RJava_Common_Instance*)this_parameter) -> instance_cond));
}

int32_t java_lang_Object_hashCode(void* this_parameter) {
    return (int32_t) this_parameter;
}
