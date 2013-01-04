package org.rjava.compiler.semantics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.rjava.compiler.CompilationTask;
import org.rjava.compiler.semantics.representation.RClass;

import static org.rjava.compiler.Constants.*;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SootResolver;
import soot.options.Options;

public class SootEngine {  
    private static final boolean DEBUG = true;
    
    private static final String[] jdkPath = {"components/soot/jce.jar",
    "components/soot/rt.jar"};
    
    private List<String> dir;
    private List<String> classNames;
    
    private Map<String, SootClass> allClasses;
    private Map<String, SootMethod> allMethods;

    public SootEngine(CompilationTask task) {
	// dir to process
	this.dir = new ArrayList<String>();
	this.dir.add(task.getPath());
	
	// sources
	this.classNames = task.getClasses();
	
	init();
    }
    
    private void init() {
	Options.v().set_src_prec(Options.src_prec_java);
	Options.v().set_whole_program(true);
	Options.v().set_process_dir(dir);
	//Options.v().set_exclude(Arrays.asList("java"));
	//Options.v().set_no_bodies_for_excluded(true);
	//Options.v().set_allow_phantom_refs(true);
	
	// set class path
	String classpath = "";
	for (String path : dir)
	    classpath += path + ":";
	for (String path : jdkPath)
	    classpath += path + ":";
	classpath += RJAVA_ANNOTATION_DIR + ":"; 
	classpath += ".";
	Options.v().set_soot_classpath(classpath);
	if (DEBUG)
	    System.out.println("soot classpath: " + classpath);
	
	// get all classes and methods
	allClasses = new HashMap<String, SootClass>();
	allMethods = new HashMap<String, SootMethod>();
	for (String className : classNames) {
	    // resolve klass and add to map
	    if (DEBUG)
		System.out.println("Resolving " + className + "...");
	    Scene.v().forceResolve(className, SootClass.SIGNATURES);
	    SootClass klass = Scene.v().getSootClass(className);
	    allClasses.put(className, klass);
	    
	    // get methods
	    for (SootMethod m : klass.getMethods()) {
		if (!m.isAbstract())
		    allMethods.put(m.getSignature(), m);
	    }
	}
	
	if (DEBUG) {
	    System.out.println("---Classes---");
	    for (Map.Entry<String, SootClass> entry : allClasses.entrySet()) {
		System.out.println("(" + entry.getKey() + ", " + entry.getValue() + ")");
	    }
	    System.out.println();
	}
    }

    public void buildSemanticMap(SemanticMap semanticMap) {
	// pass classes
	for (Map.Entry<String, SootClass> entry : allClasses.entrySet()) {
	    semanticMap.classes.put(entry.getKey(), new RClass(entry.getValue()));
	}
    }

    public static SootClass resolveAndGetClass(String name) {
	//Scene.v().forceResolve(name, SootClass.SIGNATURES);
	SootResolver.v().resolveClass(name, SootClass.SIGNATURES);
	SootClass ret = Scene.v().getSootClass(name);
	return ret;
    }
}
