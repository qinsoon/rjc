package testbed.mminterface;

import org.mmtk.plan.CollectorContext;
import org.mmtk.plan.MutatorContext;
import org.rjava.restriction.rulesets.RJavaCore;

import testbed.Main;

@RJavaCore
public class MMTkContext {
    public static MMTkContext currentContext;
    
    public static final int MAX_CONTEXT = 5;
    public static int contextCount = 0;
    public static MMTkContext[] allContexts = new MMTkContext[MAX_CONTEXT];    
    
    protected int slot;
    protected MutatorContext mutator = new org.mmtk.plan.nogc.NoGCMutator();
    protected CollectorContext collector;
    
    protected boolean running;
    
    public MMTkContext(CollectorContext collector) {
        Main.println("MMTkContext" + contextCount);
        this.collector = collector;
        this.collector.initCollector(slot);
        
        this.slot = contextCount;
        contextCount ++;        
        allContexts[slot] = this;
        
        currentContext = this;
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
    
    public int getSlot() {
        return slot;
    }
    
    public boolean isRunning() {
        return running;
    }
    
    public void setRunning(boolean running) {
        this.running = running;
    }
}
