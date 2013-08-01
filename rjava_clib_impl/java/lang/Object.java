package java.lang;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;

@RJavaCore
public class Object {
    protected static final int TEMP_STRING_LENGTH = 1024;
    
    public boolean equals(Object o) {
        return false;
    }
    
    public String toString() {
        Address buffer = C.malloc(TEMP_STRING_LENGTH);
        C.sprintf(buffer, "Object:%p", this);
        return String.newStringConstant(buffer);
    }
}
