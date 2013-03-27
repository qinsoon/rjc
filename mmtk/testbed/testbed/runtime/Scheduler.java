package testbed.runtime;

import org.rjava.restriction.rulesets.RJavaCore;

import testbed.mminterface.MMTkContext;

@RJavaCore
public class Scheduler {
    
    public static void startMMTkContext(MMTkContext context) {
        context.setRunning(true);
    }
    
    public static void stopCurrentContext() {
        MMTkContext.currentContext.setRunning(false);
    }
    
    public static void stopAllMutators() {
        for (int i = 0; i < MMTkContext.contextCount; i++) {
            if (MMTkContext.allContexts[i].isMutator())
                MMTkContext.allContexts[i].setRunning(false);
        }
    }
    
    public static void resumeAllMutators() {
        for (int i = 0; i < MMTkContext.contextCount; i++) {
            if (MMTkContext.allContexts[i].isMutator())
                MMTkContext.allContexts[i].setRunning(true);
        }
    }
}
