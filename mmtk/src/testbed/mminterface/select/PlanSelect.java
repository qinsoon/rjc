package testbed.mminterface.select;

import org.mmtk.plan.marksweep.MS;

public class PlanSelect extends MS {
    private static final PlanSelect plan = new PlanSelect();
    
    private PlanSelect() {}
    
    public static String getName() {
        return "org.mmtk.plan.marksweep.MS";
    }
    
    public static PlanSelect getPlan() {
        return plan;
    }
}
