package testbed.mmtkext;

import org.mmtk.policy.Space;
import org.mmtk.vm.MMTk_Events;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.Extent;

import testbed.Main;
@RJavaCore
public class MMTk_EventsExt extends MMTk_Events {

    @Override
    public void tracePageAcquired(Space space, Address startAddress,
            int numPages) {
//        Main.print("[event] page acquire in Space\"");
//        Main.print(space.getName());
//        Main.print("\" at ");
//        Main.print(startAddress);
//        Main.print(" of size ");
//        Main.println(numPages);
    }

    @Override
    public void tracePageReleased(Space space, Address startAddress,
            int numPages) {
//        Main.print("[event] page release in Space\"");
//        Main.print(space.getName());
//        Main.print("\" at ");
//        Main.print(startAddress);
//        Main.print(" of size ");
//        Main.println(numPages);
    }

    @Override
    public void heapSizeChanged(Extent heapSize) {
        Main.print("[event] heap size changed to ");
        Main.println(heapSize);
    }

}
