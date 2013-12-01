package org.rjava.unittest.lang;

import org.rjava.unittest.UnitTest;

public class TestNumberComparison extends UnitTest {
    public static void main(String[] args) {
        start("Test integer comparison");
        check(testIntComparison());
        
        start("Test integer boundary comparison");
        check(testIntBoundaryComparison());
        
        start("Test long/int comparison");
        check(testLongIntComparison());
        
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
    
    public static boolean testIntBoundaryComparison() {
        int MIN = -2147483648;
        int MAX = 2147483647;
        
        int a = 0;
        
        return a >= MIN && a <= MAX;
    }
    
    public static boolean testLongIntComparison() {
        int MIN = -2147483648;
        int MAX = 2147483647;
        
        long a = 0;
        
        return a >= MIN && a <= MAX;
    }
    
    public static boolean testDoubleComparison() {
        double a = 0.3;
        double b = 0.4;
        double c = 0.5;
        double d = 0.5;
        return a < b && c == d && b > a;
    }
}
