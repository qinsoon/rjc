package testbed.mmtkext;

import org.mmtk.vm.TraceInterface;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.pragma.Interruptible;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.ObjectReference;
import org.vmmagic.unboxed.Offset;
import org.vmmagic.unboxed.Word;

@RJavaCore
public class TraceInterfaceExt extends TraceInterface {

    @Override
    public boolean gcEnabled() {
        return true;
    }

    @Override
    public Offset adjustSlotOffset(boolean isScalar, ObjectReference src,
            Address slot) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Interruptible
    public Address skipOwnFramesAndDump(ObjectReference typeRef) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateDeathTime(ObjectReference obj) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setDeathTime(ObjectReference ref, Word time_) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLink(ObjectReference ref, ObjectReference link) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateTime(Word time_) {
        // TODO Auto-generated method stub

    }

    @Override
    public Word getOID(ObjectReference ref) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Word getDeathTime(ObjectReference ref) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ObjectReference getLink(ObjectReference ref) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Address getBootImageLink() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Word getOID() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setOID(Word oid) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getHeaderSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getHeaderEndOffset() {
        // TODO Auto-generated method stub
        return 0;
    }

}
