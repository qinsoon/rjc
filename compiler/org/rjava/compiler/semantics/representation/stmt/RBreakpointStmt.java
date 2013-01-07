package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;

public class RBreakpointStmt extends RStatement {

    public RBreakpointStmt(Unit internal) {
	super(internal);
    }

}
