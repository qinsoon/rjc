package org.rjava.test;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.pragma.Inline;

@RJavaCore
public class RJavaInline {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int i = 0;
        int sum = 0;
        while (i < 100) {
            sum += i;
            i = inc(i);
            superLongInlineMethod();
        }
    }

    @Inline
    public static int inc(int i) {
        return i + 1;
    }
    
    @Inline
    public static void superLongInlineMethod() {
        int sum = 0;
        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++)
                sum += i + j;
    }
}
