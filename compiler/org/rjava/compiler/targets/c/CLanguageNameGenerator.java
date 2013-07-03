package org.rjava.compiler.targets.c;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RField;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.RType;
import org.rjava.compiler.targets.c.runtime.CLanguageRuntime;

import soot.Local;
import soot.SootClass;
import soot.Type;
import soot.Value;
import soot.jimple.LongConstant;
import soot.jimple.NullConstant;
import soot.jimple.StringConstant;
import soot.jimple.internal.JArrayRef;
import soot.jimple.internal.JInstanceFieldRef;

public class CLanguageNameGenerator {
    CLanguageGenerator generator;
    
    public CLanguageNameGenerator(CLanguageGenerator generator) {
        this.generator = generator;
    }

    /*
     * generating c style name from RJava element
     */
    /**
     * get the C name for such class
     * @param klass
     * @param initDependency true if this class needs to be initialized first
     * @return
     */
    public String get(RClass klass, boolean initDependency) {
        String ret = javaNameToCName(klass.getName());
        generator.referencing(klass, ret, initDependency);
        return ret;
    }
    
    public String getStruct(RClass klass) {
        return "struct " + get(klass, false);
    }
    
    public String get(RMethod method) {
        return fromSootMethod(method.internal());
    }
    
    public String get(RType type, boolean initDependency) {
        String ret = javaNameToCName(type.getClassName());
        if (type.isReferenceType() || type.isMagicType())
            if (type.isArray())
                generator.referencing(SemanticMap.getRClassFromRType(type), ret, false);
            else
                generator.referencing(SemanticMap.getRClassFromRType(type), ret, initDependency);
        return ret;
    }
    
    public String getWithPointerIfProper(RType type, boolean initDependency) {
        return (type.isReferenceType() ? "struct " : "") + get(type, initDependency) + (type.isReferenceType()? "*":"") + (type.isArray() ? "*" : ""); 
    }
    
    public String get(RField field, boolean initDependency) {
        if (!field.isStatic())
            return field.getName();
        else return CLanguageGenerator.C_GLOBAL_VAR_PREFIX + get(field.getDeclaringClass(), initDependency) + "_" + field.getName();
    }
    
    /**
     * get a C style name for a java name. Code generating shouldn't directly call this method, use get(RClass/RMethod/RType) instead. 
     * @param javaName
     * @return
     */
    public String javaNameToCName(String javaName) {
        return javaName.replace('.', '_');
    }
    
    /*
     * generating c style name from soot element 
     */
    public String fromSootStaticFieldRef(soot.jimple.StaticFieldRef ref) {
        String className = fromSootClass(ref.getField().getDeclaringClass(), true);
        String refName = ref.getField().getName();
        return CLanguageGenerator.C_GLOBAL_VAR_PREFIX + javaNameToCName(className + "." + refName);
    }
    
    public String fromSootMethod(soot.SootMethod method) {
        String classPrefix = fromSootClass(method.getDeclaringClass(), true);
        String methodName = method.getName();
        if (methodName.equals("<init>"))
            methodName = CLanguageGenerator.RJAVA_INIT;
        else if (methodName.equals("<clinit>"))
            methodName = CLanguageGenerator.RJAVA_CLINIT;
        
        String ret = classPrefix + "_" + methodName;
        
        // add args type into method name to fake overloading
        for (int i = 0; i < method.getParameterCount(); i++) {
            ret += "_" + fromSootType(method.getParameterType(i), true);
            if (RType.initWithClassName(method.getParameterType(i).toString()).isArray())
                ret += "array";
        }
        
        return ret;
    }
    
    public String getFunctionPointerName(RMethod method) {
        return getFunctionPointerNameFromSootMethod(method.internal());
    }
    
    public String getFunctionPointerNameFromSootMethod(soot.SootMethod method) {
        String methodName = method.getName();
        if (methodName.equals("<init>"))
            methodName = CLanguageGenerator.RJAVA_INIT;
        else if (methodName.equals("<clinit>"))
            methodName = CLanguageGenerator.RJAVA_CLINIT;
        
        String ret = methodName;
        
        // add args type into method name to fake overloading
        for (int i = 0; i < method.getParameterCount(); i++) {
            ret += "_" + fromSootType(method.getParameterType(i), true);
            if (RType.initWithClassName(method.getParameterType(i).toString()).isArray())
                ret += "array";
        }
        
        return ret;
    }

    public String fromSootClass(SootClass declaringClass, boolean initDependency) {
        return get(RClass.fromSootClass(declaringClass), initDependency);
    }
    
    public String fromSootLocal(Local local) {
        return local.getName();
    }

    public String fromSootInstanceFieldRef(JInstanceFieldRef ref) {
        RClass target = RClass.whoOwnsFieldInTypeHierarchy(RClass.fromClassName(ref.getBase().getType().toString()), RType.initWithClassName(ref.getField().getType().toString()), ref.getField().getName());
        StringBuilder ret = new StringBuilder();
        ret.append("(");
        ret.append("(" + get(target, true) + "*)");
        ret.append(ref.getBase() + ")");
        ret.append(" -> " + ref.getField().getName());
        return ret.toString();
    }
    
    public String fromSootType(Type type, boolean initDependency) {
        return get(RType.initWithClassName(type.toString()), initDependency);
    }
    
    public String fromSootValue(Value value) {
        if (value.toString().equals("null"))
            return "NULL";
        else if (value instanceof StringConstant) {
            return "newStringConstant(" + value.toString() + ")";
        }
        else if (value instanceof LongConstant) {
            // make sure that long is 64bits (LL) under m32 mode
            return value.toString() + (RJavaCompiler.m32 ? "L" : "");
        }
        else return value.toString();
    }

    public String fromSootJArrayRef(JArrayRef op) {
        String type = getWithPointerIfProper(RType.initWithClassName(op.getType().toString()), true);
        
        String ret = "*((" + type + "*)";
        ret += CLanguageRuntime.invokeHelper(CLanguageRuntime.HELPER_RJAVA_ACCESS_ARRAY, new String[]{op.getBase().toString(), op.getIndex().toString()});
        ret += ")";
        
        return ret;
    }
}
