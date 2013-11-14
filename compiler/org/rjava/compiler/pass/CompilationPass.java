package org.rjava.compiler.pass;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.stmt.*;
import org.rjava.compiler.util.ElapseTimer;

import soot.jimple.StaticFieldRef;

public abstract class CompilationPass {
    public void start(String passName) {
        ElapseTimer timer = new ElapseTimer(passName, true);
        timer.start();
        
        for (RClass klass : SemanticMap.getAllClasses().values())
            if (klass.isAppClass())
                klass.accept(this);
        
        timer.end();
    }
    
    /*
     * coarse grain compilation unit
     */
    public abstract void visit(RClass klass);
    public abstract void visit(RMethod method);
    public void visit(RStatement stmt) {
        switch(stmt.getType()) {
        case RStatement.ASSIGN_STMT: 
            visit((RAssignStmt)stmt); break;
        case RStatement.BREAKPOINT_STMT:
            visit((RBreakpointStmt)stmt); break;
        case RStatement.ENTER_MONITOR_STMT:
            visit((REnterMonitorStmt)stmt); break;
        case RStatement.EXIT_MONITOR_STMT:
            visit((RExitMonitorStmt)stmt); break;
        case RStatement.GOTO_STMT:
            visit((RGotoStmt)stmt); break;
        case RStatement.IDENTITY_STMT:
            visit((RIdentityStmt)stmt); break;
        case RStatement.IF_STMT:
            visit((RIfStmt)stmt); break;
        case RStatement.INVOKE_STMT:
            visit((RInvokeStmt)stmt); break;
        case RStatement.LOOKUP_SWITCH_STMT:
            visit((RLookupSwitchStmt)stmt); break;
        case RStatement.NOP_STMT:
            visit((RNopStmt)stmt); break;
        case RStatement.RET_STMT:
            visit((RRetStmt)stmt); break;
        case RStatement.RETURN_STMT:
            visit((RReturnStmt)stmt); break;
        case RStatement.RETURN_VOID_STMT:
            visit((RReturnVoidStmt)stmt); break;
        case RStatement.TABLE_SWITCH_STMT:
            visit((RTableSwitchStmt)stmt); break;
        case RStatement.THROW_STMT:
            visit((RThrowStmt)stmt); break;
        }
    }
    
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
