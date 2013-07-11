package org.rjava.test;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class RJavaMultiarray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final double[][] function = {{0.00, 0.00, 0.10, 0.30, 0.60, 0.80, 1.00},
            { 0.00, 0.90, 0.90, 0.95, 1.00, 1.00, 1.00 },
            { 0.02, 0.90, 0.90, 0.95, 1.00, 1.00, 1.00 },
            { 0.05, 0.95, 0.95, 1.00, 1.00, 1.00, 1.00 },
            { 0.15, 1.00, 1.00, 1.10, 1.15, 1.20, 1.20 },
            { 0.30, 1.00, 1.00, 1.20, 1.25, 1.35, 1.30 },
            { 0.50, 1.00, 1.00, 1.25, 1.30, 1.50, 1.50 },
            { 1.00, 1.00, 1.00, 1.25, 1.30, 1.50, 1.50 } };
        
        System.out.println("Check live ratio");
        // Check live ratio
        double[] liveRatio = function[0];
        _assert(liveRatio[1]);
        _assert(liveRatio[liveRatio.length-1]);
        for (int i = 2; i < liveRatio.length; i++) {
          _assert(liveRatio[i-1]);
          _assert(liveRatio[i]);
          for (int j = 1; j < function.length; j++) {
            _assert(function[j][i]);
          }
        }

        System.out.println("Check GC load");
        // Check GC load
        _assert(function[1][0]);
        int len = function.length;
        _assert(function[len-1][0]);
        for (int i = 2; i < len; i++) {
          _assert(function[i-1][0]);
          _assert(function[i][0]);
        }

        System.out.println("Check rectangular matrix");
        // Check that we have a rectangular matrix
        for (int i = 1; i < function.length; i++) {
          _assert(function[i-1].length);
          _assert(function[i].length);
        }
    }
    public static void _assert(int a) {
        System.out.println(a);
    }
    public static void _assert(double a) {
        System.out.println(a);
    }
}
