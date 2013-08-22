package testbed.mminterface;

import org.mmtk.plan.PlanConstraints;
import org.rjava.restriction.rulesets.RJavaCore;

import testbed.Configuration;
import testbed.Constants;
import testbed.mminterface.select.ConstraintsSelect;

@RJavaCore
public class MMTkConstants {
    public static final int GC_HEADER_BYTES() {
        return ConstraintsSelect.getConstraints().gcHeaderWords() << Constants.LOG_BYTES_IN_WORD;
    }
}
