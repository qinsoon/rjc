package org.rjava.compiler.semantics.representation;

import java.util.HashMap;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.exception.RJavaError;
import org.rjava.compiler.semantics.representation.stmt.*;

import soot.Unit;
import soot.UnitBox;
import soot.ValueBox;
import soot.jimple.InvokeExpr;
import soot.jimple.internal.AbstractStmt;
import soot.tagkit.LineNumberTag;
import soot.tagkit.Tag;

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
    
    protected RMethod method;
    
    private int type;
    protected Unit internal;
    private int lineNumber;
    
    /**
     * some statements are intrinsic, which means the compiler will generate its code based on predefined rules. 
     */
    private boolean intrinsic;
    private String code;        // if a statement is intrinsic, we store its code here (it might be generated in a different pass rather than normal code generation)

    protected RStatement(RMethod method, Unit internal) {
    	super();
    	this.method = method;
    	this.internal = internal;
    	
    	// get line number
    	for (Tag tag : this.internal.getTags()) {
    	    if (tag instanceof LineNumberTag) {
    	        this.lineNumber = ((LineNumberTag) tag).getLineNumber();
    	    }
    	}
    	
    	try{
    	    type = JIMPLE_STMT_MAP.get(internal.getClass().toString());
    	} catch (Exception e) {
    	    RJavaCompiler.error("Cannot recognize statement type: " + internal.getClass());
    	}
    }
    
    public static RStatement from(RMethod method, Unit jimpleUnit) {
        int type = JIMPLE_STMT_MAP.get(jimpleUnit.getClass().toString());
    	switch(type) {
        	case ASSIGN_STMT: 		return new RAssignStmt(method, jimpleUnit);
        	case BREAKPOINT_STMT: 		return new RBreakpointStmt(method, jimpleUnit);
        	case ENTER_MONITOR_STMT:	return new REnterMonitorStmt(method, jimpleUnit);
        	case EXIT_MONITOR_STMT:		return new RExitMonitorStmt(method, jimpleUnit);
        	case GOTO_STMT:			return new RGotoStmt(method, jimpleUnit);
        	case IDENTITY_STMT:		return new RIdentityStmt(method, jimpleUnit);
        	case IF_STMT:			return new RIfStmt(method, jimpleUnit);
        	case INVOKE_STMT:		return new RInvokeStmt(method, jimpleUnit);
        	case LOOKUP_SWITCH_STMT:	return new RLookupSwitchStmt(method, jimpleUnit);
        	case NOP_STMT:			return new RNopStmt(method, jimpleUnit);
        	case RET_STMT:			return new RRetStmt(method, jimpleUnit);
        	case RETURN_STMT:		return new RReturnStmt(method, jimpleUnit);
        	case RETURN_VOID_STMT:		return new RReturnVoidStmt(method, jimpleUnit);
        	case TABLE_SWITCH_STMT:		return new RTableSwitchStmt(method, jimpleUnit);
        	case THROW_STMT:		return new RThrowStmt(method, jimpleUnit);
        	default:			RJavaCompiler.error("Unexpected statement type: " + type); return null;
    	}
    }
    
    public static final boolean verbose = false;
    public static final boolean verboseInvoke = false;
    
    public String toString() {
	String ret = "[" + internal.getClass() + "]:" + internal.toString();
	if (verboseInvoke && internal().containsInvokeExpr()) {
	    ret += ",invoke base:";
	    InvokeExpr invoke = internal().getInvokeExpr();
	    if (invoke instanceof soot.jimple.internal.JSpecialInvokeExpr) {
	        ret += ((soot.jimple.internal.JSpecialInvokeExpr) invoke).getBase().getType();
	    } else if (invoke instanceof soot.jimple.internal.JVirtualInvokeExpr) {
	        ret += ((soot.jimple.internal.JVirtualInvokeExpr) invoke).getBase().getType();
	    } else ret += "non-virtual invoke";
	}
	if (verbose) {
        	ret += "\nuse/def boxes: \n";
        	for (Object o : internal.getUseAndDefBoxes()) {
        	    ValueBox b = (ValueBox) o;
        	    ret += " " + b.getClass() + ": " + b.toString() + "\n";
        	}
        	ret += "unit boxes: \n";
        	for (UnitBox b : internal.getUnitBoxes()) {
        	    ret += " " + b.getClass() + ": " + b.toString() + "\n";
        	}
	}
	
	return ret;
    }

    public int getType() {
        return type;
    }
    
    public AbstractStmt internal() {
        return (AbstractStmt) internal;
    }

    public boolean isIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(boolean intrinsic) {
        this.intrinsic = intrinsic;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public boolean isReturnStmt() {
        return type == this.RET_STMT || type == this.RETURN_STMT || type == this.RETURN_VOID_STMT;
    }
    
    public RMethod getMethod() {
        return method;
    }

    public int getLineNumber() {
        return lineNumber;
    }
    
    public RJavaError newIncompleteImplementationError(String msg) {
        return new RJavaError(this.getMethod().getKlass().getName() + "." + getMethod().getName() + "()," + getLineNumber() + ":" + msg); 
    }
}
