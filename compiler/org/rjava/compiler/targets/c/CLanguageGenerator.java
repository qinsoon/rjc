package org.rjava.compiler.targets.c;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.rjava.compiler.exception.RJavaError;
import org.rjava.compiler.exception.RJavaWarning;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.targets.CodeGenerator;

public class CLanguageGenerator extends CodeGenerator {

    @Override
    public void translate(RClass klass, String source, SemanticMap semantics)
	    throws RJavaWarning, RJavaError {

    }
}
