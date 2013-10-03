package testbed.runtime;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.pragma.Inline;
import org.vmmagic.unboxed.ObjectReference;
import org.vmmagic.unboxed.ObjectReferenceArray;

import testbed.Main;

@RJavaCore
public class TestbedObject {
    private ObjectReferenceArray fields = ObjectReferenceArray.create(0);
    private int size;
    
    public TestbedObject() {
        reset();
    }
    
    public TestbedObject(int fieldCount) {
        this.fields = ObjectReferenceArray.create(fieldCount);
        computeSize();
    }
    
    public void reset() {
        this.fields = null;
        computeSize();
    }
    
    private void computeSize() {
        int minSize = ObjectModel.objectMinSize();

        this.size = minSize +
                testbed.Constants.OBJECTREFERENCE_LENGTH_IN_BYTES * getFieldCount();//fields
    }
    
    public void setField(int i, ObjectReference objRef) {
        fields.set(i, objRef);
    }
    
    @Inline
    public ObjectReference getField(int i) {
        return fields.get(i);
    }
    
    @Inline
    public int getSize() {
        return size;
    }
    
    public void setFieldCount(int i) {
        this.fields = ObjectReferenceArray.create(i);
        computeSize();
    }
    
    @Inline
    public int getFieldCount() {
        return fields.length();
    }
}
