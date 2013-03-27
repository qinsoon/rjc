package testbed.mmtkext;

import org.mmtk.policy.ImmortalSpace;
import org.mmtk.vm.Memory;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.pragma.Inline;
import org.vmmagic.pragma.Interruptible;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.Extent;

@RJavaCore
public class MemoryExt extends Memory {

    @Override
    @Interruptible
    public ImmortalSpace getVMSpace() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void globalPrepareVMSpace() {
        // TODO Auto-generated method stub

    }

    @Override
    public void collectorPrepareVMSpace() {
        // TODO Auto-generated method stub

    }

    @Override
    public void collectorReleaseVMSpace() {
        // TODO Auto-generated method stub

    }

    @Override
    public void globalReleaseVMSpace() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setHeapRange(int id, Address start, Address end) {
        // TODO Auto-generated method stub

    }

    @Override
    public int dzmmap(Address start, int size) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean mprotect(Address start, int size) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean munprotect(Address start, int size) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void zero(boolean useNT, Address start, Extent len) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dumpMemory(Address start, int beforeBytes, int afterBytes) {
        // TODO Auto-generated method stub

    }

    @Override
    @Inline
    public void sync() {
        // TODO Auto-generated method stub

    }

    @Override
    @Inline
    public void isync() {
        // TODO Auto-generated method stub

    }

    @Override
    protected Address getHeapStartConstant() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Address getHeapEndConstant() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Address getAvailableStartConstant() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Address getAvailableEndConstant() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected byte getLogBytesInAddressConstant() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    protected byte getLogBytesInWordConstant() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    protected byte getLogBytesInPageConstant() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    protected byte getLogMinAlignmentConstant() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    protected byte getMaxAlignmentShiftConstant() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    protected int getMaxBytesPaddingConstant() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    protected int getAlignmentValueConstant() {
        // TODO Auto-generated method stub
        return 0;
    }

}
