package testbed.mmtkext;

import org.mmtk.policy.ImmortalSpace;
import org.mmtk.utility.heap.VMRequest;
import org.mmtk.vm.Memory;
import org.rjava.osext.OSMemory;
import org.rjava.osext.OSNative;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.pragma.Inline;
import org.vmmagic.pragma.Interruptible;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.Extent;
import org.vmmagic.unboxed.Offset;

import testbed.Configuration;
import testbed.Constants;
import testbed.Main;
import testbed.TestbedRuntime;

@RJavaCore
public class MemoryExt extends Memory {
    private static ImmortalSpace vmSpace = null;
    private static Extent VMSPACE_SIZE = Extent.fromIntZeroExtend(0x10000000);
    @Override
    @Interruptible
    public ImmortalSpace getVMSpace() {
        if (vmSpace == null)
            vmSpace = new ImmortalSpace("vm", VMRequest.create(VMSPACE_SIZE, false));
        
        return vmSpace;
    }

    @Override
    public void globalPrepareVMSpace() {
        
    }

    @Override
    public void collectorPrepareVMSpace() {
        
    }

    @Override
    public void collectorReleaseVMSpace() {
        
    }

    @Override
    public void globalReleaseVMSpace() {
        
    }

    @Override
    public void setHeapRange(int id, Address start, Address end) {
        // TestbedRuntime.heap.setStart(start);
        // TestbedRuntime.heap.setEnd(end);
    }

    @Override
    public int dzmmap(Address start, int size) {
       int prot = OSMemory.PROT_READ | OSMemory.PROT_WRITE | OSMemory.PROT_EXEC;
       int flags = OSMemory.MAP_ANONYMOUS | OSMemory.MAP_PRIVATE | OSMemory.MAP_FIXED;
       Address ret = OSMemory.mmap(start, Extent.fromIntZeroExtend(size), prot, flags, -1, Offset.zero());
       if (ret.EQ(start))
           return 0;
       else{
           return OSNative.errno();
       }
    }

    @Override
    public boolean mprotect(Address start, int size) {
        return OSMemory.mprotect(start, Extent.fromIntZeroExtend(size), OSMemory.PROT_NONE) == 0;
    }

    @Override
    public boolean munprotect(Address start, int size) {
        return OSMemory.mprotect(start, 
                Extent.fromIntZeroExtend(size), 
                OSMemory.PROT_READ | OSMemory.PROT_WRITE | OSMemory.PROT_EXEC) == 0;
    }

    @Override
    /**
     * currently ignoring useNT argument
     */
    public void zero(boolean useNT, Address start, Extent len) {
        OSMemory.memset(start, 0x00, len);
    }

    @Override
    public void dumpMemory(Address start, int beforeBytes, int afterBytes) {
        // TODO: should dump memory here
        Main.warn("should dump memory here");
    }

    @Override
    @Inline
    public void sync() {
        // TODO: on intel machine dont need to do anything
    }

    @Override
    @Inline
    public void isync() {
        // TODO: on intel machine dont need to do anything
    }

    @Override
    protected Address getHeapStartConstant() {
        return Constants.HEAP_START;
    }

    @Override
    protected Address getHeapEndConstant() {
        return Constants.HEAP_END;
    }

    @Override
    protected Address getAvailableStartConstant() {
        return Constants.CONTIGUOUS_START;
    }

    @Override
    protected Address getAvailableEndConstant() {
        return Constants.HEAP_END;
    }

    @Override
    protected byte getLogBytesInAddressConstant() {
        return Constants.LOG_BYTES_IN_ADDRESS;
    }

    @Override
    protected byte getLogBytesInWordConstant() {
        return Constants.LOG_BYTES_IN_WORD;
    }

    @Override
    protected byte getLogBytesInPageConstant() {
        return Constants.LOG_BYTES_IN_PAGE;
    }

    @Override
    protected byte getLogMinAlignmentConstant() {
        return Constants.LOG_MIN_ALIGNMENT;
    }

    @Override
    protected byte getMaxAlignmentShiftConstant() {
        return (Configuration.BUILD_FOR_IA32 ? 1 : 0)
                + Constants.LOG_BYTES_IN_LONG 
                - Constants.LOG_BYTES_IN_INT;
    }

    @Override
    protected int getMaxBytesPaddingConstant() {
        return Constants.BYTES_IN_DOUBLE;
    }

    @Override
    protected int getAlignmentValueConstant() {
        return Constants.ALIGNMENT_VALUE;
    }

}
