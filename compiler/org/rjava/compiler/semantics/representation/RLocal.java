package org.rjava.compiler.semantics.representation;

import soot.Local;

public class RLocal {
    RMethod method;
    Local internal;
    
    RType type;
    String name;
    
    public RLocal(RMethod method, Local internal) {
        this.method = method;
        this.internal = internal;
        
        this.type = RType.initWithTypeName(internal.getType().toString());
        this.name = internal.getName();
    }

    public String toString() {
        return "[" + type + "]" + name;
    }

    public RMethod getMethod() {
        return method;
    }

    public Local getInternal() {
        return internal;
    }

    public RType getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
