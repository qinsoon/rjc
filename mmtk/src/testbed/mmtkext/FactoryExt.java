package testbed.mmtkext;

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

import testbed.Configuration;

public class FactoryExt extends Factory {

    @Override
    public OptionSet getOptionSet() {
        return Configuration.gcOptions;
    }

    @Override
    public ActivePlan newActivePlan() {
        return new ActivePlanExt();
    }

    @Override
    public Assert newAssert() {
        return new AssertExt();
    }

    @Override
    public Barriers newBarriers() {
        return new BarriersExt();
    }

    @Override
    public Collection newCollection() {
        return new CollectionExt();
    }

    @Override
    public BuildTimeConfig newBuildTimeConfig() {
        return new BuildTimeConfigExt();
    }

    @Override
    public Lock newLock(String name) {
        return new LockExt();
    }

    @Override
    public Monitor newMonitor(String name) {
        return new MonitorExt();
    }

    @Override
    public Memory newMemory() {
        return new MemoryExt();
    }

    @Override
    public ObjectModel newObjectModel() {
        return new ObjectModelExt();
    }

    @Override
    public ReferenceProcessor newReferenceProcessor(int semantics) {
        return new ReferenceProcessorExt();
    }

    @Override
    public FinalizableProcessor newFinalizableProcessor() {
        return new FinalizableProcessorExt();
    }

    @Override
    public Scanning newScanning() {
        return new ScanningExt();
    }

    @Override
    public Statistics newStatistics() {
        return new StatisticsExt();
    }

    @Override
    public Strings newStrings() {
        return new StringsExt();
    }

    @Override
    public SynchronizedCounter newSynchronizedCounter() {
        return new SynchronizedCounterExt();
    }

    @Override
    public TraceInterface newTraceInterface() {
        return new TraceInterfaceExt();
    }

    @Override
    public MMTk_Events newEvents() {
        return new MMTk_EventsExt();
    }

    @Override
    public Debug newDebug() {
        return new DebugExt();
    }

}
