package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RMethod;

import soot.jimple.InvokeExpr;

public class RInvokeExpr {
    InvokeExpr internal;
    public RInvokeExpr(InvokeExpr invokeExpr) {
        this.internal = invokeExpr;
    }
    
    /**
     * 
     * @return null if method is not in an application class
     */
    public RMethod getTargetMethod() {
        if (SemanticMap.isApplicationClass(internal.getMethod().getDeclaringClass().getName()))
            return RMethod.getFromSootMethod(internal.getMethod());
        else return null;
    }
}
