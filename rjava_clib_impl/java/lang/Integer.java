package java.lang;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;

@RJavaCore
public class Integer extends Object{
    protected int internal;
    
    public Integer(int i) {
        this.internal = i;
    }
    
    @Override
    public String toString() {
        Address ret = C.malloc(TEMP_STRING_LENGTH);
        C.sprintf(ret, "%ld", internal);
        return String.newStringConstant(ret);
    }
    
    public Integer valueOf(int i) {
        Integer ret = new Integer(i);
        return ret;
    }
    
    public int intValue() {
        return internal;
    }
    
    Integer newIntegerConstant(int i) {
        return new Integer(i);
    }
}
