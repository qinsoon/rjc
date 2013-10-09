package org.rjava.compiler.pass;

import java.util.HashSet;
import java.util.Set;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RField;
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

import soot.Value;
import soot.jimple.InstanceFieldRef;
import soot.jimple.StaticFieldRef;
import soot.jimple.internal.JInstanceFieldRef;

public class DetectInlinableFieldPass extends CompilationPass {
    private Set<RField> assignedFields = new HashSet<RField>();
    private CircularTypePass circularDetector;
    
    public DetectInlinableFieldPass(CircularTypePass circularDetector) {
        this.circularDetector = circularDetector;
    }
    
    @Override
    public void start() {        
        super.start();
        
        // check if any two classes have 'inlinable' fields that references each other
        // i.e. A.b has type of B while B.a has type of A. Then they cannot be inlinable
        // we break both of them
        for (RClass klass : SemanticMap.getAllClasses().values()) {
            if (!klass.isAppClass())
                continue;
            
            for (RField f : klass.getFields()) {
                if (f.isInstanceField() && f.isInlinable() && f.getType().isAppType()) {
                    if (circularDetector.isCircular(klass, RClass.fromClassName(f.getType().getClassName()))) {
                        f.setInlinable(false);
                    }                            
                }
            }
        }
        
        // statistics only
        for (RClass klass : SemanticMap.getAllClasses().values()) {
            if (!klass.isAppClass())
                continue;
            
            for (RField f : klass.getFields())
                if (!f.isStatic() && f.isInlinable())
                    Statistics.increaseCounterByOne("inlinable fields");
        }
    }

    @Override
    public void visit(RClass klass) {
        /*
         * set every instance field as inlinable first
         * we will set them individually as non-inlinable if its assigned at least twice
         */
        for (RField f : klass.getFields()) {
            if (!f.isStatic() 
                    && f.getType().isReferenceType() 
                    && !f.getType().isArray()
                    && !f.getType().isMagicType()) {
                f.setInlinable(true);
                Statistics.increaseCounterByOne("instance fields");
            }
        }
    }

    @Override
    public void visit(RMethod method) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(RAssignStmt stmt) {
        Value left = stmt.internal().getLeftOp();
        
        if (left instanceof InstanceFieldRef) {
            RField rf = RField.fromSootField(((InstanceFieldRef)left).getField());
            if (assignedFields.contains(rf)) {  
                rf.setInlinable(false);
            }
            else assignedFields.add(rf);
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
