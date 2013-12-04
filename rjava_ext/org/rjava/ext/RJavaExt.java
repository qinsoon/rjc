package org.rjava.ext;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.AddressArray;
import org.vmmagic.unboxed.ExtentArray;
import org.vmmagic.unboxed.ObjectReferenceArray;
import org.vmmagic.unboxed.OffsetArray;
import org.vmmagic.unboxed.WordArray;

@RJavaCore
public class RJavaExt {
    public static native Address getArrayEleAddress(Object[] array, int index);
    public static native Address getArrayEleAddress(AddressArray array, int index);
    public static native Address getArrayEleAddress(ObjectReferenceArray array, int index);
    public static native Address getArrayEleAddress(ExtentArray array, int index);
    public static native Address getArrayEleAddress(WordArray array, int index);
    public static native Address getArrayEleAddress(OffsetArray array, int index);
    public static native Address getArrayEleAddress(int[] array, int index);
    public static native Address getArrayEleAddress(short[] array, int index);
    public static native Address getArrayEleAddress(char[] array, int index);
    public static native Address getArrayEleAddress(long[] array, int index);
    public static native Address getArrayEleAddress(float[] array, int index);
    public static native Address getArrayEleAddress(double[] array, int index);
    public static native Address getArrayEleAddress(byte[] array, int index);
    public static native Address getArrayEleAddress(boolean[] array, int index);
}
