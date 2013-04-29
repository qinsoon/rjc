package org.rjava.unittest.lang;

import org.rjava.unittest.UnitTest;

public class TestNumberComparison extends UnitTest {
    public static void main(String[] args) {
        start("Test integer comparison");
        check(testIntComparison());
        
        start("Test double comparison");
        check(testDoubleComparison());
    }

    public static boolean testIntComparison() {
        int a = 3;
        int b = 4;
        int c = 5;
        int d = 5;
        return a < b && c == d && b > a;
    }
    
    public static boolean testDoubleComparison() {
        double a = 0.3;
        double b = 0.4;
        double c = 0.5;
        double d = 0.5;
        return a < b && c == d && b > a;
    }
}
