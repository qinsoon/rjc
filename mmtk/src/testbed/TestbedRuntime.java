package testbed;

import org.mmtk.utility.options.Options;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.ObjectReference;
import org.vmmagic.unboxed.ObjectReferenceArray;

import testbed.mminterface.MMTkContext;
import testbed.mminterface.MemoryManager;
import testbed.runtime.Heap;
import testbed.runtime.Scheduler;
import testbed.runtime.TestbedObject;

@RJavaCore
public class TestbedRuntime {
    public static Heap heap = new Heap();
    
    public static Object globalRootsLock = new Object();
    public static final int MAX_ROOTS_ALLOWED = 1;
    public static int rootsCount = 0;
    public static ObjectReferenceArray globalRoots = ObjectReferenceArray.create(MAX_ROOTS_ALLOWED);
    
    public static void boot() {
        MemoryManager.boot();
    }
    
    public static void start() {
        // start a mutator
        MMTkContext mutator = new MMTkContext(null);
        Scheduler.newMutatorThread(mutator);
        
        // MMTkContext mutator2 = new MMTkContext(null);
        // Scheduler.newMutatorThread(mutator2);
    }
}
