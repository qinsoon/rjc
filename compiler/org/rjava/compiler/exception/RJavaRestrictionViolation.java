package org.rjava.compiler.exception;

import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RRestriction;
import org.rjava.compiler.semantics.representation.RStatement;

public class RJavaRestrictionViolation extends Exception {
    RStatement stmt;
    RMethod method;
    RClass klass;
    String restriction;
    
    private RJavaRestrictionViolation(String message, RClass klass) {
        super(message);
        this.klass = klass;
    }
    
    private RJavaRestrictionViolation(String message, RStatement stmt) {
        super(message);
        this.stmt = stmt;
        this.method = stmt.getMethod();
        this.klass = stmt.getMethod().getKlass();
    }
    
    public static final RJavaRestrictionViolation newRestrictionViolation(String restriction, RStatement stmt) {
        String s = restriction + " failed in method " + stmt.getMethod().getKlass().getName() + "." + stmt.getMethod().getName() + "()"
                + "(line:" +stmt.getLineStart() + ",stmt: " + stmt.toString() +  ")";
        return new RJavaRestrictionViolation(s, stmt);
    }
    
    public static final RJavaRestrictionViolation newRestrictionViolation(String restriction, RClass klass) {
        String s = restriction + " failed in class " + klass.getName();
        return new RJavaRestrictionViolation(s, klass);
    }
}
