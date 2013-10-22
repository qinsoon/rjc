package org.rjava.test.opt.constantpropagation;

public class Test {
    public static int A = 1;
    public static int B;
    public static int G = (Foo.CONSTANT == 100 ? 999 : 100);
    
    public static void main(String[] args) {
        B = A + 1;
        int C = B * 2;
        int D = Foo.CONSTANT + 5;
        int F;
        if (Foo.CONSTANT == 100)
            F = 10;
        else F = 5;
    }

    public static void foo() {
        int E = B + 2;
    }
}
