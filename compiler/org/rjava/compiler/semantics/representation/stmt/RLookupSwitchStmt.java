package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;
import soot.jimple.internal.JLookupSwitchStmt;

public class RLookupSwitchStmt extends RStatement {

    public RLookupSwitchStmt(RMethod method, Unit internal) {
	super(method, internal);
	// TODO Auto-generated constructor stub
    }

    public JLookupSwitchStmt internal() {
        return (JLookupSwitchStmt) internal;
    }
}
