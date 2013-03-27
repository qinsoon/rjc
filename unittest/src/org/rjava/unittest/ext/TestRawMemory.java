package org.rjava.unittest.ext;

import org.rjava.nativeext.RawMemory;
import org.rjava.unittest.UnitTest;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.Extent;
import org.vmmagic.unboxed.Offset;

public class TestRawMemory extends UnitTest {

    public static void main(String[] args) {
        start("Test malloc");
        check(testMalloc());
        
        start("Test mmap");
        check(testMMap());
        
        start("Test mprotect");
        check(testMProtect());
    }
    
    public static boolean testMalloc() {
        Address addr = RawMemory.malloc(500);
        return !addr.isZero();
    }
    
    public static boolean testMMap() {
        Address ret = RawMemory.mmap(Address.zero(), 
                Extent.fromIntZeroExtend(4096), 
                RawMemory.PROT_READ | RawMemory.PROT_WRITE, 
                RawMemory.MAP_ANONYMOUS | RawMemory.MAP_PRIVATE, -1, Offset.zero());
        return ret.toInt() != RawMemory.MAP_FAILED;
    }
    
    public static boolean testMProtect() {
        Extent length = Extent.fromIntZeroExtend(4096);
        Address ret = RawMemory.mmap(Address.zero(), 
                length, 
                RawMemory.PROT_READ, 
                RawMemory.MAP_ANONYMOUS | RawMemory.MAP_PRIVATE, -1, Offset.zero());
        
        if (ret.toInt() == RawMemory.MAP_FAILED)
            return false;
        
        return RawMemory.mprotect(ret, length, RawMemory.PROT_READ | RawMemory.PROT_WRITE) == 0;
    }
}
