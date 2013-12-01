package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;
import soot.jimple.internal.AbstractStmt;

public class RThrowStmt extends RStatement {

    public RThrowStmt(RMethod method, AbstractStmt internal) {
	super(method, internal);
    }

}
