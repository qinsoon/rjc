package org.rjava.compiler.semantics.representation;

import soot.Value;

public class RValue{
    protected RType type;
    Value internal;

    public RValue(Value internal) {
	this.internal = internal;
    }
    
    protected RValue() {
	
    }
    
    public static RValue from(Value v) {
	return null;
    }
}
