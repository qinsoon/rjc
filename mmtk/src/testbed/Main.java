package testbed;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class Main {
    public static final boolean DEBUG = true;

    public static void main(String[] args) {
        print("[BOOT]...\n");
        TestbedRuntime.boot();
        print("DONE.\n");
        
        print("[RUN]...\n");
        TestbedRuntime.run();
    }
    
    public static void println(Object message) {
        System.out.println(message);
    }
    
    public static void println() {
        System.out.println();
    }
    
    public static void print(Object message) {
        System.out.print(message);
    }
    
    public static void warn(Object message) {
        System.out.println("[Warning]" + message);
    }
    
    public static void _assert(boolean expect, String message) {
        if (!expect)
            sysFail(message);
    }

    public static void sysFail(String message) {
        System.out.println("Fail: " + message);
        Thread.dumpStack();
        System.exit(1);
    }
    
    public static void sysExit(int code) {
        System.exit(code);
    }
}
