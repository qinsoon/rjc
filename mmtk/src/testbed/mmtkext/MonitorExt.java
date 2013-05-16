package testbed.mmtkext;

import org.mmtk.vm.Monitor;
import org.rjava.nativeext.RawConcurrency;
import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class MonitorExt extends Monitor {
    private Object lock = new Object();

    @Override
    public void lock() {
        RawConcurrency.mutexLock(lock);
    }

    @Override
    public void unlock() {
        RawConcurrency.mutexUnlock(lock);
    }

    @Override
    public void await() {
        try {
            lock.wait();
        } catch (InterruptedException ignore) {
        }
    }

    @Override
    public void broadcast() {
        lock.notifyAll();
    }

}
