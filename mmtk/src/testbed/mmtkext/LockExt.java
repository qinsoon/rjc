package testbed.mmtkext;

import org.mmtk.vm.Lock;
import org.rjava.nativeext.RawConcurrency;
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
        RawConcurrency.mutexLock(lock);
    }

    @Override
    public void check(int w) {
        
    }

    @Override
    public synchronized void release() {
        RawConcurrency.mutexUnlock(lock);
    }

}
