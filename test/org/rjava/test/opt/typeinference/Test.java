package org.rjava.test.opt.typeinference;

public class Test {
    public static void main(String[] args) {
        A a = new B();
        a.func();
        
        AbstractClass concrete = new ConcreteClass();
        A b = concrete.foo();
        A b2 = test(concrete);
    }
    
    public static A test(AbstractClass obj) {
        return obj.foo();
    }
}
