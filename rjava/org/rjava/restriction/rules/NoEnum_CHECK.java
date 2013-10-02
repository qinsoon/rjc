package org.rjava.restriction.rules;

import org.rjava.compiler.exception.RJavaRestrictionViolation;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.restriction.StaticRestrictionChecker;

import soot.SootClass;

public class NoEnum_CHECK {
    public static Boolean checkClass (RClass klass) throws RJavaRestrictionViolation {
        SootClass cur = klass.internal();
        while (cur.getSuperclass() != null) {
            cur = cur.getSuperclass();
            if (cur.getName().equals("java.lang.Enum")) {
                StaticRestrictionChecker.addRestrictionViolation(RJavaRestrictionViolation.newRestrictionViolation("NoEnum", klass));
                return false;
            }
            if (cur.getName().equals("java.lang.Object"))
                return true;
        }
        return true;
    }
}
