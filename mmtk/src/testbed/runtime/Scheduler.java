package testbed.runtime;

import org.rjava.restriction.rulesets.RJavaCore;

import testbed.Main;
import testbed.mminterface.MMTkContext;

@RJavaCore
public class Scheduler {
    private static final int MAX_THREADS = 10;    
    private static int threadCount = 0;
    
    public static int collectorCount = 0;
    public static Thread[] collectorThreads = new Thread[MAX_THREADS];
    public static MMTkContext[] collectorContexts = new MMTkContext[MAX_THREADS];
    
    public static int mutatorCount = 0;
    public static Thread[] mutatorThreads = new Thread[MAX_THREADS];
    public static MMTkContext[] mutatorContexts = new MMTkContext[MAX_THREADS];
    
    private static Object newThreadLock = new Object();
    public static void newMutatorThread(MMTkContext mutator) {
        Thread t = newThread(mutator);
        
        synchronized(newThreadLock) {
            mutatorThreads[mutatorCount] = t;
            mutatorContexts[mutatorCount] = mutator;
            mutatorCount++;
        }
        
        t.start();
    }
    
    public static void newCollectorThread(MMTkContext collector) {
        Thread t = newThread(collector);
        
        synchronized(newThreadLock) {
            collectorThreads[collectorCount] = t;
            collectorContexts[collectorCount] = collector;
            collectorCount++;
        }
        
        t.start();
    }
    
    private static Thread newThread(MMTkContext context) {
        Thread t = new Thread(context);
        Main._assert(collectorCount + mutatorCount < MAX_THREADS, "creating collector when max thread is reached");
        threadCount++;
        return t;
    }
    
    public static Thread getCurrentThread() {
        return Thread.currentThread();
    }
    
    public static MMTkContext getCurrentContext() {
        Thread current = getCurrentThread();
        
        for (int i = 0; i < mutatorCount; i++)
            if (mutatorThreads[i].getId() == current.getId())
                return mutatorContexts[i];
        for (int i = 0; i < collectorCount; i++)
            if (collectorThreads[i].getId() == current.getId())
                return collectorContexts[i];        
        
        Main.sysFail("Failed to find current context, current thread: " + current.getName());
        return null;
    }

    public static Object gcLock = new Object();
    public static boolean gcTriggering = false;
    public static void stopAllMutators() {
        synchronized(gcLock) {
            Main._assert(gcTriggering == false, "gcTriggering is already true when trying to set it to true again");
            gcTriggering = true;
        }
    }
    
    public static void resumeAllMutators() {
        synchronized(gcLock) {
            Main._assert(gcTriggering == true, "gcTriggering is false when trying to set it to false");
            gcTriggering = false;
        }
        
        // notify mutators
        for (int i = 0; i < mutatorCount; i++) {
            mutatorContexts[i].notify();
        }
    }
}
