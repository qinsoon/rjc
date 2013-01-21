package org.rjava.test;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class RJavaInt {
    int n;
    
    public RJavaInt(int i) {
        this.n = i;
    }
    
    public int f() {
        return fact(n);
    }
    
    int fact(int n) {
        return n > 2 ? n * fact(n - 1) : 0;
    }
    
    public static void main(String[] args) {
        RJavaInt t = new RJavaInt(10);
        int f = t.f();
        System.out.println("Result: " + f);
    }
}
