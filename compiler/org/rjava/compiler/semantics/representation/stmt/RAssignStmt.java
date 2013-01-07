package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.RValue;
import org.rjava.compiler.semantics.representation.value.variable.*;

import soot.Unit;
import soot.jimple.internal.JAssignStmt;

public class RAssignStmt extends RStatement {
    RVariable left;
    RValue right;

    public RAssignStmt(Unit internal) {
	super(internal);
	this.left = RVariable.from(internal().leftBox.getValue());
	this.right = RValue.from(internal().rightBox.getValue());
    }

    private JAssignStmt internal() {
	return (JAssignStmt) internal;
    }
}
