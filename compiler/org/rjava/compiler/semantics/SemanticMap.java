package org.rjava.compiler.semantics;

import java.util.HashMap;
import java.util.Map;

import org.rjava.compiler.CompilationTask;
import org.rjava.compiler.semantics.representation.*;

public class SemanticMap {
    Map<String, RClass> classes;
    SootEngine engine;
    
    public SemanticMap(CompilationTask task) {
	classes = new HashMap<String, RClass>();
	
	engine = new SootEngine(task);
	engine.buildSemanticMap(this);
    }

    public Map<String, RClass> getAllClasses() {
	return classes;
    }

}
