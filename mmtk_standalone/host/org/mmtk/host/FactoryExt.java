package org.mmtk.host;

import org.mmtk.vm.ActivePlan;
import org.mmtk.vm.Assert;
import org.mmtk.vm.Barriers;
import org.mmtk.vm.BuildTimeConfig;
import org.mmtk.vm.Collection;
import org.mmtk.vm.Debug;
import org.mmtk.vm.Factory;
import org.mmtk.vm.FinalizableProcessor;
import org.mmtk.vm.Lock;
import org.mmtk.vm.MMTk_Events;
import org.mmtk.vm.Memory;
import org.mmtk.vm.Monitor;
import org.mmtk.vm.ObjectModel;
import org.mmtk.vm.ReferenceProcessor;
import org.mmtk.vm.Scanning;
import org.mmtk.vm.Statistics;
import org.mmtk.vm.Strings;
import org.mmtk.vm.SynchronizedCounter;
import org.mmtk.vm.TraceInterface;
import org.vmutil.options.OptionSet;

public class FactoryExt extends Factory {

    @Override
    public OptionSet getOptionSet() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ActivePlan newActivePlan() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Assert newAssert() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Barriers newBarriers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection newCollection() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BuildTimeConfig newBuildTimeConfig() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Lock newLock(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Monitor newMonitor(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Memory newMemory() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ObjectModel newObjectModel() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ReferenceProcessor newReferenceProcessor(int semantics) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FinalizableProcessor newFinalizableProcessor() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scanning newScanning() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Statistics newStatistics() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Strings newStrings() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SynchronizedCounter newSynchronizedCounter() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TraceInterface newTraceInterface() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MMTk_Events newEvents() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Debug newDebug() {
        // TODO Auto-generated method stub
        return null;
    }

}
