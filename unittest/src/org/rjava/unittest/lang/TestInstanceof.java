package org.rjava.unittest.lang;

import org.rjava.unittest.UnitTest;

public class TestInstanceof extends UnitTest {
    static class Parent {
        
    }
    
    static class Child extends Parent {
        
    }
    
    public static void main(String[] args) {
        start("Test instanceof self class");
        check(testInstanceofSelfClass());
        
        start("Test instanceof parent class");
        check(testInstanceofParentClass());
    }

    public static boolean testInstanceofSelfClass() {
        Child instance = new Child();
        return instance instanceof Child;
    }
    
    public static boolean testInstanceofParentClass() {
        Child instance = new Child();
        return instance instanceof Parent;
    }
}
