package testbed;

import org.mmtk.plan.Plan;
import org.mmtk.plan.PlanConstraints;
import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public abstract class Configuration {
    public static final String activePlanName = "org.mmtk.plan.nogc.NoGC";
    public static final Plan activePlan = new org.mmtk.plan.nogc.NoGC();
    public static final PlanConstraints activeConstraints = new org.mmtk.plan.nogc.NoGCConstraints();

    public static final boolean BUILD_FOR_64_ADDRESS = true;
    public static final boolean BUILD_FOR_IA32 = true;
    
    // used by BuildTimeConfigExt
    public static final TestbedProperty properties = new TestbedProperty();
    static {
        
    }
    public static class TestbedProperty {
        final int MAX = 100;
        int size = 0;
        String[] keys = new String[MAX];
        String[] values = new String[MAX];
        
        public boolean contains(String key) {
            return get(key) == null;
        }
        
        public void put(String key, String value) {
            if (contains(key))
                return;
            
            keys[size] = key;
            values[size] = value;
            size++;
        }
        
        public String get(String key) {
            for (int i = 0; i < size; i++)
                if (keys[i].equals(key))
                    return values[i];
            return null;
        }
    }
}
