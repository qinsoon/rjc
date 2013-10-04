package org.rjava.compiler.pass;

import java.util.ArrayList;
import java.util.Collection;
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

public class TypeInferencePass extends CompilationPass {
    public static Map<Value, Value> pointsToSet = new HashMap<Value, Value>();
    public static List<Value> pointsToBlacklist = new ArrayList<Value>();
    public static Map<Value, Type> typeRoots = new HashMap<Value, Type>();
    
    int pass;
    @Override
    public void start() {
        pass = 1;
        super.start();
        
        pass = 2;
        super.start();
    }
    
    public void report() {
    }
    
    public static List<Value> tracePointsTo(Value v) {
        ArrayList<Value> ret = new ArrayList<Value>();
        
        Value trace = v;
        ret.add(v);
        
        while(collectionContainsValue(pointsToSet.keySet(), trace)) {
            trace = pointsToSet.get(collectionGetsValue(pointsToSet.keySet(), trace));
            ret.add(trace);
        }
        
        return ret;
    }
    
    public static Type inferType(Value v) {
        List<Value> trace = tracePointsTo(v);
        Value last = trace.get(trace.size()-1);
        Type ret = typeRoots.get(last);
        
        if (ret != null) {
            Statistics.increaseCounterByOne("type inference success");            
        } else 
            Statistics.increaseCounterByOne("type inference fail");
        
        return ret;
    }
    
    private static boolean collectionContainsValue(Collection<? extends Value> collection, Value v) {
        return collectionGetsValue(collection, v) != null;
    }
    
    private static Value collectionGetsValue(Collection<? extends Value> collection, Value v) {
        for (Value cur : collection) {
            if (valueEquals(cur, v))
                return cur;
        }
        return null;
    }
    
    // instance field is slightly different
    private static boolean valueEquals(Value a, Value b) {
        if (a instanceof InstanceFieldRef && b instanceof InstanceFieldRef) {
            InstanceFieldRef refA = (InstanceFieldRef)a;
            InstanceFieldRef refB = (InstanceFieldRef)b;
            
            return refA.getField().getDeclaringClass().equals(refB.getField().getDeclaringClass())
                    && refA.getField().getName().equals(refB.getField().getName());
        } else return a.equivTo(b);
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
        if (collectionContainsValue(pointsToBlacklist, from))
            return;
        
        if (collectionContainsValue(pointsToSet.keySet(), from)) {
            // reassign
            Value delete = collectionGetsValue(pointsToSet.keySet(), from);
            pointsToSet.remove(delete);
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
            } else if (right instanceof ParameterRef) {
                
            }
        } else if (pass == 2) {
            addToPointsToSet(stmt.internal().getLeftOp(), stmt.internal().getRightOp());
        }
    }

    @Override
    public void visit(RIfStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RInvokeStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RLookupSwitchStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RNopStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RRetStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RReturnStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RReturnVoidStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RTableSwitchStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RThrowStmt stmt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RInvokeExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RStatement stmt, StaticFieldRef staticRef) {
        // TODO Auto-generated method stub
        
    }

}
