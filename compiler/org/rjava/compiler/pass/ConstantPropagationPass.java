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
import org.rjava.compiler.util.SootValueMultiMap;

import soot.Immediate;
import soot.Type;
import soot.Value;
import soot.ValueBox;
import soot.jimple.BinopExpr;
import soot.jimple.DoubleConstant;
import soot.jimple.FloatConstant;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.LongConstant;
import soot.jimple.NumericConstant;
import soot.jimple.ParameterRef;
import soot.jimple.StaticFieldRef;
import soot.jimple.VirtualInvokeExpr;
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
    
    public ConstantPropagationPass() {

    }
    
    static class Lattice {
        Status status;
        Number value;
        
        public Lattice(Status status, Number value) {
            this.status = status;
            this.value = value;
        }
        
        public Lattice(Status status) {
            this(status, null);
        }
        
        @Override
        public String toString() {
            String ret = status.toString();
            if (status == Status.CONSTANT)
                ret += "(" + value + ")";
            return ret;
        }
        
        @Override
        public boolean equals(Object o) {
            if (! (o instanceof Lattice))
                return false;
            
            Lattice l = (Lattice)o;
            if ((l.status == Status.UNKNOWN && status == Status.UNKNOWN)
                    || (l.status == Status.NONCONSTANT && status == Status.NONCONSTANT)) 
                return true;
            
            if (l.status == Status.CONSTANT && status == Status.CONSTANT && l.value.doubleValue() == value.doubleValue())
                return true;
            
            return false;
        }
        
        public static Lattice meet(Lattice s1, Lattice s2) {
            if (s1.status == Status.UNKNOWN)
                return s2;
            if (s2.status == Status.UNKNOWN)
                return s1;
            
            if (s1.status == Status.NONCONSTANT)
                return s1;
            if (s2.status == Status.NONCONSTANT)
                return s2;
            
            if (s1.value.doubleValue() == s2.value.doubleValue())
                return s1; // or s2, they are same
            
            if (s1.value.doubleValue() != s2.value.doubleValue())
                return new Lattice(Status.NONCONSTANT);
            
            RJavaCompiler.fail("Invalid meet operation");
            return null;
        }
    }
    
    enum Status{
        UNKNOWN, CONSTANT, NONCONSTANT;
    }
    
    public SootValueMap<Lattice> results = new SootValueMap<Lattice>();
    
    SootValueMultiMap<RStatement> defuse = new SootValueMultiMap<RStatement>();
    
    Queue<RStatement> worklist = new LinkedList<RStatement>();
    
    int pass;
    final int GET_DEFUSE_AND_CONSTANT_P1 = 1;
    final int PREPARE_JUMPFUNCTIONS_P2   = 2;
    //final int MATCHING_ARGUMENT_P3       = 3;
    //final int DECIDING_CONSTANT_FORMAL_PARAMETERS_P4 = 4;
    
    @Override
    public void start() {
        // intra-procedural constant propagation
        // see <Optimizing Compiler for Modern Architecture> Book P147
        
        // collect constants and get def-use
        pass = GET_DEFUSE_AND_CONSTANT_P1;
        RJavaCompiler.println("Gathering def-use and constants..");
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
            for (Value k : results.keySet()) {
                System.out.println(k + ":=" + getLattice(k));
            }
        }
        
        // inter-procedural constant propagation
        // see 'Interprocedural Constant Propagation' paper from David Callahan
        pass = PREPARE_JUMPFUNCTIONS_P2;
        RJavaCompiler.println("Preparing jump functions..");
        super.start();        
        
        RJavaCompiler.println("Start propagation...");
        constantPropagation();
        
        if (DEBUG)
            report();
    }

    private void constantPropagation() {
        // constant propagation
        while (!worklist.isEmpty()) {
            if (DEBUG)
                System.out.println("\n");
            
            // choose and remove statement x from worklist
            RStatement x = worklist.poll();
            if (DEBUG)
                System.out.println("examining " + x.toSimpleString());
            
            /*
             * if x is return stmt, we find all its call sites
             */
            if (x instanceof RReturnStmt) {
                if (multipleReturnMethods.get(x.getMethod()) == true) {
                    if (DEBUG)
                        System.out.println(x.getMethod().getSignature() + " has multiple return stmt. skip");
                    continue;
                }
                
                if (DEBUG)
                    System.out.println("return stmt of " + x.getMethod().getSignature() + ". Adding its callsites");
                
                RReturnStmt retStmt = (RReturnStmt) x;
                Value retValue = retStmt.internal().getOp();
                //RJavaCompiler.assertion(isConstant(retValue), "ReturnStmt:" + x.toSimpleString() + " is in worklist, bu its OP:" + retValue + " is not constant (its " + getValueStatus(retValue) + ")");
                
                List<RStatement> callsites = SemanticMap.cg.getCallGraph().getCallSites(x.getMethod());
                
                if (x.getMethod().isUniqueImplementingOtherAbstractMethod()) {
                    callsites.addAll(SemanticMap.cg.getCallGraph().getCallSites(x.getMethod().getAbstractMethodThisMethodIsUniqueImplementing()));
                }
                
                if (callsites != null)
                    for (RStatement callsite : callsites) {
                        // we will its invoke expr as constant
                        Value callsiteExpr = callsite.internal().getInvokeExpr();
                        
                        boolean validCallsite = true;
                        // first check if the invoke expr actually points to this return stmt (use pta to devirtualize some invoke)
                        if (callsiteExpr instanceof VirtualInvokeExpr) {
                            Value base = ((VirtualInvokeExpr) callsiteExpr).getBase();
                            if (RClass.fromClassName(RType.initWithSootType(base.getType()).getClassName()).isDefactoFinal())
                                validCallsite = true;
                            else {
                                Type inferred = SemanticMap.pta.inferType(base);
                                if (inferred != null && RType.initWithSootType(inferred).equals(RType.initWithClassName(x.getMethod().getKlass().getName())))
                                        validCallsite = true;
                                else validCallsite = false;
                            }
                        } 
                        
                        if (!validCallsite)
                            continue;
                        
                        if (isConstant(retValue))
                            newConstant(callsiteExpr, getConstant(retValue));
                        else setLattice(callsiteExpr, new Lattice(Status.NONCONSTANT));
                        RJavaCompiler.assertion(getLattice(retValue) != null, "Lattice of ret value in " + x.getMethod().getSignature() + " cant be found");
                        RJavaCompiler.assertion(getLattice(retValue).status != Status.UNKNOWN, "ret value in " + x.getMethod().getSignature() + " is UNKNOWN");
                        worklist.add(callsite);
                        if (DEBUG)
                            System.out.println("adding " + callsite.toSimpleString());
                    }
                
                continue;
            }
            
            
            /*
             * x is an assignment stmt or identity stmt
             */
            // let v denote the output variable for x
            Value left = x.getLeftOp(), right = x.getRightOp();
            Value v = left;
            Lattice old = results.get(v);
            
            // possible that assumption breaks, that we cannot/shouldnot evaluate            
            if (old.status == Status.NONCONSTANT) {
                if (DEBUG)
                    System.out.println(v + "(lh) was set as NONCONSTANT before, skipping");
                continue;
            }
            
            Status rightOpStatus = checkRightOpStatus(right);
            
            if (rightOpStatus == Status.NONCONSTANT || (getLattice(right)!=null && getLattice(right).status == Status.NONCONSTANT)) {
                setLattice(v, new Lattice(Status.NONCONSTANT));
                if (DEBUG)
                    System.out.println("right side is NONCONSTANT, thus left is NONCONSTANT");
                // we need to re-evaluate all its uses
                Set<RStatement> uses = (Set<RStatement>)defuse.get(v);
                if (uses != null) {
                    for (RStatement use : uses) {
                        worklist.add(use);
                        if (DEBUG)
                            System.out.println("adding " + use.toSimpleString() + " to work list");
                    }
                }
                continue;
            }
            
            if (checkRightOpStatus(right) == Status.CONSTANT && !exprCanBeEvaluated(right)) {
                if (DEBUG)
                    System.out.println(right + "(rh) cannot be evaluated, skipping");
                continue;
            }
            
            //RJavaCompiler.assertion(rightOpStatus == Status.CONSTANT && exprCanBeEvaluated(right), "unexpected right operation status when polling:" + x.toSimpleString() + ", right op status:" + rightOpStatus);
            
            if (x.containsInvokeExpr()) {
                // there can be two situations.
                // 1. we known the invocation arguments are constant, we use jump functions to add those parameter identity stmts
                InvokeExpr invoke = x.getInvokeExpr().getInternal();
                if (checkRightOpStatus(invoke) == Status.CONSTANT) {
                    if (DEBUG)
                        System.out.println("Use jump function on " + x.toSimpleString());
                    Value[] parameters = formalParameters.get(x.getInvokeExpr().getTargetMethod());
                    if (parameters != null)
                        for (int i = 0; i < parameters.length; i++) {
                            Value para = parameters[i];
                            if (DEBUG)
                                System.out.println(para + " is set to " + getLattice(invoke.getArg(i)).value);
                            newConstant(para, getLattice(invoke.getArg(i)).value);
                            if (DEBUG)
                                System.out.println("adding " + parameterIdentity.get(para) + " to work list");
                            worklist.add(parameterIdentity.get(para));
                        }
                    continue;
                }
                // 2. the invocation already evaluated, and it returns a constant
                // in this case, we can eval(right). let the following code do the thing
            }
            
            // newval:= symbolic interpretation of x
            Number newval = eval(right);
            newval = typecast(right, newval);
            
            if (old.status == Status.CONSTANT && old.value.doubleValue() != newval.doubleValue()) {
                setLattice(v, new Lattice(Status.NONCONSTANT));
                if (DEBUG)
                    System.out.println("Evaluated to be different value, " + v + " is NONCONSTANT");
                // we need to re-evaluate all its uses
                Set<RStatement> uses = (Set<RStatement>)defuse.get(v);
                if (uses != null) {
                    for (RStatement use : uses) {
                        worklist.add(use);
                        if (DEBUG)
                            System.out.println("adding " + use.toSimpleString() + " to work list");
                    }
                }
                continue;
            }
            
            if (old == null || old.status == Status.UNKNOWN){                
                // valout(v,x) := newval
                newConstant(v, newval);                
                
                // for all (x,y) from def-use
                Set<RStatement> uses = (Set<RStatement>) defuse.get(v);
                if (uses == null || uses.isEmpty()) {
                    if (DEBUG)
                        System.out.println("val not used, no more propagating");
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
                    
                    if (y instanceof RReturnStmt) {
                        /*if (DEBUG)
                            System.out.println("return stmt. adding its callsite to work list");
                        List<RStatement> callsites = SemanticMap.cg.getCallGraph().getCallSites(y.getMethod());
                        if (callsites != null)
                            for (RStatement callsite : callsites) {
                                if (DEBUG)
                                    System.out.println("adding " + callsite.toSimpleString() + " to work list");
                                newConstant(callsite.getInvokeExpr().getInternal(), newval);
                                worklist.add(callsite);
                            }            
                        continue;*/
                        if (DEBUG)
                            System.out.println("adding return stmt:" + y.toSimpleString() + " to work list");
                        worklist.add(y);
                        continue;
                    }
                    
                    // since v is now known as a constant, we can check all the y subexpressions
                    // if they are all constants, then we add y to worklist
                    if (checkRightOpStatus(y.getRightOp()) == Status.CONSTANT && exprCanBeEvaluated(y.getRightOp())) {
                        worklist.add(y);
                        if (DEBUG)
                            System.out.println("adding " + y.toSimpleString() + " to work list");
                    }
                } // end of for (RStatement y : uses)
            } // end of if (!evalEqual())
            
        } // end of while(!worklist.isEmpty())
    }
    
    private Status checkRightOpStatus(Value rightOp) {
        List<ValueBox> yRightUses = (List<ValueBox>)rightOp.getUseBoxes();
        
        if (yRightUses == null || yRightUses.isEmpty()) {
            return getValueStatus(rightOp);
        } else {
            // right op is an expression, we check if all use boxes are constant
            boolean atLeastOneNonConstant = false;
            boolean isAllConstants = true;
            
            for (ValueBox val : yRightUses) {
                if (isNonConstant(val.getValue()))
                    atLeastOneNonConstant = true;
                if (!isConstant(val.getValue()))
                    isAllConstants = false;
            }
            
            if (atLeastOneNonConstant)
                return Status.NONCONSTANT;
            if (isAllConstants)
                return Status.CONSTANT;
            return Status.UNKNOWN;
        }
    }
    
    private boolean exprCanBeEvaluated(Value expr) {
        if (getLattice(expr) != null && getLattice(expr).status == Status.CONSTANT)
            return true;
        
        return expr instanceof InvokeExpr
                || expr instanceof Immediate 
                || expr instanceof JNegExpr 
                || expr instanceof JCastExpr
                || expr instanceof BinopExpr;
    }
    
    private Number typecast(Value right, Number newval) {
        Number ret = null;
        // type cast
        if (right instanceof IntConstant || right.getType().toString().equals("int"))
            ret = newval.intValue();
        else if (right instanceof LongConstant || right.getType().toString().equals("long"))
            ret = newval.longValue();
        else if (right instanceof FloatConstant || right.getType().toString().equals("float"))
            ret = newval.floatValue();
        else if (right instanceof DoubleConstant || right.getType().toString().equals("double"))
            ret = newval.doubleValue();
        else if (right.getType().toString().equals("short") 
                || right.getType().toString().equals("boolean") 
                || right.getType().toString().equals("byte") 
                || right.getType().toString().equals("char"))
            ret = newval.intValue();
        else {
            RJavaCompiler.fail("Unknown numeric type: " + right.getType());
        }
        
        return ret;
    }
    
    /**
     * we have ensured this value can be evaluated
     * @param value
     * @return
     */
    private Number eval(Value value){        
        // evaluated constant
        if (getLattice(value) != null && getLattice(value).status == Status.CONSTANT)
            return results.get(value).value;
        
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
        
        return null;
    }

    @Override
    public void visit(RClass klass) {
    }

    HashMap<RMethod, Value[]> formalParameters = new HashMap<RMethod, Value[]>();
    SootValueMap<RStatement> parameterIdentity = new SootValueMap<RStatement>();
    
    @Override
    public void visit(RMethod method) {    
        if (pass == GET_DEFUSE_AND_CONSTANT_P1) {
            Value[] paraArray = new Value[method.getParameters().size()];
            formalParameters.put(method, paraArray);
        }
    }

    @Override
    public void visit(RAssignStmt stmt) {
        if (pass == GET_DEFUSE_AND_CONSTANT_P1) {
            checkDefUseAndConstant(stmt);
        }        
    }

    public void checkDefUseAndConstant(RStatement stmt) {
        RJavaCompiler.assertion(stmt instanceof RAssignStmt || stmt instanceof RIdentityStmt, "Unexpected type of stmt in precheckStmt():" + stmt.getClass());
        
        Value valOut = stmt.getLeftOp();
                   
        // for each output v of s do valout(v,s) := unknown
        if (getLattice(valOut) == null)
            setLattice(valOut, new Lattice(Status.UNKNOWN));
        else setLattice(valOut, new Lattice(Status.NONCONSTANT));

        // for each input w of s - valin(w,s) 
        Value rightOp = stmt.getRightOp();
        
        //System.out.println("Adding defuse for stmt " + stmt);
        List<ValueBox> uses = rightOp.getUseBoxes();
        if (!uses.isEmpty()) {
            boolean allBoxesConstants = true;
            for (ValueBox box : uses) {
                Value val = box.getValue();
                if (val instanceof NumericConstant)
                    newConstant(val, getNumberFromValue(val));
                else allBoxesConstants = false;
                //else setLattice(val, new Lattice(Status.UNKNOWN));
                
                // valIn is def, this statement is use
                // put into defuse
                //System.out.println("val:" + val + " used in statement " + stmt.toSimpleString());
                defuse.put(val, stmt);
            }
            
            if (allBoxesConstants)
                worklist.add(stmt);
        }
        else {
            if (rightOp instanceof NumericConstant) {
                // if w is constant, valin(w,s) := constant value of w
                newConstant(rightOp, getNumberFromValue(rightOp));
                
                // add all statement of constant form, e.g. X=5
                worklist.add(stmt);
                //worklistHistory.add(stmt);
            } else {
                // if w is variable, valin(w,s) := unknown
                //setLattice(rightOp, new Lattice(Status.UNKNOWN));
            }
            
            //System.out.println("val:" + rightOp + " used in statement " + stmt.toSimpleString());
            defuse.put(rightOp, stmt);
        }
    }
    
    private Lattice getLattice(Value v) {
        return results.get(v);
    }
    
    private void setLattice(Value v, Lattice l) {
        if (!results.contains(v)) {
            results.put(v, l);
            return;
        }
        
        Lattice old = results.get(v);
        if (old.status.ordinal() < l.status.ordinal())
            results.put(v, l);
        else if (old.status == Status.CONSTANT && l.status == Status.CONSTANT) {
            if (old.value.doubleValue() != l.value.doubleValue()) {
                results.put(v, new Lattice(Status.NONCONSTANT));
                if (DEBUG)
                    System.out.println("setting " + v + " from " + old.value + " to " + l.value + ", thus it is a NONCONSTANT. pay attention");
            }
        }
    }
    
    public void newConstant(Value v, Number n) {
        Lattice old = getLattice(v);
        if (old == null)
            old = new Lattice(Status.UNKNOWN);
        
        Lattice newLattice = Lattice.meet(old, new Lattice(Status.CONSTANT, n));
        setLattice(v, newLattice);
        if (DEBUG)
            System.out.println("new Constant:" + v + "=" + newLattice);
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
    }

    @Override
    public void visit(REnterMonitorStmt stmt) {  
    }

    @Override
    public void visit(RExitMonitorStmt stmt) { 
    }

    @Override
    public void visit(RGotoStmt stmt) { 
    }

    @Override
    public void visit(RIdentityStmt stmt) {
        if (pass == GET_DEFUSE_AND_CONSTANT_P1) {
            checkDefUseAndConstant(stmt);
        }
        if (pass == PREPARE_JUMPFUNCTIONS_P2) {
            // for each procedural p in the program do
            //   for each parameter x to p do
            //     Val(x) := UNKNOWN
            Value right = stmt.internal().getRightOp(); 
            if (right instanceof ParameterRef) {
                setLattice(right, new Lattice(Status.UNKNOWN));
                
                // register as formal parameters for the method
                Value[] paraArray = formalParameters.get(stmt.getMethod());
                
                paraArray[((ParameterRef) right).getIndex()] = right;
                parameterIdentity.put(right, stmt);
            }
        }
    }

    @Override
    public void visit(RIfStmt stmt) { 
    }

    @Override
    public void visit(RInvokeStmt stmt) {
    }

    @Override
    public void visit(RLookupSwitchStmt stmt) {
    }

    @Override
    public void visit(RNopStmt stmt) {
    }

    @Override
    public void visit(RRetStmt stmt) {
    }

    HashMap<RMethod, Boolean> multipleReturnMethods = new HashMap<RMethod, Boolean>();
    @Override
    public void visit(RReturnStmt stmt) {
        if (pass == GET_DEFUSE_AND_CONSTANT_P1) {
            defuse.put(stmt.internal().getOp(), stmt);
            
            if (multipleReturnMethods.containsKey(stmt.getMethod()))
                multipleReturnMethods.put(stmt.getMethod(), true);
            else multipleReturnMethods.put(stmt.getMethod(), false);
        }
    }

    @Override
    public void visit(RReturnVoidStmt stmt) { 
    }

    @Override
    public void visit(RTableSwitchStmt stmt) {
    }

    @Override
    public void visit(RThrowStmt stmt) {
    }

    @Override
    public void visit(RInvokeExpr expr) {

    }

    @Override
    public void visit(RStatement stmt, StaticFieldRef staticRef) {
    }
    
    public Status getValueStatus(Value v) {
        if (isConstant(v))
            return Status.CONSTANT;
        if (isNonConstant(v))
            return Status.NONCONSTANT;
        if (isUnknown(v))
            return Status.UNKNOWN;
        
        RJavaCompiler.fail("Unexpected status of value " + v + ", which is " + getLattice(v));
        return null;
    }
    
    public boolean isConstant(Value v) {
        return getLattice(v) != null && getLattice(v).status == Status.CONSTANT;
    }
    
    public boolean isNonConstant(Value v) {
        return getLattice(v) != null && getLattice(v).status == Status.NONCONSTANT;
    }
    
    public boolean isUnknown(Value v) {
        return getLattice(v) == null || getLattice(v).status == Status.UNKNOWN;
    }
    
    public Number getConstant(Value v) {
        RJavaCompiler.assertion(isConstant(v), "Value " + v + " is not a constant. Check with isConstant() first");
        
        Number ret = results.get(v).value;
        
        RJavaCompiler.assertion(ret != null, "Constant for value:" + v + " from result set is null");
        
        return ret;
    }

    public void report() {
        RJavaCompiler.println("All constants:");
        for (Value v : results.keySet()) {
            if (isConstant(v))
                RJavaCompiler.println(v + "=" + getConstant(v));
        }
    }
}
