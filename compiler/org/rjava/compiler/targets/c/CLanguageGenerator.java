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
	try {
	    System.out.println("  Translating " + source + "...");
	    // Create an input character stream from source file
	    ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(source));
	    // Create a lexer that feeds from that stream
	    RJavaToCLexer lexer = new RJavaToCLexer(input);
	    // Create a stream fo tokens fed by the lexer
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    // Create a parser that feeds off the token stream
	    RJavaToCParser parser = new RJavaToCParser(tokens);
	    // Begin parsing at rule 'compilationUnit'
	    parser.compilationUnit();
	} catch (FileNotFoundException e) {
	    throw new RJavaError("Couldn't find source: " + source);
	} catch (IOException e) {
	    throw new RJavaError("File IO Exception: " + e.getMessage());
	} catch (RecognitionException e) {
	    throw new RJavaError("RecognitionException: " + e.getMessage());
	}
    }
}
