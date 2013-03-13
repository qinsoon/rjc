package org.rjava.unittest.magic;

import org.rjava.restriction.rulesets.RJavaCore;
import org.rjava.unittest.UnitTest;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.ObjectReference;
import org.vmmagic.unboxed.Offset;

@RJavaCore
public class TestAddress extends UnitTest{
    public static void main(String[] args) {
        start("Address store/load");
        check(TestAddressStoreLoad());
        
        start("Address offset store/load");
        check(TestAddressOffsetStoreLoad());
    }

    public static boolean TestAddressStoreLoad() {
        Integer i = new Integer(1);
        Address addr = ObjectReference.fromObject(i).toAddress();
        addr.store(100);
        int load = addr.loadInt();
        
        return load == 100;
    }
    
    public static boolean TestAddressOffsetStoreLoad() {
        Integer[] array = new Integer[5];
        Address addr = ObjectReference.fromObject(array).toAddress();
        Offset offset = Offset.fromIntSignExtend(2);
        addr.store(100, offset);
        int load = addr.loadInt(offset);
        
        return load == 100;        
    }
}
