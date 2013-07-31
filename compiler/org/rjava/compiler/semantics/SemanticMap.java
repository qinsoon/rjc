package org.rjava.compiler.semantics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.rjava.compiler.CompilationTask;
import org.rjava.compiler.Constants;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.pass.DependencyGraphPass;
import org.rjava.compiler.semantics.representation.*;
import org.rjava.compiler.util.JGraphTUtils;

import soot.SootClass;

public abstract class SemanticMap {
    public static final boolean DEBUG = true;
    
    // task.class <-> RClass
    public static Map<String, RClass> classes;
    
    // task.class <-> task.sources
    public static Map<String, RType> types;
    
    // class hierarchy
    public static TypeHierarchy hierarchy;
    
    // interfaces
    public static List<RClass> interfacesThatNeedInit = new ArrayList<RClass>();
    
    // class initialization dependency
    // FIXME: do not use it until code generation is done (use it in post-translation)
    public static DependencyGraph dependencyGraph;
    
    // call graph
    // FIXME: do not use it until code generation is done (use it in post-translation)
    public static CallGraph callGraph;
    
    public static SootEngine engine;

    public static void initSemanticMap(CompilationTask task) {
    	classes = new HashMap<String, RClass>();
    	types = new HashMap<String, RType>();
    	
    	// force a few primitive types in the map
    	for (String primitive : RType.PRIMITIVE_TYPES)
    	    types.put(primitive, RType.initWithClassName(primitive));
    	
    	// get class-level info
    	engine = new SootEngine(task);
    	engine.addAllClasses();
    	// all nested classes are added in this way
    	for (SootClass klass : engine.getAllAppClassesInScene()) {
    	    String name = klass.getName();

    	    // add to semantic map
	        RClass.fromSootClass(klass);
	        // add to compilation task
	        task.addClassByClassName(name);
    	}
    	
    	// init hierarchy
    	hierarchy = TypeHierarchy.init();
    	if (DEBUG)
    	    hierarchy.printHierarchy();
    	
    	// if one class is named to be compiled, we have to compile all its ancestor    	
    	for (int i = 0; i < task.getClasses().toArray().length; i++) {
    	    String className = (String) task.getClasses().toArray()[i];
    	    Set<RClass> needToCompile = hierarchy.getAncestorsOf(classes.get(className));
    	    
    	    for (RClass klass : needToCompile) {
    	        task.addClassByClassName(klass.getName());
    	    }
    	}
    	
    	// check twins
    	for (RClass klass : classes.values()) {
    	    for (RMethod method : klass.getMethods())
    	        method.checkTwin();
    	}
    	
        // init call graph
        callGraph = new CallGraph();
        buildCallGraph();
        if (CallGraph.DEBUG)
            callGraph.dumpGraph();
        
        // init class initialization dependency
        dependencyGraph = new DependencyGraph();
        DependencyGraphPass pass = new DependencyGraphPass();
        pass.start();
        dependencyGraph.generateClassDependencyGraph();
    }

    private static void buildCallGraph() {
        for (RClass klass : classes.values()) {
            for (RMethod method : klass.getMethods()) {
                for (RStatement stmt : method.getBody()) {
                    if (stmt.containsInvokeExpr()) {
                        RMethod target = stmt.getInvokeExpr().getTargetMethod();
                        
                        // we only care about application classes
                        if (target != null)
                            callGraph.addCallEdge(method, target);
                    }
                }
            }
        }
    }

    public static Map<String, RClass> getAllClasses() {
        return classes;
    }

    /*public static Map<String, String> getSources() {
        return sources;
    }*/
    
    /**
     * havent tested this method much. Suggest not using it.
     * @param klass
     * @return
     */
    @Deprecated
    public static RType getRTypeFromRClass(RClass klass) {
        return types.get(klass.getName());
    }
    
    /**
     * 
     * @param type
     * @return null if type cannot be found or if type isnt an app type (we do not have its RClass)
     */
    public static RClass getRClassFromRType(RType type) {
        // if type is not an application, we dont have its RClass then
        if (!type.isAppType())
            return null;
        
        if (RJavaCompiler.ENABLE_ASSERTION)
            RJavaCompiler.assertion(type.isReferenceType(), type + " should be reference type");
        RClass ret = classes.get(type.getClassName());
        if (RJavaCompiler.ENABLE_ASSERTION)
            RJavaCompiler.assertion(ret != null, "cannot find " + type.getClassName() + " in semantic map");
        return ret;
    }
    
    public static boolean isApplicationClass(String className) {
        return !isJavaLib(className) && !isRJavaLib(className);
    }
    
    public static boolean isJavaLib(String className) {
        return className.startsWith("java.") || className.startsWith("javax.");
    }
    
    public static boolean isRJavaLib(String className) {
        return className.startsWith("org.rjava.restriction") || 
                className.startsWith("org.vmmagic") ||
                className.startsWith("org.rjava.osext");
    }
    
    public static boolean isUnboxedType(String className) {
        for (String s : Constants.MAGIC_ARRAY_TYPES)
            if (className.equals(s))
                return true;
        
        for (String s : Constants.MAGIC_TYPES)
            if (className.equals(s))
                return true;
        
        return false;
    }
    
    public static void dumpTypes() {
        RJavaCompiler.println("RTypes at the point:");
        for (String key : types.keySet()) {
            RJavaCompiler.println(key + "->" + types.get(key).toString());
        }
    }
}
