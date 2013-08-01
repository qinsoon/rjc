package org.rjava.unittest.magic;

import org.rjava.restriction.rulesets.RJavaCore;
import org.rjava.unittest.UnitTest;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.AddressArray;
import org.vmmagic.unboxed.ObjectReference;

@RJavaCore
public class TestAddressArray extends UnitTest {

    public static void main(String[] args) {
        start("AddressArray create");
        check(TestAddressArrayCreate());
        
        start("AddressArray set/get");
        check(TestAddressArraySetGet());
    }

    public static boolean TestAddressArrayCreate() {
        AddressArray array = AddressArray.create(5);
        return true;
    }
    
    public static boolean TestAddressArraySetGet() {
        AddressArray array = AddressArray.create(5);
        Integer i = new Integer(1);
        Address addr = ObjectReference.fromObject(i).toAddress();
        addr.store(100);
        
        array.set(2, addr);
        int get = array.get(2).loadInt();
        
        return get == 100;
    }
}
