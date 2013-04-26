package testbed.mminterface.select;

import org.mmtk.plan.nogc.NoGC;

public class PlanSelect extends NoGC {
    private static final PlanSelect plan = new PlanSelect();
    
    private PlanSelect() {}
    
    public static String getName() {
        return "org.mmtk.plan.nogc.NoGC";
    }
    
    public static PlanSelect getPlan() {
        return plan;
    }
}
