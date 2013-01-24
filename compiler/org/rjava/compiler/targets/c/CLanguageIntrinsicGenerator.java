package org.rjava.compiler.targets.c;

import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.RType;
import org.rjava.compiler.semantics.representation.stmt.RInvokeStmt;

import soot.SootMethod;
import soot.jimple.InvokeExpr;
import soot.jimple.internal.JSpecialInvokeExpr;
import soot.jimple.internal.JVirtualInvokeExpr;

public class CLanguageIntrinsicGenerator {

    public CLanguageIntrinsicGenerator() {
        // TODO Auto-generated constructor stub
    }

    public void generate(RType type) {
        if (type.getClassName().equals("java.lang.String")) {
            type.setType(null);
            type.setClassName("RJAVA_STR");
            type.setPackageName(null);
            type.setPrimitive(true);
        }
    }

    public void generate(RStatement stmt) {
        if (stmt instanceof RInvokeStmt) {
            InvokeExpr invoke = stmt.internal().getInvokeExpr();
            if (invoke instanceof JSpecialInvokeExpr && invoke.getMethod().getDeclaringClass().getName().equals("java.lang.Object")) {
                stmt.setIntrinsic(true);
                stmt.setCode(CLanguageGenerator.commentln(stmt.toString()));
            } else if (invoke instanceof JVirtualInvokeExpr && invoke.getMethod().getDeclaringClass().getName().equals("java.lang.Object")) {
                stmt.setIntrinsic(true);
                stmt.setCode(CLanguageGenerator.commentln(stmt.toString()));
            }
        }
    }

    public void generate(RMethod method) {
        method.setIntrinsic(false);
    }
}
