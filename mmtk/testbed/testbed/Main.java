package testbed;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class Main {
    public static final boolean DEBUG = true;

    public static void main(String[] args) {

    }
    
    public static void warn(String message) {
        System.out.println("Warning" + message);
    }
    
    public static void _assert(boolean expect, String message) {
        if (!expect)
            sysFail(message);
    }

    public static void sysFail(String message) {
        System.out.println("Fail: " + message);
        System.exit(1);
    }
}
