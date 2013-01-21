package org.rjava.compiler.targets.c;

import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.semantics.representation.RType;

import soot.SootMethod;

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
        
    }

    public void generate(RMethod method) {
        method.setIntrinsic(false);
    }
}
