package org.rjava.nativeext;

import org.vmmagic.unboxed.Address;

public abstract class RawMemory {
    public static native Address malloc(int size);
}
