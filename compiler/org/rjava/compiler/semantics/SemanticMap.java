package org.rjava.compiler.semantics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.rjava.compiler.CompilationTask;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.representation.*;
import org.rjava.compiler.semantics.symtab.RJavaSymbolTableLexer;
import org.rjava.compiler.semantics.symtab.RJavaSymbolTableParser;

import antlr.RecognitionException;

public class SemanticMap {
    Map<String, RClass> classes;
    Map<String, String> sources;
    SootEngine engine;
    
    public SemanticMap(CompilationTask task) {
	classes = new HashMap<String, RClass>();
	
	// get class-level info
	engine = new SootEngine(task);
	engine.buildSemanticMap(this);
	
	// map class name with source files
	sources = new HashMap<String, String>();
	for (int i = 0; i < task.getClasses().size(); i++) {
	    sources.put(task.getClasses().get(i), task.getSources().get(i));
	}
	
	// build symbol table
	buildSymbolTable();
    }

    public Map<String, RClass> getAllClasses() {
	return classes;
    }

    private void buildSymbolTable() {
	for (String klass : classes.keySet()) {
	    try {
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(sources.get(klass)));
		RJavaSymbolTableLexer lexer = new RJavaSymbolTableLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		RJavaSymbolTableParser parser = new RJavaSymbolTableParser(tokens);
		parser.setClass(classes.get(klass));
		parser.compilationUnit();
		
		if (RJavaCompiler.DEBUG)
		    classes.get(klass).printSymbolTalbe();
	    } catch (FileNotFoundException e) {
		e.printStackTrace();
	    } catch (IOException e) {
		e.printStackTrace();
	    } catch (org.antlr.runtime.RecognitionException e) {
		e.printStackTrace();
	    }
	}
    }
}
