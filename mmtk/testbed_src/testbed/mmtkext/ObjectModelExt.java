package testbed.mmtkext;

import org.mmtk.vm.ObjectModel;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.ObjectReference;
import org.vmmagic.unboxed.Offset;
import org.vmmagic.unboxed.Word;

import testbed.Main;
import testbed.runtime.Scheduler;
import org.mmtk.plan.CollectorContext;

@RJavaCore
public class ObjectModelExt extends ObjectModel {

    @Override
    public ObjectReference copy(ObjectReference from, int allocator) {
        int size = testbed.runtime.ObjectModel.bytesRequiredWhenCopied(from);
        int align = 0;
        
        CollectorContext c = Scheduler.getCurrentContext().collector();
        allocator = c.copyCheckAllocator(from, size, align, allocator);
        Address toRegion = c.allocCopy(from, size, align, 0, allocator);
        ObjectReference to = toRegion.toObjectReference();
        
        testbed.runtime.ObjectModel.initializeCopiedObject(from, to);
        
        c.postCopy(to, null, size, allocator);
        
        return to;
    }

    @Override
    public Address copyTo(ObjectReference from, ObjectReference to,
            Address region) {
        Main.unimplementedInterface();
        return null;
    }

    @Override
    public ObjectReference getReferenceWhenCopiedTo(ObjectReference from,
            Address to) {
        return to.toObjectReference();
    }

    @Override
    public int getSizeWhenCopied(ObjectReference object) {
        return testbed.runtime.ObjectModel.bytesRequiredWhenCopied(object);
    }

    @Override
    public int getAlignWhenCopied(ObjectReference object) {
        return 0;
    }

    @Override
    public int getAlignOffsetWhenCopied(ObjectReference object) {
        return 0;
    }

    @Override
    public int getCurrentSize(ObjectReference object) {
        return object.toAddress().loadInt(testbed.runtime.ObjectModel.OFFSET_OBJECT_SIZE);
    }

    @Override
    public ObjectReference getNextObject(ObjectReference object) {
        return getObjectFromStartAddress(getObjectEndAddress(object));
    }

    @Override
    public ObjectReference getObjectFromStartAddress(Address start) {
        return start.toObjectReference();
    }

    @Override
    public Address getObjectEndAddress(ObjectReference object) {
        int size = getCurrentSize(object);
        return object.toAddress().plus(size);
    }

    @Override
    public byte[] getTypeDescriptor(ObjectReference ref) {
        return "no type".getBytes();
    }

    @Override
    public boolean isArray(ObjectReference object) {
        return false;
    }

    @Override
    public boolean isPrimitiveArray(ObjectReference object) {
        return false;
    }

    @Override
    public int getArrayLength(ObjectReference object) {
        return 0;
    }

    @Override
    public boolean attemptAvailableBits(ObjectReference object, Word oldVal,
            Word newVal) {
        return object.toAddress().attempt(
                oldVal, 
                newVal,
                testbed.runtime.ObjectModel.OFFSET_HEADER);
    }

    @Override
    public Word prepareAvailableBits(ObjectReference object) {
        return object.toAddress().prepareWord(testbed.runtime.ObjectModel.OFFSET_HEADER);
    }

    @Override
    public void writeAvailableByte(ObjectReference object, byte val) {
        object.toAddress().store(val, testbed.runtime.ObjectModel.OFFSET_HEADER);
    }

    @Override
    public byte readAvailableByte(ObjectReference object) {
        return object.toAddress().loadByte(testbed.runtime.ObjectModel.OFFSET_HEADER);
    }

    @Override
    public void writeAvailableBitsWord(ObjectReference object, Word val) {
        object.toAddress().store(val, testbed.runtime.ObjectModel.OFFSET_HEADER);
    }

    @Override
    public Word readAvailableBitsWord(ObjectReference object) {
        return object.toAddress().loadWord(testbed.runtime.ObjectModel.OFFSET_HEADER);
    }

    @Override
    public Offset GC_HEADER_OFFSET() {
        return testbed.runtime.ObjectModel.OFFSET_GC_HEADER;
    }

    @Override
    public Address objectStartRef(ObjectReference object) {
        return object.toAddress().plus(testbed.runtime.ObjectModel.OFFSET_GC_HEADER);
    }

    @Override
    public Address refToAddress(ObjectReference object) {
        return object.toAddress();
    }

    @Override
    public boolean isAcyclic(ObjectReference typeRef) {
        return false;
    }

    @Override
    public void dumpObject(ObjectReference object) {
        testbed.runtime.ObjectModel.dumpObject(object);
    }

    @Override
    protected Offset getArrayBaseOffset() {
        return Offset.zero();
    }

}
