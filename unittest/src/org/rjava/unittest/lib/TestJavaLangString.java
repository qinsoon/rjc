package org.rjava.unittest.lib;

import org.rjava.unittest.UnitTest;

public class TestJavaLangString extends UnitTest {
    public static void main(String[] args) {
        start("Test string literals and equals()");
        check(testStringLiteralAndEquals());
        
        start("Test new String()");
        check(testNewString());
        
        start("Test charAt()");
        check(testCharAt());
        
        start("Test length()");
        check(testLength());
        
        start("Test getBytes()");
        check(testGetBytes());
        
        start("Test substring()");
        check(testSubstring());
        
        start("Test indexOf()");
        check(testIndexOf());
        
        start("Test toLowerCase()");
        check(testToLowerCase());
    }

    public static boolean testStringLiteralAndEquals() {
        String a = "hello";
        String b = "hello";
        return a.equals(b);
    }
    
    public static boolean testNewString() {
        String literal = "hello";
        String a = new String("hello");
        String b = new String(a);
        
        return a.equals(literal) && b.equals(literal); 
    }
    
    public static boolean testCharAt() {
        String literal = "hello";
        return literal.charAt(1) == 'e';
    }
    
    public static boolean testLength() {
        String literal = "hello";
        return literal.length() == 5;
    }
    
    public static boolean testGetBytes() {
        String literal = "hello";
        byte[] bytes = {'h', 'e', 'l', 'l', 'o'};
        for (int i = 0; i < 5; i++)
            if (bytes[i] != literal.getBytes()[i])
                return false;
        
        return true;
    }
    
    public static boolean testSubstring() {
        String literal = "hello";
        return literal.substring(2).equals("llo") && literal.substring(2, 4).equals("ll");
    }
    
    public static boolean testIndexOf() {
        String literal = "123123123";
        return literal.indexOf('2') == 1 && literal.indexOf('2', 3) == 4;
    }
    
    public static boolean testToLowerCase() {
        String literal = "HeLlO";
        return literal.toLowerCase().equals("hello");
    }
}
