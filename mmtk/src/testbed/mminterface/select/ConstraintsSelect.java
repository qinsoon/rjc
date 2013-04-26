package testbed.mminterface.select;

import org.mmtk.plan.nogc.NoGCConstraints;

public class ConstraintsSelect extends NoGCConstraints {
    private static final ConstraintsSelect constraints = new ConstraintsSelect();
    
    private ConstraintsSelect() {}
    
    public static ConstraintsSelect getConstraints() {
        return constraints;
    }
}
