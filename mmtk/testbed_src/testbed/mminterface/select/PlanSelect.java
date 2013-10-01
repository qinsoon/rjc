package testbed.mminterface.select;

import org.mmtk.plan.semispace.SS;
import org.vmmagic.pragma.Inline;

public class PlanSelect extends SS {
    private static PlanSelect plan;
    
    private PlanSelect() {}
    
    public static void initPlan() {
        plan = new PlanSelect();
    }
    
    public static String getName() {
        return "org.mmtk.plan.semispace.SS";
    }
    
    @Inline
    public static PlanSelect getPlan() {
        return plan;
    }
}
