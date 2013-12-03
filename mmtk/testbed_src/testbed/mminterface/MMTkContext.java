package testbed.mminterface;

import org.mmtk.plan.CollectorContext;
import org.mmtk.plan.MutatorContext;
import org.rjava.osext.OSConcurrency;
import org.rjava.osext.OSNative;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.pragma.Inline;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.ObjectReference;
import org.vmmagic.unboxed.ObjectReferenceArray;
import org.vmmagic.unboxed.Word;

import testbed.Main;
import testbed.TestbedRuntime;
import testbed.mminterface.select.MutatorSelect;
import testbed.mminterface.select.PlanSelect;
import testbed.runtime.ObjectModel;
import testbed.runtime.Scheduler;
import testbed.runtime.TestbedObject;

@RJavaCore
public class MMTkContext implements Runnable{  
    private static int idCount = 0;
    protected int id;
    
    // which thread is running this context
    Thread thread;
    
    protected MutatorContext mutator = new MutatorSelect();
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
    
    @Inline
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
            Scheduler.statisticsAllocStart();
            // mutator's job
            
//            allocSingleObject();
//            allocExhaustDeadObjects();
//            allocExhaustObjectsRandomRoot();
            allocExhaustObjectsRandomRootRandomField();
//            allocExtremePerformance();
        }
    }
    
    /**
     * allocate a single object
     */
    public void allocSingleObject() {
        while(true) {
            // we dont need gc, then alloc
            TestbedObject obj = new TestbedObject(0);
            ObjectReference objRef = MemoryManager.alloc(obj).toObjectReference();
            
            ObjectModel.dumpObject(objRef);
        }
    }
    
    public void allocExtremePerformance() {
        TestbedObject obj = new TestbedObject(0);
        while(true) {
            Scheduler.gcPoint();
            
            // allocation sequence
            int allocator = PlanSelect.getPlan().ALLOC_DEFAULT;
            int site = PlanSelect.getPlan().DEFAULT_SITE;
            int size = obj.getSize();
            
            Address ret = mutator.alloc(size, 0, 0, allocator, site);
            testbed.runtime.ObjectModel.initializeObject(ret.toObjectReference(), obj);
            mutator.postAlloc(ret.toObjectReference(), ObjectReference.nullReference(), size, allocator);
            
            allocationVolume += size;
        }
    }
    
    /**
     * exhaust allocation
     */
    public long allocationVolume = 0;
    
    public void allocExhaustDeadObjects() {
        TestbedObject obj = new TestbedObject(0);        
        while(true) {
            Scheduler.gcPoint();
            
            ObjectReference objRef = MemoryManager.alloc(obj).toObjectReference();
            // ObjectModel.dumpObject(objRef);
            
            allocationVolume += obj.getSize();
        }
    }
    
    public void allocExhaustObjectsRandomRoot() {
        TestbedObject obj = new TestbedObject(0);
        double random;
        while(true) {
            Scheduler.gcPoint();
            
            ObjectReference objRef = MemoryManager.alloc(obj).toObjectReference();
            
            allocationVolume += obj.getSize();
            
            // random
            random = OSNative.random();
            if (random <= Main.randomRootChance) {
                TestbedRuntime.addToRootAllowErasing(objRef);
            }
        }
    }
    
    public void allocExhaustObjectsRandomRootRandomField() {
        TestbedObject obj = new TestbedObject();
        
        ObjectReferenceArray objectToBeReferenced = ObjectReferenceArray.create(Main.maxField);
        int fieldCount = 0;
        
        double random;
        
        while(true) {
            Scheduler.gcPoint();
            
            // construct obj to be allocated
            obj.reset();
            
            random = OSNative.random();
            if (fieldCount == Main.maxField || random <= Main.randomReferencingChance) {
                // this object will reference those objects in the array
                obj.setFieldCount(fieldCount);
                for (int i = 0; i < fieldCount; i++)
                    obj.setField(i, objectToBeReferenced.get(i));
                
                // reset stored objects
                fieldCount = 0;
            } else {
                // this object will have no field, we dont need to do anything here
            }
            
            // alloc
            ObjectReference objRef = MemoryManager.alloc(obj).toObjectReference();
            allocationVolume += obj.getSize();
            
            // is this obj root?
            random = OSNative.random();
            if (random <= Main.randomRootChance) {
                TestbedRuntime.addToRootAllowErasing(objRef);
            }
            
            // will this obj be referenced?
            random = OSNative.random();
            if (random <= Main.randomReferencedChance) {
                objectToBeReferenced.set(fieldCount, objRef);
                fieldCount++;
            }
        }
    }

    private int gcState;
    public static final int MUTATOR = 0;
    public static final int GOING_TO_BLOCK = 1;
    public static final int BLOCK = 2;
    
    public int getGCState() {
        return gcState;
    }
    public boolean isBlocked() {
        return gcState == BLOCK;
    }
    public boolean shouldSuspendThisContext() {
        return gcState == MUTATOR;
    }
    public void informGoingToBlock() {
        gcState = GOING_TO_BLOCK;
    }
    
    public static final Object blockLock = new Object();
    
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
