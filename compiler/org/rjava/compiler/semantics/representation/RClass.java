package org.rjava.compiler.semantics.representation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.rjava.compiler.semantics.SootEngine;

import soot.SootClass;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;

public class RClass {
    private SootClass internal;
    private String name;
    
    // 'annotations' are what are declared with source
    private List<RRestriction> restrictions;
    // 'restrictions' are RJava restriction rules, including those unfolded from rulesets
    private List<RAnnotation> annotations;
    
    public RClass(SootClass sootClass) {
	this.internal = sootClass;
	this.name = internal.getName();
	
	this.annotations = fetchAnnotations(internal);
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
		    result.add(new RAnnotation(t));  
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
}
