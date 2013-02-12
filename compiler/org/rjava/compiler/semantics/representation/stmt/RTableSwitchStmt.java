package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;
import soot.jimple.internal.JTableSwitchStmt;

public class RTableSwitchStmt extends RStatement {

    public RTableSwitchStmt(RMethod method, Unit internal) {
	super(method, internal);
	// TODO Auto-generated constructor stub
    }

    public JTableSwitchStmt internal() {
        return (JTableSwitchStmt) internal;
    }
}
