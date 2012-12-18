package org.rjava.compiler;

import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RMethod;

public final class Constants {
    // rjava source file extension, same as Java at the moment
    public static final String RJAVA_EXT = ".java";
    
    // rjava restr./ext. annotations' path
    public static final String RJAVA_ANNOTATION_DIR = "rjava/";
    
    public static final String RJAVA_RESTRICTION_RULE_PACKAGE = "org.rjava.restriction.rules";
    public static final String RJAVA_RESTRICTION_RULE_PRAGMA = "org.rjava.restriction.RestrictionRule";
    public static final String RJAVA_RESTRICTION_RULESET_PACKAGE = "org.rjava.restriction.rulesets";
    public static final String RJAVA_RESTRICTION_RULESET_PRAGMA = "org.rjava.restriction.RestrictionRuleset";
    
    // the suffix that check rules end with
    public static final String CHECK_RULE_SUFFIX = "_CHECK";
    public static final String CHECK_CLASS_METHOD = "checkClass";
    public static final Class[] CHECK_CLASS_PARA = new Class[] {
	RClass.class, SemanticMap.class
    };
    public static final String CHECK_METHOD_METHOD = "checkMethod";
    public static final Class[] CHECK_METHOD_PARA = new Class[] {
	RMethod.class, SemanticMap.class
    };

    
    private Constants(){}
}
