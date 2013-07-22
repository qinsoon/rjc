package testbed.runtime;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.ObjectReference;
import org.vmmagic.unboxed.ObjectReferenceArray;

@RJavaCore
public class TestbedObject {
    ObjectReferenceArray fields;
    int size;
    int fieldCount;
    
    public TestbedObject(int fieldCount) {
        // copy fields
        this.fields = ObjectReferenceArray.create(fieldCount);
        
        int minSize = testbed.Constants.WORD_LENGTH_IN_BYTES + // header
                testbed.Constants.INT_IN_BYTES + // size
                testbed.Constants.INT_IN_BYTES;// field count

        this.size = minSize +
                testbed.Constants.OBJECTREFERENCE_LENGTH_IN_BYTES * fieldCount;//fields
    }
    
    public void setField(int i, ObjectReference objRef) {
        fields.set(i, objRef);
    }
    
    public int getSize() {
        return size;
    }
    
    public int getFieldCount() {
        return fieldCount;
    }
}
