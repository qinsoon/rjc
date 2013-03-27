package testbed.mmtkext;
import org.mmtk.vm.BuildTimeConfig;
import org.rjava.restriction.rulesets.RJavaCore;

import testbed.Configuration;


@RJavaCore
public class BuildTimeConfigExt extends BuildTimeConfig {

    @Override
    public String getPlanName() {
        return Configuration.activePlanName;
    }

    @Override
    public String getStringProperty(String name) {
        return Configuration.properties.get(name);
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
        return Integer.parseInt(Configuration.properties.get(name));
    }

    @Override
    public int getIntProperty(String name, int dflt) {
        String get = Configuration.properties.get(name);
        if (get == null)
            return dflt;
        else return Integer.parseInt(get);
    }

    @Override
    public boolean getBooleanProperty(String name) {
        return Boolean.parseBoolean(Configuration.properties.get(name));
    }

    @Override
    public boolean getBooleanProperty(String name, boolean dflt) {
        String get = Configuration.properties.get(name);
        if (get == null)
            return dflt;
        else return Boolean.parseBoolean(get);
    }

}
