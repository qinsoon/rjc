package org.rjava.compiler.semantics.representation;

import soot.Local;

public class RLocal {
    RMethod method;
    Local internal;
    
    RType type;
    String name;
    
    /**
     * for inlining object, some locals will be value (pointing to the inlined object)
     */
    boolean byValue = false;
    
    public RLocal(RMethod method, Local internal) {
        this.method = method;
        this.internal = internal;
        
        this.type = RType.initWithClassName(internal.getType().toString());
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
    
    public boolean isByValue() {
        return byValue;
    }
    
    public void setByValue(boolean byValue) {
        this.byValue = byValue;
    }
}
