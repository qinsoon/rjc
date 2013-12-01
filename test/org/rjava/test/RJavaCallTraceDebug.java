package org.rjava.test;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class RJavaCallTraceDebug {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        foo(b);
    }

    public static void foo(int i) {
        int c = i + 1;
        problem();
        int d = c + 1;
    }
    
    public static void problem() {
        int b = 10 / 0;
        System.out.println(b);
    }
}
