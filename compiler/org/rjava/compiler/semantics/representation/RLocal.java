package org.rjava.compiler.semantics.representation;

import org.rjava.compiler.RJavaCompiler;

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
    
    /**
     * 
     * @param method
     * @param internal
     * @return null if cannot find the named local in such method
     */
    public static RLocal fromSootLocal(RMethod method, Local internal) {
        for (RLocal l : method.getLocals()) {
            if (l.internal.equals(internal))
                return l;
        }
        
        //RJavaCompiler.fail("cant find local: " + internal + " in method " + method.getName() + "()");
        return null;
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
