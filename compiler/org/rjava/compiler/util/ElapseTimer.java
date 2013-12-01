package org.rjava.compiler.util;

import org.rjava.compiler.RJavaCompiler;

public class ElapseTimer {
    long start;
    long end;
    String name;
    
    boolean reportOnStartNEnd;
    
    public ElapseTimer(String name, boolean report) {
        this.name = name;
        this.reportOnStartNEnd = report;
    }
    
    public void start() {
        if (reportOnStartNEnd)
            RJavaCompiler.printImm(name + "...");
        
        start = System.currentTimeMillis();
    }
    
    public void end() {
        RJavaCompiler.assertion(start != 0, "Start this timer first");
        end = System.currentTimeMillis();
        
        if (reportOnStartNEnd)
            RJavaCompiler.printlnImm(" [" + read() + "ms]");
    }
    
    public long read() {
        RJavaCompiler.assertion(end != 0, "End this timer first");
        return end - start;
    }
    
    public String report() {
        return name + " [" + read() + "ms]";
    }
}
