package org.rjava.compiler.semantics.representation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.rjava.compiler.CompilationUnit;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.pass.CompilationPass;
import org.rjava.compiler.semantics.DependencyEdgeNode;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.SootEngine;

import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;

public class RClass implements DependencyEdgeNode, CompilationUnit{
    SootClass internal;
    private String name;
    
    // 'annotations' are what are declared with source
    private List<RRestriction> restrictions;
    // 'restrictions' are RJava restriction rules, including those unfolded from rulesets
    private List<RAnnotation> annotations;
    
    // methods
    private List<RMethod> methods = new ArrayList<RMethod>();
    
    // fields
    private List<RField> fields = new ArrayList<RField>();
    
    private RClass superClass;
    
    /**
     * check if the corresponding RClass is resolved. if so, simply fetch it, otherwise resolve it
     * @param sootClass
     * @return
     */
    public static RClass fromSootClass(SootClass sootClass) {
        String className = sootClass.getName();
        RClass rClass = SemanticMap.classes.get(className);
        if (rClass == null) {
            rClass = new RClass(sootClass);
            SemanticMap.classes.put(className, rClass);
        }
        return rClass;
    }
    
    public static RClass fromClassName(String className) {
        RClass rClass = SemanticMap.classes.get(className);
        if (rClass == null) {
            rClass = new RClass(SootEngine.resolveAndGetClass(className));
            SemanticMap.classes.put(className, rClass);
        }
        return rClass;
    }
    
    protected RClass(SootClass sootClass) {
    	this.internal = sootClass;
    	this.name = internal.getName();
    	
    	this.annotations = fetchAnnotations(internal);
    	
        fetchMethods();
        fetchFields();
    	
    	//if (internal.hasSuperclass() && !internal.getSuperclass().getName().equals("java.lang.Object"))
        if (internal.hasSuperclass())
    	    superClass = fromSootClass(internal.getSuperclass());
    }

    private void fetchFields() {
        Iterator<SootField> iter = internal.getFields().iterator();
        while (iter.hasNext()) {
            fields.add(new RField(this, iter.next()));
        }
    }

    private void fetchMethods() {
    	for (SootMethod m : internal.getMethods()) {
    	    RMethod tmp = new RMethod(this, m);
    	    
    	    // a method maybe a twin for another method. See twin in RMethod
    	    if (isAppClass()) {
        	    boolean validMethod = true;
        	    for (RMethod method : methods) {
        	        if (method.isTwin(tmp)) {
        	            method.setTwin(tmp);
        	            validMethod = false;
        	        }
        	    }
        	    
        	    if (validMethod) {
        	        methods.add(tmp);
        	    }
    	    } else {
    	        methods.add(tmp);
    	    }
    	}
    }

    /**
     * get annotations from SootClass Tag
     * @param klass
     * @return list of RAnnotation
     */
    private List<RAnnotation> fetchAnnotations(SootClass klass) {
	List<RAnnotation> result = new ArrayList<RAnnotation>();
	for (Tag tag : klass.getTags()) {
	    // only deal with VisibilityAnnotationTag
	    if (tag instanceof VisibilityAnnotationTag) {
		VisibilityAnnotationTag annoTag = (VisibilityAnnotationTag) tag;
		for (AnnotationTag t : annoTag.getAnnotations()) {
		    result.add(new RAnnotation(t, this));  
		}
	    }
	}
	
	return result;
    }

    /**
     * get a list of restrictions on such class. Build restriction list when first executed
     * @return list of {@link RRestriction}
     */
    public List<RRestriction> getRestrictions() {
	if (restrictions == null)
	    restrictions = fetchRestrictions();		// build from annotations

	return restrictions;
    }    

    // fetch restrictions
    private List<RRestriction> fetchRestrictions() {
	List<RRestriction> result = new ArrayList<RRestriction>();
	for (RAnnotation anno : annotations) {
	    List<RRestriction> restrictions = RRestriction.unfold(anno);
	    if (restrictions != null)
		result.addAll(restrictions);
	}
	return result;
    }

    /**
     * get class name
     * @return class name
     */
    public String getName() {
        return name;
    }
    
    public String toString() {
        return name;
    }

    /**
     * get a list of annotations on such class
     * @return list of {@link RAnnotation}
     */
    public List<RAnnotation> getAnnotations() {
        return annotations;
    }

    public List<RMethod> getMethods() {
        return methods;
    }


    public List<RField> getFields() {
        return fields;
    }

    public RClass getSuperClass() {
        return superClass;
    }
    
    public RClass getSuperMostClass() {
        if (superClass != null)
            return superClass.getSuperMostClass();
        else return this;
    }
    
    public boolean hasSuperClass() {
        return superClass != null;
    }
    
    public boolean isInterface() {
        return internal.isInterface();
    }
    
    public boolean hasInterfaces() {
        return internal.getInterfaceCount() != 0;
    }
    
    public boolean hasInheritedInterfaces() {
        if (!hasSuperClass())
            return false;
        
        RClass superClass = getSuperClass();
        do {
            if (superClass.hasInterfaces())
                return true;
            else if (superClass.hasSuperClass())
                superClass = superClass.getSuperClass();
            else return false;
        } while(true);
    }
    
    public List<RClass> getInheritedInterfaces() {
        if (!hasInheritedInterfaces())
            return null;
        
        List<RClass> ret = new ArrayList<RClass>();
        RClass superClass = getSuperClass();
        do {
            if (superClass.hasInterfaces()) {
                ret.addAll(superClass.getInterfaces());
            }
            if (superClass.hasSuperClass())
                superClass = superClass.getSuperClass();
            else return ret;
        } while (true);
    }
    
    public List<RClass> getInterfaces() {
        if (!hasInterfaces())
            return null;
        
        List<RClass> ret = new ArrayList<RClass>();
        Iterator<SootClass> iter = internal.getInterfaces().iterator();
        while(iter.hasNext()) {
            ret.add(RClass.fromSootClass(iter.next()));
        }
        return ret;
    }
    
    public RMethod getCLInitMethod() {
        for (RMethod method : methods)
            if (method.getName().equals("<clinit>"))
                return method;
        return null;
    }
    
    public SootClass internal() {
        return internal;
    }
    
    public RMethod getImplementingMethodOfAnInterfaceMethod(RMethod interfaceMethod) {
        RClass base = this;
        do {
            for (RMethod method : base.methods) {
                if (method.internal.getName().equals(interfaceMethod.internal.getName()) && 
                        method.internal.getParameterTypes().equals(interfaceMethod.internal.getParameterTypes()))
                    return method;
            }
            if (base.hasSuperClass())
                base = base.getSuperClass();
            else return null;
        } while(true);
    }
    /**
     * 
     * @param sootMethod
     * @return null if cannot find such method
     */
    public RMethod getMethodByMatchingNameAndParameters(SootMethod sootMethod) {
        for (RMethod method : methods) {
            if (method.internal.getName().equals(sootMethod.getName()) && 
                    method.internal.getParameterTypes().equals(sootMethod.getParameterTypes()))
                return method;
        }
        
        return null;
    }
    
    /**
     * returns the class who declares the method but whose parent doesnt declare such method
     * @param base
     * @param method
     * @return
     */
    public static RClass whoOwnsMethodInTypeHierarchy(RClass base, RMethod method) {
        String methodName = method.internal().getName();
        List params = method.internal().getParameterTypes();
        
        return whoOwnsMethodInTypeHierarchyInternal(base, methodName, params);
    }
    
    public static RClass whoOwnsMethodInTypeHierarchy(RClass base, SootMethod method) {
        return whoOwnsMethodInTypeHierarchyInternal(base, method.getName(), method.getParameterTypes());
    }
    
    private static RClass whoOwnsMethodInTypeHierarchyInternal(RClass base, String methodName, List params) {
        RClass ret = base;
        while(true) {
            // ret declares such method, but either he has no parent or his parent doesnt have such method
            if (
                    (ret.internal.declaresMethod(methodName, params) && 
                    ( ret.getSuperClass() == null || !ret.getSuperClass().internal.declaresMethod(methodName, params))))
                return ret;
            else {
                if (ret.hasSuperClass())
                    ret = ret.getSuperClass();
                else return null;
            }
        }
    }
    
    public static RClass whoOwnsFieldInTypeHierarchy(RClass base, RType type, String name) {
        RClass ret = base;
        while(true) {
            for (RField f : ret.getFields()) {
                if (f.getType().equals(type) && f.getName().equals(name))
                    return ret;
            }
            if (ret.hasSuperClass())
                ret = ret.getSuperClass();
            else return null;
        }
    }

    /**
     * this class overrides some methods from previous interface
     * @param myInterface
     * @return
     */
    public boolean hasOverridingMethodsFromInterface(RClass myInterface) {
        for (RMethod method : methods) {
            if (method.isClassInitializer())
                continue;
            for (RMethod interfaceMethod : myInterface.getMethods()) {
                if (method.internal.getName().equals(interfaceMethod.internal.getName()) &&
                        method.internal.getParameterTypes().equals(interfaceMethod.internal.getParameterTypes()))
                    return true;
            }
        }
        return false;
    }
    
    public boolean isAppClass() {
        return SemanticMap.isApplicationClass(name);
    }
    
    public boolean equals(Object o) {
        if (o.getClass().equals(RClass.class))
            return this.internal.equals(((RClass) o).internal);
        else return false;
    }
    
    public boolean isDescendanceof(RClass another) {
        if (getSuperClass() == null)
            return false;
        
        if (getSuperClass().equals(another))
            return true;
        else return getSuperClass().isDescendanceof(another);
    }

    @Override
    public void accept(CompilationPass pass) {
        pass.visit(this);
        for (RMethod method : methods)
            method.accept(pass);
    }

    @Override
    public boolean isCLInitNode() {
        return false;
    }

    @Override
    public boolean isClassNode() {
        return true;
    }
    
    public void dump() {
        RJavaCompiler.debug("RClass: " + getName());
        RJavaCompiler.debug("Methods:");
        for (RMethod m : methods)
            RJavaCompiler.debug(m);
    }
}
