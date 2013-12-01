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
    public static int maxRootsAllowed;
    public static int rootsCount = 0;
    public static ObjectReferenceArray globalRoots;;
    
    public static boolean booted = false;
    
    public static void boot() {
        maxRootsAllowed = Main.maxRoot;
        globalRoots = ObjectReferenceArray.create(maxRootsAllowed);
        Scheduler.boot();
        MemoryManager.boot();
        
        booted = true;
    }
    
    /**
     * add the object reference as a root. If the root count excess the maxiumum roots number, 
     * we erase existing roots
     * @param objRef
     */
    public static void addToRootAllowErasing(ObjectReference objRef) {
        synchronized (globalRootsLock) {
            if (rootsCount >= maxRootsAllowed) 
                rootsCount = 0;
            
            globalRoots.set(rootsCount, objRef);
            rootsCount++;
        }
    }
    
    public static void start() {
        for (int i = 0; i < Configuration.MUTATOR_COUNT; i++) {
            // start a mutator
            MMTkContext mutator = new MMTkContext(null);
            Scheduler.newMutatorThread(mutator);
        }
    }
}
