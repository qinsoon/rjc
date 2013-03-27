package testbed.mmtkext;

import org.mmtk.vm.Debug;
import org.rjava.restriction.rulesets.RJavaCore;

import testbed.Main;

@RJavaCore
public class DebugExt extends Debug {

    @Override
    public boolean isEnabled() {
        return Main.DEBUG;
    }

}
