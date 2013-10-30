package org.rjava.compiler.pass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.RType;
import org.rjava.compiler.semantics.representation.stmt.RAssignStmt;
import org.rjava.compiler.semantics.representation.stmt.RBreakpointStmt;
import org.rjava.compiler.semantics.representation.stmt.REnterMonitorStmt;
import org.rjava.compiler.semantics.representation.stmt.RExitMonitorStmt;
import org.rjava.compiler.semantics.representation.stmt.RGotoStmt;
import org.rjava.compiler.semantics.representation.stmt.RIdentityStmt;
import org.rjava.compiler.semantics.representation.stmt.RIfStmt;
import org.rjava.compiler.semantics.representation.stmt.RInvokeExpr;
import org.rjava.compiler.semantics.representation.stmt.RInvokeStmt;
import org.rjava.compiler.semantics.representation.stmt.RLookupSwitchStmt;
import org.rjava.compiler.semantics.representation.stmt.RNopStmt;
import org.rjava.compiler.semantics.representation.stmt.RRetStmt;
import org.rjava.compiler.semantics.representation.stmt.RReturnStmt;
import org.rjava.compiler.semantics.representation.stmt.RReturnVoidStmt;
import org.rjava.compiler.semantics.representation.stmt.RTableSwitchStmt;
import org.rjava.compiler.semantics.representation.stmt.RThrowStmt;
import org.rjava.compiler.util.SootCollectionUtils;
import org.rjava.compiler.util.SootValueMap;
import org.rjava.compiler.util.Statistics;

import soot.Type;
import soot.Value;
import soot.jimple.Constant;
import soot.jimple.InstanceFieldRef;
import soot.jimple.ParameterRef;
import soot.jimple.StaticFieldRef;
import soot.jimple.ThisRef;
import soot.jimple.internal.JArrayRef;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.internal.JInstanceFieldRef;
import soot.jimple.internal.JNewExpr;
import soot.jimple.internal.JimpleLocal;

public class PointsToAnalysisPass extends CompilationPass {
    private SootValueMap<Value> pointsToSet = new SootValueMap<Value>();
    private List<Value> pointsToBlacklist = new ArrayList<Value>();
    private SootValueMap<Type> typeRoots = new SootValueMap<Type>();
    
    public static final boolean DEBUG = true;
    
    int pass;
    @Override
    public void start() {        
        // find type roots (all the 'new's)
        pass = 1;
        super.start();
        
        // find points-to
        pass = 2;
        super.start();
        
        // more analysis - especially inter-procedural parameter type inference
        pass = 3;
        super.start();
    }
    
    public void report() {
    }
    
    public List<Value> tracePointsTo(Value v) {
        ArrayList<Value> ret = new ArrayList<Value>();
        
        Value trace = v;
        ret.add(v);
        
        while(pointsToSet.contains(trace)) {
            trace = pointsToSet.get(trace);
            ret.add(trace);
        }
        
        return ret;
    }
    
    public Type inferType(Value v) {
        List<Value> trace = tracePointsTo(v);
        Value last = trace.get(trace.size()-1);
        Type ret = typeRoots.get(last);        
        return ret;
    }

    @Override
    public void visit(RClass klass) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RMethod method) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RAssignStmt stmt) {
        JAssignStmt sootStmt = stmt.internal();
        Value left = sootStmt.getLeftOp();
        Value right = sootStmt.getRightOp();
        
        if (!RType.initWithSootType(left.getType()).isAppType() || !RType.initWithSootType(right.getType()).isAppType())
            return;
        
        if (pass == 1) {
            // find out the real type of a pointer
            if (right instanceof JNewExpr) {
                typeRoots.put(right, ((JNewExpr)right).getType());
            }
        } else if (pass == 2){        
            addToPointsToSet(left, right);
        }
    }
    
    private void addToPointsToSet(Value from, Value to) {
        if (SootCollectionUtils.contains(pointsToBlacklist, from))
            return;
        
        if (pointsToSet.contains(from)) {
            // reassign
            pointsToSet.remove(from);
            pointsToBlacklist.add(from);
        } else {
            pointsToSet.put(from, to);
        }
    }

    @Override
    public void visit(RBreakpointStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(REnterMonitorStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RExitMonitorStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RGotoStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RIdentityStmt stmt) {
        if (pass == 1) {
            Value right = stmt.internal().getRightOp();
            
            if (right instanceof ThisRef) {
                if (stmt.getMethod().getKlass().isDefactoFinal()) {
                    typeRoots.put(right, right.getType());
                }
            }
        } else if (pass == 2) {
            if (stmt.internal().getRightOp() instanceof ThisRef) {
                addToPointsToSet(stmt.internal().getLeftOp(), stmt.internal().getRightOp());
            }
        } else if (pass == 3) {
            Value right = stmt.internal().getRightOp();
            
            if (right instanceof ParameterRef) {
                List<RStatement> callsites = 
                        SemanticMap.cg.getCallGraph().getCallSites(stmt.getMethod());
                if (callsites == null || callsites.size() == 0) {
                    Statistics.increaseCounterByOne("no call site");
                    return;
                } else if (callsites.size() == 1) {
                    Statistics.increaseCounterByOne("unique call site");
                    RStatement callsite = callsites.get(0);
                    Value arg = 
                            callsite.getInvokeExpr().getInternal().getArg(((ParameterRef)right).getIndex());
                    addToPointsToSet(right, arg);
                    addToPointsToSet(stmt.internal().getLeftOp(), right);
                } else {
                    // TODO: if arguments of different call sites can be type-inferred, and they have the same type
                    // we can infer the parameter's type
                    Statistics.increaseCounterByOne("multiple call sites");
                }
            }
        }
    }

    @Override
    public void visit(RIfStmt stmt) {}

    @Override
    public void visit(RInvokeStmt stmt) {}

    @Override
    public void visit(RLookupSwitchStmt stmt) {}

    @Override
    public void visit(RNopStmt stmt) {}

    @Override
    public void visit(RRetStmt stmt) {}

    @Override
    public void visit(RReturnStmt stmt) {
        if (pass == 2) {
            RMethod thisMethod = stmt.getMethod();
            List<RStatement> callsites = SemanticMap.cg.getCallGraph().getCallSites(thisMethod);
            if (callsites != null)
                for (RStatement invokeStmt : callsites) {
                    this.addToPointsToSet(invokeStmt.getInvokeExpr().getInternal(), stmt.internal().getOp());
                }
            
            if (thisMethod.isUniqueImplementingOtherAbstractMethod()) {
                RMethod abstractMethod = thisMethod.getAbstractMethodThisMethodIsUniqueImplementing();
                callsites = SemanticMap.cg.getCallGraph().getCallSites(abstractMethod);
                if (callsites != null)
                    for (RStatement invokeStmt : callsites) {
                        this.addToPointsToSet(invokeStmt.getInvokeExpr().getInternal(), stmt.internal().getOp());
                    }
            }
        }
    }

    @Override
    public void visit(RReturnVoidStmt stmt) {}

    @Override
    public void visit(RTableSwitchStmt stmt) {}

    @Override
    public void visit(RThrowStmt stmt) {}

    @Override
    public void visit(RInvokeExpr expr) {}

    @Override
    public void visit(RStatement stmt, StaticFieldRef staticRef) {}

}
