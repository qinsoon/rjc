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
        
        this.type = RType.initWithClassName(f.getType().toString());
        this.name = f.getName();
    }

    public RType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public boolean isStatic() {
        return internal.isStatic();
    }
    
    public boolean isFinal() {
        return internal.isFinal();
    }
    
    public RClass getDeclaringClass() {
        return klass;
    }
    
    public boolean equals(Object another) {
        return internal.equals(((RField)another).internal);
    }
}
