package testbed.mminterface;

import org.mmtk.plan.MutatorContext;
import org.mmtk.plan.Plan;
import org.mmtk.utility.heap.HeapGrowthManager;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.ObjectReference;

import testbed.Configuration;
import testbed.Main;
import testbed.TestbedRuntime;
import testbed.runtime.TestbedObject;

@RJavaCore
public class MemoryManager {
    public static void boot() {
        Main.print("-Set heap\n");
        HeapGrowthManager.boot(TestbedRuntime.heap.getHeapSize(), TestbedRuntime.heap.getHeapSize());
        
        Main.print("-Process options\n");
        Plan.activePlan.processOptions();
        
        Main.print("-Enable allocation\n");
        Plan.activePlan.enableAllocation();
        
        Main.print("-Enable collection\n");
        Plan.activePlan.enableCollection();
    }
    
    public static Address alloc(TestbedObject object) {
        int allocator = Plan.activePlan.ALLOC_DEFAULT;
        int site = Plan.activePlan.getAllocationSite(false);
        int align = 0;  // we dont need to align
        int offset = 0;
        int size = object.getSize();
        
        MutatorContext mutator = MMTkContext.currentContext.mutator();
        Address ret = mutator.alloc(size, align, offset, allocator, site);
        testbed.runtime.ObjectModel.initializeObject(ret, object);
        mutator.postAlloc(ret.toObjectReference(), ObjectReference.nullReference(), size, allocator);
        
        return ret;
    }
}
