package org.rjava.nativeext;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public abstract class Native {
    /**
     * 
     * @return last errno (in errno.h)
     */
    public native static int errno();
    
    /**
     * 
     * @return strerror(errno)
     */
    public native static String strErrno();
    
    /**
     * return a random double between 0 and 1
     * @return
     */
    public native static double random();
}
