package testbed.mmtkext;

import org.mmtk.plan.TraceLocal;
import org.mmtk.plan.TransitiveClosure;
import org.mmtk.vm.Scanning;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.ObjectReference;

import testbed.Constants;
import testbed.Main;
import testbed.TestbedRuntime;
import testbed.mminterface.MMTkContext;
import testbed.runtime.ObjectModel;
import testbed.runtime.Scheduler;

@RJavaCore
public class ScanningExt extends Scanning {

    @Override
    public void scanObject(TransitiveClosure trace, ObjectReference object) {
        int fieldCount = object.toAddress().loadInt(ObjectModel.OFFSET_FIELD_COUNT);
        Address cursor = object.toAddress().plus(ObjectModel.OFFSET_FIELD_START);
        for (int i = 0; i < fieldCount; i++) {
            trace.processEdge(object, cursor);
            cursor = cursor.plus(Constants.OBJECTREFERENCE_LENGTH_IN_BYTES);
        }
    }

    @Override
    public void specializedScanObject(int id, TransitiveClosure trace,
            ObjectReference object) {
        Main.warn("not support specializedScanObject. go to normal scan");
        scanObject(trace, object);
    }

    @Override
    public void resetThreadCounter() {
        // TODO: 
    }

    @Override
    public void notifyInitialThreadScanComplete() {
        Scheduler.getCurrentContext().mutator().flushRememberedSets();
    }

    @Override
    public void computeStaticRoots(TraceLocal trace) {
        // TODO Auto-generated method stub
    }

    @Override
    public void computeGlobalRoots(TraceLocal trace) {
        Main.println("computeGlobalRoots()");
        for (int i = 0; i < TestbedRuntime.rootsCount; i++) {
            // Address slot
            // the following MMTk code will load ObjectReference from slot
            // thus we cannot just pass the obj ref
            Object dummy = new Object();
            Address slot = ObjectReference.fromObject(dummy).toAddress();
            slot.store(TestbedRuntime.globalRoots.get(i));
            Main.print("Processing root:");
            Main.print(slot.loadObjectReference());
            Main.print("(stored at");
            Main.print(slot);
            Main.println(")");
            trace.processRootEdge(slot, true);
        }
    }

    @Override
    public void computeThreadRoots(TraceLocal trace) {
        // TODO Auto-generated method stub
    }

    @Override
    public void computeBootImageRoots(TraceLocal trace) {
        // TODO Auto-generated method stub

    }

}
