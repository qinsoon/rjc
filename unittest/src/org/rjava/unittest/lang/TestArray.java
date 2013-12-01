package org.rjava.unittest.lang;

import org.rjava.restriction.rulesets.RJavaCore;
import org.rjava.unittest.UnitTest;

@RJavaCore
public class TestArray extends UnitTest {
    public static void main(String[] args) {
        start("Test int array");
        check(testIntArray());
        
        start("Test double array");
        check(testDoubleArray());
    }

    public static boolean testIntArray() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        return array[0] == 0 && array[4] == 4 && array[9] == 9;
    }
    
    public static boolean testDoubleArray() {
        double[] array = {0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9};
        return (array[0] == 0)
                && (array[4] == 0.4)
                && (array[9] == 0.9);
    }
}
