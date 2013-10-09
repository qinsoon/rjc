package org.rjava.compiler.pass;

import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RField;
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

import soot.jimple.StaticFieldRef;

/**
 * if two or more types that have instance fields that references each other, they are circular types
 * @author yi
 *
 */
public class CircularTypePass extends CompilationPass {
    DefaultDirectedGraph<RClass, DefaultEdge> graph = new DefaultDirectedGraph<RClass, DefaultEdge>(DefaultEdge.class);
    ConnectivityInspector<RClass, DefaultEdge> inspector;
    
    @Override
    public void start() {
        super.start();
        
        inspector = new ConnectivityInspector<RClass, DefaultEdge>(graph);
    }
    
    @Override
    public void visit(RClass klass) {
        for (RField f : klass.getFields()) {
            if (f.isInstanceField() && f.getType().isAppType()) {
                RClass k1 = klass;
                RClass k2 = RClass.fromClassName(f.getType().getClassName());
                
                if (!graph.containsVertex(k1))
                    graph.addVertex(k1);
                if (!graph.containsVertex(k2))
                    graph.addVertex(k2);
                
                graph.addEdge(klass, RClass.fromClassName(f.getType().getClassName()));
            }
        }
        
        if (klass.hasSuperClass() && klass.getSuperClass().isAppClass()) {
            if (!graph.containsVertex(klass))
                graph.addVertex(klass);
            if (!graph.containsVertex(klass.getSuperClass()))
                graph.addVertex(klass.getSuperClass());
            
            graph.addEdge(klass, klass.getSuperClass());
        }
    }
    
    public boolean isCircular(RClass a, RClass b) {
        return inspector.pathExists(a, b);
    }

    @Override
    public void visit(RMethod method) {
        // TODO Auto-generated method stub
        
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

    @Override
    public void visit(RInvokeExpr expr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RStatement stmt, StaticFieldRef staticRef) {
        // TODO Auto-generated method stub
        
    }

}
