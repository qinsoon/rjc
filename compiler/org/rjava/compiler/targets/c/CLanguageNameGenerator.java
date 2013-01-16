package org.rjava.compiler.targets.c;

import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RField;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.RType;

import soot.Local;
import soot.SootClass;
import soot.Value;

public class CLanguageNameGenerator {

    public CLanguageNameGenerator() {

    }

    /*
     * generating c style name from RJava element
     */
    public String get(RClass klass) {
        return javaNameToCName(klass.getName());
    }
    
    public String get(RMethod method) {
        String classPrefix = get(method.getKlass());
        String methodName = method.getName();
        if (methodName.equals("<init>"))
            methodName = CLanguageGenerator.RJAVA_INIT;
        else if (methodName.equals("<clinit>"))
            methodName = CLanguageGenerator.RJAVA_CLINIT;
        return classPrefix + "_" + methodName;
    }
    
    public String get(RType type) {
        return javaNameToCName(type.getClassName());
    }
    
    public String get(RField field) {
        return "";
    }
    
    private String javaNameToCName(String javaName) {
        return javaName.replace('.', '_');
    }
    
    /*
     * generating c style name from soot element 
     */
    public String fromSootStaticFieldRef(soot.jimple.StaticFieldRef ref) {
        String className = ref.getField().getDeclaringClass().getName();
        String refName = ref.getField().getName();
        return javaNameToCName(className + "." + refName);
    }
    
    public String fromSootMethod(soot.SootMethod method) {
        String classPrefix = fromSootClass(method.getDeclaringClass());
        String methodName = method.getName();
        if (methodName.equals("<init>"))
            methodName = CLanguageGenerator.RJAVA_INIT;
        else if (methodName.equals("<clinit>"))
            methodName = CLanguageGenerator.RJAVA_CLINIT;
        return classPrefix + "_" + methodName;
    }

    public String fromSootClass(SootClass declaringClass) {
        return javaNameToCName(declaringClass.getName());
    }
    
    public String fromSootLocal(Local local) {
        return local.getName();
    }
}
