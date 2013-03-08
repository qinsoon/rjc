package java.lang;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;

@RJavaCore
public class StringBuffer {
    protected Address internal;
    int currentBufferSize;
    
    public StringBuffer() {
        this.internal = C.malloc(TEMP_STRING_LENGTH);
        this.internal.store(C.STRING_END);
        this.currentBufferSize = TEMP_STRING_LENGTH;
    }
    
    public void append(Object o) {
        Address str;
        if (o == null)
            str = String.rawCString("NULL");
        else {
            str = C.malloc(TEMP_STRING_LENGTH);
            C.strcpy(str, o.toString().internal);
        }
        
        if (C.strlen(str) + C.strlen(internal) + 1 > currentBufferSize) {
            Address old = this.internal;
            internal = C.malloc(currentBufferSize * 2);
            currentBufferSize = currentBufferSize * 2;
            C.strcpy(internal, old);
        }
        
        C.strcat(internal, str);
    }
    
    public void append(int i) {
        Address iStr = C.malloc(TEMP_STRING_LENGTH);
        C.sprintf(iStr, "%" + C.PRId32, i);
        append(String.newStringConstant(iStr));
    }
    
    public String toString() {
        return String.newStringConstant(internal);
    }
}
