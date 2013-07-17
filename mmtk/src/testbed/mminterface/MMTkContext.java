package testbed.mminterface;

import org.mmtk.plan.CollectorContext;
import org.mmtk.plan.MutatorContext;
import org.rjava.nativeext.RawConcurrency;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.ObjectReference;

import testbed.Main;
import testbed.TestbedRuntime;
import testbed.runtime.ObjectModel;
import testbed.runtime.Scheduler;
import testbed.runtime.TestbedObject;

@RJavaCore
public class MMTkContext implements Runnable{  
    private static int idCount = 0;
    protected int id;
    
    // which thread is running this context
    Thread thread;
    
    protected MutatorContext mutator = new org.mmtk.plan.marksweep.MSMutator();
    protected CollectorContext collector;
    
    public MMTkContext() {
        this(null);
    }
    
    public MMTkContext(CollectorContext collector) {
        this.id = idCount;
        idCount ++;
        mutator.initMutator(id);
        
        this.collector = collector;
        if (collector != null)
            this.collector.initCollector(id);
    }
    
    public void setThread(Thread t) {
        this.thread = t;
    }
    public Thread getThread() {
        return this.thread;
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
            
            // allocSingleObject();
            allocExhaustDeadObjects();
        }
    }
    
    /**
     * allocate a single object
     */
    public void allocSingleObject() {
        while(true) {
            // we dont need gc, then alloc
            TestbedObject obj = new TestbedObject(null);
            ObjectReference objRef = MemoryManager.alloc(obj).toObjectReference();
            
            ObjectModel.dumpObject(objRef);
            
            synchronized (TestbedRuntime.globalRootsLock) {
                TestbedRuntime.globalRoots.set(TestbedRuntime.rootsCount, objRef);
                TestbedRuntime.rootsCount++;
                if (TestbedRuntime.rootsCount >= TestbedRuntime.MAX_ROOTS_ALLOWED)
                    Main.println("Reached max roots, testbed will quit.");
                    Main.sysExit(1);
            }
        }
    }
    
    /**
     * exhaust allocation
     */
    public long objectAllocedSinceLastGC = 0;

    public void allocExhaustDeadObjects() {
        TestbedObject obj = new TestbedObject(null);        
        while(true) {
            gcPoint();
            
            ObjectReference objRef = MemoryManager.alloc(obj).toObjectReference();
            
            objectAllocedSinceLastGC++;
            if (objectAllocedSinceLastGC % 100000 == 0) {
               // Main.print(objectAllocedSinceLastGC + " objects allocated:");
               // Main.println(objRef.toAddress());
            }
        }
    }
    
    public void gcPoint() {
        if (Scheduler.gcState != Scheduler.MUTATOR) 
            blockForGC();
    }
    
    private int gcState;
    public static final int MUTATOR = 0;
    public static final int GOING_TO_BLOCK = 1;
    public static final int BLOCK = 2;
    public static final int SUSPEND = 3;
    
    public int getGCState() {
        return gcState;
    }
    public boolean shouldSuspendThisContext() {
        return gcState == MUTATOR;
    }
    public void informGoingToBlock() {
        gcState = GOING_TO_BLOCK;
    }
    public void informSuspend() {
        gcState = SUSPEND;
    }
    public void informResume() {
        gcState = MUTATOR;
    }
    
    private final Object blockLock = new Object();
    
    public void blockForGC() {
        synchronized (blockLock) {
            try {
                gcState = BLOCK;
                blockLock.wait();
            } catch (InterruptedException ignore) {}
        }
    }    
    public void unblockAfterGC() {
        synchronized (blockLock) {
            gcState = MUTATOR;
            blockLock.notify();
        }
    }
        
}
