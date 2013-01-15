package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;
import soot.jimple.internal.JIdentityStmt;

public class RIdentityStmt extends RStatement {

    public RIdentityStmt(Unit internal) {
    	super(internal);
    	// TODO Auto-generated constructor stub
    }

    public JIdentityStmt internal() {
        return (JIdentityStmt) internal;
    }
}
