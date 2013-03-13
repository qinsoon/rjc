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

public abstract class SemanticMap {
    public static final boolean DEBUG = true;
    
    // task.class <-> RClass
    public static Map<String, RClass> classes;
    // task.class <-> task.sources
    public static Map<String, String> sources;
    public static Map<String, RType> types;
    
    // class hierarchy
    public static TypeHierarchy hierarchy;
    
    // interfaces
    public static List<RClass> interfacesThatNeedInit = new ArrayList<RClass>();
    
    public static SootEngine engine;

    public static void initSemanticMap(CompilationTask task) {
    	classes = new HashMap<String, RClass>();
    	types = new HashMap<String, RType>();
    	
    	// get class-level info
    	engine = new SootEngine(task);
    	engine.buildSemanticMap();
    	
    	// init hierarchy
    	hierarchy = TypeHierarchy.init();
    	if (DEBUG)
    	    hierarchy.printHierarchy();
    	// TODO: if one class is named to be compiled, we have to compile all its ancestor
    	for (int i = 0; i < task.getClasses().toArray().length; i++) {
    	    String className = (String) task.getClasses().toArray()[i];
    	    Set<RClass> needToCompile = hierarchy.getAncestorsOf(classes.get(className));
    	    
    	    for (RClass klass : needToCompile) {
    	        if (!task.getClasses().contains(klass.getName()))
    	            task.addClass(klass.getName());
    	    }
    	}
    	
        // map class name with source files
        sources = new HashMap<String, String>();
        for (int i = 0; i < task.getClasses().toArray().length; i++) {
            sources.put((String)task.getClasses().toArray()[i], (String)task.getSources().toArray()[i]);
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

    public static Map<String, String> getSources() {
        return sources;
    }
    
    public static RType getRTypeFromRClass(RClass klass) {
        return types.get(klass.getName());
    }
    
    public static RClass getRClassFromRType(RType type) {
        if (RJavaCompiler.ENABLE_ASSERTION)
            RJavaCompiler.assertion(type.isReferenceType(), type + " should be reference type");
        RClass ret = classes.get(type.getClassName());
        if (RJavaCompiler.ENABLE_ASSERTION)
            RJavaCompiler.assertion(ret != null, "cannot find " + type.getClassName() + " in semantic map");
        return ret;
    }
}
