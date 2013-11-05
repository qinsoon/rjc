package org.rjava.restriction.rules;

import org.rjava.compiler.exception.RJavaRestrictionViolation;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.restriction.StaticRestrictionChecker;

import soot.Value;
import soot.jimple.InvokeExpr;
import soot.jimple.internal.JSpecialInvokeExpr;
import soot.jimple.internal.JStaticInvokeExpr;
import soot.jimple.internal.JVirtualInvokeExpr;

public class NoDynamicLoading_CHECK {
    public static final String CLASS_FORNAME = "<java.lang.Class: java.lang.Class forName(java.lang.String)>";
    public static final String CLASSLOADER_LOADCLASS = "<java.lang.ClassLoader: java.lang.Class loadClass(java.lang.String)>";
    
    public static Boolean checkClass (RClass klass) throws RJavaRestrictionViolation {
    	boolean pass = true;
    	for (RMethod method : klass.getMethods()) {
    	    for (RStatement statement : method.getBody()) {
    		if (statement.internal().containsInvokeExpr()) {
    		    InvokeExpr invoke = statement.internal().getInvokeExpr();
    		    if (invoke instanceof JStaticInvokeExpr) {
    			// check if the invoke is Class.forName(String);
    			JStaticInvokeExpr staticInvoke = (JStaticInvokeExpr) invoke;
    			if (staticInvoke.getMethodRef().getSignature().equals(CLASS_FORNAME)) {
    			    StaticRestrictionChecker.addRestrictionViolation(RJavaRestrictionViolation.newRestrictionViolation("NoDynamicLoading", statement));
    			    pass = false;
    			}
    		    } else if (invoke instanceof JVirtualInvokeExpr) {
    			// check if the invoke is aClassLoader.loadClass(String); or laodClass(String, boolean);
    			JVirtualInvokeExpr virtualInvoke = (JVirtualInvokeExpr) invoke;
    			if (virtualInvoke.getBase().getType().toString().equals("java.lang.ClassLoader") && virtualInvoke.getMethodRef().getSignature().equals(CLASSLOADER_LOADCLASS)) {
    			    StaticRestrictionChecker.addRestrictionViolation(RJavaRestrictionViolation.newRestrictionViolation("NoDynamicLoading", statement));
    			    pass = false;
    			}
    		    }
    		}
    	}
	}
	
	return pass;
    }
}
