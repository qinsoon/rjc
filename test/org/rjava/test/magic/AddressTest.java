package org.rjava.test.magic;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.ObjectReference;
import org.vmmagic.unboxed.Offset;

@RJavaCore
public class AddressTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Zero extend");
        Address addr = Address.fromIntZeroExtend(0x80000000);
        System.out.println(addr.toLong());
        addr = addr.minus(1);
        System.out.println(addr.toLong());
        
        Address addr3 = Address.fromIntZeroExtend(0);
        System.out.println(addr3.toLong());
        addr3 = addr3.minus(1);
        System.out.println(addr3.toLong());
        
        System.out.println("Sign extend");
        Address addr2 = Address.fromIntSignExtend(0x80000000);
        System.out.println(addr2.toLong());
        addr2 = addr2.minus(1);
        System.out.println(addr2.toLong());
        
        Address addr4 = Address.fromIntSignExtend(0);
        System.out.println(addr4.toLong());
        addr4 = addr4.minus(1);
        System.out.println(addr4.toLong());
    }

}
