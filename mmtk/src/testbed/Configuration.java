package testbed;

import org.mmtk.plan.Plan;
import org.mmtk.plan.PlanConstraints;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmutil.options.OptionSet;

@RJavaCore
public abstract class Configuration {
    /* true if build for 64bits address, otherwise 32 bits */
    public static final boolean BUILD_FOR_64_ADDRESS = false;
    
    /* arch */
    public static final boolean BUILD_FOR_IA32 = true;
    
    /* os */
    public static final int MACH_OS = 0;
    /* chosen os */
    public static final int OS = MACH_OS;

    /* MMTk verbose */
    public static final int GC_VERBOSE = 0;
    
    /* Mutator threads */
    public static final int MUTATOR_COUNT = 2;
}
