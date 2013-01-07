package org.rjava.compiler.exception;

import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RRestriction;
import org.rjava.compiler.semantics.representation.RStatement;

public class RJavaRestrictionViolation extends Exception {
    public RJavaRestrictionViolation(String s) {
	super(s);
    }
    
    public RJavaRestrictionViolation(RStatement stmt, RClass klass, RRestriction rule) {
	
    }
}
