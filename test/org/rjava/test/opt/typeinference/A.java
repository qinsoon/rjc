package org.rjava.test.opt.typeinference;

public class A {
    public static Object staticField = new A();
    
    private Object instanceField = new A();
    
    public void func() {
        Object obj = staticField;
        Object obj2 = instanceField;
    }
}
