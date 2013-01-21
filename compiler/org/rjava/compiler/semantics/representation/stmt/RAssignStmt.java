package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;
import soot.jimple.internal.JAssignStmt;

public class RAssignStmt extends RStatement {
   public RAssignStmt(RMethod method, Unit internal) {
	super(method, internal);
    }

    public JAssignStmt internal() {
	return (JAssignStmt) internal;
    }
}
