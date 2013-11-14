package org.rjava.compiler.util;

import java.util.Collection;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.pass.PointsToAnalysisPass;


import soot.Local;
import soot.Value;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InvokeExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.internal.JimpleLocal;

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
        } 
               
        if (a instanceof InvokeExpr && b instanceof InvokeExpr) {
            InvokeExpr invokeA = (InvokeExpr) a;
            InvokeExpr invokeB = (InvokeExpr) b;
            
            boolean sameTypeInvoke = a.getClass().equals(b.getClass());
            if (!sameTypeInvoke) {
                return false;
            }
            
            boolean sameMethod = invokeA.getMethod().equals(invokeB.getMethod());
            if (!sameMethod) {
                return false;
            }
            
            for (int i = 0; i < invokeA.getArgCount(); i++)
                if (!invokeA.getArg(i).equivTo(invokeB.getArg(i))) {
                    return false;
                }
            
            if (a instanceof SpecialInvokeExpr && b instanceof SpecialInvokeExpr) {
                SpecialInvokeExpr specialInvokeA = (SpecialInvokeExpr) a;
                SpecialInvokeExpr specialInvokeB = (SpecialInvokeExpr) b;
                return specialInvokeA.getBase().equivTo(specialInvokeB.getBase());
            }
            
            if (a instanceof VirtualInvokeExpr && b instanceof VirtualInvokeExpr) {
                VirtualInvokeExpr virtualInvokeA = (VirtualInvokeExpr) a;
                VirtualInvokeExpr virtualInvokeB = (VirtualInvokeExpr) b;
                return virtualInvokeA.getBase().equivTo(virtualInvokeB.getBase());
            }
            
            return true;
        }
        
        return a.equivTo(b);
    }
}
