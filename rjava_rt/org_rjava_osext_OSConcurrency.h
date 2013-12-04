#ifndef ORG_RJAVA_OSEXT_OSCONCURRENCY_H
#define ORG_RJAVA_OSEXT_OSCONCURRENCY_H

#include "rjava_crt.h"
#include "rjava_clib.h"

#define org_rjava_osext_OSConcurrency_mutexLock_java_lang_Object(obj) \
	pthread_mutex_lock(&(((RJava_Common_Instance*) obj) -> instance_mutex))
	
#define org_rjava_osext_OSConcurrency_mutexUnlock_java_lang_Object(obj) \
	pthread_mutex_unlock(&(((RJava_Common_Instance*) obj) -> instance_mutex))

void org_rjava_osext_OSConcurrency_threadSuspend_java_lang_Thread(java_lang_Thread* t);
void org_rjava_osext_OSConcurrency_threadResume_java_lang_Thread(java_lang_Thread* t);

#endif