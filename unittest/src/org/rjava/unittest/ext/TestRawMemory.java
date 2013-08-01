package org.rjava.unittest.ext;

import org.rjava.osext.OSMemory;
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
        
        start("Test memset");
        check(testMemset());
    }
    
    public static boolean testMalloc() {
        Address addr = OSMemory.malloc(500);
        return !addr.isZero();
    }
    
    public static boolean testMMap() {
        Address ret = OSMemory.mmap(Address.zero(), 
                Extent.fromIntZeroExtend(4096), 
                OSMemory.PROT_READ | OSMemory.PROT_WRITE, 
                OSMemory.MAP_ANONYMOUS | OSMemory.MAP_PRIVATE, -1, Offset.zero());
        return ret.toInt() != OSMemory.MAP_FAILED;
    }
    
    public static boolean testMProtect() {
        Extent length = Extent.fromIntZeroExtend(4096);
        Address ret = OSMemory.mmap(Address.zero(), 
                length, 
                OSMemory.PROT_READ, 
                OSMemory.MAP_ANONYMOUS | OSMemory.MAP_PRIVATE, -1, Offset.zero());
        
        if (ret.toInt() == OSMemory.MAP_FAILED)
            return false;
        
        return OSMemory.mprotect(ret, length, OSMemory.PROT_READ | OSMemory.PROT_WRITE) == 0;
    }
    
    public static boolean testMemset() {
        Address start = OSMemory.malloc(500);
        return OSMemory.memset(start, 0x00, Extent.fromIntZeroExtend(500)).EQ(start);
    }
}
