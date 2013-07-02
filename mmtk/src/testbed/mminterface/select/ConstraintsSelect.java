package testbed.mminterface.select;

import org.mmtk.plan.marksweep.MSConstraints;

public class ConstraintsSelect extends MSConstraints {
    private static final ConstraintsSelect constraints = new ConstraintsSelect();
    
    private ConstraintsSelect() {}
    
    public static ConstraintsSelect getConstraints() {
        return constraints;
    }
}
