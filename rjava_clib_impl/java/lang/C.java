package java.lang;

import java.lang.Object;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;

@RJavaCore
public abstract class C {
    public static final char STRING_END = '\0';
    public static final String PRId32 = "ld";
    
    public static native Address malloc(int size);
    
    public static native int sprintf(Address str, String format, Object... arguments);
    
    public static native int printf(String format, Object... arguments);
    
    public static native Address strcpy(Address dest, Address source);
    public static native int strlen(Address str);
    public static native Address strcat(Address dest, Address src);
}
