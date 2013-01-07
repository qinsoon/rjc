package org.rjava.compiler.semantics.representation;

import java.util.HashMap;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.representation.stmt.*;

import soot.Unit;
import soot.UnitBox;
import soot.ValueBox;

public abstract class RStatement {
    public static final int ASSIGN_STMT = 1;
    public static final int BREAKPOINT_STMT = 2;
    public static final int ENTER_MONITOR_STMT = 3;
    public static final int EXIT_MONITOR_STMT = 4;
    public static final int GOTO_STMT = 5;
    public static final int IDENTITY_STMT = 6;
    public static final int IF_STMT = 7;
    public static final int INVOKE_STMT = 8;
    public static final int LOOKUP_SWITCH_STMT = 9;
    public static final int NOP_STMT = 10;
    public static final int RET_STMT = 11;
    public static final int RETURN_STMT = 12;
    public static final int RETURN_VOID_STMT = 13;
    public static final int TABLE_SWITCH_STMT = 14;
    public static final int THROW_STMT = 15;
    
    private static final HashMap<String, Integer> JIMPLE_STMT_MAP = new HashMap<String, Integer>();
    static {
	JIMPLE_STMT_MAP.put("class soot.jimple.internal.JAssignStmt", ASSIGN_STMT);
	JIMPLE_STMT_MAP.put("class soot.jimple.internal.JBreakpointStmt", BREAKPOINT_STMT);
	JIMPLE_STMT_MAP.put("class soot.jimple.internal.JEnterMonitorStmt", ENTER_MONITOR_STMT);
	JIMPLE_STMT_MAP.put("class soot.jimple.internal.JExitMonitorStmt", EXIT_MONITOR_STMT);
	JIMPLE_STMT_MAP.put("class soot.jimple.internal.JGotoStmt", GOTO_STMT);
	JIMPLE_STMT_MAP.put("class soot.jimple.internal.JIdentityStmt", IDENTITY_STMT);
	JIMPLE_STMT_MAP.put("class soot.jimple.internal.JIfStmt", IF_STMT);
	JIMPLE_STMT_MAP.put("class soot.jimple.internal.JInvokeStmt", INVOKE_STMT);
	JIMPLE_STMT_MAP.put("class soot.jimple.internal.JLookupSwitchStmt", LOOKUP_SWITCH_STMT);
	JIMPLE_STMT_MAP.put("class soot.jimple.internal.JNopStmt", NOP_STMT);
	JIMPLE_STMT_MAP.put("class soot.jimple.internal.JRetStmt", RET_STMT);
	JIMPLE_STMT_MAP.put("class soot.jimple.internal.JReturnStmt", RETURN_STMT);
	JIMPLE_STMT_MAP.put("class soot.jimple.internal.JReturnVoidStmt", RETURN_VOID_STMT);
	JIMPLE_STMT_MAP.put("class soot.jimple.internal.JTableSwitchStmt", TABLE_SWITCH_STMT);
	JIMPLE_STMT_MAP.put("class soot.jimple.internal.JThrowStmt", THROW_STMT);
    }
    
    private int type;
    protected Unit internal;

    protected RStatement(Unit internal) {
	super();
	this.internal = internal;
	try{
	    type = JIMPLE_STMT_MAP.get(internal.getClass().toString());
	} catch (Exception e) {
	    System.err.println("Cannot recognize statement type: " + internal.getClass());
	}
    }
    
    public static RStatement from(Unit jimpleUnit) {
	int type = JIMPLE_STMT_MAP.get(jimpleUnit.getClass().toString());
	switch(type) {
	case ASSIGN_STMT: 		return new RAssignStmt(jimpleUnit);
	case BREAKPOINT_STMT: 		return new RBreakpointStmt(jimpleUnit);
	case ENTER_MONITOR_STMT:	return new REnterMonitorStmt(jimpleUnit);
	case EXIT_MONITOR_STMT:		return new RExitMonitorStmt(jimpleUnit);
	case GOTO_STMT:			return new RGotoStmt(jimpleUnit);
	case IDENTITY_STMT:		return new RIdentityStmt(jimpleUnit);
	case IF_STMT:			return new RIfStmt(jimpleUnit);
	case INVOKE_STMT:		return new RInvokeStmt(jimpleUnit);
	case LOOKUP_SWITCH_STMT:	return new RLookupSwitchStmt(jimpleUnit);
	case NOP_STMT:			return new RNopStmt(jimpleUnit);
	case RET_STMT:			return new RRetStmt(jimpleUnit);
	case RETURN_STMT:		return new RReturnStmt(jimpleUnit);
	case RETURN_VOID_STMT:		return new RReturnVoidStmt(jimpleUnit);
	case TABLE_SWITCH_STMT:		return new RTableSwitchStmt(jimpleUnit);
	case THROW_STMT:		return new RThrowStmt(jimpleUnit);
	default:			RJavaCompiler.error("Unexpected statement type: " + type); return null;
	}
    }
    
    public String toString() {
	String ret = "[" + internal.getClass() + "]:" + internal.toString() + "\n";
	ret += "use/def boxes: \n";
	for (Object o : internal.getUseAndDefBoxes()) {
	    ValueBox b = (ValueBox) o;
	    ret += " " + b.getClass() + ": " + b.toString() + "\n";
	}
	ret += "unit boxes: \n";
	for (UnitBox b : internal.getUnitBoxes()) {
	    ret += " " + b.getClass() + ": " + b.toString() + "\n";
	}
	
	return ret;
    }

    public int getType() {
        return type;
    }
}
