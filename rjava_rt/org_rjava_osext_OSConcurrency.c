#include "org_rjava_osext_OSConcurrency.h"
#include <signal.h>

#define RESUME_SIG  SIGUSR2
#define SUSPEND_SIG SIGUSR1

static sigset_t wait_mask;
static __thread int suspended;    // per-thread flag

void org_rjava_osext_OSConcurrency_threadSuspend_java_lang_Thread(java_lang_Thread* t) {
    pthread_kill(t->internal_thread, SUSPEND_SIG);
}

void org_rjava_osext_OSConcurrency_threadResume_java_lang_Thread(java_lang_Thread* t) {
    pthread_kill(t->internal_thread, RESUME_SIG);
}

/* helpers */
void resume_handler(int sig) {
    suspended = 0;
}

void suspend_handler(int sig) {
    if (suspended) return;
    suspended = 1;
    do sigsuspend(&wait_mask); while (suspended);
}

void rjava_init_thread_suspending() {
    struct sigaction sa;
    
    sigfillset(&wait_mask);
    sigdelset(&wait_mask, SUSPEND_SIG);
    sigdelset(&wait_mask, RESUME_SIG);
    
    sigfillset(&sa.sa_mask);
    sa.sa_flags = 0;
    sa.sa_handler = resume_handler;
    sigaction(RESUME_SIG, &sa, NULL);
    
    sa.sa_handler = suspend_handler;
    sigaction(SUSPEND_SIG, &sa, NULL);
}