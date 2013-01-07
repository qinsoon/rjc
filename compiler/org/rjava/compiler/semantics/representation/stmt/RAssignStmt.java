package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;
import soot.jimple.internal.JAssignStmt;

public class RAssignStmt extends RStatement {
   public RAssignStmt(Unit internal) {
	super(internal);
    }

    public JAssignStmt internal() {
	return (JAssignStmt) internal;
    }
}
