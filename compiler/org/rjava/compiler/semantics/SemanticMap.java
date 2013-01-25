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

public abstract class SemanticMap {
    public static final boolean DEBUG = true;
    
    // task.class <-> RClass
    public static Map<String, RClass> classes;
    // task.class <-> task.sources
    public static Map<String, String> sources;
    public static Map<String, RType> types;
    public static SootEngine engine;

    public static void initSemanticMap(CompilationTask task) {
    	classes = new HashMap<String, RClass>();
    	types = new HashMap<String, RType>();
    	
    	// get class-level info
    	engine = new SootEngine(task);
    	engine.buildSemanticMap();
    	
    	// map class name with source files
    	sources = new HashMap<String, String>();
    	for (int i = 0; i < task.getClasses().size(); i++) {
    	    sources.put(task.getClasses().get(i), task.getSources().get(i));
    	}
    }

    public static Map<String, RClass> getAllClasses() {
        return classes;
    }

    public static Map<String, String> getSources() {
        return sources;
    }
}
