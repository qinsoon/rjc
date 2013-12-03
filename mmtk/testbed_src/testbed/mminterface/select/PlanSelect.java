package testbed.mminterface.select;

import org.mmtk.plan.marksweep.MS;
import org.mmtk.plan.semispace.SS;
import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.pragma.Inline;

@RJavaCore
public class PlanSelect extends SS {
//public class PlanSelect extends MS {
    private static PlanSelect plan;
    
    private PlanSelect() {}
    
    public static void initPlan() {
        plan = new PlanSelect();
    }
    
    public static String getName() {
        return "org.mmtk.plan.marksweep.MS";
    }
    
    @Inline
    public static PlanSelect getPlan() {
        return plan;
    }
}
