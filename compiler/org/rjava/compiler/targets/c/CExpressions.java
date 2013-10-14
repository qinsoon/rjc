package org.rjava.compiler.targets.c;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RType;
import org.rjava.compiler.targets.c.runtime.CLanguageRuntime;
import org.rjava.compiler.targets.c.runtime.RuntimeHelpers;
import org.rjava.compiler.util.HelperMethod;
import org.rjava.compiler.util.Statistics;

import soot.Local;
import soot.SootField;
import soot.Type;
import soot.Value;
import soot.jimple.BinopExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.NumericConstant;
import soot.jimple.StaticFieldRef;
import soot.jimple.internal.JArrayRef;
import soot.jimple.internal.JCastExpr;
import soot.jimple.internal.JCmpExpr;
import soot.jimple.internal.JCmpgExpr;
import soot.jimple.internal.JCmplExpr;
import soot.jimple.internal.JEqExpr;
import soot.jimple.internal.JInstanceFieldRef;
import soot.jimple.internal.JInstanceOfExpr;
import soot.jimple.internal.JInterfaceInvokeExpr;
import soot.jimple.internal.JLengthExpr;
import soot.jimple.internal.JNeExpr;
import soot.jimple.internal.JNegExpr;
import soot.jimple.internal.JNewArrayExpr;
import soot.jimple.internal.JNewExpr;
import soot.jimple.internal.JNewMultiArrayExpr;
import soot.jimple.internal.JSpecialInvokeExpr;
import soot.jimple.internal.JStaticInvokeExpr;
import soot.jimple.internal.JUshrExpr;
import soot.jimple.internal.JVirtualInvokeExpr;
import soot.jimple.internal.JimpleLocal;

public class CExpressions {
    CLanguageGenerator generator;
    CIdentifiers id;

    public CExpressions(CLanguageGenerator generator) {
        this.generator = generator;
        this.id = new CIdentifiers(generator);
    }

    public boolean isValidSootLValue(Value v) {
        return v instanceof JimpleLocal || v instanceof JInstanceFieldRef
                || v instanceof StaticFieldRef || v instanceof JArrayRef;
    }

    public String fromSootLValue(Value leftOp) {
        // left op -> local | field | local.field | local[imm]
        String leftOpStr = CLanguageGenerator.INCOMPLETE_IMPLEMENTATION;
        if (leftOp instanceof soot.jimple.internal.JimpleLocal) {
            leftOpStr = id.fromSootLocal((Local) leftOp);
        } else if (leftOp instanceof soot.jimple.internal.JInstanceFieldRef) {
            leftOpStr = fromSootInstanceFieldRef((JInstanceFieldRef) leftOp);
        } else if (leftOp instanceof soot.jimple.StaticFieldRef) {
            leftOpStr = fromSootStaticFieldRef((StaticFieldRef) leftOp);
        } else if (leftOp instanceof soot.jimple.internal.JArrayRef) {
            leftOpStr = fromSootJArrayRef((soot.jimple.internal.JArrayRef) leftOp);
        } else {
            RJavaCompiler.println("leftOp:" + leftOp.getClass());
            RJavaCompiler.incompleteImplementationError();
        }

        return leftOpStr;
    }

    public String fromSootRValue(Value rightOp) {
        // right op -> rvalue | imm
        // rvalue -> concreteRef | imm | expr
        // concreteRef -> field | local.field | local[imm]
        // expr -> imm1 binop imm2 | (type) imm | imm instanceof type |
        // invokeExpr | new refType | newarray (type) [imm] |
        // newmultiarray(type)[imm1]...[immn][]* | length imm | neg imm;
        // invokeExpr -> specialinvoke/interfaceinvoke/virtualinvoke
        // local.m(imm1,...,immn) | staticinvoke m(imm1,...,immn)
        String rightOpStr = CLanguageGenerator.INCOMPLETE_IMPLEMENTATION;
        if (rightOp instanceof soot.jimple.StaticFieldRef) {
            rightOpStr = fromSootStaticFieldRef((StaticFieldRef) rightOp);
        } else if (rightOp instanceof soot.jimple.internal.JimpleLocal) {
            rightOpStr = id.fromSootLocal((Local) rightOp);
        } else if (rightOp instanceof soot.jimple.internal.JInstanceFieldRef) {
            rightOpStr = fromSootInstanceFieldRef((JInstanceFieldRef) rightOp);
        } else if (rightOp instanceof soot.jimple.InvokeExpr) {
            rightOpStr = fromSootInvokeExpr((InvokeExpr) rightOp);
        } else if (rightOp instanceof soot.jimple.BinopExpr) {
            rightOpStr = fromSootBinopExpr((BinopExpr) rightOp);
        } else if (rightOp instanceof soot.jimple.NumericConstant) {
            rightOpStr = id.fromSootValue((NumericConstant) rightOp);
        } else if (rightOp instanceof soot.jimple.internal.JNewExpr) {
            rightOpStr = fromSootJNewExpr((JNewExpr) rightOp);
        } else if (rightOp instanceof soot.jimple.StringConstant) {
            rightOpStr = id.fromSootValue((soot.jimple.StringConstant) rightOp);
        } else if (rightOp instanceof soot.jimple.NullConstant) {
            rightOpStr = id.fromSootValue((soot.jimple.NullConstant) rightOp);
        } else if (rightOp instanceof soot.jimple.internal.JLengthExpr) {
            rightOpStr = fromSootJLengthExpr((soot.jimple.internal.JLengthExpr) rightOp);
        } else if (rightOp instanceof soot.jimple.internal.JNewArrayExpr) {
            rightOpStr = fromSootJNewArrayExpr((soot.jimple.internal.JNewArrayExpr) rightOp);
        } else if (rightOp instanceof soot.jimple.internal.JNewMultiArrayExpr) {
            rightOpStr = fromSootJNewMultiArrayExpr((soot.jimple.internal.JNewMultiArrayExpr) rightOp);
        } else if (rightOp instanceof soot.jimple.internal.JArrayRef) {
            rightOpStr = fromSootJArrayRef((soot.jimple.internal.JArrayRef) rightOp);
        } else if (rightOp instanceof soot.jimple.internal.JCastExpr) {
            rightOpStr = fromSootJCastExpr((soot.jimple.internal.JCastExpr) rightOp);
        } else if (rightOp instanceof soot.jimple.internal.JInstanceOfExpr) {
            rightOpStr = fromSootJInstanceOfExpr((JInstanceOfExpr) rightOp);
        } else if (rightOp instanceof soot.jimple.internal.JNegExpr) {
            rightOpStr = fromSootJNegExpr((JNegExpr) rightOp);
        } else {
            RJavaCompiler.println("rightOp:" + rightOp.getClass());
            RJavaCompiler.incompleteImplementationError();
        }

        return rightOpStr;
    }

    public String fromSootInvokeExpr(soot.jimple.InvokeExpr invoke) {
        String ret = null;
        if (invoke instanceof soot.jimple.internal.JVirtualInvokeExpr) {
            ret = fromSootJVirtualInvokeExpr((JVirtualInvokeExpr) invoke);
        } else if (invoke instanceof soot.jimple.internal.JSpecialInvokeExpr) {
            ret = fromSootJSpecialInvokeExpr((JSpecialInvokeExpr) invoke);
        } else if (invoke instanceof soot.jimple.internal.JInterfaceInvokeExpr) {
            ret = fromSootJInterfaceInvokeExpr((JInterfaceInvokeExpr) invoke);
        } else if (invoke instanceof soot.jimple.internal.JStaticInvokeExpr) {
            ret = fromSootJStaticInvokeExpr((JStaticInvokeExpr) invoke);
        } else {
            ret = CLanguageGenerator.INCOMPLETE_IMPLEMENTATION;
            RJavaCompiler.incompleteImplementationError();
        }
        if (RClass.fromSootClass(invoke.getMethod().getDeclaringClass())
                .isAppClass())
            generator
                    .referencing(RMethod.getFromSootMethod(invoke.getMethod()));
        return ret;
    }

    // FIXME: library call and app call should be unified.
    public String fromSootJVirtualInvokeExpr(
            soot.jimple.internal.JVirtualInvokeExpr virtualInvoke) {
        String callingClass = virtualInvoke.getMethod().getDeclaringClass()
                .getName();
        if (callingClass.startsWith("java.")
                || callingClass.startsWith("javax.")
                || callingClass.startsWith("org.vmmagic.")) {
            return fromSootJVirtualInvokeExpr_libCall(virtualInvoke);
        } else
            return fromSootJVirtualInvokeExpr_appCall(virtualInvoke);
    }

    /**
     * virtual call into library, we dont do any dispatching related work here.
     * 
     * @param virtualInvoke
     * @return
     */
    public String fromSootJVirtualInvokeExpr_libCall(
            soot.jimple.internal.JVirtualInvokeExpr virtualInvoke) {
        String methodName = id.fromSootMethod(virtualInvoke.getMethod());
        String base = id.fromSootLocal((Local) virtualInvoke.getBase());

        String ret = methodName + "(" + base;

        if (virtualInvoke.getArgCount() == 0)
            ret += ")";
        else {
            for (int i = 0; i < virtualInvoke.getArgCount(); i++) {
                // ret += ", " + name.fromSootValue(virtualInvoke.getArg(i));
                ret += ", " + typeCastingForInvokeParameter(virtualInvoke, i);
            }
            ret += ")";
        }

        return ret;
    }

    /**
     * virtual call into application, we have to solve dispatching here.
     * 
     * @param virtualInvoke
     * @return
     */
    public String fromSootJVirtualInvokeExpr_appCall(
            soot.jimple.internal.JVirtualInvokeExpr virtualInvoke) {
        /* trying to devirtualize the invoke first */
        Statistics.increaseCounterByOne(Statistics.VIRTUAL_CALL_COUNT);
        String typeInfo = "";
        if (RJavaCompiler.OPT_DEVIRTUALIZATION) {
            Value baseValue = virtualInvoke.getBase();
            Type baseType = baseValue.getType();
            Type inferred;

            String typeInferenceInfo = "";
            if (RClass.fromClassName(
                    RType.initWithSootType(baseType).getClassName())
                    .isDefactoFinal()) {
                inferred = baseType;

                typeInferenceInfo = baseValue.toString() + "(final) -> "
                        + inferred.toString();
            } else {
                inferred = SemanticMap.pta.inferType(baseValue);

                for (Value v : SemanticMap.pta.tracePointsTo(baseValue)) {
                    typeInferenceInfo += v + "->";
                }
                typeInferenceInfo += inferred != null ? inferred.toString()
                        : "???";
            }

            typeInfo = Code.commentln(typeInferenceInfo);

            if (inferred != null) {
                Statistics.increaseCounterByOne("type inference success");

                // devirtualize
                Statistics.increaseCounterByOne("devirtualize");
                StringBuilder ret = new StringBuilder();

                RType inferredRType = RType.initWithSootType(inferred);
                RClass targetClass = SemanticMap
                        .getRClassFromRType(inferredRType);
                RClass actualClass = RClass
                        .whoImplementsMethodLastInTypeHierarchy(targetClass,
                                RMethod.getFromSootMethod(virtualInvoke
                                        .getMethod()));
                RMethod directInvoke = actualClass
                        .getMethodByMatchingNameAndParameters(virtualInvoke
                                .getMethod());

                generator.referencing(directInvoke);

                ret.append(id.get(actualClass));
                ret.append("_");
                ret.append(id
                        .getFunctionPointerNameFromSootMethod(virtualInvoke
                                .getMethod()));
                ret.append("(");

                String base = id.fromSootLocal((Local) virtualInvoke.getBase());
                ret.append(base);

                if (virtualInvoke.getArgCount() == 0)
                    ret.append(")");
                else {
                    for (int i = 0; i < virtualInvoke.getArgCount(); i++) {
                        // ret += ", " +
                        // name.fromSootValue(virtualInvoke.getArg(i));
                        ret.append(", "
                                + typeCastingForInvokeParameter(virtualInvoke,
                                        i));
                    }
                    ret.append(")");
                }
                return ret.toString() + typeInfo;
            }

            Statistics.increaseCounterByOne("type inference fail");
        }

        /* virtual call */

        // for a call to cat.speak()
        // we will have ((Animal_class) ((RJava_Common_Instance*) cat) ->
        // class_struct) -> speak(cat);
        // 1. who declares speak() 2. use common instance to get class_struct

        // get who declares speak() first
        RClass baseClass = RClass.fromClassName(virtualInvoke.getBase()
                .getType().toString());
        RClass targetClass = RClass.whoOwnsMethodInTypeHierarchy(baseClass,
                virtualInvoke.getMethod());

        // use class_struct to get function ptr
        String methodName = id
                .getFunctionPointerNameFromSootMethod(virtualInvoke.getMethod());
        String base = id.fromSootLocal((Local) virtualInvoke.getBase());

        StringBuilder ret = new StringBuilder();
        ret.append(Code.getClassAttributeFromInstance(base, id.get(targetClass),
                methodName));
        ret.append("(" + base); // base is the first parameter

        if (virtualInvoke.getArgCount() == 0)
            ret.append(")");
        else {
            for (int i = 0; i < virtualInvoke.getArgCount(); i++) {
                // ret.append(", " +
                // name.fromSootValue(virtualInvoke.getArg(i)));
                ret.append(", "
                        + typeCastingForInvokeParameter(virtualInvoke, i));
            }
            ret.append(")");
        }

        return ret.toString() + typeInfo;
    }

    public String fromSootJInterfaceInvokeExpr(JInterfaceInvokeExpr invoke) {
        // for a class Cat cat which implements interface DoArithmetic, and
        // correspondingly has method calcAdd()
        // we have a pointer (DoArithmetic* cat) which is actually pointing to
        // Cat
        // we invoke calcAdd by ((DoArithmetic*) rjava_get_interface(
        // ((RJava_Common_Class*)((RJava_Common_Instance*) cat) -> class_struct)
        // -> interfaces, "DoArithmetic") ) -> calcAdd();

        StringBuilder ret = new StringBuilder();

        // get the interface name first
        RClass interfaceClass = RClass.fromClassName(invoke.getBase().getType()
                .toString());
        String methodName = id.getFunctionPointerNameFromSootMethod(invoke
                .getMethod());
        String base = id.fromSootLocal((Local) invoke.getBase());

        ret.append("(");
        ret.append("(" + id.get(interfaceClass) + "*) ");
        String interfaceList = Code.getClassAttributeFromInstance(base, CLanguageRuntime.INTERFACE_LIST);
        String interfaceName = "\"" + id.get(interfaceClass) + "\"";
        ret.append(RuntimeHelpers.invoke(RuntimeHelpers.GET_INTERFACE,
                new String[] { interfaceList, interfaceName }));
        ret.append(")");
        ret.append(" -> " + methodName + "(" + base);

        if (invoke.getArgCount() == 0)
            ret.append(")");
        else {
            for (int i = 0; i < invoke.getArgCount(); i++) {
                // ret.append(", " + name.fromSootValue(invoke.getArg(i)));
                ret.append(", " + typeCastingForInvokeParameter(invoke, i));
            }
            ret.append(")");
        }

        return ret.toString();
    }

    public String fromSootJSpecialInvokeExpr(
            soot.jimple.internal.JSpecialInvokeExpr specialInvoke) {
        String methodName = id.fromSootMethod(specialInvoke.getMethod());
        String base = id.fromSootLocal((Local) specialInvoke.getBase());

        String ret = methodName + "(" + base;

        if (specialInvoke.getArgCount() == 0)
            ret += ")";
        else {
            for (int i = 0; i < specialInvoke.getArgCount(); i++) {
                // ret += ", " + name.fromSootValue(specialInvoke.getArg(i));
                ret += ", " + typeCastingForInvokeParameter(specialInvoke, i);
            }
            ret += ")";
        }

        return ret;
    }

    public String fromSootJStaticInvokeExpr(JStaticInvokeExpr actualInvoke) {
        String ret = "";
        ret = id.fromSootMethod(actualInvoke.getMethod());

        ret += "(";
        for (int i = 0; i < actualInvoke.getArgCount(); i++) {
            // ret += name.fromSootValue(actualInvoke.getArg(i));
            ret += typeCastingForInvokeParameter(actualInvoke, i);
            if (i != actualInvoke.getArgCount() - 1)
                ret += ", ";
        }
        ret += ")";
        return ret;
    }

    public String fromSootJNegExpr(JNegExpr rightOp) {
        return "-(" + id.fromSootValue(rightOp.getOp()) + ")";
    }

    public String fromSootConditionExpr(soot.jimple.ConditionExpr conditionExpr) {
        // if we are comparing two pointers, we need to do a type cast (to avoid
        // gcc warnings)
        if (conditionExpr instanceof JEqExpr
                || conditionExpr instanceof JNeExpr) {
            RType left = RType.initWithClassName(conditionExpr.getOp1()
                    .getType().toString());
            RType right = RType.initWithClassName(conditionExpr.getOp2()
                    .getType().toString());
            if (left.isReferenceType() && right.isReferenceType()) {
                return "(intptr_t)" + id.fromSootValue(conditionExpr.getOp1())
                        + " " + conditionExpr.getSymbol() + " (intptr_t)"
                        + id.fromSootValue(conditionExpr.getOp2());
            }
        }

        // default
        return id.fromSootValue(conditionExpr.getOp1())
                + conditionExpr.getSymbol()
                + id.fromSootValue(conditionExpr.getOp2());
    }

    public String fromSootBinopExpr(soot.jimple.BinopExpr binopExpr) {
        if (binopExpr instanceof JCmpExpr || binopExpr instanceof JCmpgExpr) {
            // Java:
            // a < b in java

            // Jimple:
            // int result = a cmpg b
            // if (result < 0) goto true_stmt
            // goto false_stmt

            // Java:
            // a == b in java

            // Jimple:
            // int result = a cmpg b
            // if (result == 0) goto true_stmt
            // goto false_stmt

            // So translated C:
            // int result = (a < b) ? -1 : ((a == b) ? 0 : 1)

            String op1 = id.fromSootValue(binopExpr.getOp1());
            String op2 = id.fromSootValue(binopExpr.getOp2());

            String ret = "(" + op1 + "<" + op2 + ") ? -1 : ((" + op1 + "=="
                    + op2 + ") ? 0 : 1)";
            return ret;
        }
        if (binopExpr instanceof JCmplExpr) {
            // Java:
            // a > b

            // Jimple:
            // int result = a cmpl b
            // if (result > 0) goto true_stmt
            // goto false_stmt

            // So translated C:
            // int result = (a > b) ? : 1 ((a == b) ? 0 : -1)
            String op1 = id.fromSootValue(binopExpr.getOp1());
            String op2 = id.fromSootValue(binopExpr.getOp2());
            String ret = "(" + op1 + ">" + op2 + ") ? 1 : ((" + op1 + "=="
                    + op2 + ") ? 0 : -1)";
            return ret;
        }
        if (binopExpr instanceof JUshrExpr) {
            return "(unsigned int)(" + id.fromSootValue(binopExpr.getOp1())
                    + " >> " + id.fromSootValue(binopExpr.getOp2()) + ")";
        }

        // default
        return id.fromSootValue(binopExpr.getOp1()) + binopExpr.getSymbol()
                + id.fromSootValue(binopExpr.getOp2());
    }

    public String fromSootJNewExpr(soot.jimple.internal.JNewExpr newExpr) {
        // intrinsic happens, and this type becomes a primitive type. just init
        // it to zero
        if (RType.initWithClassName(newExpr.getType().toString()).isPrimitive())
            return "0";

        // otherwise, we malloc
        String type = id.fromSootType(newExpr.getType());
        String ret = "(" + type + CLanguageGenerator.POINTER + ") "
                + CLanguageGenerator.MALLOC + "(";
        ret += CLanguageGenerator.SIZE_OF + "(" + type + "))";
        return ret;
    }

    public String fromSootJCastExpr(JCastExpr castExpr) {
        return "("
                + id.getWithPointerIfProper(RType.initWithClassName(castExpr
                        .getCastType().toString())) + ")"
                + castExpr.getOp().toString();
    }

    /*
     * RJava array implements
     */
    public String fromSootJLengthExpr(JLengthExpr rightOp) {
        return RuntimeHelpers.invoke(RuntimeHelpers.LENGTH_OF_ARRAY,
                new String[] { rightOp.getOp().toString() });
    }

    public String fromSootJNewArrayExpr(JNewArrayExpr rightOp) {
        String length = rightOp.getSize().toString();
        String eleSize = "(long) sizeof("
                + id.getWithPointerIfProper(RType.initWithClassName(rightOp
                        .getBaseType().toString())) + ")";
        return RuntimeHelpers.invoke(RuntimeHelpers.NEW_ARRAY, new String[] {
                length, eleSize });
    }

    public String fromSootJNewMultiArrayExpr(JNewMultiArrayExpr rightOp) {
        String dimensionArray = "(int[]){";
        for (int i = 0; i < rightOp.getSizeCount(); i++) {
            dimensionArray += rightOp.getSize(i);
            if (i != rightOp.getSizeCount() - 1)
                dimensionArray += ",";
        }
        dimensionArray += "}";

        String dimensionSize = String.valueOf(rightOp.getSizeCount());
        String eleSize = "sizeof(" + id.fromSootType(rightOp.getBaseType())
                + ")";
        return RuntimeHelpers.invoke(RuntimeHelpers.NEW_MULTIARRAY,
                new String[] { dimensionArray, dimensionSize, eleSize });
    }

    /*
     * instanceof expression
     */
    public String fromSootJInstanceOfExpr(JInstanceOfExpr expr) {
        // e.g. temp instanceof org.mmtk.plan.ComplexPhase
        // will translate to a call to helper method rjava_instanceof(temp,
        // &org_mmtk_plan_CompelxPhase_class_instance);
        String ret = RuntimeHelpers
                .invoke(RuntimeHelpers.INSTANCEOF,
                        new String[] {
                                "(void*)" + id.fromSootValue(expr.getOp()),
                                "(void*)&"
                                        + id.fromSootType(expr.getCheckType())
                                        + CLanguageRuntime.CLASS_STRUCT_INSTANCE_SUFFIX });
        return ret;
    }

    public String fromSootInstanceFieldRef(JInstanceFieldRef ref,
            String actualBase) {
        Value base = ref.getBase();
        SootField field = ref.getField();
        RClass current = RClass.fromClassName(base.getType().toString());
        RClass target = RClass.whoOwnsFieldInTypeHierarchy(current,
                RType.initWithClassName(field.getType().toString()),
                field.getName());

        if (RJavaCompiler.OPT_OBJECT_INLINING
                && SemanticMap.oi.doesPointToInlinableField(base)) {
            StringBuilder ret = new StringBuilder();

            if (current.equals(target)) {
                ret.append("(");
                ret.append(actualBase);
                ret.append(")." + field.getName());
            } else {
                ret.append("(*(");
                ret.append("(" + id.get(target) + "*)");
                ret.append("&" + actualBase + "))");
                ret.append("." + field.getName());
            }
            return ret.toString();
        }
        
        return Code.getInstanceAttribute(actualBase, id.get(target), field.getName());
    }

    public String fromSootInstanceFieldRef(JInstanceFieldRef ref) {
        return fromSootInstanceFieldRef(ref, ref.getBase().toString());
    }

    public String fromSootJArrayRef(JArrayRef op) {
        String type = id.getWithPointerIfProper(RType.initWithClassName(op
                .getType().toString()));

        String ret = "*((" + type + "*)";
        HelperMethod accessArray;
        if (generator.getMethodContext().hasNoBoundsCheckAnnotation()
                || !RJavaCompiler.getGeneratorOptions().allowArrayBoundCheck())
            accessArray = RuntimeHelpers.ACCESS_ARRAY_NOBOUNDS_CHECK;
        else
            accessArray = RuntimeHelpers.ACCESS_ARRAY;
        ret += RuntimeHelpers.invoke(accessArray, new String[] {
                op.getBase().toString(), op.getIndex().toString() });
        ret += ")";

        return ret;
    }

    public String fromSootStaticFieldRef(soot.jimple.StaticFieldRef ref) {
        RClass klass = RClass.fromSootClass(ref.getField().getDeclaringClass());
        return CLanguageGenerator.C_GLOBAL_VAR_PREFIX + id.get(klass) + "_"
                + ref.getField().getName();
    }

    /*
     * type cast
     */
    /**
     * used when expect and current types are both value (instead of pointer)
     * 
     * @param expect
     * @param current
     * @param value
     * @return
     */
    public String typeCastingByValue(Type expect, Type current, String value) {
        if (expect.equals(current))
            return value;

        String ret = "(" + id.fromSootType(expect) + ")" + value;
        return ret;
    }

    /**
     * generate typecasting expr
     * 
     * @param expect
     *            expect type
     * @param current
     *            current type
     * @param value
     *            current value
     * @return
     */
    public String typeCasting(Type expect, Type current, String value) {
        if (expect.equals(current))
            return value;

        return typeCasting(RType.initWithSootType(expect),
                RType.initWithSootType(current), value);
    }

    public String typeCasting(RType expectRType, RType currentRType,
            String value) {
        if (expectRType.equals(currentRType))
            return value;

        String expr = value;

        // check if we should unbox the type
        if (expectRType.isPrimitive()
                && currentRType.isBoxedPrimitiveType()
                && RType.boxedTypeMatchesPrimitiveType(currentRType,
                        expectRType)) {
            expr = "(" + value + ") -> internal";
        }
        // check if we should box the type
        else if (expectRType.isBoxedPrimitiveType()
                && currentRType.isPrimitive()
                && RType.boxedTypeMatchesPrimitiveType(expectRType,
                        currentRType)) {
            String shortBoxedTypeName = expectRType.getClassName().substring(
                    expectRType.getClassName().lastIndexOf('.'));
            expr = "new" + shortBoxedTypeName + "Constant(" + value + ")";
        }
        // type cast
        // TODO: check type cast
        else
            // if (expectRType.isReferenceType())
            expr = "(" + id.getWithPointerIfProper(expectRType) + ")" + value;

        return expr;
    }

    public String typeCastingForInvokeParameter(InvokeExpr invoke, int arg) {
        Type expect = invoke.getMethod().getParameterType(arg);
        Type current = invoke.getArg(arg).getType();
        String value = id.fromSootValue(invoke.getArg(arg));
        return typeCasting(expect, current, value);
    }
}
