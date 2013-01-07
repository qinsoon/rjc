package org.rjava.compiler.semantics.representation.value.variable;

import org.rjava.compiler.semantics.representation.RValue;

import soot.Value;

public class RVariable extends RValue {
    public static final int CONSTANT = 1;
    public static final int IDENTITY_REF = 2;
    public static final int INSTANCE_FIELD_REF = 3;
    public static final int LOCAL = 4;

    public RVariable(Value v) {
	super(v);
    }

    public static RVariable from(Value v) {
	return null;
    }
}
