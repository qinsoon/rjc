package testbed.mmtkext;

import org.mmtk.vm.Lock;
import org.rjava.osext.OSConcurrency;
import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class LockExt extends Lock {
    private String name;
    private Object lock = new Object();

    @Override
    public void setName(String str) {
        this.name = str;
    }

    @Override
    public void acquire() {
        OSConcurrency.mutexLock(lock);
    }

    @Override
    public void check(int w) {
        
    }

    @Override
    public synchronized void release() {
        OSConcurrency.mutexUnlock(lock);
    }

}
