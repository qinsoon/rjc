package org.rjava.unittest.lang;

import org.rjava.restriction.rulesets.RJavaCore;
import org.rjava.unittest.UnitTest;

@RJavaCore
public class TestInterface extends UnitTest {

    public static void main(String[] args) {
        start("Test interface constants");
        check(testInterfaceConstants());
        
        start("Test interface methods");
        check(testInterfaceMethod());
        
        start("Test interface methods overriden by subclass");
        check(testInterfaceMethodOverridenBySubclass());
        
        start("Test invoke interface");
        check(testInvokeInterface());
    }
    
    public static boolean testInvokeInterface() {
        Interface i = new Implementor();
        Interface i2 = new SubImplementorOverride();
        Interface i3 = new SubImplementorNoOverride();
        return i.interfaceMethod() == 99 && i2.interfaceMethod() == 100 && i3.interfaceMethod() == 99;
    }
    
    public static boolean testInterfaceConstants() {
        return Interface.CONSTANT == 0 && Implementor.CONSTANT == 0;
    }
    
    public static boolean testInterfaceMethod() {
        return new Implementor().interfaceMethod() == 99;
    }
    
    public static boolean testInterfaceMethodOverridenBySubclass() {
        return new SubImplementorOverride().interfaceMethod() == 100 && new SubImplementorNoOverride().interfaceMethod() == 99;
    }
    
    static class Implementor implements Interface {
        public int interfaceMethod() {
            return 99;
        }        
    }
    
    static class SubImplementorOverride extends Implementor {
        public int interfaceMethod() {
            return 100;
        }
    }
    
    static class SubImplementorNoOverride extends Implementor {
        
    }

    static interface Interface {
        static final int CONSTANT = 0;
        public int interfaceMethod();
    }
}
