package org.rjava.restriction.rules;

import java.io.FileInputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.restriction.rules.check.NoDynamicLoadingANTLRLexer;
import org.rjava.restriction.rules.check.NoDynamicLoadingANTLRParser;

public class NoDynamicLoading_CHECK {
    public static Boolean checkClass (RClass klass, SemanticMap semantics) {
	try{
	    ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(semantics.getSources().get(klass.getName())));
	    NoDynamicLoadingANTLRLexer lexer = new NoDynamicLoadingANTLRLexer(input);
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    NoDynamicLoadingANTLRParser parser = new NoDynamicLoadingANTLRParser(tokens);
	    parser.compilationUnit();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return true;
    }
}
