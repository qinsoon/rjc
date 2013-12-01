package org.rjava.unittest.ext;

import org.rjava.unittest.UnitTest;
import org.vmmagic.pragma.Inline;

public class TestInline extends UnitTest {

    public static void main(String[] args) {
        start("Test static method inline");
        check(testStaticMethodInline());
        
        start("Test virtual method inline");
        check(testVirtualMethodInline());
        
        start("Test virtual method override inline");
        check(testVirtualMethodOverrideInline());
    }

    public static boolean testStaticMethodInline() {
        int sum = 0;
        for (int i = 0; i < 100; i++)
            sum+=i;
        
        return sum == staticInlineMethod();
    }
    
    public static boolean testVirtualMethodInline() {
        return new TestInline().virtualInlineMethod() == staticInlineMethod();
    }
    
    public static boolean testVirtualMethodOverrideInline() {
        return new TestInlineExt().virtualInlineMethod() == staticInlineMethod() + 1;
    }
    
    @Inline
    public static int staticInlineMethod() {
        int sum = 0;
        for (int i = 0; i < 100; i++)
            sum += i;
        
        return sum;
    }
    
    @Inline
    public int virtualInlineMethod() {
        int sum = 0;
        for (int i = 0; i < 100; i++)
            sum += i;
        
        return sum;
    }
    
    static class TestInlineExt extends TestInline {
        @Override
        @Inline
        public int virtualInlineMethod() {
            int sum = 1;
            for (int i = 0; i < 100; i++)
                sum += i;
            return sum;
        }
    }
}
