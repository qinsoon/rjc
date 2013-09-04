package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.pass.CompilationPass;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;
import soot.jimple.StaticFieldRef;
import soot.jimple.internal.AbstractStmt;
import soot.jimple.internal.JAssignStmt;

public class RAssignStmt extends RStatement {
   public RAssignStmt(RMethod method, AbstractStmt internal) {
	super(method, internal);
    }

    public JAssignStmt internal() {
	return (JAssignStmt) internal;
    }
    
    @Override
    public void accept(CompilationPass pass) {
        super.accept(pass);
        if (internal().getLeftOp() instanceof StaticFieldRef)
            pass.visit(this, (StaticFieldRef)internal().getLeftOp());
        if (internal().getRightOp() instanceof StaticFieldRef)
            pass.visit(this, (StaticFieldRef)internal().getRightOp());
    }
    
    @Override
    public String toString() {
        String leftOp = internal().getLeftOp().getClass().toString();
        String rightOp = internal().getRightOp().getClass().toString();
        return super.toString() + "[left:" + leftOp + ",right:" + rightOp +"]";
    }
}
