package org.rjava.test.opt.objectinline;

public class Test {
    public static final int LIST_LENGTH = 1000000;

    /**
     * @param args
     */
    public static void main(String[] args) {
        // construct list
        A1 list = new A1();
        A1 head = list;
        for (int i = 0; i < LIST_LENGTH; i++) {
            list.next = new A1();
            list = list.next;
        }
        
        System.out.println("setting field..");
        
        for (int i = 0; i < 100; i++) {
            list = head;
            for (int j = 0; j < LIST_LENGTH; j++) {
                list.field.number += i;
                list = list.next;
            }
        }
        
        System.out.println("field.number=" + head.field.number);
    }
}
