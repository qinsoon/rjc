package org.rjava.compiler.semantics.symtab;

import org.rjava.compiler.semantics.representation.RType;

public class RIdentifier {
    RType type;
    String id;
    
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
    public void setArray(boolean array) {
        this.type.setArray(array);
    }
    
    public String toString() {
	return type + " " + id;
    }
}
