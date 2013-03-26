package org.rjava.unittest.lang;

import org.rjava.restriction.rulesets.RJavaCore;
import org.rjava.unittest.UnitTest;

@RJavaCore
public class TestInheritance extends UnitTest {

    public static void main(String[] args) {
        start("Test field inheritance");
        check(testFieldInheritance());
        
        start("Test instance method inheritance");
        check(testInstanceMethodInheritance());
        
        start("Test instance method override");
        check(testInstanceMethodOverride());
        
        start("Test static method inheritance");
        check(testStaticMethodInheritance());
    }

    static class Parent {
        int field = 0;
        public int instanceMethod() {
            return 0;
        }
        public static int staticMethod() {
            return 0;
        }
    }
    
    static class ChildNoChange extends Parent {
        
    }
    
    static class Child extends Parent {
        public int instanceMethod() {
            return 1;
        }
    }
    
    public static boolean testFieldInheritance() {
        Parent parent = new Parent();
        Child child = new Child();
        
        return parent.field == 0 && child.field == 0;
    }
    
    public static boolean testInstanceMethodInheritance() {
        Parent parent = new Parent();
        ChildNoChange child = new ChildNoChange();
        
        return parent.instanceMethod() == 0 && child.instanceMethod() == 0;
    }
    
    public static boolean testInstanceMethodOverride() {
        Parent parent = new Parent();
        Child child = new Child();
        
        return parent.instanceMethod() == 0 && child.instanceMethod() == 1;
    }
    
    public static boolean testStaticMethodInheritance() {
        return Parent.staticMethod() == 0 && Child.staticMethod() == 0;
    }
}
