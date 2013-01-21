package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;
import soot.jimple.internal.JInvokeStmt;

public class RInvokeStmt extends RStatement {

    public RInvokeStmt(RMethod method, Unit internal) {
	super(method, internal);
	// TODO Auto-generated constructor stub
    }

    public JInvokeStmt internal() {
        return (JInvokeStmt) internal;
    }
}
