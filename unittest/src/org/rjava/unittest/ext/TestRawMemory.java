package org.rjava.unittest.ext;

import org.rjava.nativeext.RawMemory;
import org.rjava.unittest.UnitTest;
import org.vmmagic.unboxed.Address;

public class TestRawMemory extends UnitTest {

    public static void main(String[] args) {
        start("Test malloc");
        check(testMalloc());
    }
    
    public static boolean testMalloc() {
        Address addr = RawMemory.malloc(500);
        return !addr.isZero();
    }
}
