package org.rjava.test;

public class RJavaObjectTest {
    public static void foo(Object i) {
        i = new Integer(1);
        System.out.println("in foo(): " + i);
    }
    
    public static void main(String[] args) {
        Object o = null;
        foo(o);
        System.out.println("after foo(): " + o);
    }
}
