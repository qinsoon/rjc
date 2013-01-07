package org.rjava.restriction.rules;

import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;

public class NoDynamicLoading_CHECK {
    public static Boolean checkClass (RClass klass, SemanticMap semantics) {
	for (RMethod method : klass.getMethods()) {
	    System.out.println("Method " + method.getName() + "{");
	    for (RStatement statement : method.getBody()) {
		System.out.println(statement);
		if (statement.getType() == RStatement.INVOKE_STMT) {
		    
		}
	    }
	    System.out.println("}");
	}
	
	return true;
    }
}
