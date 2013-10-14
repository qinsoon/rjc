package org.rjava.compiler.targets.c;

import java.util.List;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RField;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.RType;
import org.rjava.compiler.targets.c.runtime.CLanguageRuntime;
import org.rjava.compiler.targets.c.runtime.RuntimeHelpers;
import org.rjava.compiler.util.HelperMethod;
import org.rjava.compiler.util.Statistics;

import soot.Local;
import soot.SootClass;
import soot.SootField;
import soot.SootFieldRef;
import soot.Type;
import soot.Value;
import soot.jimple.IntConstant;
import soot.jimple.LongConstant;
import soot.jimple.NullConstant;
import soot.jimple.StringConstant;
import soot.jimple.internal.JArrayRef;
import soot.jimple.internal.JInstanceFieldRef;

public class CIdentifiers {
    CLanguageGenerator generator;
    
    public CIdentifiers(CLanguageGenerator generator) {
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
    public String get(RClass klass) {
        String ret = javaNameToCName(klass.getName());
        generator.referencing(klass);
        return ret;
    }
    
    public String getStruct(RClass klass) {
        return "struct " + get(klass);
    }
    
    public String get(RMethod method) {
        return fromSootMethod(method.internal());
    }
    
    public String get(RType type) {
        String ret = javaNameToCName(type.getClassName());
        if (type.isReferenceType() || type.isMagicType())
            // FIXME
            if (type.isArray())
                generator.referencing(type);
            else
                generator.referencing(type);
        return ret;
    }
    
    public String getWithPointerIfProper(RType type) {
        return (type.isReferenceType() ? "struct " : "") + get(type) + (type.isReferenceType()? "*":"") + (type.isArray() ? "*" : ""); 
    }
    
    public String get(RField field) {
        if (!field.isStatic())
            return field.getName();
        else return CLanguageGenerator.C_GLOBAL_VAR_PREFIX + get(field.getDeclaringClass()) + "_" + field.getName();
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
            ret += "_" + fromSootType(method.getParameterType(i));
            if (RType.initWithClassName(method.getParameterType(i).toString()).isArray())
                ret += "array";
        }
        
        return ret;
    }

    public String fromSootClass(SootClass declaringClass) {
        return get(RClass.fromSootClass(declaringClass));
    }
    
    public String fromSootLocal(Local local) {
        return local.getName();
    }
    
    public String fromSootType(Type type) {
        return get(RType.initWithClassName(type.toString()));
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
        else if ( (value instanceof IntConstant)
                && Integer.parseInt(value.toString()) == Integer.MIN_VALUE) {
            // to avoid warning: warning: this decimal constant is unsigned only in ISO C90
            // thus we need to include <limits.h>
            return "INT_MIN";
        }
        else return value.toString();
    }
}
