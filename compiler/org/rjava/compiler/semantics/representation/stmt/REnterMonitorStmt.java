package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;
import soot.jimple.internal.AbstractStmt;
import soot.jimple.internal.JEnterMonitorStmt;

public class REnterMonitorStmt extends RStatement {

    public REnterMonitorStmt(RMethod method, AbstractStmt internal) {
	super(method, internal);
	// TODO Auto-generated constructor stub
    }

    public JEnterMonitorStmt internal() {
        return (JEnterMonitorStmt) internal;
    }
}
