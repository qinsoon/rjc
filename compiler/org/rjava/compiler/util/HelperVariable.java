package org.rjava.compiler.util;

public class HelperVariable {
    public static final HelperVariable VOID_VAR = new HelperVariable("void", "");
    
    String type;
    String name;
    
    public HelperVariable(String type, String name) {
        super();
        this.type = type;
        this.name = name;
    }
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }    
}
