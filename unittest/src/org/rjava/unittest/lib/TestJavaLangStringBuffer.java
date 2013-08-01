package org.rjava.unittest.lib;

import org.rjava.unittest.UnitTest;

public class TestJavaLangStringBuffer extends UnitTest {
    public static void main(String[] args) {
        start("Test explicit new()");
        check(testExplicitNew());
        
        start("Test explicit append()");
        check(testExplicitAppend());
        
        start("Test implicit use");
        check(testImplicitUse());
    }
    
    public static boolean testExplicitNew() {
        String a = "hello";
        StringBuffer buffer1 = new StringBuffer(a);
        StringBuffer buffer2 = new StringBuffer("hello");
        return buffer1.toString().equals("hello") && buffer2.toString().equals("hello");
    }

    public static boolean testExplicitAppend() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("hello");
        buffer.append(" ");
        buffer.append("world");
        return buffer.toString().equals("hello world");
    }
    
    public static boolean testImplicitUse() {
        String a = "hello";
        a += " ";
        a += "world";
        return a.equals("hello world");
    }
}
