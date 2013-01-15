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

public class SemanticMap {
    public static final boolean DEBUG = true;
    
    // task.class <-> RClass
    Map<String, RClass> classes;
    // task.class <-> task.sources
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
    }

    public Map<String, RClass> getAllClasses() {
	return classes;
    }

    public Map<String, String> getSources() {
        return sources;
    }
}
