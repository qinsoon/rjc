package testbed.mmtkext;

import org.mmtk.vm.SynchronizedCounter;
import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class SynchronizedCounterExt extends SynchronizedCounter {
    // TODO: this counter is not synchronized
    private int count = 0;

    @Override
    public int reset() {
        int val = count;
        count = 0;
        return val;
    }

    @Override
    public int increment() {
        int val = count;
        count++;
        return val;
    }

    @Override
    public int peek() {
        return count;
    }

}
