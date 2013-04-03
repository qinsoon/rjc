package org.rjava.unittest.lib;

import org.rjava.restriction.rulesets.RJavaCore;
import org.rjava.unittest.UnitTest;

@RJavaCore
public class TestJavaLangClass extends UnitTest {

    public static void main(String[] args) {
        start("Test Class.forName()");
        check(testClassForName());
    }

    public static boolean testClassForName() {
        try {
            Class.forName("java.lang.Integer");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
