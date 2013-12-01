package org.rjava.compiler.util;

import java.util.HashMap;
import java.util.Map;

import org.rjava.compiler.RJavaCompiler;

public class Statistics {
    public static final boolean ENABLE = true;
    
    public static final String VIRTUAL_CALL_COUNT = "virtual call sites";
    
    public static final String TOTAL_ASSIGNMENT = "total assignment";
    public static final String LOCAL_REASSIGN = "local reassign";
    public static final String INSTANCE_FIELD_REASSIGN = "local field reassign";
    public static final String STATIC_FIELD_REASSIGN = "static field reassign";
    public static final String ARRAY_REF_REASSIGN = "array ref reassign";
    
    public static final String TYPE_FOUND = "type found";
    public static final String TYPE_NOT_FOUND = "type not found";
    
    public static final Map<Object, Long> counters = new HashMap<Object, Long>();
    
    public static final void report() {
        RJavaCompiler.println("RJava Compiler statistics. \ncounters:");
        for (Object o : counters.keySet()) {
            RJavaCompiler.println(o + ": " + counters.get(o));
        }
    }
    
    public static final void increaseCounter(Object counter, long increase) {
        if (!counters.containsKey(counter)) {
            counters.put(counter, increase);
            return;
        }
        
        long l = counters.get(counter);
        counters.put(counter, l + increase);
    }
    
    public static final void increaseCounterByOne(Object counter) {
        increaseCounter(counter, 1);
    }
    
    public static final void setCounter(Object counter, long count) {
        counters.put(counter, count);
    }
    
    public static final long getCounter(Object counter) {
        return counters.get(counter);
    }
}
