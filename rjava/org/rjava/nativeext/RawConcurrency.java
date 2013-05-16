package org.rjava.nativeext;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public abstract class RawConcurrency {
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
}
