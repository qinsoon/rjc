package testbed.mminterface;

import org.mmtk.plan.MutatorContext;
import org.mmtk.plan.Plan;
import org.mmtk.utility.heap.HeapGrowthManager;
import org.mmtk.utility.options.Options;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.ObjectReference;

import testbed.Configuration;
import testbed.Main;
import testbed.TestbedRuntime;
import testbed.mminterface.select.PlanSelect;
import testbed.runtime.Scheduler;
import testbed.runtime.TestbedObject;

@RJavaCore
public class MemoryManager {
    public static void boot() {
        Main.print("-Set heap\n");
        HeapGrowthManager.boot(TestbedRuntime.heap.getHeapSize(), TestbedRuntime.heap.getHeapSize());
        
        Main.print("-Set options\n");
        Options.eagerMmapSpaces.setValue(true);
        Options.verbose.setValue(Main.gcVerbose);
        Options.variableSizeHeap.setValue(false);
        
        Main.print("-Process options\n");
        PlanSelect.getPlan().processOptions();
        
        Main.print("-Enable allocation\n");
        PlanSelect.getPlan().enableAllocation();
        
        Main.print("-Enable collection\n");
        PlanSelect.getPlan().enableCollection();
    }
    
    public static Address alloc(TestbedObject object) {
        int allocator = PlanSelect.getPlan().ALLOC_DEFAULT;
        int site = PlanSelect.getPlan().getAllocationSite(false);
        int align = 0;  // we dont need to align
        int offset = 0;
        int size = object.getSize();
        
        MutatorContext mutator = Scheduler.getCurrentContext().mutator();
        Address ret = mutator.alloc(size, align, offset, allocator, site);
        testbed.runtime.ObjectModel.initializeObject(ret, object);
        mutator.postAlloc(ret.toObjectReference(), ObjectReference.nullReference(), size, allocator);
        
        return ret;
    }
}
