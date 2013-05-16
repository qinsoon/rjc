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
        synchronized(newThreadLock) {
            Thread t = newThread(mutator);
            mutatorThreads[mutatorCount] = t;
            mutatorContexts[mutatorCount] = mutator;
            mutatorCount++;
        }
    }
    
    public static void newCollectorThread(MMTkContext collector) {
        synchronized(newThreadLock) {
            Thread t = newThread(collector);
            collectorThreads[collectorCount] = t;
            collectorContexts[collectorCount] = collector;
            collectorCount++;
        }
    }
    
    private static Thread newThread(MMTkContext context) {
        Thread t = new Thread(context);
        Main._assert(collectorCount + mutatorCount < MAX_THREADS, "creating collector when max thread is reached");
        threadCount++;
        t.start();
        return t;
    }
    
    public static Thread getCurrentThread() {
        return Thread.currentThread();
    }
    
    public static MMTkContext getCurrentContext() {
        Thread current = getCurrentThread();
        for (int i = 0; i < mutatorCount; i++)
            if (mutatorThreads[i].equals(current))
                return mutatorContexts[i];
        for (int i = 0; i < collectorCount; i++)
            if (collectorThreads[i].equals(current))
                return collectorContexts[i];
        
        return null;
    }

    public static Object gcLock = new Object();
    public static boolean gcTriggering = false;
    public static void stopAllMutators() {

    }
    
    public static void resumeAllMutators() {

    }
}
