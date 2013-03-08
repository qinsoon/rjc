package java.io;

import java.lang.C;
import java.lang.Object;
import java.lang.String;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class PrintStream {
    public void println(String str) {
        print(str);
        println();
    }
    
    public void println() {
        C.printf("\n");
    }
    
    public void println(int i) {
        print(i);
        println();
    }
    
    public void println(Object obj) {
        String str = obj.toString();
        println(str);
    }
    
    public void print(String str) {
        C.printf("%s", str.internal);
    }
    
    public void print(char c) {
        C.printf("%c", c);
    }
    
    public void print(int i) {
        C.printf("%" + C.PRId32, i);
    }
}
