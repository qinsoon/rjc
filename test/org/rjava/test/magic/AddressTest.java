package org.rjava.test.magic;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.ObjectReference;
import org.vmmagic.unboxed.Offset;

@RJavaCore
public class AddressTest {
    public static final Offset RJAVA_ARRAY_C_HEADER = Offset.fromIntSignExtend(12);
    public static final Offset INT_WIDTH = Offset.fromIntSignExtend(4);
    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer i = new Integer(1);
        Address i_address = ObjectReference.fromObject(i).toAddress();
        i_address.store(2);
        int after = i_address.loadInt();
        System.out.println(after);
        
        final Offset RJAVA_ARRAY_C_HEADER = Offset.fromIntSignExtend(12);
        final Offset INT_WIDTH = Offset.fromIntSignExtend(4);
        
        int[] array = new int[5];
        Address array_addr = ObjectReference.fromObject(array).toAddress();
        array_addr = array_addr.plus(RJAVA_ARRAY_C_HEADER);
        array_addr.store(0);
        for (int j = 1; j < 5; j++) {
            array_addr = array_addr.plus(INT_WIDTH);
            array_addr.store(j);
        }
        for (int k = 0; k < 5; k++) {
            System.out.println(array[k]);
        }
    }

}
