package org.rjava.restriction.rules;

import java.io.FileInputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;

public class NoDynamicLoading_CHECK {
    public static Boolean checkClass (RClass klass, SemanticMap semantics) {

	return true;
    }
}
