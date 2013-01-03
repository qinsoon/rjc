package org.rjava.compiler.semantics.symtab;

import org.rjava.compiler.semantics.representation.RType;

public class RIdentifier {
    RType type;
    String id;
    boolean array;
    
    public RType getType() {
        return type;
    }
    public void setType(RType type) {
        this.type = type;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public boolean isArray() {
        return array;
    }
    public void setArray(boolean array) {
        this.array = array;
    }
    
    public String toString() {
	return type.getClassName() + " " + id + (array ? "[]":"");
    }
}
