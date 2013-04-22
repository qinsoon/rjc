package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.CompilationUnit;
import org.rjava.compiler.pass.CompilationPass;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;

import soot.jimple.InvokeExpr;

public class RInvokeExpr implements CompilationUnit{
    RStatement stmt;
    InvokeExpr internal;
    public RInvokeExpr(InvokeExpr invokeExpr, RStatement stmt) {
        this.internal = invokeExpr;
        this.stmt = stmt;
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

    public RStatement getContainingStmt() {
        return stmt;
    }

    public InvokeExpr getInternal() {
        return internal;
    }

    @Override
    public void accept(CompilationPass pass) {
        pass.visit(this);
    }
}
