package testbed;

import java.util.HashMap;
import java.util.Map;

import org.mmtk.plan.Plan;
import org.mmtk.plan.PlanConstraints;
import org.mmtk.plan.nogc.NoGC;
import org.mmtk.plan.nogc.NoGCConstraints;
import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class Configuration {
    public static final String activePlanName = "org.mmtk.plan.nogc.NoGC";
    public static final Plan activePlan = new org.mmtk.plan.nogc.NoGC();
    public static final PlanConstraints activeConstraints = new org.mmtk.plan.nogc.NoGCConstraints();

    // used by BuildTimeConfigExt
    public static final Map<String, String> properties = new HashMap<String, String>();
    static {
        
    }
}
