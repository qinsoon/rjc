package org.rjava.test.opt.objectinline;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        A1 a1 = new A1();
        for (int i = 0; i < 100; i++)
            a1.field.number += i;
        
        A2 a2 = new A2();
        for (int i = 0; i < 100; i++)
            a2.field.number += i;
    }

}
