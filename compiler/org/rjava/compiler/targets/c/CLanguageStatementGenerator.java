package org.rjava.compiler.targets.c;

import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.stmt.*;

import soot.jimple.internal.JIdentityStmt;

public class CLanguageStatementGenerator {

    public CLanguageStatementGenerator() {
        // TODO Auto-generated constructor stub
    }
    
    public String get(RStatement stmt) {
        switch (stmt.getType()) {
        case RStatement.ASSIGN_STMT:            return get((RAssignStmt) stmt);
        case RStatement.BREAKPOINT_STMT:        return get((RBreakpointStmt) stmt);
        case RStatement.ENTER_MONITOR_STMT:     return get((REnterMonitorStmt) stmt);
        case RStatement.EXIT_MONITOR_STMT:      return get((RExitMonitorStmt) stmt);
        case RStatement.GOTO_STMT:              return get((RGotoStmt) stmt);
        case RStatement.IDENTITY_STMT:          return get((RIdentityStmt) stmt);
        case RStatement.IF_STMT:                return get((RIfStmt) stmt);
        case RStatement.INVOKE_STMT:            return get((RInvokeStmt) stmt);
        case RStatement.LOOKUP_SWITCH_STMT:     return get((RLookupSwitchStmt) stmt);
        case RStatement.NOP_STMT:               return get((RNopStmt) stmt);
        case RStatement.RET_STMT:               return get((RRetStmt) stmt);
        case RStatement.RETURN_STMT:            return get((RReturnStmt) stmt);
        case RStatement.RETURN_VOID_STMT:       return get((RReturnVoidStmt) stmt);
        case RStatement.TABLE_SWITCH_STMT:      return get((RTableSwitchStmt) stmt);
        case RStatement.THROW_STMT:             return get((RThrowStmt) stmt);
        default: return null;
        }
    }

    private String get(RAssignStmt stmt) {
        return "";
    }
    
    private String get(RBreakpointStmt stmt) {
        return "";
    }
    
    private String get(REnterMonitorStmt stmt) {
        return "";
    }
    
    private String get(RExitMonitorStmt stmt) {
        return "";
    }
    
    private String get(RGotoStmt stmt) {
        return "";
    }
    
    private String get(RIdentityStmt stmt) {
        JIdentityStmt internal = stmt.internal();
        return "";
    }
    
    private String get(RIfStmt stmt) {
        return "";
    }
    
    private String get(RInvokeStmt stmt) {
        return "";
    }
    
    private String get(RLookupSwitchStmt stmt) {
        return "";
    }
    
    private String get(RNopStmt stmt) {
        return "";
    }
    
    private String get(RRetStmt stmt) {
        return "";
    }
    
    private String get(RReturnStmt stmt) {
        return "";
    }
    
    private String get(RReturnVoidStmt stmt) {
        return "";
    }
    
    private String get(RTableSwitchStmt stmt) {
        return "";
    }
    
    private String get(RThrowStmt stmt) {
        return "";
    }
}
