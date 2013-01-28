package org.rjava.compiler.targets.c;

import java.util.HashMap;
import java.util.Map;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RLocal;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.RType;
import org.rjava.compiler.semantics.representation.stmt.*;

import soot.Local;
import soot.PointsToAnalysis;
import soot.PointsToSet;
import soot.Scene;
import soot.SootClass;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.BinopExpr;
import soot.jimple.ConditionExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.NumericConstant;
import soot.jimple.ParameterRef;
import soot.jimple.StaticFieldRef;
import soot.jimple.StringConstant;
import soot.jimple.internal.AbstractStmt;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.internal.JGotoStmt;
import soot.jimple.internal.JIdentityStmt;
import soot.jimple.internal.JIfStmt;
import soot.jimple.internal.JInstanceFieldRef;
import soot.jimple.internal.JInterfaceInvokeExpr;
import soot.jimple.internal.JInvokeStmt;
import soot.jimple.internal.JNewExpr;
import soot.jimple.internal.JNopStmt;
import soot.jimple.internal.JSpecialInvokeExpr;
import soot.jimple.internal.JStaticInvokeExpr;
import soot.jimple.internal.JVirtualInvokeExpr;
import soot.jimple.internal.JimpleLocal;

public class CLanguageStatementGenerator {
    CLanguageNameGenerator name;
    CLanguageGenerator generator;
    
    
    private int labelIndex = 0;
    // <target.hashCode(), labelIndex>
    private Map<Integer, Integer> jumpLabels = new HashMap<Integer, Integer>();
    
    public CLanguageStatementGenerator(CLanguageGenerator generator) {
        this.generator = generator;
        name = new CLanguageNameGenerator(generator);
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

    private String get(RAssignStmt stmt) {
        JAssignStmt internal = stmt.internal();
        
        // left op -> local | field | local.field | local[imm]
        Value leftOp = internal.getLeftOp();
        String leftOpStr = CLanguageGenerator.INCOMPLETE_IMPLEMENTATION;
        
        if (leftOp instanceof soot.jimple.internal.JimpleLocal) {
            leftOpStr = name.fromSootLocal((Local) leftOp);
        } else if (leftOp instanceof soot.jimple.internal.JInstanceFieldRef) {
            leftOpStr = name.fromSootInstanceFieldRef((JInstanceFieldRef) leftOp);
        }            
        else {
            
        }
        
        // right op -> rvalue | imm
        // rvalue -> concreteRef | imm | expr
        // concreteRef -> field | local.field | local[imm]
        // expr -> imm1 binop imm2 | (type) imm | imm instanceof type | invokeExpr | new refType | newarray (type) [imm] | newmultiarray(type)[imm1]...[immn][]* | length imm | neg imm;
        // invokeExpr -> specialinvoke/interfaceinvoke/virtualinvoke local.m(imm1,...,immn) | staticinvoke m(imm1,...,immn)
        Value rightOp = internal.getRightOp();
        String rightOpStr = CLanguageGenerator.INCOMPLETE_IMPLEMENTATION;
        if (rightOp instanceof soot.jimple.StaticFieldRef) {
            rightOpStr = name.fromSootStaticFieldRef((StaticFieldRef) rightOp);
        } else if (rightOp instanceof soot.jimple.internal.JimpleLocal) {
            rightOpStr = name.fromSootLocal((Local) rightOp);
        } else if (rightOp instanceof soot.jimple.internal.JInstanceFieldRef) {
            rightOpStr = name.fromSootInstanceFieldRef((JInstanceFieldRef) rightOp);
        } else if (rightOp instanceof soot.jimple.internal.JVirtualInvokeExpr) {
            rightOpStr = fromSootJVirtualInvokeExpr((JVirtualInvokeExpr) rightOp);
        } else if (rightOp instanceof soot.jimple.BinopExpr) {
            rightOpStr = fromSootBinopExpr((BinopExpr) rightOp);
        } else if (rightOp instanceof soot.jimple.NumericConstant) {
            rightOpStr = fromSootNumericConstant((NumericConstant) rightOp);
        } else if (rightOp instanceof soot.jimple.internal.JNewExpr) {
            rightOpStr = fromSootJNewExpr((JNewExpr) rightOp);
        } else if (rightOp instanceof soot.jimple.StringConstant) {
            rightOpStr = fromSootStringConstant((soot.jimple.StringConstant) rightOp);
        }
        else {
            System.out.println(rightOp.getClass());
        }
        
        // check type
        String castStr = "";
        if (!leftOp.getType().equals(rightOp.getType())) {
            RType leftOpRType = RType.initWithClassName(leftOp.getType().toString());
            if (leftOpRType.isReferenceType()) 
                castStr = "(" + name.get(leftOpRType) + "*)";
        }
        
        return leftOpStr + " = " + castStr + rightOpStr;
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
        return "goto " + jumpToLabel((AbstractStmt) stmt.internal().getTarget());
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
        } else {

        }
        
        return ret;
    }
    
    private String get(RIfStmt stmt) {
        JIfStmt internal = stmt.internal();
        String ret = "";
        ret += "if (" + fromSootConditionExpr((ConditionExpr) internal.getCondition()) + ") ";
        ret += "goto " + jumpToLabel((AbstractStmt) internal.getTarget());
        return ret;
    }
    
    private String get(RInvokeStmt stmt) {
        JInvokeStmt internal = stmt.internal();
        InvokeExpr actualInvoke = internal.getInvokeExpr();
        
        String ret = "";
        
        if (actualInvoke instanceof soot.jimple.internal.JVirtualInvokeExpr) {
            ret = fromSootJVirtualInvokeExpr((JVirtualInvokeExpr) actualInvoke);
        } else if (actualInvoke instanceof soot.jimple.internal.JSpecialInvokeExpr) {
            ret = fromSootJSpecialInvokeExpr((JSpecialInvokeExpr) actualInvoke);
        } else if (actualInvoke instanceof soot.jimple.internal.JInterfaceInvokeExpr) {
            ret = fromSootJInterfaceInvokeExpr((JInterfaceInvokeExpr) actualInvoke);
        } else if (actualInvoke instanceof soot.jimple.internal.JStaticInvokeExpr) {
            ret = fromSootJStaticInvokeExpr((JStaticInvokeExpr) actualInvoke);
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
        // intentionally return empty
        return "";
    }
    
    private String get(RRetStmt stmt) {
        return "";
    }
    
    private String get(RReturnStmt stmt) {
        return CLanguageGenerator.RETURN + " " + stmt.internal().getOp();
    }
    
    private String get(RReturnVoidStmt stmt) {
        return CLanguageGenerator.RETURN;
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
        String callingClass = virtualInvoke.getMethod().getDeclaringClass().getName();
        if (callingClass.startsWith("java.") || callingClass.startsWith("javax.")) {
            return fromSootJVirtualInvokeExpr_libCall(virtualInvoke);
        } else return fromSootJVirtualInvokeExpr_appCall(virtualInvoke);
    }
    
    private String fromSootJVirtualInvokeExpr_libCall(soot.jimple.internal.JVirtualInvokeExpr virtualInvoke) {
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
    
    private String fromSootJVirtualInvokeExpr_appCall(soot.jimple.internal.JVirtualInvokeExpr virtualInvoke) {
        // for a call to cat.speak()
        // we will have ((Animal_class) ((RJava_Common_Instance*) cat) -> class_struct) -> speak(cat);
        //             1. who declares speak() 2. use common instance to get class_struct
        
        // get who declares speak() first
        RClass baseClass = RClass.fromClassName(virtualInvoke.getBase().getType().toString());
        RMethod callingMethod = baseClass.getMethodBySootSignature(virtualInvoke.getMethod().getSignature());
        RClass targetClass = RClass.whoOwnsMethodInTypeHierarchy(baseClass, callingMethod);
        
        // use class_struct to get function ptr
        String methodName = virtualInvoke.getMethod().getName();
        String base = name.fromSootLocal((Local) virtualInvoke.getBase());
        
        StringBuilder ret = new StringBuilder();
        ret.append("(");
        ret.append("(" + name.get(targetClass) + CLanguageGenerator.CLASS_STRUCT_SUFFIX + "*)");
        ret.append("(((" + CLanguageGenerator.COMMON_INSTANCE_STRUCT + "*) " + base + ")");
        ret.append(" -> " + CLanguageGenerator.POINTER_TO_CLASS_STRUCT + "))");
        ret.append(" -> " + methodName + "(" + base);   //base is the first parameter
        
        if (virtualInvoke.getArgCount() == 0)
            ret.append(")");
        else {
            for (int i = 0; i < virtualInvoke.getArgCount(); i++) {
                ret.append(", " + virtualInvoke.getArg(i).toString());
            }
            ret.append(")");
        }
        
        return ret.toString();
    }
    
    
    private String fromSootJInterfaceInvokeExpr(
            JInterfaceInvokeExpr invoke) {
        // for a call to cat.speak()
        // we will have ((Animal_class) ((RJava_Common_Instance*) cat) -> class_struct) -> speak(cat);
        //             1. who declares speak() 2. use common instance to get class_struct
        
        // get who declares speak() first
        RClass baseClass = RClass.fromClassName(invoke.getBase().getType().toString());
        RMethod callingMethod = baseClass.getMethodBySootSignature(invoke.getMethod().getSignature());
        RClass targetClass = RClass.whoOwnsMethodInTypeHierarchy(baseClass, callingMethod);
        
        // use class_struct to get function ptr
        String methodName = invoke.getMethod().getName();
        String base = name.fromSootLocal((Local) invoke.getBase());
        
        StringBuilder ret = new StringBuilder();
        ret.append("(");
        //ret.append("(" + name.get(targetClass) + CLanguageGenerator.CLASS_STRUCT_SUFFIX + "*)");
        ret.append("(((" + CLanguageGenerator.COMMON_INSTANCE_STRUCT + "*) " + base + ")");
        ret.append(" -> " + CLanguageGenerator.POINTER_TO_CLASS_STRUCT + "))");
        ret.append(" -> " + methodName + "(" + base);   //base is the first parameter
        
        if (invoke.getArgCount() == 0)
            ret.append(")");
        else {
            for (int i = 0; i < invoke.getArgCount(); i++) {
                ret.append(", " + invoke.getArg(i).toString());
            }
            ret.append(")");
        }
        
        return ret.toString();
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

    private String fromSootJStaticInvokeExpr(JStaticInvokeExpr actualInvoke) {
        String ret = "";
        ret = name.fromSootMethod(actualInvoke.getMethod());
        
        ret += "(";
        for (int i = 0; i < actualInvoke.getArgCount(); i++) { 
            ret += actualInvoke.getArg(i).toString();
            if (i != actualInvoke.getArgCount() - 1)
                ret += ", ";
        }
        ret += ")";
        return ret;
    }
    
    private String fromSootConditionExpr(soot.jimple.ConditionExpr conditionExpr) {
        return conditionExpr.toString();
    }
    
    private String fromSootBinopExpr(soot.jimple.BinopExpr binopExpr) {
        return binopExpr.toString();
    }
    
    private String fromSootNumericConstant(soot.jimple.NumericConstant numericConstant) {
        return numericConstant.toString();
    }

    private String fromSootStringConstant(StringConstant stringConstant) {
        return stringConstant.toString();
    }
    
    private String fromSootJNewExpr(soot.jimple.internal.JNewExpr newExpr) {
        String type = name.fromSootType(newExpr.getType());
        String ret = "(" + type + CLanguageGenerator.POINTER + ") " + CLanguageGenerator.MALLOC + "(";
        ret += CLanguageGenerator.SIZE_OF + "(" + type + "))";
        return ret;
    }
    
    /*
     * jumping labels
     */
    private String jumpToLabel(AbstractStmt target) {
        String ret = "label" + labelIndex;
        jumpLabels.put(target.hashCode(), labelIndex);
        labelIndex ++;
        return ret;
    }
    
    private String destLabel(RStatement stmt) {
        Integer labelIndex = jumpLabels.get(stmt.internal().hashCode());
        if (labelIndex == null)
            return "";
        else return "label" + labelIndex + ":";
    }
}
