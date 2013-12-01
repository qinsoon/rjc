package org.rjava.test.interfacetest;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class ConstantInterfaceTest implements ConstantInterface {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(MESSAGE);
        System.out.println(BIRTHDAY);
        new ConstantInterfaceTest().bye();
    }

    public void bye() {
        System.out.println("bye");
    }
}
