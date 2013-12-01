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
import org.rjava.compiler.pass.CallGraphPass;
import org.rjava.compiler.pass.CircularTypePass;
import org.rjava.compiler.pass.ClassHierarchyPass;
import org.rjava.compiler.pass.ConstantPropagationPass;
import org.rjava.compiler.pass.DependencyGraphPass;
import org.rjava.compiler.pass.DetectInlinableFieldPass;
import org.rjava.compiler.pass.PointsToAnalysisPass;
import org.rjava.compiler.pass.RestrictionPass;
import org.rjava.compiler.semantics.representation.*;
import org.rjava.compiler.util.JGraphTUtils;

import soot.SootClass;

public abstract class SemanticMap {
    public static final boolean DEBUG = true;
    
    // task.class <-> RClass
    private static Map<String, RClass> classes;
    
    // task.class <-> task.sources
    private static Map<String, RType> types;
    
    // class hierarchy
    public static ClassHierarchyPass cha;
    
    // interfaces
    public static List<RClass> interfacesThatNeedInit = new ArrayList<RClass>();
    
    // class initialization dependency
    public static DependencyGraphPass dg;
    
    // call graph
    public static CallGraphPass cg;
    
    // points-to
    public static PointsToAnalysisPass pta;
    
    // object inlining
    public static DetectInlinableFieldPass oi;
    
    // constant propagation
    public static ConstantPropagationPass cp;
    
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
    	
    	/*
    	 * The order of the following passes matters. DONT CHANGE 
    	 */
    	
    	// init hierarchy - we need this for the next step below
    	cha = new ClassHierarchyPass();
    	cha.start("Class Hierarchy Analysis");
//    	if (DEBUG)
//    	    cha.getClassHierarchy().printHierarchy();
    	
    	// if one class is named to be compiled, we have to compile all its ancestor    	
    	for (int i = 0; i < task.getClasses().toArray().length; i++) {
    	    String className = (String) task.getClasses().toArray()[i];
    	    Set<RClass> needToCompile = cha.getClassHierarchy().getAncestorsOf(classes.get(className));
    	    
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
        cg = new CallGraphPass();
        cg.start("Call Graph Building");
        
        // init class initialization dependency
        dg = new DependencyGraphPass();
        dg.start("Class Initialization Dependency");
        
        // init restrictions
        RestrictionPass rPass = new RestrictionPass();
        rPass.start("Restriction Propagating");
        
        // points to analysis
        if (!RJavaCompiler.noOpt) {
            pta = new PointsToAnalysisPass();
            pta.start("Points-To Analysis");
        }
        
        if (RJavaCompiler.OPT_OBJECT_INLINING) {
            CircularTypePass circularTypePass = new CircularTypePass();
            circularTypePass.start("Object Inlining - find circular type");
            
            oi = new DetectInlinableFieldPass(circularTypePass);
            oi.start("Object Inlining - find inlinable field");
        }
        
        if (RJavaCompiler.OPT_CONSTANT_PROPAGATION) {
            cp = new ConstantPropagationPass();
            cp.start("Constant Propagation");
        }
        
        // nop
    }

    public static Map<String, RClass> getAllClasses() {
        return classes;
    }
    
    public static Map<String, RType> getAllTypes() {
        return types;
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
     * Use RClass.initWithClassName(type.getClassName()) instead
     * @param type
     * @return null if type cannot be found or if type isnt an app type (we do not have its RClass)
     */
    @Deprecated
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
    
    public static RClass getOuterClass(RClass inner) {
        RJavaCompiler.assertion(inner.isInnerClass(), inner.getName() + " is not an inner class");
        int cut = inner.getName().indexOf('$');
        String outerClassName = inner.getName().substring(0, cut);
        return classes.get(outerClassName);
    }
}
