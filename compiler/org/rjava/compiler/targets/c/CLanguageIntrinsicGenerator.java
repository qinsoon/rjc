package org.rjava.compiler.targets.c;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.rjava.compiler.Constants;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.RType;
import org.rjava.compiler.semantics.representation.stmt.RAssignStmt;
import org.rjava.compiler.semantics.representation.stmt.RIdentityStmt;
import org.rjava.compiler.semantics.representation.stmt.RInvokeStmt;
import org.rjava.compiler.targets.c.runtime.CLanguageRuntime;

import soot.SootMethod;
import soot.jimple.InvokeExpr;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.internal.JIdentityStmt;
import soot.jimple.internal.JSpecialInvokeExpr;
import soot.jimple.internal.JVirtualInvokeExpr;

public class CLanguageIntrinsicGenerator {
    CLanguageNameGenerator name;
    CLanguageGenerator languageGenerator;
    
    public static final Map<String, String> JAVA_PRIMITIVE_TO_C_TYPE = new HashMap<String, String>();
    static {
        JAVA_PRIMITIVE_TO_C_TYPE.put("boolean", "bool");
        JAVA_PRIMITIVE_TO_C_TYPE.put("short", "int16_t");
        JAVA_PRIMITIVE_TO_C_TYPE.put("int", "int32_t");
        JAVA_PRIMITIVE_TO_C_TYPE.put("long", "int64_t");
    }
    
    public CLanguageIntrinsicGenerator(CLanguageGenerator generator) {
        this.languageGenerator = generator;
        name = new CLanguageNameGenerator(generator);
    }

    public void generate(RType type) {
        // java to c matching
        if (JAVA_PRIMITIVE_TO_C_TYPE.keySet().contains(type.getClassName())) {
            type.setClassName(JAVA_PRIMITIVE_TO_C_TYPE.get(type.getClassName()));
        }
        // soot internal type
        else if (type.getClassName().equals("null_type")) {
            // void*
            type.setType(null);
            type.setClassName("void*");
            type.setPrimitive(true);
            type.setArray(false);
            type.setVoidType(true);
        }        
        // magic types are primitives
        else if (Arrays.asList(Constants.MAGIC_TYPES).contains(type.getClassName())) {
            type.setPrimitive(true);
        }
    }

    public void generate(RStatement stmt) {
        if (stmt.internal().containsInvokeExpr()) {
            InvokeExpr invoke = stmt.internal().getInvokeExpr();
            // remove any call to object
            if (invoke instanceof JSpecialInvokeExpr && invoke.getMethod().getDeclaringClass().getName().equals("java.lang.Object")) {
                stmt.setIntrinsic(true);
                stmt.setCode(CLanguageGenerator.comment(stmt.toString()));
            } else if (invoke instanceof JVirtualInvokeExpr && invoke.getMethod().getDeclaringClass().getName().equals("java.lang.Object")) {
                stmt.setIntrinsic(true);
                stmt.setCode(CLanguageGenerator.comment(stmt.toString()));
            }
            
            // rewrite boxed primitive type init
            /*else if (invoke instanceof JSpecialInvokeExpr && invoke.getMethod().getName().equals("<init>") && invoke.getMethod().getDeclaringClass().getName().startsWith("java.lang")) {
                if (invoke.getMethod().getDeclaringClass().getName().equals("java.lang.Integer")) {
                    if (invoke.getMethod().getSignature().equals("<java.lang.Integer: void <init>(int)>")) {
                        stmt.setIntrinsic(true);
                        stmt.setCode(name.fromSootValue(((JSpecialInvokeExpr) invoke).getBase()) + " = " + name.fromSootValue(invoke.getArg(0))); 
                    }
                }
            }*/
        } 
        // transform char** args into an 'rjava' array
        else if (stmt instanceof RIdentityStmt && stmt.getMethod().isMainMethod() && 
                ((JIdentityStmt)stmt.internal()).getLeftOp().toString().equals("args") 
                && ((JIdentityStmt)stmt.internal()).getRightOp().toString().contains("parameter0")) {
            stmt.setIntrinsic(true);
            stmt.setCode("args = " + CLanguageRuntime.RJAVA_INIT_ARGS + "(argc, parameter0)");
        }
    }

    public void generate(RMethod method) {
        method.setIntrinsic(false);
    }
}
