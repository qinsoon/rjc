package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;

public class RThrowStmt extends RStatement {

    public RThrowStmt(RMethod method, Unit internal) {
	super(method, internal);
    }

}
