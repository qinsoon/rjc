package org.rjava.compiler.targets.c.runtime;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.stmt.RAssignStmt;
import org.rjava.compiler.semantics.representation.stmt.RInvokeStmt;
import org.rjava.compiler.targets.c.CLanguageGenerator;
import org.rjava.compiler.targets.c.Intrinsics;
import org.rjava.compiler.targets.c.CIdentifier;

import soot.jimple.InvokeExpr;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.internal.JStaticInvokeExpr;

public class RJavaLangForCIntrinsicGenerator extends
        Intrinsics {

    public RJavaLangForCIntrinsicGenerator(CLanguageGenerator generator) {
        super(generator);
    }

    public void generate(RStatement stmt) {
        super.generate(stmt);
        
        // we deal with c functions here.
        if (stmt.internal().containsInvokeExpr()) {
            InvokeExpr invoke = stmt.internal().getInvokeExpr();
            String code = null, invokeStr = null;
            if (invoke instanceof JStaticInvokeExpr &&  invoke.getMethod().getDeclaringClass().getName().equals("java.lang.C")) {
                // do the code generation here
                invokeStr = invoke.getMethod().getName();
                invokeStr += "(";
                for (int i = 0; i < invoke.getArgCount(); i++) {
                    invokeStr += name.fromSootValue(invoke.getArg(i));
                    if (i != invoke.getArgCount() - 1)
                        invokeStr += ",";
                }
                invokeStr += ")";
            } else return;
            
            // check if we need to generate other part of the code
            if (stmt instanceof RAssignStmt) {
                JAssignStmt sootAssign = ((RAssignStmt)stmt).internal();
                code = name.fromSootValue(sootAssign.getLeftOp()) + " = " + invokeStr;
            } else if (stmt instanceof RInvokeStmt) {
                code = invokeStr;
            } else {
                RJavaCompiler.fail("An RStatement that contains invoke expr should either be assignment or invoke stmt. ");
            }
            
            // save
            stmt.setIntrinsic(true);
            stmt.setCode(code);
        }
    }
}
