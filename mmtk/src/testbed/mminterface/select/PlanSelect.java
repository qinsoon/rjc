package testbed.mminterface.select;

import org.mmtk.plan.marksweep.MS;

public class PlanSelect extends MS {
    private static PlanSelect plan;
    
    private PlanSelect() {}
    
    public static void initPlan() {
        plan = new PlanSelect();
    }
    
    public static String getName() {
        return "org.mmtk.plan.marksweep.MS";
    }
    
    public static PlanSelect getPlan() {
        return plan;
    }
}
