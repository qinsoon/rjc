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
    
    public static final boolean verboseUseBoxes = true;
    
    @Override
    public String toString() {
        String leftOp = internal().getLeftOp().getClass().toString();
        String rightOp = internal().getRightOp().getClass().toString();
        
        StringBuilder ret = new StringBuilder();
        ret.append(super.toString() + "\n[left:" + leftOp + ",right:" + rightOp +"]");
        
        if (verboseUseBoxes) {
            ret.append("\nRH Useboxes:\n");
            for (Object o : internal().getRightOp().getUseBoxes()) {
                ret.append("-" + o.toString() + "\n");
            }
            ret.append("LH Useboxes:\n");
            for (Object o : internal().getLeftOp().getUseBoxes()) {
                ret.append("-" + o.toString() + "\n");
            }
        }
        
        return ret.toString(); 
    }
}
