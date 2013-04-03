package testbed;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.ObjectReference;

import testbed.mminterface.MMTkContext;
import testbed.mminterface.MemoryManager;
import testbed.runtime.Heap;
import testbed.runtime.TestbedObject;

@RJavaCore
public class TestbedRuntime {
    public static Heap heap = new Heap();
    
    public static ObjectReference globalRoot;
    
    public static void boot() {
        MemoryManager.boot();
    }
    
    public static void run() {
        TestbedObject root = new TestbedObject(null);
        globalRoot = MemoryManager.alloc(root).toObjectReference();
    }
}
