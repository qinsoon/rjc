package testbed;

import org.mmtk.plan.Plan;
import org.mmtk.plan.PlanConstraints;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmutil.options.OptionSet;

@RJavaCore
public abstract class Configuration {
    public static final boolean BUILD_FOR_64_ADDRESS = true;
    public static final boolean BUILD_FOR_IA32 = true;
}
