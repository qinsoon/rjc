package java.lang;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;

@RJavaCore
public class String extends Object {
    public Address internal = C.malloc(TEMP_STRING_LENGTH);
    public int length;
    
    public String(Address charPtr) {
        C.strcpy(internal, charPtr);
        length = C.strlen(internal);
    }
    
    public String(String string) {
        C.strcpy(this.internal, string.internal);
        length = C.strlen(internal);
    }
    
    @Override
    public boolean equals(Object o) {
        for (int i = 0; i < TEMP_STRING_LENGTH; i++) {
            char c = internal.plus(i).loadChar();
            if (c != ((String)o).internal.plus(i).loadChar())
                return false;
            if (c == C.STRING_END)
                return true;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return this;
    }
    
    public char charAt(int i) {
        return internal.plus(i).loadChar();
    }
    
    static String newStringConstant(Address str) {
        return new String(str);
    }
    
    static Address rawCString(String str) {
        Address ret = C.malloc(str.length + 1);
        for (int i = 0; i < str.length; i++)
            ret.plus(i).store(str.charAt(i));
        ret.plus(str.length + 1).store(C.STRING_END);
        return ret;
    }
}
