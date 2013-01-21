package org.rjava.compiler.targets.c;

import org.rjava.compiler.semantics.representation.RLocal;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.RType;
import org.rjava.compiler.semantics.representation.stmt.*;

import soot.Local;
import soot.Value;
import soot.jimple.InvokeExpr;
import soot.jimple.ParameterRef;
import soot.jimple.StaticFieldRef;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.internal.JIdentityStmt;
import soot.jimple.internal.JInvokeStmt;
import soot.jimple.internal.JSpecialInvokeExpr;
import soot.jimple.internal.JVirtualInvokeExpr;
import soot.jimple.internal.JimpleLocal;

public class CLanguageStatementGenerator {
    CLanguageNameGenerator name = new CLanguageNameGenerator();
    
    public CLanguageStatementGenerator() {
        // TODO Auto-generated constructor stub
    }
    
    /*
     * get from RLocal
     */
    public String get(RLocal local) {
        String ret = "";
        RType localType = local.getType();
        ret += name.get(localType);
        // array to pointer
        if (localType.isArray())
            ret += CLanguageGenerator.POINTER;
        if (!localType.isPrimitive() && !localType.isVoidType())
            ret += CLanguageGenerator.POINTER;
        ret += " " + local.getName();
        return ret;
    }
    
    /*
     * get from RStatement
     */
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
        JAssignStmt internal = stmt.internal();
        
        String ret = "";
        
        // left op -> local | field | local.field | local[imm]
        Value leftOp = internal.getLeftOp();
        if (leftOp instanceof soot.jimple.internal.JimpleLocal) {
            ret = ((soot.jimple.internal.JimpleLocal) leftOp).getName();
        } else {
            ret = CLanguageGenerator.INCOMPLETE_IMPLEMENTATION;
        }
        
        ret += " = ";
        
        // right op -> rvalue | imm
        // rvalue -> concreteRef | imm | expr
        // concreteRef -> field | local.field | local[imm]
        // expr -> imm1 binop imm2 | (type) imm | imm instanceof type | invokeExpr | new refType | newarray (type) [imm] | newmultiarray(type)[imm1]...[immn][]* | length imm | neg imm;
        // invokeExpr -> specialinvoke/interfaceinvoke/virtualinvoke local.m(imm1,...,immn) | staticinvoke m(imm1,...,immn)
        Value rightOp = internal.getRightOp();
        if (rightOp instanceof soot.jimple.StaticFieldRef) {
            ret += name.fromSootStaticFieldRef((StaticFieldRef) rightOp);
        } else {
            ret += CLanguageGenerator.INCOMPLETE_IMPLEMENTATION;
        }
        
        return ret;
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
        
        String ret = CLanguageGenerator.INCOMPLETE_IMPLEMENTATION;
        Value rightOp = internal.getRightOp();
        if (rightOp instanceof soot.jimple.ParameterRef) {
            // left op
            ret = internal.getLeftOp().toString() + " = ";
            
            // right op
            soot.jimple.ParameterRef parameterRef = (ParameterRef) rightOp;
            ret += CLanguageGenerator.FORMAL_PARAMETER + parameterRef.getIndex();
        } else if (rightOp instanceof soot.jimple.ThisRef) {
            ret = CLanguageGenerator.THIS_LOCAL + " = " + CLanguageGenerator.THIS_PARAMETER;
        }
        
        return ret;
    }
    
    private String get(RIfStmt stmt) {
        return "";
    }
    
    private String get(RInvokeStmt stmt) {
        JInvokeStmt internal = stmt.internal();
        InvokeExpr actualInvoke = internal.getInvokeExpr();
        
        String ret = "";
        
        if (actualInvoke instanceof soot.jimple.internal.JVirtualInvokeExpr) {
            ret = fromSootJVirtualInvokeExpr((JVirtualInvokeExpr) actualInvoke);
        } else if (actualInvoke instanceof soot.jimple.internal.JSpecialInvokeExpr) {
            ret = fromSootJSpecialInvokeExpr((JSpecialInvokeExpr) actualInvoke);
        }
        
        else {
            ret = CLanguageGenerator.INCOMPLETE_IMPLEMENTATION;
        }
        
        return ret;
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
        return "return";
    }
    
    private String get(RTableSwitchStmt stmt) {
        return "";
    }
    
    private String get(RThrowStmt stmt) {
        return "";
    }
    
    /*
     * from soot statement/expr representation
     */
    private String fromSootJVirtualInvokeExpr(soot.jimple.internal.JVirtualInvokeExpr virtualInvoke) {
        String methodName = name.fromSootMethod(virtualInvoke.getMethod());
        String base = name.fromSootLocal((Local) virtualInvoke.getBase());
        
        String ret = methodName + "(" + base;
        
        if (virtualInvoke.getArgCount() == 0)
            ret += ")";
        else {
            for (int i = 0; i < virtualInvoke.getArgCount(); i++) {
                ret += ", " + virtualInvoke.getArg(i).toString();
            }
            ret += ")";
        }
        
        return ret;
    }
    
    private String fromSootJSpecialInvokeExpr(soot.jimple.internal.JSpecialInvokeExpr specialInvoke) {
        String methodName = name.fromSootMethod(specialInvoke.getMethod());
        String base = name.fromSootLocal((Local) specialInvoke.getBase());
        
        String ret = methodName + "(" + base;
        
        if (specialInvoke.getArgCount() == 0)
            ret += ")";
        else {
            for (int i = 0; i < specialInvoke.getArgCount(); i++) {
                ret += ", " + specialInvoke.getArg(i).toString();
            }
            ret += ")";
        }
        
        return ret;
    }
}
