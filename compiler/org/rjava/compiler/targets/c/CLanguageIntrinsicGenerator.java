package org.rjava.compiler.targets.c;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.rjava.compiler.Constants;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.representation.RLocal;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.RType;
import org.rjava.compiler.semantics.representation.stmt.RAssignStmt;
import org.rjava.compiler.semantics.representation.stmt.RIdentityStmt;
import org.rjava.compiler.semantics.representation.stmt.RInvokeStmt;
import org.rjava.compiler.targets.c.runtime.CLanguageRuntime;

import soot.Body;
import soot.Local;
import soot.PatchingChain;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.InvokeExpr;
import soot.jimple.ParameterRef;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.internal.JIdentityStmt;
import soot.jimple.internal.JNopStmt;
import soot.jimple.internal.JReturnStmt;
import soot.jimple.internal.JSpecialInvokeExpr;
import soot.jimple.internal.JStaticInvokeExpr;
import soot.jimple.internal.JVirtualInvokeExpr;
import soot.jimple.internal.JimpleLocal;
import soot.util.Chain;
import soot.util.HashChain;

public class CLanguageIntrinsicGenerator {
    public static final boolean DEBUG = true;
    
    protected CLanguageNameGenerator name;
    protected CLanguageGenerator languageGenerator;
    
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
            type.setMagicType(true);
        } else if (Arrays.asList(Constants.MAGIC_ARRAY_TYPES).contains(type.getClassName())) {
            type.setPrimitive(true);
            type.setMagicType(true);
        }
    }

    public void generate(RStatement stmt) {
        if (stmt.internal().containsInvokeExpr()) {
            InvokeExpr invoke = stmt.internal().getInvokeExpr();
            // remove any call to object
            if (invoke instanceof JSpecialInvokeExpr && invoke.getMethod().getDeclaringClass().getName().equals("java.lang.Object")) {
                //stmt.setIntrinsic(true);
                //stmt.setCode(CLanguageGenerator.comment(stmt.toString()));
            } else if (invoke instanceof JVirtualInvokeExpr && invoke.getMethod().getDeclaringClass().getName().equals("java.lang.Object")) {
                //stmt.setIntrinsic(true);
                //stmt.setCode(CLanguageGenerator.comment(stmt.toString()));
            } else if (invoke instanceof JStaticInvokeExpr && invoke.getMethod().getDeclaringClass().getName().equals("java.lang.Class") && invoke.getMethod().getName().equals("forName")) {
                /*stmt.setIntrinsic(true);
                
                // intrinsic code
                String code = "java_lang_Class_forName(";
                
                // get the class_instance for such RJava class
                // className holds something like "java.lang.Integer"
                String classInstance = invoke.getArg(0).toString();
                // remove double quotes
                classInstance = classInstance.substring(1, classInstance.length() - 1);
                // convert className to &java_lang_Integer_class_instance
                classInstance = classInstance.replace('.', '_');
                classInstance += CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX;
                
                code += "&" + classInstance + ")";
                
                stmt.setCode(code);*/
            }
        } 
        // transform char** args into an 'rjava' array
        else if (stmt instanceof RIdentityStmt && stmt.getMethod().isMainMethod() && 
                ((JIdentityStmt)stmt.internal()).getLeftOp().toString().equals("args") 
                && ((JIdentityStmt)stmt.internal()).getRightOp().toString().contains("parameter0")) {
            stmt.setIntrinsic(true);
            stmt.setCode("args = " + CLanguageRuntime.invokeHelper(CLanguageRuntime.HELPER_RJAVA_INIT_ARGS, new String[]{"argc", "parameter0"}));
        }
    }

    public void generate(RMethod method) {
        // soot's helper class to dynamic load classes (including exceptions)
        // since we won't do dynamic loading in RJava, we dont generate exceptions
        if (method.internal().getName().equals("class$") && method.internal().getReturnType().toString().equals("java.lang.Class") 
                && method.internal().getParameterCount() == 1 && method.internal().getParameterType(0).toString().equals("java.lang.String")) {
            Body body = method.internal().retrieveActiveBody();
            
            // clear body
            PatchingChain<Unit> units = body.getUnits();
            Iterator<Unit> iter = units.iterator();
            
            Chain<Unit> newUnits = new HashChain<Unit>();
            
            boolean add = true;
            while(iter.hasNext()) {
                Unit current = iter.next();
                if (add)
                    newUnits.add(current);
                if (current instanceof JReturnStmt) 
                    add = false;
            }
            
            units.clear();
            units.addAll(newUnits);
            method.update();
        }
    }
}
