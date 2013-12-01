package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;
import soot.jimple.internal.AbstractStmt;
import soot.jimple.internal.JInvokeStmt;
import soot.jimple.internal.JSpecialInvokeExpr;

public class RInvokeStmt extends RStatement {

    public RInvokeStmt(RMethod method, AbstractStmt internal) {
	super(method, internal);
	// TODO Auto-generated constructor stub
    }

    public JInvokeStmt internal() {
        return (JInvokeStmt) internal;
    }
    
    public boolean isInvokingSuperInit() {
        if (!method.getKlass().hasSuperClass())
            return false;
        
        // 1. special invoke
        // 2. calling to super class
        // 3. method name is <init>
        boolean cond1 = internal().getInvokeExpr() instanceof JSpecialInvokeExpr;
        boolean cond2 = internal().getInvokeExpr().getMethod().getDeclaringClass().getName().equals(method.getKlass().getSuperClass().getName());
        boolean cond3 = internal().getInvokeExpr().getMethod().getName().equals("<init>");
        return cond1 && cond2 && cond3;
    }
}
