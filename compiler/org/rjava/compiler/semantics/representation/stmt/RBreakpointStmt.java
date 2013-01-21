package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;
import soot.jimple.internal.JBreakpointStmt;

public class RBreakpointStmt extends RStatement {

    public RBreakpointStmt(RMethod method, Unit internal) {
	super(method, internal);
    }
    
    public JBreakpointStmt internal() {
	return (JBreakpointStmt) internal;
    }
}
