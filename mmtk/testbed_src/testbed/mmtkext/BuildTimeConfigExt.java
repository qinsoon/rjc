package testbed.mmtkext;
import org.mmtk.plan.Plan;
import org.mmtk.vm.BuildTimeConfig;
import org.rjava.restriction.rulesets.RJavaCore;

import testbed.Configuration;
import testbed.mminterface.select.PlanSelect;


@RJavaCore
public class BuildTimeConfigExt extends BuildTimeConfig {
    // used by BuildTimeConfigExt
    public static final TestbedProperty properties = new TestbedProperty();
    static {
        properties.put("mmtk.headerMarkBit", "true");
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

    @Override
    public String getPlanName() {
        return PlanSelect.getName();
    }

    @Override
    public String getStringProperty(String name) {
        return properties.get(name);
    }

    @Override
    public String getStringProperty(String name, String dflt) {
        String ret = getStringProperty(name);
        if (ret == null)
            return dflt;
        else return ret;
    }

    @Override
    public int getIntProperty(String name) {
        return Integer.parseInt(properties.get(name));
    }

    @Override
    public int getIntProperty(String name, int dflt) {
        String get = properties.get(name);
        if (get == null)
            return dflt;
        else return Integer.parseInt(get);
    }

    @Override
    public boolean getBooleanProperty(String name) {
        return Boolean.parseBoolean(properties.get(name));
    }

    @Override
    public boolean getBooleanProperty(String name, boolean dflt) {
        String get = properties.get(name);
        if (get == null)
            return dflt;
        else return Boolean.parseBoolean(get);
    }

}
