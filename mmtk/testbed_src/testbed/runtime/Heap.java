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
        Main.print("Heap start=");
        Main.println(start);
        Main.print("Heap end=");
        Main.println(end);
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
