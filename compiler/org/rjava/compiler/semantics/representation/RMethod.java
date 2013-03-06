package org.rjava.compiler.semantics.representation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.SootEngine;

import soot.Body;
import soot.Local;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.UnitBox;

public class RMethod {
    private List<RType> parameters = new ArrayList<RType>();
    private String name;
    private RType returnType;
    private RClass klass;
    private List<RStatement> body = new ArrayList<RStatement>();
    private List<RLocal> locals = new ArrayList<RLocal>();
    
    private boolean mainMethod;
    
    SootMethod internal;
    
    private boolean intrinsic;
    private String code;
    
    /**
     * in some situation, the way javac/soot deals with generics would 
     * produce two methods with same name same parameters but different return types
     * this causes problem when mapping this code into c
     * a minimal example is:
     * class ParentReturnType{}
     * class ChildReturnType{}
     * class Parent {
     *   ParentReturnType foo() {...}
     * }
     * class Child<R extends ChildReturnType> extends Parent {
     *   @Override R foo() {...}
     * }
     * 
     * java frontend produces two versions of foo() for Child class:
     * 1. ChildReturnType foo(), whose body is from 'R foo()'
     * 2. ParentReturnType foo(), which simply calls the first foo()
     * 
     * They are a twin for each other. We do not want both methods to 
     * be RMethod in a RClass. So when one is created, the other's return 
     * type and body are set as twinReturnType and twinBody. 
     * And _immediately_ we check returntypes and bodies to get a RMethod
     * with ParentReturnType (so signature is the same as in parent) and 
     * the defined method body
     */
    private RType twinReturnType;
    private List<RStatement> twinBody;
    
    public RMethod(RClass rClass, SootMethod m) {
    	this.internal = m;
    	this.name = m.getName();
    	this.klass = rClass;
    	update();
    }
    
    public void update() {
        parameters.clear();
        body.clear();
        locals.clear();
        
        this.returnType = RType.initWithClassName(internal.getReturnType().toString());
        // get parameter
        for (Object o : internal.getParameterTypes()) {
            Type t = (Type)o;
            parameters.add(RType.initWithClassName(t.toString()));
        }
        
        if (internal.isConcrete()) {
            
            try {
                // get body
                Body sootBody = null;
                if (SootEngine.RUN_SOOT) {
                    sootBody = SootEngine.methodStorage.get(internal);
                }
                else sootBody = internal.retrieveActiveBody();
                        
                Iterator<Unit> iter = sootBody.getUnits().iterator();
                while(iter.hasNext()) {
                    body.add(RStatement.from(this, iter.next()));
                }
                
                Iterator<Local> iter2 = sootBody.getLocals().iterator();
                while(iter2.hasNext()) {
                    locals.add(new RLocal(this, iter2.next()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        checkMainMethod();
    }

    public List<RType> getParameters() {
        return parameters;
    }

    public String getName() {
        return name;
    }

    public RType getReturnType() {
        return returnType;
    }
    
    public String toString() {
	String ret = "<" + returnType.toString() + " " + name + "(";
	for (int i = 0; i < parameters.size(); i++) {
	    ret += parameters.get(i).toString();
	    if (i != parameters.size() - 1)
		ret += ",";
	}
	ret += ")>";
	return ret;
    }

    public List<RStatement> getBody() {
        return body;
    }

    private void checkMainMethod() {
        this.mainMethod =                 // return void
                returnType.isVoidType() &&
                // 1 parameter, array, String
                parameters.size() == 1 && parameters.get(0).isArray() && parameters.get(0).getClassName().equals("java.lang.String") && 
                // method name is main
                name.equals("main");
    }
    
    public boolean isStatic() {
        return internal.isStatic();
    }

    public RClass getKlass() {
        return klass;
    }
    
    public SootMethod internal() {
        return internal;
    }

    public List<RLocal> getLocals() {
        return locals;
    }

    public boolean isIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(boolean intrinsic) {
        this.intrinsic = intrinsic;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isMainMethod() {
        return mainMethod;
    }
    
    public boolean shouldBeInlined() {
        return body.size() <= 25 && RJavaCompiler.getCurrentGeneratorOptions().allowInline();
    }

    /**
     * is this method overriding some method from its super class?
     * @return
     */
    public boolean isOverridingMethod() {
        SootClass superClass = internal.getDeclaringClass().getSuperclass();
        if (superClass != null && superClass.declaresMethod(internal.getName(), internal.getParameterTypes()))
            return true;
        else return false;
    }
    
    public boolean isConstructor() {
        return getName().equals("<init>");
    }
    
    public boolean isClassInitializer() {
        return getName().equals("<clinit>");
    }
    
    /**
     * are two methods twins. See {@link twin} in this class for details
     * @param possibleTwin
     * @return
     */
    public boolean isTwin(RMethod possibleTwin) {
        if (!name.equals(possibleTwin.name))
            return false;
        
        if (parameters.size() != possibleTwin.parameters.size())
            return false;
        
        for (int i = 0; i < parameters.size(); i++)
            if (!parameters.get(i).equals(possibleTwin.parameters.get(i)))
                return false;
        
        // should be a twin, but we need to check if this method is already a twin for other method (that shouldn't happen)
        assert (twinReturnType == null && twinBody == null);
        return true;
    }
    
    public void setTwin(RMethod twin) {
        assert (twinReturnType == null && twinBody == null);
        this.twinReturnType = twin.returnType;
        this.twinBody = twin.body;
    }
    
    public void checkTwin() {
        if (twinReturnType == null || twinBody == null)
            return;
        
        RClass myReturn = SemanticMap.getRClassFromRType(returnType);
        RClass hisReturn = SemanticMap.getRClassFromRType(twinReturnType);
        if (myReturn.isDescendanceof(hisReturn)) {
            // more general return type should be return type.
            RType xhg = twinReturnType;
            twinReturnType = returnType;
            returnType = xhg;
            
            // body with more specific return type should be the real body

        } else {
            List xhg = twinBody;
            twinBody = body;
            body = xhg;
        }
    }
}
