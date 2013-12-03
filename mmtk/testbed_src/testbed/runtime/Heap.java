package testbed.runtime;

import org.mmtk.vm.VM;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.Extent;

import testbed.Constants;
import testbed.Main;

@RJavaCore
public class Heap {
    Address start = VM.AVAILABLE_START;
    Address end = VM.AVAILABLE_END;
    
    public Extent getHeapSize() {
        return Extent.fromIntSignExtend(0x25000000);
    }
    
    public Address getStart() {
        return start;
    }
    public void setStart(Address start) {
        this.start = start;
    }
    public Address getEnd() {
        return end;
    }
    public void setEnd(Address end) {
        this.end = end;
    }    
}
