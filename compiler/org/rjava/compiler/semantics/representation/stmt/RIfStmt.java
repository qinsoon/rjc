package org.rjava.compiler.semantics.representation.stmt;

import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;

import soot.Unit;
import soot.jimple.ConditionExpr;
import soot.jimple.internal.*;

public class RIfStmt extends RStatement {

    public RIfStmt(RMethod method, AbstractStmt internal) {
	super(method, internal);
	// TODO Auto-generated constructor stub
    }

    public JIfStmt internal() {
        return (JIfStmt) internal;
    }
    
    public String toString() {
        soot.jimple.ConditionExpr conditionExpr = (soot.jimple.ConditionExpr)internal().getCondition();
        
        String ret = "if ";
        ret += conditionExpr.getOp1().toString();
        ret += "(" + conditionExpr.getOp1().getClass().toString() + ") ";
        ret += conditionExpr.getSymbol();
        ret += conditionExpr.getOp2().toString();
        ret += "(" + conditionExpr.getOp2().getClass().toString() + ") ";
        ret += "goto " + internal().getTarget();
        
        return ret;
    }
}
