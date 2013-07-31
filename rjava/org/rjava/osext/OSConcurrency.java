package org.rjava.osext;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public abstract class OSConcurrency {
    /**
     * lock on the object instance_mutex. This method is an alternative to MonitorEnter of such object (synchronized method/block)
     * @param lock
     */
    public static native void mutexLock(Object lock);
    
    /**
     * unlock on the object instance_mutex. This method is an alternative to MonitorExit of such object (synchronized method/block)
     * @param lock
     */
    public static native void mutexUnlock(Object lock);
    
    /**
     * suspending a RJava thread by sending signal
     * @param t
     */
    public static native void threadSuspend(Thread t);
    
    /**
     * resume a suspended RJava thread
     * @param t
     */
    public static native void threadResume(Thread t);
}
