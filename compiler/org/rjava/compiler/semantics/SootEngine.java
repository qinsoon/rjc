package org.rjava.compiler.semantics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.rjava.compiler.CompilationTask;
import org.rjava.compiler.semantics.representation.RClass;

import static org.rjava.compiler.Constants.*;

import soot.Body;
import soot.BodyTransformer;
import soot.PackManager;
import soot.PhaseOptions;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootMethod;
import soot.SootResolver;
import soot.Transform;
import soot.jimple.spark.SparkTransformer;
import soot.options.Options;

public class SootEngine {  
    private static final boolean DEBUG = false;
    
    public static boolean RUN_SOOT = false;
    
    private static final String[] jdkPath = {"components/soot/jce.jar",
    "components/soot/rt.jar"};
    
    private List<String> dir;
    private List<String> classNames;
    
    private Map<String, SootClass> allClasses;
    private Map<String, SootMethod> allMethods;
    
    public static Map<SootMethod, Body> methodStorage = new HashMap<SootMethod, Body>();

    public SootEngine(CompilationTask task) {
    	// dir to process
    	this.dir = new ArrayList<String>();
    	this.dir.add(task.getPath());
    	
    	// sources
    	this.classNames = task.getClasses();
    	
    	init();
    }
    
    private void init() {
        runSoot();        
    	resolveClasses();
    }

    private void resolveClasses() {
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
    	        //System.out.println("method:" + m.getSignature());
    	        //System.out.println(" body :" + m.retrieveActiveBody());
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

    private void runSoot() {
        List<String> sootArgs = new ArrayList<String>();
        
        // whole program
        Options.v().set_whole_program(true);
        
        // source preference: java
        Options.v().set_src_prec(Options.src_prec_java);
        
        // no output
        Options.v().set_output_format(Options.output_format_none);
        
        // exclude java.*
        Options.v().set_exclude(Arrays.asList("java", "org.vmmagic"));
        Options.v().set_no_bodies_for_excluded(true);
        Options.v().set_allow_phantom_refs(true);
        
        // keep line number
        Options.v().set_keep_line_number(true);
        
        // classpath
        String classpath = "";
        for (String path : dir)
            classpath += path + ":";
        for (String path : jdkPath)
            classpath += path + ":";
        classpath += RJAVA_ANNOTATION_DIR + ":"; 
        classpath += ".";
        Options.v().set_soot_classpath(classpath);
        
        PhaseOptions.v().setPhaseOption("wjop", "enabled:true");
        PhaseOptions.v().setPhaseOption("jop", "enabled:true");
        
        //enable points-to analysis
        //PhaseOptions.v().setPhaseOption("cg", "enabled:true");
        //PhaseOptions.v().setPhaseOption("cg.spark", "enabled:true");
        
        // set application classes
        sootArgs.add("--app");
        for (String className : classNames) {
            sootArgs.add(className);
        }
        
        if (RUN_SOOT) {
            // get jimple body
            PackManager.v().getPack("jop").add(new Transform("jop.getbody", new soot.BodyTransformer() {
                @Override
                protected void internalTransform(Body body, String phase, Map arg2) {
                    methodStorage.put(body.getMethod(), body);
                }
            }));

            soot.Main.main(sootArgs.toArray(new String[0]));
        }
    }

    public void buildSemanticMap() {
    	// pass classes
    	for (Map.Entry<String, SootClass> entry : allClasses.entrySet()) {
    	    RClass.fromSootClass(entry.getValue());
    	}
    }

    public static SootClass resolveAndGetClass(String name) {
        if (!Scene.v().containsClass(name))
            SootResolver.v().resolveClass(name, SootClass.BODIES);
    	return Scene.v().getSootClass(name);
    }
    
    public static void ensureResolved(SootClass sootClass) {
    }
}
