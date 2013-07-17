package testbed.runtime;

import org.rjava.nativeext.RawConcurrency;
import org.rjava.restriction.rulesets.RJavaCore;

import testbed.Main;
import testbed.mminterface.MMTkContext;

@RJavaCore
public class Scheduler {
    private static final int MAX_THREADS = 10;    
    private static int threadCount = 0;
    
    public static int collectorCount = 0;
    public static MMTkContext[] collectorContexts = new MMTkContext[MAX_THREADS];
    
    public static int mutatorCount = 0;
    public static MMTkContext[] mutatorContexts = new MMTkContext[MAX_THREADS];
    
    private static Object newThreadLock = new Object();
    public static void newMutatorThread(MMTkContext mutator) {
        Thread t = newThread(mutator);
        
        synchronized(newThreadLock) {
            mutator.setThread(t);
            mutatorContexts[mutatorCount] = mutator;
            mutatorCount++;
        }
        
        t.start();
    }
    
    public static void newCollectorThread(MMTkContext collector) {
        Thread t = newThread(collector);
        
        synchronized(newThreadLock) {
            collector.setThread(t);
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
            if (mutatorContexts[i].getThread().getId() == current.getId())
                return mutatorContexts[i];
        for (int i = 0; i < collectorCount; i++)
            if (collectorContexts[i].getThread().getId() == current.getId())
                return collectorContexts[i];        
        
        Main.sysFail("Failed to find current context, current thread: " + current.getName());
        return null;
    }
    
    public static long totalObjectAlloced = 0;
    public static long objectAllocedSinceLastGC = 0;
    public static int gcTime = 1;
    
    public static int gcState;
    public static final int MUTATOR = 0;
    public static final int WAITING_FOR_TRIGGERING_MUTATOR = 1;
    public static final int STOPPING_MUTATORS = 2;
    public static final int GC = 3;
    
    public static final Object gcStateChangeLock = new Object();
    public static final Object blockingMutatorLock = new Object();
    
    public static void stopAllMutators() {
        synchronized (gcStateChangeLock) {
            if (gcState != STOPPING_MUTATORS) {
                gcState = WAITING_FOR_TRIGGERING_MUTATOR;
                // wait here
                try {
                    gcStateChangeLock.wait();
                } catch (InterruptedException ignore) {}
            }
            
            gcState = STOPPING_MUTATORS;
        }
        
        // stop all mutators
        for (int i = 0; i < mutatorCount; i++) {
            MMTkContext context = mutatorContexts[i];
            totalObjectAlloced += context.objectAllocedSinceLastGC;
            objectAllocedSinceLastGC += context.objectAllocedSinceLastGC;
            
            // stop mutators here
            // the thread(mutator) which triggers this GC will block itself in currentThreadBlockForGC()
            // the other threads will be suspended
            
            if (context.shouldSuspendThisContext()) {
                RawConcurrency.threadSuspend(context.getThread());
                context.informSuspend();
            } else {
                // until the thread that triggers the GC to be blocked
                while(context.getGCState() != MMTkContext.BLOCK) {
                    Thread.yield();
                }
            }
        }
        
        synchronized (gcStateChangeLock) {
            gcState = GC;
        }
    }
    
    public static void resumeAllMutators() {
        synchronized (gcStateChangeLock) {
            gcState = MUTATOR;
        }
        
        // resume mutators here
        for (int i = 0; i < mutatorCount; i++) {
            MMTkContext context = mutatorContexts[i];
            context.objectAllocedSinceLastGC = 0;
            
            // if a mutator is suspended, we use the same mechanism to resume it
            if (context.getGCState() == MMTkContext.SUSPEND) {
                context.informResume();
                RawConcurrency.threadResume(context.getThread());
            }
            // if the mutator is blocked, we unblock it
            else if (context.getGCState() == MMTkContext.BLOCK)
                context.unblockAfterGC();
            else Main._assert(false, "Unexpected MMTkContext gc state: " + context.getGCState());
        }
        
        Main.println("[DEBUG]GC" + gcTime + ", total objects allocated:" + totalObjectAlloced + ",objects allocated since last GC:" + objectAllocedSinceLastGC);
        gcTime ++;
        objectAllocedSinceLastGC = 0;
    }

    public static void currentThreadBlockForGC() {
        synchronized (gcStateChangeLock) {
            if (gcState == WAITING_FOR_TRIGGERING_MUTATOR) {
                getCurrentContext().informGoingToBlock();
                gcStateChangeLock.notify();
            }
            gcState = STOPPING_MUTATORS;
        }
        
        getCurrentContext().blockForGC();
    }
}
