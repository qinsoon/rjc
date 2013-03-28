package testbed.runtime;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class TestbedObject {
    TestbedObject[] fields;
    int size;
    int fieldCount;
    
    public TestbedObject(TestbedObject[] fields) {
        this.fields = fields;
        int minSize = testbed.Constants.WORD_LENGTH_IN_BYTES + // header
                testbed.Constants.INT_IN_BYTES + // size
                testbed.Constants.INT_IN_BYTES;// field count
        if (fields != null) {
            this.size = minSize +
                testbed.Constants.OBJECTREFERENCE_LENGTH_IN_BYTES * fields.length;//fields
            this.fieldCount = fields.length;
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
