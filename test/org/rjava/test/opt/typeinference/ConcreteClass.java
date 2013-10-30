package org.rjava.test.opt.typeinference;

public class ConcreteClass extends AbstractClass {
    @Override
    public A foo() {
        return new B();
    }    
}
