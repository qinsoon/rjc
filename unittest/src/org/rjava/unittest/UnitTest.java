package org.rjava.unittest;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public abstract class UnitTest {
    protected static final void start(String testName) {
        System.out.print(testName + ":");
    }
    
    protected static final void check(boolean result) {
        if (result)
            System.out.println("success");
        else System.out.println("fail");
    }
}
