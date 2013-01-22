package org.rjava.compiler.semantics.representation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.SootEngine;

import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;

public class RClass {
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
    
    protected RClass(SootClass sootClass) {
    	this.internal = sootClass;
    	this.name = internal.getName();
    	
    	this.annotations = fetchAnnotations(internal);
    	
    	fetchMethods();
    	fetchFields();
    	
    	if (internal.hasSuperclass() && !internal.getSuperclass().getName().equals("java.lang.Object"))
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
    	    methods.add(new RMethod(this, m));
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
}
