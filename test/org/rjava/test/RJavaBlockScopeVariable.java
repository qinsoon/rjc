package org.rjava.test;

public class RJavaBlockScopeVariable {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 5; i++)
            sum += i;
        for (int i = 5; i < 10; i++)
            sum += i;
    }

}
