package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;
import soot.jimple.internal.*;

public class RIfStmt extends RStatement {

    public RIfStmt(RMethod method, Unit internal) {
	super(method, internal);
	// TODO Auto-generated constructor stub
    }

    public JIfStmt internal() {
        return (JIfStmt) internal;
    }
}
