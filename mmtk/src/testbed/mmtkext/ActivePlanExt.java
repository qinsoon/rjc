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
import testbed.mminterface.select.ConstraintsSelect;
import testbed.mminterface.select.PlanSelect;
import testbed.runtime.Scheduler;

@RJavaCore
public class ActivePlanExt extends ActivePlan {
    @Override
    public Plan global() {
        return PlanSelect.getPlan();
    }

    @Override
    public PlanConstraints constraints() {
        return ConstraintsSelect.getConstraints();
    }

    @Override
    public CollectorContext collector() {
        return Scheduler.getCurrentContext().collector();
    }

    @Override
    public boolean isMutator() {
        return !Scheduler.getCurrentContext().isCollector();
    }

    @Override
    public MutatorContext mutator() {
        return Scheduler.getCurrentContext().mutator();
    }

    @Override
    public Log log() {
        return Scheduler.getCurrentContext().mutator().getLog();
    }

    @Override
    public int collectorCount() {
        return Scheduler.collectorCount;
    }

    int mutatorIdCursor = 0;
    
    @Override
    public void resetMutatorIterator() {
        mutatorIdCursor = 0;
    }

    @Override
    public MutatorContext getNextMutator() {
        for (int i = mutatorIdCursor; i < Scheduler.mutatorCount; i++)
            if (Scheduler.mutatorContexts[i] != null) {
                mutatorIdCursor++;
                return Scheduler.mutatorContexts[i].mutator();
            }
        
        return null;
    }

}
