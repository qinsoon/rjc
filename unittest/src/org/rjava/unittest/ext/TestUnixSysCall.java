package org.rjava.unittest.ext;

import org.rjava.nativeext.RawMemory;
import org.rjava.nativeext.UnixSysCall;
import org.rjava.unittest.UnitTest;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.Extent;
import org.vmmagic.unboxed.Offset;

public class TestUnixSysCall extends UnitTest {

    public static void main(String[] args) {
        start("Test mmap");
        check(testMMap());
    }

    public static boolean testMMap() {
        Address start = RawMemory.malloc(500);
        Address ret = UnixSysCall.mmap(start, 
                Extent.fromIntZeroExtend(500), 
                UnixSysCall.PROT_READ | UnixSysCall.PROT_WRITE, 
                UnixSysCall.MAP_ANONYMOUS, -1, Offset.zero());
        return ret.toInt() == UnixSysCall.MAP_FAILED;
    }
}
