package org.rjava.compiler.semantics.representation;

import soot.SootField;

public class RField {
    RClass klass;
    SootField internal;
    
    RType type;
    String name;

    public RField(RClass klass, SootField f) {
        this.klass = klass;
        this.internal = f;
    }

    public RType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

}
