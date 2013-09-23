package org.rjava.compiler;

import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RMethod;

public final class Constants {
    // rjava source file extension, same as Java at the moment
    public static final String RJAVA_EXT = ".java";
    
    public static final String RJAVA_RESTRICTION_RULE_PACKAGE = "org.rjava.restriction.rules";
    public static final String RJAVA_RESTRICTION_RULE_PRAGMA = "org.rjava.restriction.RestrictionRule";
    public static final String RJAVA_RESTRICTION_RULESET_PACKAGE = "org.rjava.restriction.rulesets";
    public static final String RJAVA_RESTRICTION_RULESET_PRAGMA = "org.rjava.restriction.RestrictionRuleset";
    
    public static final String RJAVA_INLINE_ANNOTATION = "org.vmmagic.pragma.Inline";
    public static final String RJAVA_NOBOUNDSCHECK_ANNOTATION = "org.vmmagic.pragma.NoBoundsCheck";
    
    // the suffix that check rules end with
    public static final String CHECK_RULE_SUFFIX = "_CHECK";
    public static final String CHECK_CLASS_METHOD = "checkClass";
    public static final Class[] CHECK_CLASS_PARA = new Class[] {
	RClass.class
    };
    public static final String CHECK_METHOD_METHOD = "checkMethod";
    public static final Class[] CHECK_METHOD_PARA = new Class[] {
	RMethod.class
    };

    public static final String MAGIC_ADDRESS            = "org.vmmagic.unboxed.Address";
    public static final String MAGIC_EXTENT             = "org.vmmagic.unboxed.Extent";
    public static final String MAGIC_OBJECTREFERENCE    = "org.vmmagic.unboxed.ObjectReference";
    public static final String MAGIC_OFFSET             = "org.vmmagic.unboxed.Offset";
    public static final String MAGIC_WORD               = "org.vmmagic.unboxed.Word";
    
    public static final String MAGIC_ARRAY_SUFFIX       = "Array";
    
    public static final String[] MAGIC_TYPES = {
        MAGIC_ADDRESS,
        MAGIC_EXTENT,
        MAGIC_OBJECTREFERENCE,
        MAGIC_OFFSET,
        MAGIC_WORD
    };

    public static final String[] MAGIC_ARRAY_TYPES = {
        MAGIC_ADDRESS           + MAGIC_ARRAY_SUFFIX,
        MAGIC_EXTENT            + MAGIC_ARRAY_SUFFIX,
        MAGIC_OBJECTREFERENCE   + MAGIC_ARRAY_SUFFIX,
        MAGIC_OFFSET            + MAGIC_ARRAY_SUFFIX,
        MAGIC_WORD              + MAGIC_ARRAY_SUFFIX
    };

    public static final String[] RJAVA_JAVA_LANG = {
        "java.io.PrintStream",
        "java.lang.Class",
        "java.lang.ClassNotFoundException",
        "java.lang.Exception",
        "java.lang.Integer",
        "java.lang.NoClassDefFoundError",
        "java.lang.Object",
        "java.lang.String",
        "java.lang.StringBuffer",
        "java.lang.System",
        "java.lang.Throwable",
        "java.lang.Boolean",
        "java.lang.Float",
        "java.lang.Double",
        "java.lang.Thread",
        "java.lang.Runnable",
        "java.lang.InterruptedException"
    };
    public static final String RJAVA_LIB_IMPL_DIR = "rjava_clib_impl/";
    
    private Constants(){}
}
