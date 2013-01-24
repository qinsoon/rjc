package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;
import soot.jimple.internal.JIdentityStmt;

public class RIdentityStmt extends RStatement {

    public RIdentityStmt(RMethod method, Unit internal) {
    	super(method, internal);
    	// TODO Auto-generated constructor stub
    }

    public JIdentityStmt internal() {
        return (JIdentityStmt) internal;
    }
    
    public boolean isFetchingThisParameter() {
        return internal().getLeftOp().toString().equals("this") && (internal().getRightOp() instanceof soot.jimple.ThisRef);
    }
}
