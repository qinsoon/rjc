package testbed.mminterface;

import org.mmtk.plan.CollectorContext;
import org.mmtk.plan.MutatorContext;
import org.rjava.restriction.rulesets.RJavaCore;

import testbed.Main;
import testbed.TestbedRuntime;
import testbed.runtime.Scheduler;

@RJavaCore
public class MMTkContext implements Runnable{  
    private static int idCount = 0;
    protected int id;
    
    protected MutatorContext mutator = new org.mmtk.plan.nogc.NoGCMutator();
    protected CollectorContext collector;
    
    public MMTkContext(CollectorContext collector) {
        this.collector = collector;       
        this.id = idCount;
        this.collector.initCollector(id);
        idCount ++;
    }
    
    public MutatorContext mutator() {
        return mutator;
    }
    
    public CollectorContext collector() {
        return collector;
    }
    
    public boolean isMutator() {
        return mutator != null;
    }
    
    public boolean isCollector() {
        return collector != null;
    }
    
    public int getId() {
        return id;
    }

    @Override
    public void run() {
        if (isCollector()) {
            collector.run();
        } else {
            // mutator's job
            TestbedRuntime.allocSequence();
        }
    }
}
