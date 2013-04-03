package org.mmtk.utility.statistics;

public abstract class Phase {
    public static final int MUTATOR = 0;    // mu
    public static final int GC = 1;         // gc
    public static final int COMBINED = 2;   // all
    
    public static final String getName(int phase) {
        switch (phase) {
        case MUTATOR:   return "mu";
        case GC:        return "gc";
        case COMBINED:  return "all";
        default:        return null;
        }
    }
}
