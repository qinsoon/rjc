package testbed.mmtkext;

import org.mmtk.vm.Barriers;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.pragma.NoCheckStore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.Extent;
import org.vmmagic.unboxed.ObjectReference;
import org.vmmagic.unboxed.Offset;
import org.vmmagic.unboxed.Word;

import testbed.Main;

@RJavaCore
public class BarriersExt extends Barriers {

    @Override
    public void booleanWrite(ObjectReference ref, boolean value,
            Word metaDataA, Word metaDataB, int mode) {
        Main.unimplementedInterface();
    }

    @Override
    public boolean booleanRead(ObjectReference ref, Word metaDataA,
            Word metaDataB, int mode) {
        Main.unimplementedInterface();
        return false;
    }

    @Override
    public void byteWrite(ObjectReference ref, byte value, Word metaDataA,
            Word metaDataB, int mode) {
        Main.unimplementedInterface();
    }

    @Override
    public byte byteRead(ObjectReference ref, Word metaDataA, Word metaDataB,
            int mode) {
        Main.unimplementedInterface();
        return 0;
    }

    @Override
    public void charWrite(ObjectReference ref, char value, Word metaDataA,
            Word metaDataB, int mode) {
        Main.unimplementedInterface();
    }

    @Override
    public char charRead(ObjectReference ref, Word metaDataA, Word metaDataB,
            int mode) {
        Main.unimplementedInterface();
        return 0;
    }

    @Override
    public void shortWrite(ObjectReference ref, short value, Word metaDataA,
            Word metaDataB, int mode) {
        Main.unimplementedInterface();
    }

    @Override
    public short shortRead(ObjectReference ref, Word metaDataA, Word metaDataB,
            int mode) {
        Main.unimplementedInterface();
        return 0;
    }

    @Override
    public void intWrite(ObjectReference ref, int value, Word metaDataA,
            Word metaDataB, int mode) {
        Main.unimplementedInterface();
    }

    @Override
    public int intRead(ObjectReference ref, Word metaDataA, Word metaDataB,
            int mode) {
        Main.unimplementedInterface();
        return 0;
    }

    @Override
    public boolean intTryCompareAndSwap(ObjectReference objref, int old,
            int value, Word metaDataA, Word metaDataB, int mode) {
        Main.unimplementedInterface();
        return false;
    }

    @Override
    public void longWrite(ObjectReference ref, long value, Word metaDataA,
            Word metaDataB, int mode) {
        Main.unimplementedInterface();
    }

    @Override
    public long longRead(ObjectReference ref, Word metaDataA, Word metaDataB,
            int mode) {
        Main.unimplementedInterface();
        return 0;
    }

    @Override
    public boolean longTryCompareAndSwap(ObjectReference objref, long old,
            long value, Word metaDataA, Word metaDataB, int mode) {
        Main.unimplementedInterface();
        return false;
    }

    @Override
    public void floatWrite(ObjectReference ref, float value, Word metaDataA,
            Word metaDataB, int mode) {
        Main.unimplementedInterface();
    }

    @Override
    public float floatRead(ObjectReference ref, Word metaDataA, Word metaDataB,
            int mode) {
        Main.unimplementedInterface();
        return 0;
    }

    @Override
    public void doubleWrite(ObjectReference ref, double value, Word metaDataA,
            Word metaDataB, int mode) {
        Main.unimplementedInterface();
    }

    @Override
    public double doubleRead(ObjectReference ref, Word metaDataA,
            Word metaDataB, int mode) {
        Main.unimplementedInterface();
        return 0;
    }

    @Override
    public void objectReferenceWrite(ObjectReference ref,
            ObjectReference value, Word metaDataA, Word metaDataB, int mode) {
        Main.unimplementedInterface();
    }

    @Override
    public ObjectReference objectReferenceRead(ObjectReference ref,
            Word metaDataA, Word metaDataB, int mode) {
        Main.unimplementedInterface();
        return null;
    }

    @Override
    public void objectReferenceNonHeapWrite(Address slot,
            ObjectReference target, Word metaDataA, Word metaDataB) {
        Main.unimplementedInterface();
    }

    @Override
    public ObjectReference objectReferenceAtomicWrite(ObjectReference ref,
            ObjectReference target, Word metaDataA, Word metaDataB, int mode) {
        Main.unimplementedInterface();
        return null;
    }

    @Override
    public boolean objectReferenceTryCompareAndSwap(ObjectReference ref,
            ObjectReference old, ObjectReference target, Word metaDataA,
            Word metaDataB, int mode) {
        Main.unimplementedInterface();
        return false;
    }

    @Override
    public void wordWrite(ObjectReference ref, Word target, Word metaDataA,
            Word metaDataB, int mode) {
        Main.unimplementedInterface();
    }

    @Override
    public Word wordAtomicWrite(ObjectReference ref, Word rawTarget,
            Word metaDataA, Word metaDataB, int mode) {
        Main.unimplementedInterface();
        return null;
    }

    @Override
    public boolean wordTryCompareAndSwap(ObjectReference ref, Word old,
            Word target, Word metaDataA, Word metaDataB, int mode) {
        Main.unimplementedInterface();
        return false;
    }

    @Override
    public Word wordRead(ObjectReference ref, Word metaDataA, Word metaDataB,
            int mode) {
        Main.unimplementedInterface();
        return null;
    }

    @Override
    public void addressWrite(ObjectReference ref, Address target,
            Word metaDataA, Word metaDataB, int mode) {
        Main.unimplementedInterface();
    }

    @Override
    public Address addressRead(ObjectReference ref, Word metaDataA,
            Word metaDataB, int mode) {
        Main.unimplementedInterface();
        return null;
    }

    @Override
    public boolean addressTryCompareAndSwap(ObjectReference ref, Address old,
            Address target, Word metaDataA, Word metaDataB, int mode) {
        Main.unimplementedInterface();
        return false;
    }

    @Override
    public void offsetWrite(ObjectReference ref, Offset target, Word metaDataA,
            Word metaDataB, int mode) {
        Main.unimplementedInterface();
    }

    @Override
    public Offset offsetRead(ObjectReference ref, Word metaDataA,
            Word metaDataB, int mode) {
        Main.unimplementedInterface();
        return null;
    }

    @Override
    public void extentWrite(ObjectReference ref, Extent target, Word metaDataA,
            Word metaDataB, int mode) {
        Main.unimplementedInterface();
    }

    @Override
    public Extent extentRead(ObjectReference ref, Word metaDataA,
            Word metaDataB, int mode) {
        Main.unimplementedInterface();
        return null;
    }

    @Override
    public void objectArrayStoreNoGCBarrier(Object[] dst, int index,
            Object value) {
        dst[index] = value;
    }

}
