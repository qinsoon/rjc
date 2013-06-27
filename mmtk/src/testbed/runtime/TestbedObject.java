package testbed.runtime;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.ObjectReferenceArray;

@RJavaCore
public class TestbedObject {
    ObjectReferenceArray fields;;
    int size;
    int fieldCount;
    
    public TestbedObject(ObjectReferenceArray refArray) {
        // copy fields
        if (refArray != null) {
            this.fields = ObjectReferenceArray.create(refArray.length());
            for (int i = 0; i < refArray.length(); i++)
                this.fields.set(i, refArray.get(i));
        }
        
        int minSize = testbed.Constants.WORD_LENGTH_IN_BYTES + // header
                testbed.Constants.INT_IN_BYTES + // size
                testbed.Constants.INT_IN_BYTES;// field count
        if (refArray != null) {
            this.size = minSize +
                testbed.Constants.OBJECTREFERENCE_LENGTH_IN_BYTES * refArray.length();//fields
            this.fieldCount = refArray.length();
        } else {
            this.size = minSize;
            this.fieldCount = 0;
        }
    }
    
    public int getSize() {
        return size;
    }
    
    public int getFieldCount() {
        return fieldCount;
    }
}
