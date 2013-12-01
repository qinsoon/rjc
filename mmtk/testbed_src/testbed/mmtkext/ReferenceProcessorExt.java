package testbed.mmtkext;

import org.mmtk.plan.TraceLocal;
import org.mmtk.vm.ReferenceProcessor;
import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class ReferenceProcessorExt extends ReferenceProcessor {

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public void scan(TraceLocal trace, boolean nursery) {
        // TODO Auto-generated method stub

    }

    @Override
    public void forward(TraceLocal trace, boolean nursery) {
        // TODO Auto-generated method stub

    }

    @Override
    public int countWaitingReferences() {
        // TODO Auto-generated method stub
        return 0;
    }

}
