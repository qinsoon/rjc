package testbed.mminterface;

import org.mmtk.plan.CollectorContext;
import org.mmtk.plan.MutatorContext;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.ObjectReference;

import testbed.Main;
import testbed.TestbedRuntime;
import testbed.runtime.Scheduler;
import testbed.runtime.TestbedObject;

@RJavaCore
public class MMTkContext implements Runnable{  
    private static int idCount = 0;
    protected int id;
    
    protected MutatorContext mutator = new org.mmtk.plan.nogc.NoGCMutator();
    protected CollectorContext collector;
    
    public MMTkContext() {
        this(null);
    }
    
    public MMTkContext(CollectorContext collector) {
        this.id = idCount;
        idCount ++;
        
        this.collector = collector;
        if (collector != null)
            this.collector.initCollector(id);
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

    public void run() {
        if (isCollector()) {
            collector.run();
        } else {
            // mutator's job
            allocLoop();
        }
    }
    
    /**
     * the allocation loop happens here
     */
    public void allocLoop() {
        // ObjectReference lastObj = ObjectReference.nullReference();
        while(true) {
            // check gc first
            if (Scheduler.gcTriggering) {
                synchronized(this) {
                    try {
                        wait();
                    } catch (InterruptedException ignore) {}
                }
            }
            
            // we dont need gc, then alloc
            TestbedObject obj = new TestbedObject(null);
            ObjectReference objRef = MemoryManager.alloc(obj).toObjectReference();
            
            synchronized (TestbedRuntime.globalRootsLock) {
                TestbedRuntime.globalRoots.set(TestbedRuntime.rootsCount, objRef);
                TestbedRuntime.rootsCount++;
                if (TestbedRuntime.rootsCount >= TestbedRuntime.MAX_ROOTS_ALLOWED)
                    Main.println("Reached max roots, testbed will quit.");
                    Main.sysExit(1);
            }
        }
    }
    
    public void waitForGC() {
        
    }
}
