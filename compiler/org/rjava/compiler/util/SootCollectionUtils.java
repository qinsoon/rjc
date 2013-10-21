package org.rjava.compiler.util;

import java.util.Collection;


import soot.Value;
import soot.jimple.InstanceFieldRef;

public abstract class SootCollectionUtils {

    public static boolean contains(Collection<? extends Value> collection, Value v) {
        return gets(collection, v) != null;
    }

    public static Value gets(Collection<? extends Value> collection, Value v) {
        for (Value cur : collection) {
            if (isEqualValue(cur, v))
                return cur;
        }
        return null;
    }

    // instance field is slightly different
    public static boolean isEqualValue(Value a, Value b) {
        if (a instanceof InstanceFieldRef && b instanceof InstanceFieldRef) {
            InstanceFieldRef refA = (InstanceFieldRef)a;
            InstanceFieldRef refB = (InstanceFieldRef)b;
            
            return refA.getField().getDeclaringClass().equals(refB.getField().getDeclaringClass())
                    && refA.getField().getName().equals(refB.getField().getName());
        } else return a.equivTo(b);
    }
}
