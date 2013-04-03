package testbed.mminterface;

import org.rjava.restriction.rulesets.RJavaCore;

import testbed.Configuration;
import testbed.Constants;

@RJavaCore
public class MMTkConstants {
    public static final int GC_HEADER_BYTES() {
        return Configuration.activeConstraints.gcHeaderWords() << Constants.LOG_BYTES_IN_WORD;
    }
}
