package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;
import soot.jimple.internal.JInvokeStmt;

public class RInvokeStmt extends RStatement {

    public RInvokeStmt(Unit internal) {
	super(internal);
	// TODO Auto-generated constructor stub
    }

    public JInvokeStmt internal() {
        return (JInvokeStmt) internal;
    }
}
