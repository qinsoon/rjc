package org.rjava.restriction.rules;

import org.rjava.compiler.exception.RJavaRestrictionViolation;
import org.rjava.compiler.restriction.StaticRestrictionChecker;
import org.rjava.compiler.semantics.representation.RClass;

import soot.Modifier;
import soot.SootClass;

public class NoEnum_CHECK {
    public static Boolean checkClass (RClass klass) throws RJavaRestrictionViolation {
        SootClass cur = klass.internal();
        if (Modifier.isEnum(cur.getModifiers())) {
            StaticRestrictionChecker.addRestrictionViolation(RJavaRestrictionViolation.newRestrictionViolation("NoEnum", klass));
            return false;
        } return true;
    }
}
