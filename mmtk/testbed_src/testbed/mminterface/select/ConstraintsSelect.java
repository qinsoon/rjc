package testbed.mminterface.select;

//import org.mmtk.plan.marksweep.MSConstraints;
import org.mmtk.plan.semispace.SSConstraints;
import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class ConstraintsSelect extends SSConstraints {
//public class ConstraintsSelect extends MSConstraints {
    private static final ConstraintsSelect constraints = new ConstraintsSelect();
    
    private ConstraintsSelect() {}
    
    public static ConstraintsSelect getConstraints() {
        return constraints;
    }
}
