package org.rjava.restriction.rules;

import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;

public class NoException_CHECK {
    public static Boolean checkClass (RClass klass) {
	return true;
    }
}
