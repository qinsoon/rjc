package testbed.runtime;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.ObjectReference;
import org.vmmagic.unboxed.ObjectReferenceArray;

import testbed.Main;

@RJavaCore
public class TestbedObject {
    private ObjectReferenceArray fields;
    private int size;
    
    public TestbedObject() {
        reset();
    }
    
    public TestbedObject(int fieldCount) {
        // copy fields
        this.fields = ObjectReferenceArray.create(fieldCount);
        computeSize();
    }
    
    public void reset() {
        this.fields = null;
        computeSize();
    }
    
    private void computeSize() {
        int minSize = ObjectModel.objectMinSize();

        if (fields == null)
            this.size = minSize;
        else this.size = minSize +
                testbed.Constants.OBJECTREFERENCE_LENGTH_IN_BYTES * getFieldCount();//fields
    }
    
    public void setField(int i, ObjectReference objRef) {
        fields.set(i, objRef);
    }
    
    public ObjectReference getField(int i) {
        return fields.get(i);
    }
    
    public int getSize() {
        return size;
    }
    
    public void setFieldCount(int i) {
        this.fields = ObjectReferenceArray.create(i);
        computeSize();
    }
    
    public int getFieldCount() {
        if (fields == null)
            return 0;
        else return fields.length();
    }
}
