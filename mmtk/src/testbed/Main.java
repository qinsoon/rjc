package testbed;

import org.rjava.restriction.rulesets.RJavaCore;
import org.vmmagic.unboxed.Address;
import org.vmmagic.unboxed.Extent;
import org.vmmagic.unboxed.ObjectReference;
import org.vmmagic.unboxed.Offset;
import org.vmmagic.unboxed.Word;

import testbed.mminterface.select.PlanSelect;

@RJavaCore
public class Main {
    public static final boolean DEBUG = true;

    public static void main(String[] args) {
        print("[BOOT]...\n");
        PlanSelect.initPlan();
        TestbedRuntime.boot();
        print("DONE.\n");
        
        print("[RUN]...\n");
        TestbedRuntime.start();
    }
    
    public static void print(Address addr) {
        System.out.print(Integer.toHexString(addr.toInt()));
    }    
    public static void println(Address addr) {
        System.out.println(Integer.toHexString(addr.toInt()));
    }    
    public static void print(Extent ext) {
        System.out.print(Integer.toHexString(ext.toInt()));
    }
    public static void println(Extent ext) {
        System.out.println(Integer.toHexString(ext.toInt()));
    }
    public static void print(Offset offset) {
        System.out.print(offset.toInt());
    }
    public static void println(Offset offset) {
        System.out.println(offset.toInt());
    }
    public static void print(ObjectReference objRef) {
        System.out.print(Integer.toHexString(objRef.toAddress().toInt()));
    }
    public static void println(ObjectReference objRef) {
        System.out.println(Integer.toHexString(objRef.toAddress().toInt()));
    }
    public static void print(Word word) {
        System.out.print(Integer.toHexString(word.toInt()));
    }
    public static void println(Word word) {
        System.out.println(Integer.toHexString(word.toInt()));    
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
