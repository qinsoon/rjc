package org.rjava.test.opt.objectinline;

public class A1 {
    B field;        // should be inlined
    C field2;       // cant be inlined - circular reference
    B field3;       // cant be inlined - assigned twice
    
    public A1 next;
    
    public A1() {
        field = new B();
        //field2 = new C();
        field3 = new B();
    }
    
    public void reassign() {
        field3 = new B();
    }
}
