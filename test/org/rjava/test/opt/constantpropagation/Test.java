package org.rjava.test.opt.constantpropagation;

public class Test {
    public static int A1_C = 1;
    public static int B2_C;
    public static int G = (Foo.CONSTANT == 100 ? 999 : 100);
    
    public static void main(String[] args) {
        B2_C = A1_C + 1;
        int C4 = B2_C * 2;
        int D105_C = Foo.CONSTANT + 5;
        int F10;
        if (Foo.CONSTANT == 100)
            F10 = 10;
        else F10 = 5;
        int H110 = foo2(D105_C);
        int I1000 = foo3();
        
        int trash;
        for (int i = 0; i < 100; i++) {
            trash = Foo.CONSTANT + i;
        }
    }

    public static void foo() {
        int E4_C = B2_C + 2;
    }
    
    public static int foo2(int x) {
        return x + 5;
    }
    
    public static int foo3() {
        return 1000;
    }
}
