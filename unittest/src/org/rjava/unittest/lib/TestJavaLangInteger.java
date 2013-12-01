package org.rjava.unittest.lib;

import org.rjava.unittest.UnitTest;

public class TestJavaLangInteger extends UnitTest {

    public static void main(String[] args) {
        start("Test valueOf(int)");
        check(testValueOfInt());
        
        start("Test new Integer(int)");
        check(testNewInteger());
        
        start("Test toString()");
        check(testToString());
        
        start("Test intValue()");
        check(testIntValue());
        
        start("Test parseInt(String)");
        check(testParseInt());
    }

    public static boolean testValueOfInt() {
        int a = 10;
        Integer i = Integer.valueOf(a);
        return i == 10;
    }
    
    public static boolean testNewInteger() {
        Integer i = new Integer(10);
        return i == 10;
    }
    
    public static boolean testToString() {
        Integer i = new Integer(10);
        String str = i.toString();
        return str.equals("10");
    }
    
    public static boolean testIntValue() {
        Integer i = new Integer(10);
        int i2 = i.intValue();
        return i2 == 10;
    }
    
    public static boolean testParseInt() {
        int i = Integer.parseInt("10");
        return i == 10;
    }
}
