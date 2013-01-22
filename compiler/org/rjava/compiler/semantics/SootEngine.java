package org.rjava.compiler.semantics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.rjava.compiler.CompilationTask;
import org.rjava.compiler.semantics.representation.RClass;

import static org.rjava.compiler.Constants.*;

import soot.PackManager;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootMethod;
import soot.SootResolver;
import soot.Transform;
import soot.jimple.spark.SparkTransformer;
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
    	Options.v().set_exclude(Arrays.asList("java"));
    	Options.v().set_no_bodies_for_excluded(true);
    	Options.v().set_allow_phantom_refs(true);
    	
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
    	
        runSoot();
    	
    	// get all classes and methods
    	allClasses = new HashMap<String, SootClass>();
    	allMethods = new HashMap<String, SootMethod>();
    	for (String className : classNames) {
    	    // resolve klass and add to map
    	    if (DEBUG)
    		System.out.println("Resolving " + className + "...");
    	    SootClass klass = resolveAndGetClass(className);
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
    	
    	Scene.v().loadNecessaryClasses();
    }

    private void runSoot() {
        List<String> sootArgs = new ArrayList<String>();
        sootArgs.add("-W");
        
        // no output
        sootArgs.add("-f");
        sootArgs.add("n");
        
        sootArgs.add("-p");
        sootArgs.add("wjop");
        sootArgs.add("enabled:true");
        
        //enable points-to analysis
        sootArgs.add("-p");
        sootArgs.add("cg");
        sootArgs.add("enabled:true");

        sootArgs.add("-p");
        sootArgs.add("cg.spark");
        sootArgs.add("enabled:true");
        
        sootArgs.add("-p");
        sootArgs.add("cg.spark");
        sootArgs.add("verbose:true");
        
        soot.Main.main(sootArgs.toArray(new String[0]));
        System.out.println("Soot done. ");
    }

    public void buildSemanticMap() {
    	// pass classes
    	for (Map.Entry<String, SootClass> entry : allClasses.entrySet()) {
    	    RClass.fromSootClass(entry.getValue());
    	}
    }

    public static SootClass resolveAndGetClass(String name) {
    	//Scene.v().forceResolve(name, SootClass.SIGNATURES);
    	SootResolver.v().resolveClass(name, SootClass.BODIES);
    	SootClass ret = Scene.v().getSootClass(name);
    	return ret;
    }
    
    public static void ensureResolved(SootClass sootClass) {
    }
}
