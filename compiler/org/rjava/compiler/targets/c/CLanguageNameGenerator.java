package org.rjava.compiler.targets.c;

import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RField;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.RType;

import soot.Local;
import soot.SootClass;
import soot.Type;
import soot.Value;
import soot.jimple.internal.JInstanceFieldRef;

public class CLanguageNameGenerator {
    CLanguageGenerator generator;
    
    public CLanguageNameGenerator(CLanguageGenerator generator) {
        this.generator = generator;
    }

    /*
     * generating c style name from RJava element
     */
    public String get(RClass klass) {
        String ret = javaNameToCName(klass.getName());
        generator.referencing(ret);
        return ret;
    }
    
    public String get(RMethod method) {
        return fromSootMethod(method.internal());
    }
    
    public String get(RType type) {
        String ret = javaNameToCName(type.getClassName());
        if (type.isReferenceType())
            generator.referencing(ret);
        return ret;
    }
    
    public String getWithPointerIfProper(RType type) {
        return get(type) + (type.isReferenceType() ? "*" : ""); 
    }
    
    public String get(RField field) {
        if (!field.isStatic())
            return field.getName();
        else return get(field.getDeclaringClass()) + "_" + field.getName();
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
        
        String ret = classPrefix + "_" + methodName;
        
        // add args type into method name to fake overloading
        for (int i = 0; i < method.getParameterCount(); i++) {
            ret += "_" + fromSootType(method.getParameterType(i));
        }
        
        return ret;
    }

    public String fromSootClass(SootClass declaringClass) {
        return get(RClass.fromSootClass(declaringClass));
    }
    
    public String fromSootLocal(Local local) {
        return local.getName();
    }

    public String fromSootInstanceFieldRef(JInstanceFieldRef ref) {
        RClass target = RClass.whoOwnsFieldInTypeHierarchy(RClass.fromClassName(ref.getBase().getType().toString()), RType.initWithClassName(ref.getField().getType().toString()), ref.getField().getName());
        StringBuilder ret = new StringBuilder();
        ret.append("(");
        ret.append("(" + get(target) + "*)");
        ret.append(ref.getBase() + ")");
        ret.append(" -> " + ref.getField().getName());
        return ret.toString();
    }
    
    public String fromSootType(Type type) {
        return get(RType.initWithClassName(type.toString()));
    }
}
