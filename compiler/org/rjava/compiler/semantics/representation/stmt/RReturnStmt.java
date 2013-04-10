package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;
import soot.jimple.internal.AbstractStmt;
import soot.jimple.internal.JReturnStmt;

public class RReturnStmt extends RStatement {

    public RReturnStmt(RMethod method, AbstractStmt internal) {
	super(method, internal);
	// TODO Auto-generated constructor stub
    }

    public JReturnStmt internal() {
        return (JReturnStmt) internal;
    }
}
