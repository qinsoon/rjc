package org.rjava.compiler.pass;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.DependencyGraph;
import org.rjava.compiler.semantics.SemanticMap;
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
import org.rjava.compiler.util.ElapseTimer;

import soot.jimple.StaticFieldRef;
import soot.jimple.internal.JVirtualInvokeExpr;

public class DependencyGraphPass extends CompilationPass {
    private DependencyGraph dependencyGraph;
    
    Stack<RMethod> stack = new Stack<RMethod>();
    Set<RMethod> processed = new HashSet<RMethod>();
    
    public DependencyGraph getDependencyGraph() {
        RJavaCompiler.assertion(dependencyGraph != null, "Dependency graph isnt ready, since DependencyGraphPass hasnt run yet");
        return dependencyGraph;
    }
    
    @Override
    public void start(String name) {
        ElapseTimer timer = new ElapseTimer(name, true);
        timer.start();
        
        dependencyGraph = new DependencyGraph();
        
        for (RClass klass : SemanticMap.getAllClasses().values()) {
            RMethod clinit = klass.getCLInitMethod();
            if (clinit != null) {
                stack.push(clinit);
                visit(klass);
            }
        }
        
        while(!stack.isEmpty()) {
            RMethod f = stack.pop();
            if (processed.contains(f))
                continue;
            
            f.accept(this);
            
            processed.add(f);
        }
        
        dependencyGraph.generateClassDependencyGraph();
        
        timer.end();
    }

    /**
     * 1) if A is app class and A has <clinit>, then A -> A.<clinit>
     */
    @Override
    public void visit(RClass klass) {
        if (klass.isAppClass() && klass.getCLInitMethod() != null)
            dependencyGraph.addEdgeRelation(klass, klass.getCLInitMethod());
    }

    @Override
    public void visit(RMethod method) {
        // do nothing for method and stmt, but all invoke exprs will be visited - we do stuff there
    }

    @Override
    public void visit(RStatement stmt) {
        // do nothing for method and stmt, but all invoke exprs will be visited - we do stuff there
    }

    @Override
    public void visit(RAssignStmt stmt) {
        // TODO Auto-generated method stub

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

    /**
     * 2) if f is a static or instance method of app class, and f calls another static or instance method g of app class, then f->g.
     * In addition, if g is invoked by invokevirtual and is overriden as g', then f->g'
     */
    @Override
    public void visit(RInvokeExpr expr) {
        RMethod caller = expr.getContainingStmt().getMethod();
        
        RClass calleeClass = RClass.fromSootClass(expr.getInternal().getMethod().getDeclaringClass());
        if (!calleeClass.isAppClass())
            return;
        
        RMethod callee = RMethod.getFromSootMethod(expr.getInternal().getMethod());
        
        if (caller.equals(callee))
            return;
        
        dependencyGraph.addEdgeRelation(caller, callee);
        stack.push(callee);
        
        if (expr.getInternal() instanceof JVirtualInvokeExpr) {
            for (RMethod overridingMethod : callee.getOverridingMethod()) {
                if (caller.equals(overridingMethod))
                    continue;
                
                dependencyGraph.addEdgeRelation(caller, overridingMethod);
                stack.push(overridingMethod);
            }
        }
    }

    /**
     * 3) if f is a static or virtual method of app class, f uses static field B.a, then f->B 
     */
    @Override
    public void visit(RStatement stmt, StaticFieldRef staticRef) {
        RClass stmtClass = stmt.getMethod().getKlass();
        RClass referencedClass = RClass.fromSootClass(staticRef.getField().getDeclaringClass());
        if (!referencedClass.isAppClass())
            return;
        
        dependencyGraph.addEdgeRelation(stmt.getMethod(), referencedClass);
    }
}
