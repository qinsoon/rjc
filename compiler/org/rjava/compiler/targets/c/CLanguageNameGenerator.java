package org.rjava.compiler.targets.c;

import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RField;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.RType;

public class CLanguageNameGenerator {

    public CLanguageNameGenerator() {
        // TODO Auto-generated constructor stub
    }

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
}
