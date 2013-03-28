package testbed.runtime;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.Extent;

@RJavaCore
public class Heap {
    Address start;
    Address end;
    
    public Extent getHeapSize() {
        return end.diff(start).toWord().toExtent();
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
