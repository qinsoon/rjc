package testbed.mmtkext;

import org.mmtk.plan.CollectorContext;
import org.mmtk.plan.MutatorContext;
import org.mmtk.plan.Plan;
import org.mmtk.plan.PlanConstraints;
import org.mmtk.utility.Log;
import org.mmtk.vm.ActivePlan;
import org.rjava.restriction.rulesets.RJavaCore;

import testbed.Configuration;
import testbed.Main;
import testbed.mminterface.MMTkContext;

@RJavaCore
public class ActivePlanExt extends ActivePlan {
    @Override
    public Plan global() {
        return Plan.activePlan;
    }

    @Override
    public PlanConstraints constraints() {
        return PlanConstraints.activeConstraints;
    }

    @Override
    public CollectorContext collector() {
        return MMTkContext.currentContext.collector();
    }

    @Override
    public boolean isMutator() {
        return MMTkContext.currentContext.isMutator();
    }

    @Override
    public MutatorContext mutator() {
        return MMTkContext.currentContext.mutator();
    }

    @Override
    public Log log() {
        return MMTkContext.currentContext.mutator().getLog();
    }

    @Override
    public int collectorCount() {
        int sum = 0;
        for (MMTkContext context : MMTkContext.allContexts)
            if (context.isCollector())
                sum ++;
        
        return sum;
    }

    MMTkContext mutatorIterator;
    
    @Override
    public void resetMutatorIterator() {
        mutatorIterator = null;
        for (int i = 0; i < MMTkContext.allContexts.length; i++) {
            MMTkContext currentContext = MMTkContext.allContexts[i];
            if (currentContext.isMutator())
                mutatorIterator = currentContext;
        }
        
        Main._assert(mutatorIterator != null, "failed to reset mutator iterator");
    }

    @Override
    public MutatorContext getNextMutator() {
        Main._assert(mutatorIterator != null, 
                "mutator iterator is null when trying to get next mutator");
        
        int currentSlot = mutatorIterator.getSlot();
        for (int i = currentSlot + 1; i < MMTkContext.MAX_CONTEXT; i++) {
            if (MMTkContext.allContexts[i].isMutator())
                return MMTkContext.allContexts[i].mutator();
        }
        
        return null;
    }

}
