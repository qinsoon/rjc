package org.rjava.compiler.pass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.apache.commons.collections.MultiHashMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
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
import org.rjava.compiler.util.SootValueMultiMap;

import soot.Immediate;
import soot.Value;
import soot.ValueBox;
import soot.jimple.BinopExpr;
import soot.jimple.DoubleConstant;
import soot.jimple.FloatConstant;
import soot.jimple.IntConstant;
import soot.jimple.LongConstant;
import soot.jimple.NumericConstant;
import soot.jimple.StaticFieldRef;
import soot.jimple.internal.JAddExpr;
import soot.jimple.internal.JAndExpr;
import soot.jimple.internal.JCastExpr;
import soot.jimple.internal.JCmpExpr;
import soot.jimple.internal.JCmpgExpr;
import soot.jimple.internal.JCmplExpr;
import soot.jimple.internal.JDivExpr;
import soot.jimple.internal.JEqExpr;
import soot.jimple.internal.JGeExpr;
import soot.jimple.internal.JGtExpr;
import soot.jimple.internal.JLeExpr;
import soot.jimple.internal.JLtExpr;
import soot.jimple.internal.JMulExpr;
import soot.jimple.internal.JNeExpr;
import soot.jimple.internal.JNegExpr;
import soot.jimple.internal.JOrExpr;
import soot.jimple.internal.JRemExpr;
import soot.jimple.internal.JShlExpr;
import soot.jimple.internal.JShrExpr;
import soot.jimple.internal.JSubExpr;
import soot.jimple.internal.JXorExpr;
import soot.util.HashMultiMap;

public class ConstantPropagationPass extends CompilationPass {
    /**
     * when turned on, for x := temp$1 (temp$1 is known to be CONSTANT), we dont use the constant value
     * instead, generated code is x = temp$1; assert (x == CONSTANT)
     * when turned off, we we use constant value
     */
    public static final boolean ASSERT_CORRECTNESS = false;
    public static final boolean USE_CONSTANT = !ASSERT_CORRECTNESS;
    
    public static final boolean DEBUG = false;
    
    public ConstantPropagationPass(ConstantDefinitionPass constantDefs) {
        //this.constantDefs = constantDefs;
    }
    
    enum Lattice{
        UNKNOWN, CONSTANT, NONCONSTANT
    }
    
    public SootValueMap<Lattice> valueStatus = new SootValueMap<Lattice>();
    public SootValueMap<Number>  result = new SootValueMap<Number>();
    
    SootValueMultiMap<RStatement> defuse = new SootValueMultiMap<RStatement>();
    
    Queue<RStatement> worklist = new LinkedList<RStatement>();
    Set<RStatement> worklistHistory = new HashSet<RStatement>();
    
    int pass;
    
    @Override
    public void start() {
        // intra-procedural constant propagation
        // see <Optimizing Compiler for Modern Architecture> Book P147
        
        // collect constants and get def-use
        pass = 1;
        super.start();
        
        if (DEBUG) {
            for (Object o : defuse.keySet()) {
                System.out.println("def:" + o);
                System.out.println("use:");
                for (RStatement o2 : defuse.get((Value) o)) {
                    System.out.println("-" + o2.toSimpleString());
                }
                System.out.println();
            }
            
            System.out.println("value status:");
            for (Value k : valueStatus.keySet()) {
                System.out.println(k + ":=" + getValueStatus(k));
            }
        }
        
        System.out.println("Start propagation---------------");
        intraProceduralConstantPropagation();
        
        pass = 2;
        //super.start();
        
        if (DEBUG)
            report();
    }

    private void intraProceduralConstantPropagation() {
        // constant propagation
        while (!worklist.isEmpty()) {
            // choose and remove statement x from worklist
            RStatement x = worklist.poll();
            if (DEBUG)
                System.out.println("examining " + x.toSimpleString());
            
            // x should either be assign or identity statement
            // let v denote the output variable for x
            Value left = x.getLeftOp(), right = x.getRightOp();
            Value v = left;
            
            // newval:= symbolic interpretation of x
            Number newval = null;
            try{
                newval = eval(right);
                
                // type cast
                if (right instanceof IntConstant || right.getType().toString().equals("int"))
                    newval = (Integer) newval;
                else if (right instanceof LongConstant || right.getType().toString().equals("long"))
                    newval = (Long) newval;
                else if (right instanceof FloatConstant || right.getType().toString().equals("float"))
                    newval = (Float) newval;
                else if (right instanceof DoubleConstant || right.getType().toString().equals("double"))
                    newval = (Double) newval;
                else if (right.getType().toString().equals("short") 
                        || right.getType().toString().equals("boolean") 
                        || right.getType().toString().equals("byte") 
                        || right.getType().toString().equals("char"))
                    newval = (Integer) newval;
                else {
                    RJavaCompiler.fail("Unknown numeric type: " + right.getType());
                }
            } catch (RuntimeException e) {
                continue;
            }
            if (getValueStatus(left) == Lattice.NONCONSTANT)
                continue;
            
            // if newval != valout(v,x)
            if (!evalEqual(v, newval)) {
                // valout(v,x) := newval
                newConstant(v, newval);                
                
                // for all (x,y) from def-use
                Set<RStatement> uses = (Set<RStatement>) defuse.get(v);
                if (uses == null || uses.isEmpty()) {
                    if (DEBUG)
                        System.out.println("val not used, no more propgating");
                    continue;
                }
                
                if (DEBUG)
                    System.out.println("propagating from " + v);
                for (RStatement y : uses) {
                    if (DEBUG)
                        System.out.println(y.toSimpleString());
                    // oldval := valin(v, y)
                    // valin(v,y) := oldval ^ valout(v,x)
                    // if valin(v,y) != oldval then worklist := worklist + {y}
                    
                    // since v is now known as a constant, we can check all the y subexpressions
                    // if they are all constants, then we add y to worklist
                    Value yRight = y.getRightOp();
                    List<ValueBox> yRightUses = (List<ValueBox>)yRight.getUseBoxes();
                    boolean canEvaluate = true;
                                     
                    if (yRightUses == null || yRightUses.isEmpty()) {
                        if (getValueStatus(yRight) != Lattice.CONSTANT)
                            canEvaluate = false;
                    } else {
                        // right op is an expression, we check if all use boxes are constant, and also check if the expr can be evaluated
                        for (ValueBox val : yRightUses) {
                            if (getValueStatus(val.getValue()) != Lattice.CONSTANT)
                                canEvaluate = false;
                        }
                        if (!exprCanBeEvaluated(yRight))
                            canEvaluate = false;   
                    }
                    if (worklistHistory.contains(y))
                        canEvaluate = false;
                    
                    if (canEvaluate) {
                        worklist.add(y);
                        worklistHistory.add(y);
                        if (DEBUG)
                            System.out.println("adding " + y.toSimpleString() + " to work list");
                    }
                } // end of for (RStatement y : uses)
            } // end of if (!evalEqual())
            
            if (DEBUG)
                System.out.println("\n");
        } // end of while(!worklist.isEmpty())
    }
    
    private boolean exprCanBeEvaluated(Value expr) {
        return expr instanceof Immediate 
                || expr instanceof JNegExpr 
                || expr instanceof JCastExpr
                || expr instanceof BinopExpr;
    }
    
    private boolean evalEqual(Value v, Number val) {
        return false;
    }
    
    /**
     * we have ensured this value can be evaluated
     * @param value
     * @return
     */
    private Number eval(Value value) throws RuntimeException{
        if (getValueStatus(value) == Lattice.NONCONSTANT)
            throw new RuntimeException();
        
        // evaluated constant
        if (getValueStatus(value) == Lattice.CONSTANT)
            return result.get(value);
        
        // immediate constant
        if (value instanceof Immediate) {
            RJavaCompiler.assertion(false, "Value:" + value + " is immediate value (it should already be in the result list)");
        }
        
        if (value instanceof JNegExpr) {
            JNegExpr neg = (JNegExpr) value;
            return -eval(neg.getOp()).doubleValue();
        }
        
        if (value instanceof JCastExpr) {
            JCastExpr cast = (JCastExpr) value;
            return eval(cast.getOp()).doubleValue();
        }
        
        RJavaCompiler.assertion(value instanceof BinopExpr, "value:" + value + " is not binop expr");
        
        // binop
        BinopExpr binop = (BinopExpr) value;
        double op1 = eval(binop.getOp1()).doubleValue();
        double op2 = eval(binop.getOp2()).doubleValue();
        int intop1 = eval(binop.getOp1()).intValue();
        int intop2 = eval(binop.getOp2()).intValue();
        
        // add/sub/mul/div/rem
        if (value instanceof JAddExpr) {
            return op1 + op2;
        } else if (value instanceof JSubExpr) {
            return op1 - op2;
        } else if (value instanceof JMulExpr) {
            return op1 * op2;
        } else if (value instanceof JDivExpr) {
            return op1 / op2;
        } else if (value instanceof JRemExpr) {
            return op1 % op2;
        }
        
        // and/or/xor - integers only
        if (value instanceof JAndExpr) {
            return intop1 & intop2;
        } else if (value instanceof JOrExpr) {
            return intop1 | intop2;
        } else if (value instanceof JXorExpr) {
            return intop1 ^ intop2;
        }
        
        // cmp/cmpg/cmpl
        if (value instanceof JCmpExpr || value instanceof JCmpgExpr) {
            if (op1 < op2)
                return -1;
            else if (op1 == op2)
                return 0;
            else return 1;
        } else if (value instanceof JCmplExpr) {
            if (op1 > op2)
                return 1;
            else if (op1 == op2)
                return 0;
            else return -1;
        }
        
        // eq/ge/gt/le/lt/ne
        if (value instanceof JEqExpr) {
            if (op1 == op2)
                return 1;
            else return 0;
        } else if (value instanceof JGeExpr) {
            if (op1 >= op2)
                return 1;
            else return 0;
        } else if (value instanceof JGtExpr) {
            if (op1 > op2)
                return 1;
            else return 0;
        } else if (value instanceof JLeExpr) {
            if (op1 <= op2)
                return 1;
            else return 0;
        } else if (value instanceof JLtExpr) {
            if (op1 < op2)
                return 1;
            else return 0;
        } else if (value instanceof JNeExpr) {
            if (op1 != op2)
                return 1;
            else return 0;
        }
        
        // shl/shr
        if (value instanceof JShlExpr) {
            return intop1 << intop2;
        } else if (value instanceof JShrExpr) {
            return intop1 >> intop2;
        }
        
        RJavaCompiler.fail("cant eval value:" + value + ", class:" + value.getClass());
        
        return 0;
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
        if (pass == 1) {
            Value valOut = stmt.internal().getLeftOp();
            
            if (valueStatus.contains(valOut)) {
                setValueStatus(valOut, Lattice.NONCONSTANT);
            } else {            
                // for each output v of s do valout(v,s) := unknown
                setValueStatus(valOut, Lattice.UNKNOWN);
            }

            // for each input w of s - valin(w,s) 
            Value rightOp = stmt.internal().getRightOp();
            if (rightOp instanceof NumericConstant) {
                // if w is constant, valin(w,s) := constant value of w
                newConstant(rightOp, getNumberFromValue(rightOp));
                
                // add all statement of constant form, e.g. X=5
                worklist.add(stmt);
                worklistHistory.add(stmt);
            } else {
                // if w is variable, valin(w,s) := unknown
                // setValueStatus(rightOp, Lattice.UNKNOWN);
            }
            
            //System.out.println("Adding defuse for stmt " + stmt);
            List<ValueBox> uses = stmt.internal().getRightOp().getUseBoxes();
            if (!uses.isEmpty())
                for (ValueBox box : uses) {
                    Value val = box.getValue();
                    if (val instanceof NumericConstant)
                        newConstant(val, getNumberFromValue(val));
                    
                    // valIn is def, this statement is use
                    // put into defuse
                    //System.out.println("val:" + val + " used in statement " + stmt.toSimpleString());
                    defuse.put(val, stmt);
                }
            else {
                //System.out.println("val:" + rightOp + " used in statement " + stmt.toSimpleString());
                defuse.put(rightOp, stmt);
            }
        }        
    }
    
    private Lattice getValueStatus(Value v) {
        return valueStatus.get(v);
    }
    
    private void setValueStatus(Value v, Lattice l) {
        if (!valueStatus.contains(v)) {
            valueStatus.put(v, l);
            return;
        }
        
        Lattice old = valueStatus.get(v);
        //RJavaCompiler.assertion(old.ordinal() <= l.ordinal(), "Trying to set status for " + v + " from " + old + " to " + l);
        if (old.ordinal() < l.ordinal())
            valueStatus.put(v, l);
    }
    
    public void newConstant(Value v, Number n) {
        setValueStatus(v, Lattice.CONSTANT);
        result.put(v, n);
        if (DEBUG)
            System.out.println("Found constant:" + v + "=" + n);
    }

    public Number getNumberFromValue(Value valIn) {
        if (valIn instanceof IntConstant) {
            return ((IntConstant)valIn).value;
        } else if (valIn instanceof LongConstant) {
            return ((LongConstant)valIn).value;
        } else if (valIn instanceof DoubleConstant) {
            return ((DoubleConstant)valIn).value;
        } else if (valIn instanceof FloatConstant) {
            return ((FloatConstant)valIn).value;
        }
        
        RJavaCompiler.fail("valIn:" +valIn + " is not a numeric constant, it is " + valIn.getClass());
        
        return null;
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
        // TODO Auto-generated method stub
        
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
    
    public boolean isConstant(Value v) {
        return getValueStatus(v) != null && getValueStatus(v) == Lattice.CONSTANT;
    }
    
    public Number getConstant(Value v) {
        RJavaCompiler.assertion(isConstant(v), "Value " + v + " is not a constant. Check with isConstant() first");
        
        Number ret = result.get(v);
        
        RJavaCompiler.assertion(ret != null, "Constant for value:" + v + " from result set is null");
        
        return ret;
    }

    public void report() {
        RJavaCompiler.println("All constants:");
        for (Value v : result.keySet()) {
            RJavaCompiler.println(v + "=" + result.get(v));
        }
    }
}
