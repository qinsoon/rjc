package org.rjava.compiler.semantics.representation;

import org.rjava.compiler.semantics.SootEngine;

import soot.tagkit.AnnotationTag;
import static org.rjava.compiler.Constants.*;

public class RAnnotation {
    private AnnotationTag internal;
    private RType type;
    
    public RAnnotation(AnnotationTag tag, RClass klass) {
    	this.internal = tag;
    	this.type = RType.initWithTypeName(tag.getType());
    }

    /**
     * is this annotation a restriction rule? This will cause resolving such annotation interface
     * @return true if this annotation is a restriction rule
     */
    public boolean isRestrictionRule() {
	RClass annoClass = new RClass(SootEngine.resolveAndGetClass(type.getClassName()));
	for (RAnnotation rAnno : annoClass.getAnnotations())
	    if (rAnno.type.getClassName().equals(RJAVA_RESTRICTION_RULE_PRAGMA))
		return true;
	
	return false;
    }

    /**
     * is this annotation a restriction ruleset? This will cause resolving such annotation interface
     * @return true if this annotation is a restriction ruleset
     */
    public boolean isRestrictionRuleset() {
	RClass annoClass = new RClass(SootEngine.resolveAndGetClass(type.getClassName()));
	for (RAnnotation rAnno : annoClass.getAnnotations()) {
	    if (rAnno.type.getClassName().equals(RJAVA_RESTRICTION_RULESET_PRAGMA))
		return true;
	}
	
	return false;
    }    

    AnnotationTag getInternal() {
        return internal;
    }

    public RType getType() {
        return type;
    }
}
