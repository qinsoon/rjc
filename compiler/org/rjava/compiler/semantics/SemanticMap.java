package org.rjava.compiler.semantics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.tree.TreeModel;

import org.rjava.compiler.CompilationTask;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.representation.*;
import org.rjava.compiler.util.Tree;

import soot.SootClass;

public abstract class SemanticMap {
    public static final boolean DEBUG = true;
    
    // task.class <-> RClass
    public static Map<String, RClass> classes;
    // task.class <-> task.sources
    //public static Map<String, String> sources;
    public static Map<String, RType> types;
    
    // class hierarchy
    public static TypeHierarchy hierarchy;
    
    // interfaces
    public static List<RClass> interfacesThatNeedInit = new ArrayList<RClass>();
    
    // class initialization dependency
    public static DependencyGraph classInitDependencyGraph;
    
    public static SootEngine engine;

    public static void initSemanticMap(CompilationTask task) {
    	classes = new HashMap<String, RClass>();
    	types = new HashMap<String, RType>();
    	
    	// force a few primitive types in the map
    	for (String primitive : RType.PRIMITIVE_TYPES)
    	    types.put(primitive, RType.initWithClassName(primitive));
    	
    	// get class-level info
    	engine = new SootEngine(task);
    	engine.buildSemanticMap();
    	// all nested classes are added in this way (?)
    	for (SootClass klass : engine.getAllAppClassesInScene()) {
    	    String name = klass.getName();
    	    if (!isRJavaLib(name) && classes.get(name) == null) {
    	        // add to semantic map
    	        RClass.fromSootClass(klass);
    	        // add to compilation task
    	        task.addClassByClassName(name);
    	    }
    	}
    	
    	// init hierarchy
    	hierarchy = TypeHierarchy.init();
    	if (DEBUG)
    	    hierarchy.printHierarchy();
    	
    	// init class initialization dependency
    	classInitDependencyGraph = new DependencyGraph();

    	// if one class is named to be compiled, we have to compile all its ancestor    	
    	for (int i = 0; i < task.getClasses().toArray().length; i++) {
    	    String className = (String) task.getClasses().toArray()[i];
    	    Set<RClass> needToCompile = hierarchy.getAncestorsOf(classes.get(className));
    	    
    	    for (RClass klass : needToCompile) {
    	        if (!task.getClasses().contains(klass.getName()))
    	            task.addClassByClassName(klass.getName());
    	    }
    	}
    	
    	// check twins
    	for (RClass klass : classes.values()) {
    	    for (RMethod method : klass.getMethods())
    	        method.checkTwin();
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
                className.startsWith("org.rjava.nativeext");
    }
    
    public static void dumpTypes() {
        RJavaCompiler.println("RTypes at the point:");
        for (String key : types.keySet()) {
            RJavaCompiler.println(key + "->" + types.get(key).toString());
        }
    }
}
