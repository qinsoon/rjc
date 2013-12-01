package testbed.mmtkext;

import org.mmtk.vm.Assert;
import org.rjava.restriction.rulesets.RJavaCore;

import testbed.Main;
import testbed.runtime.Stack;

@RJavaCore
public class AssertExt extends Assert {

    @Override
    public void fail(String message) {
        Main.sysFail(message);
    }

    @Override
    public void _assert(boolean cond) {
        if (!cond)
            fail("assertion failed");
    }

    @Override
    public void _assert(boolean cond, String message) {
        Main._assert(cond, message);
    }

    @Override
    public void dumpStack() {
        Stack.dump();
    }

    @Override
    protected boolean getVerifyAssertionsConstant() {
        return Main.DEBUG;
    }

}
