package org.rjava.test.interfacetest;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public interface ConstantInterface {
    static String MESSAGE = new String("Hello World");
    static int BIRTHDAY   = 19870210;
    
    public void bye();
}
