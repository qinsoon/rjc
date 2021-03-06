package testbed.mmtkext;

import org.mmtk.plan.CollectorContext;
import org.mmtk.plan.MutatorContext;
import org.mmtk.vm.Collection;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.pragma.Interruptible;
import org.vmmagic.pragma.Unpreemptible;

import testbed.Main;
import testbed.mminterface.MMTkContext;
import testbed.runtime.Scheduler;

@RJavaCore
public class CollectionExt extends Collection {

    @Override
    @Interruptible
    public void spawnCollectorContext(CollectorContext context) {
        Scheduler.newCollectorThread(new MMTkContext(context));
    }

    @Override
    public int getDefaultThreads() {
        // FIXME: need to be configurable
        return 1;
    }

    @Override
    public int getActiveThreads() {
        return 1;
    }

    @Override
    @Unpreemptible
    public void blockForGC() {
        Scheduler.currentThreadBlockForGC();
    }

    @Override
    public void prepareMutator(MutatorContext m) {
        // do nothing
    }

    @Override
    public void requestMutatorFlush() {
        Scheduler.getCurrentContext().mutator().flush();
    }

    @Override
    @Unpreemptible
    public void stopAllMutators() {
        Scheduler.stopAllMutators();
    }

    @Override
    @Unpreemptible
    public void resumeAllMutators() {
        Scheduler.resumeAllMutators();
    }

    @Override
    public void outOfMemory() {
        Main.sysFail("Out of memory");
    }

}
