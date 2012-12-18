package org.rjava.compiler.semantics.representation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.rjava.compiler.semantics.SootEngine;

import soot.Scene;
import soot.SootClass;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;

public class RRestriction{
    private RAnnotation anno;
    private String name;
    
    public RRestriction(RAnnotation anno) {
	this.anno = anno;
	this.name = anno.getType().getClassName();
    }

    public static List<RRestriction> unfold(RAnnotation anno) {
	if (anno.isRestrictionRule()) {
	    return Arrays.asList(new RRestriction(anno));
	}	    
	else if (anno.isRestrictionRuleset()) {
	    List<RRestriction> result = new ArrayList<RRestriction>();
	    
	    RClass annoClass = new RClass(SootEngine.resolveAndGetClass(anno.getType().getClassName()));
	    for (RAnnotation rAnno : annoClass.getAnnotations()) {
		result.addAll(unfold(rAnno));
	    }
	    
	    return result;
	}
	return new ArrayList<RRestriction>();
    }
    
    public String getName() {
	return name;
    }
}
