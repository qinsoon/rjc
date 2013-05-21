package testbed.runtime;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.Extent;

import testbed.Constants;

@RJavaCore
public class Heap {
    Address start = Constants.HEAP_START;
    Address end = Constants.HEAP_END;
    
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
