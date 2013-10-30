package org.rjava.compiler.targets.c;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.exception.RJavaError;
import org.rjava.compiler.pass.ConstantPropagationPass;
import org.rjava.compiler.pass.PointsToAnalysisPass;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RField;
import org.rjava.compiler.semantics.representation.RLocal;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.RType;
import org.rjava.compiler.semantics.representation.stmt.*;
import org.rjava.compiler.targets.c.runtime.CLanguageRuntime;
import org.rjava.compiler.targets.c.runtime.RuntimeHelpers;
import org.rjava.compiler.util.HelperMethod;
import org.rjava.compiler.util.Statistics;

import soot.Local;
import soot.PointsToAnalysis;
import soot.PointsToSet;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.BinopExpr;
import soot.jimple.ConditionExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.NullConstant;
import soot.jimple.NumericConstant;
import soot.jimple.ParameterRef;
import soot.jimple.StaticFieldRef;
import soot.jimple.StringConstant;
import soot.jimple.internal.AbstractStmt;
import soot.jimple.internal.JArrayRef;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.internal.JCastExpr;
import soot.jimple.internal.JCmpExpr;
import soot.jimple.internal.JCmpgExpr;
import soot.jimple.internal.JCmplExpr;
import soot.jimple.internal.JEnterMonitorStmt;
import soot.jimple.internal.JEqExpr;
import soot.jimple.internal.JExitMonitorStmt;
import soot.jimple.internal.JGotoStmt;
import soot.jimple.internal.JIdentityStmt;
import soot.jimple.internal.JIfStmt;
import soot.jimple.internal.JInstanceFieldRef;
import soot.jimple.internal.JInstanceOfExpr;
import soot.jimple.internal.JInterfaceInvokeExpr;
import soot.jimple.internal.JInvokeStmt;
import soot.jimple.internal.JLengthExpr;
import soot.jimple.internal.JLookupSwitchStmt;
import soot.jimple.internal.JNeExpr;
import soot.jimple.internal.JNegExpr;
import soot.jimple.internal.JNewArrayExpr;
import soot.jimple.internal.JNewExpr;
import soot.jimple.internal.JNewMultiArrayExpr;
import soot.jimple.internal.JNopStmt;
import soot.jimple.internal.JSpecialInvokeExpr;
import soot.jimple.internal.JStaticInvokeExpr;
import soot.jimple.internal.JTableSwitchStmt;
import soot.jimple.internal.JUshrExpr;
import soot.jimple.internal.JVirtualInvokeExpr;
import soot.jimple.internal.JimpleLocal;

public class CStatements {
    CIdentifiers id;
    CLanguageGenerator generator;
    CExpressions expr;
    
    private int labelIndex = 0;
    // <target.hashCode(), labelIndex>
    private Map<Integer, Integer> jumpLabels = new HashMap<Integer, Integer>();
    
    public CStatements(CLanguageGenerator generator) {
        this.generator = generator;
        id = new CIdentifiers(generator);
        expr = new CExpressions(generator);
    }
    
    /*
     * get from RLocal
     */
    public String get(RLocal local) {
        String ret = "";
        RType localType = local.getType();
        ret += id.get(localType);
        // array to pointer
        if (localType.isArray())
            ret += CLanguageGenerator.POINTER;
        if (!localType.isPrimitive() && !localType.isVoidType() && !local.isByValue())
            ret += CLanguageGenerator.POINTER;
        ret += " " + local.getName();
        return ret;
    }
    
    /*
     * get from RStatement
     */
    public String get(RStatement stmt) throws RJavaError {
        switch (stmt.getType()) {
            case RStatement.ASSIGN_STMT:            return destLabel(stmt) + get((RAssignStmt) stmt);
            case RStatement.BREAKPOINT_STMT:        return destLabel(stmt) + get((RBreakpointStmt) stmt);
            case RStatement.ENTER_MONITOR_STMT:     return destLabel(stmt) + get((REnterMonitorStmt) stmt);
            case RStatement.EXIT_MONITOR_STMT:      return destLabel(stmt) + get((RExitMonitorStmt) stmt);
            case RStatement.GOTO_STMT:              return destLabel(stmt) + get((RGotoStmt) stmt);
            case RStatement.IDENTITY_STMT:          return destLabel(stmt) + get((RIdentityStmt) stmt);
            case RStatement.IF_STMT:                return destLabel(stmt) + get((RIfStmt) stmt);
            case RStatement.INVOKE_STMT:            return destLabel(stmt) + get((RInvokeStmt) stmt);
            case RStatement.LOOKUP_SWITCH_STMT:     return destLabel(stmt) + get((RLookupSwitchStmt) stmt);
            case RStatement.NOP_STMT:               return destLabel(stmt) + get((RNopStmt) stmt);
            case RStatement.RET_STMT:               return destLabel(stmt) + get((RRetStmt) stmt);
            case RStatement.RETURN_STMT:            return destLabel(stmt) + get((RReturnStmt) stmt);
            case RStatement.RETURN_VOID_STMT:       return destLabel(stmt) + get((RReturnVoidStmt) stmt);
            case RStatement.TABLE_SWITCH_STMT:      return destLabel(stmt) + get((RTableSwitchStmt) stmt);
            case RStatement.THROW_STMT:             return destLabel(stmt) + get((RThrowStmt) stmt);
            default: return null;
        }
    }

    private String get(RAssignStmt stmt) throws RJavaError {
        JAssignStmt internal = stmt.internal();
        

        Value leftOp = internal.getLeftOp();
        String leftOpStr = expr.fromSootLValue(leftOp);
        
        Value rightOp = internal.getRightOp();
        String rightOpStr = expr.fromSootRValue(rightOp);
        
        // check type
        String rightOpWithCast = expr.typeCasting(leftOp.getType(), rightOp.getType(), rightOpStr);
        
        if (RJavaCompiler.OPT_OBJECT_INLINING) {
            if (leftOp instanceof JInstanceFieldRef) {
                JInstanceFieldRef lInstanceRef = (JInstanceFieldRef) leftOp;
                // if leftOp's base is a by-value local, then we need to find out the actual memory to store
                if (lInstanceRef.getBase() instanceof Local && RLocal.fromSootLocal(generator.getMethodContext(), ((Local) lInstanceRef.getBase())).isByValue()) {
                    RJavaCompiler.println("-checking actual memory store for " + lInstanceRef);
                    List<Value> pointsTo = SemanticMap.pta.tracePointsTo(lInstanceRef.getBase());
                    Value lastNonByValue = null;
                    for (Value v : pointsTo) {
                        RJavaCompiler.print("->" + v);
                        boolean isLocal = v instanceof Local;
                        boolean isLocalInSameContext = false;
                        boolean isLocalByValue = false;
                        if (isLocal) {
                            RLocal rl = RLocal.fromSootLocal(generator.getMethodContext(), (Local) v);
                            isLocalInSameContext = rl != null;
                            if (isLocalInSameContext)
                                isLocalByValue = rl.isByValue();
                        }
                        if ((!isLocal || (isLocal && isLocalInSameContext && !isLocalByValue)) && expr.isValidSootLValue(v)) {
                            lastNonByValue = v;
                            RJavaCompiler.print(" [actualMemoryStore]");
                        }
                        RJavaCompiler.println("");
                    }
                    
                    RJavaCompiler.assertion(lastNonByValue != null, "failed to find an actual memory storage for " + leftOp);
                    
                    leftOpStr = expr.fromSootInstanceFieldRef(lInstanceRef, expr.fromSootLValue(lastNonByValue));
                }
            }
            
            if (leftOp instanceof JInstanceFieldRef && RField.fromSootField(((JInstanceFieldRef)leftOp).getField()).isInlinable()) {                
                if (rightOp instanceof JimpleLocal && RLocal.fromSootLocal(generator.getMethodContext(), (Local) rightOp).isByValue())
                    return leftOpStr + " = " + expr.typeCastingByValue(leftOp.getType(), rightOp.getType(), rightOpStr);
                else return leftOpStr + " = *(" + rightOpWithCast + ")";
            }
            
            if (rightOp instanceof JInstanceFieldRef && RField.fromSootField(((JInstanceFieldRef)rightOp).getField()).isInlinable()) {
                if (leftOp instanceof JimpleLocal && RLocal.fromSootLocal(generator.getMethodContext(), (Local) leftOp).isByValue())
                    return leftOpStr + " = " + expr.typeCastingByValue(leftOp.getType(), rightOp.getType(), rightOpStr);
                else return leftOpStr + " = &(" + rightOpWithCast + ")";
            }
        }
        
        if (RJavaCompiler.OPT_CONSTANT_PROPAGATION) {
            if (SemanticMap.cp.isConstant(leftOp)) {
                if (ConstantPropagationPass.ASSERT_CORRECTNESS) {
                    String assertion = "assert (" + leftOpStr + " == " + id.fromJavaNumber(SemanticMap.cp.getConstant(leftOp)) + ")";
                    return leftOpStr + " = " + rightOpWithCast + ";" + assertion;
                }
                if (ConstantPropagationPass.USE_CONSTANT) {
                    String constantRight = id.fromJavaNumber(SemanticMap.cp.getConstant(leftOp));
                    return leftOpStr + " = " + expr.typeCasting(leftOp.getType(), rightOp.getType(), constantRight);
                }
            }
        }
        
        if (PointsToAnalysisPass.DEBUG) {
            Type inferred = SemanticMap.pta.inferType(leftOp);
            String typeInferenceInfo = "";
            for (Value v : SemanticMap.pta.tracePointsTo(leftOp)) {
                typeInferenceInfo += v + "->";
            }
            typeInferenceInfo += inferred != null ? inferred.toString()
                    : "???";
            return leftOpStr + " = " + rightOpWithCast + Code.commentln(typeInferenceInfo);
        }
        
        return leftOpStr + " = " + rightOpWithCast;        
    }

    private String get(RBreakpointStmt stmt) throws RJavaError {
        throw stmt.newIncompleteImplementationError("BreakpointStmt");
    }
    
    private String get(REnterMonitorStmt stmt) throws RJavaError {
        JEnterMonitorStmt internal = stmt.internal();
        return "pthread_mutex_lock(&(((" + CLanguageRuntime.COMMON_INSTANCE_STRUCT + "*) " + id.fromSootValue(internal.getOp()) + ") -> " + CLanguageRuntime.INSTANCE_MUTEX + "))";
    }
    
    private String get(RExitMonitorStmt stmt) throws RJavaError {
        JExitMonitorStmt internal = stmt.internal();
        return "pthread_mutex_unlock(&(((" + CLanguageRuntime.COMMON_INSTANCE_STRUCT + "*) " + id.fromSootValue(internal.getOp()) + ") -> " + CLanguageRuntime.INSTANCE_MUTEX + "))";
    }
    
    private String get(RGotoStmt stmt) {
        return "goto " + jumpToLabel((AbstractStmt) stmt.internal().getTarget());
    }
    
    private String get(RIdentityStmt stmt) throws RJavaError {
        JIdentityStmt internal = stmt.internal();
        
        String ret = CLanguageGenerator.INCOMPLETE_IMPLEMENTATION;
        Value rightOp = internal.getRightOp();
        if (rightOp instanceof soot.jimple.ParameterRef) {
            // left op
            ret = id.fromSootValue(internal.getLeftOp()) + " = ";
            
            // right op
            soot.jimple.ParameterRef parameterRef = (ParameterRef) rightOp;
            ret += CLanguageGenerator.FORMAL_PARAMETER + parameterRef.getIndex();
        } else if (rightOp instanceof soot.jimple.ThisRef) {
            ret = id.fromSootValue(internal.getLeftOp()) + " = " + CLanguageGenerator.THIS_PARAMETER;
        } else if (rightOp instanceof soot.jimple.internal.JCaughtExceptionRef) {
            ret = exceptionLabel(stmt);
        }
        else {
            throw stmt.newIncompleteImplementationError("rightOp:" + rightOp.getClass());
        }
        
        return ret;
    }
    
    private String get(RIfStmt stmt) {
        JIfStmt internal = stmt.internal();
        String ret = "";
        ret += "if (" + expr.fromSootConditionExpr((ConditionExpr) internal.getCondition()) + ") ";
        ret += "goto " + jumpToLabel((AbstractStmt) internal.getTarget());
        return ret;
    }
    
    private String get(RInvokeStmt stmt) throws RJavaError {
        JInvokeStmt internal = stmt.internal();
        InvokeExpr actualInvoke = internal.getInvokeExpr();
        
        return expr.fromSootInvokeExpr(actualInvoke);
    }
    
    private String get(RNopStmt stmt) {
        // intentionally return empty
        return CLanguageGenerator.SEMICOLON + Code.comment("nop");
    }
    
    private String get(RRetStmt stmt) throws RJavaError {
        throw stmt.newIncompleteImplementationError("RetStmt");
    }
    
    private String get(RReturnStmt stmt) {
        RType returnType = stmt.getMethod().getReturnType();
        RType valueType = RType.initWithSootType(stmt.internal().getOp().getType());
        return CLanguageGenerator.RETURN + " " + expr.typeCasting(returnType, valueType, id.fromSootValue(stmt.internal().getOp()));
    }
    
    private String get(RReturnVoidStmt stmt) {
        return CLanguageGenerator.RETURN;
    }
    
    private String get(RTableSwitchStmt stmt) {
        JTableSwitchStmt internal = stmt.internal();
        StringBuilder ret = new StringBuilder();
        
        ret.append("switch (" + internal.getKey().toString() + ") {\n");
        for (int i = internal.getLowIndex(); i <= internal.getHighIndex(); i++) {
            ret.append("  case " + i + ":");
            ret.append("goto " + this.jumpToLabel((AbstractStmt) internal.getTarget(i - internal.getLowIndex())) + ";\n");
        }
        ret.append("  default: goto " + this.jumpToLabel((AbstractStmt) internal.getDefaultTarget()) + ";\n");
        ret.append("  }");
        return ret.toString();
    }
    
    private String get(RLookupSwitchStmt stmt) throws RJavaError {
        JLookupSwitchStmt internal = stmt.internal();
        StringBuilder ret = new StringBuilder();
        
        ret.append("switch (" + id.fromSootValue(internal.getKey()) + ") {\n");
        for (int i = 0; i < internal.getLookupValues().size(); i++) {
            ret.append("  case " + internal.getLookupValue(i) + ":");
            ret.append("goto " + jumpToLabel((AbstractStmt) internal.getTarget(i)) + ";\n");
        }
        ret.append("  default: goto " + jumpToLabel((AbstractStmt) internal.getDefaultTarget()) + ";\n");
        ret.append("  }");
        return ret.toString();
    }
    
    private String get(RThrowStmt stmt) throws RJavaError {
        return Code.comment(stmt.internal().toString());
    }
    
    /*
     * from soot statement/expr representation
     */  
    
    /*
     * jumping labels
     */
    private String jumpToLabel(AbstractStmt target) {
        if (jumpLabels.containsKey(target.hashCode()))
            return "label" + jumpLabels.get(target.hashCode());
        
        String ret = "label" + labelIndex;
        jumpLabels.put(target.hashCode(), labelIndex);
        labelIndex ++;
        return ret;
    }
    
    private String exceptionLabel(RStatement stmt) {
        Integer storedLabel = jumpLabels.get(stmt.internal().hashCode());
        if (storedLabel == null) {
            String ret = "label" + labelIndex + ":" + Code.comment("exception handler");
            jumpLabels.put(stmt.internal().hashCode(), labelIndex);
            labelIndex ++;
            return ret;
        }
        else return "label" + storedLabel + ":" + Code.comment("exception handler");
    }
    
    private String destLabel(RStatement stmt) {
        if (stmt.internal().getBoxesPointingToThis().size() == 0)
            return "";
        
        Integer storedLabel = jumpLabels.get(stmt.internal().hashCode());
        if (storedLabel == null) {
            String ret = "label" + labelIndex + ":";
            jumpLabels.put(stmt.internal().hashCode(), labelIndex);
            labelIndex ++;
            return ret;
        }
        else return "label" + storedLabel + ":";
    }
}
