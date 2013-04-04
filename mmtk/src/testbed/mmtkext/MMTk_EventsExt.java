package testbed.mmtkext;

import org.mmtk.policy.Space;
import org.mmtk.vm.MMTk_Events;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.Extent;

public class MMTk_EventsExt extends MMTk_Events {

    @Override
    public void tracePageAcquired(Space space, Address startAddress,
            int numPages) {
        // TODO Auto-generated method stub

    }

    @Override
    public void tracePageReleased(Space space, Address startAddress,
            int numPages) {
        // TODO Auto-generated method stub

    }

    @Override
    public void heapSizeChanged(Extent heapSize) {
        // TODO Auto-generated method stub

    }

}
