package org.rjava.compiler.pass;

import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.stmt.*;

import soot.jimple.StaticFieldRef;

public abstract class CompilationPass {
    public void start() {
        for (RClass klass : SemanticMap.classes.values())
            klass.accept(this);
    }
    
    /*
     * coarse grain compilation unit
     */
    public abstract void visit(RClass klass);
    public abstract void visit(RMethod method);
    public abstract void visit(RStatement stmt);
    
    /*
     * statement
     */
    public abstract void visit(RAssignStmt stmt);
    public abstract void visit(RBreakpointStmt stmt);
    public abstract void visit(REnterMonitorStmt stmt);
    public abstract void visit(RExitMonitorStmt stmt);
    public abstract void visit(RGotoStmt stmt);
    public abstract void visit(RIdentityStmt stmt);
    public abstract void visit(RIfStmt stmt);
    public abstract void visit(RInvokeStmt stmt);
    public abstract void visit(RLookupSwitchStmt stmt);
    public abstract void visit(RNopStmt stmt);
    public abstract void visit(RRetStmt stmt);
    public abstract void visit(RReturnStmt stmt);
    public abstract void visit(RReturnVoidStmt stmt);
    public abstract void visit(RTableSwitchStmt stmt);
    public abstract void visit(RThrowStmt stmt);
    
    /*
     * invoke expr
     */
    public abstract void visit(RInvokeExpr expr);
    
    /*
     * finer grained unit (soot unit)
     */
    public abstract void visit(RStatement stmt, StaticFieldRef staticRef);
}
