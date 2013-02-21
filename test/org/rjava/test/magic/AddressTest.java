package org.rjava.test.magic;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.ObjectReference;

@RJavaCore
public class AddressTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer i = new Integer(1);
        Address i_address = ObjectReference.fromObject(i).toAddress();
        i_address.store(2);
        int after = i_address.loadInt();
        System.out.println(after);
    }

}
