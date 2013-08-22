package testbed.mmtkext;

import org.mmtk.plan.TraceLocal;
import org.mmtk.vm.FinalizableProcessor;
import org.rjava.restriction.rulesets.RJavaCore;

import testbed.Main;

@RJavaCore
public class FinalizableProcessorExt extends FinalizableProcessor {

    @Override
    public void clear() {
        Main.warn("FinalizableProcessor.clear() called, but not implemented");
    }

    @Override
    public void scan(TraceLocal trace, boolean nursery) {
        Main.warn("FinalizableProcessor.scan() called, but not implemented");
    }

    @Override
    public void forward(TraceLocal trace, boolean nursery) {
        Main.warn("FinalizableProcessor.forward() called, but not implemented");
    }

}
