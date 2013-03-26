package org.rjava.unittest.lang;

import org.rjava.unittest.UnitTest;

public class TestNestedClass extends UnitTest {
    static class NestedClass {
        int instanceField = 1;
        public static int staticField = 2;
        public int instanceMethod() {
            return 101;
        }
        public static int staticMethod() {
            return 102;
        }
    }
    
    public static void main(String[] args) {
        start("Test new nested class");
        check(testNestedClass());
        
        start("Test nested class instace field");
        check(testNestedClassInstanceField());
        
        start("Test nested class static field");
        check(testNestedClassStaticField());
        
        start("Test nested class instance method");
        check(testNestedClassInstanceMethod());
        
        start("Test nested class static method");
        check(testNestedClassStaticMethod());
    }
    
    public static boolean testNestedClass() {
        new NestedClass();
        return true;
    }
    
    public static boolean testNestedClassInstanceField() {
        return new NestedClass().instanceField == 1;
    }
    
    public static boolean testNestedClassStaticField() {
        return NestedClass.staticField == 2;
    }
    
    public static boolean testNestedClassInstanceMethod() {
        return new NestedClass().instanceMethod() == 101;
    }
    
    public static boolean testNestedClassStaticMethod() {
        return NestedClass.staticMethod() == 102;
    }
}
