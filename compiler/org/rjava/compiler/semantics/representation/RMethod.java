package org.rjava.compiler.semantics.representation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.rjava.compiler.CompilationUnit;
import org.rjava.compiler.Constants;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.pass.CompilationPass;
import org.rjava.compiler.semantics.DependencyEdgeNode;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.SootEngine;
import org.rjava.compiler.util.Tree;
import org.rjava.compiler.util.TreeBreadthFirstIterator;

import soot.Body;
import soot.Local;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.UnitBox;
import soot.jimple.internal.AbstractStmt;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;

public class RMethod implements DependencyEdgeNode, CompilationUnit{
    private List<RType> parameters = new ArrayList<RType>();
    private String name;
    private RType returnType;
    private RClass klass;
    private List<RStatement> body = new ArrayList<RStatement>();
    private List<RLocal> locals = new ArrayList<RLocal>();
    
    private boolean mainMethod;
    
    SootMethod internal;
    
    private boolean intrinsic = false;
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
    private List<RLocal> twinLocals;
    
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
        
        // we dont care about the source code of library
        if (internal.isConcrete() && klass.isAppClass()) {
            
            try {
                // get body
                // FIXME: seems to be a problem if we call update() from intrinsic pass. are we getting the modified body?
                Body sootBody = null;
                if (SootEngine.RUN_SOOT) {
                    sootBody = SootEngine.methodStorage.get(internal);
                }
                else sootBody = internal.retrieveActiveBody();
                        
                Iterator<Unit> iter = sootBody.getUnits().iterator();
                while(iter.hasNext()) {
                    body.add(RStatement.from(this, (AbstractStmt)iter.next()));
                }
                
                // soot may have two locals with the same name, we need to fix this
                Iterator<Local> iter2 = sootBody.getLocals().iterator();
                while(iter2.hasNext()) {
                    Local l = iter2.next();
                    
                    /*
                     * if we have several locals as 'int a'. the second one will be 'int a_rjmagiclocal2', the third one will be 'int a_rjmagiclocal3'
                     */
                    int existingLocalsWithSameName = 0;
                    for (RLocal existingLocal : locals) {
                        if (existingLocal.getName().equals(l.getName()) ||    // the second local with the same name
                                                                              // the subsequent local with the same name) 
                                existingLocal.getName().startsWith(l.getName() + "_rjmagiclocal"))   {
                            existingLocalsWithSameName++;                        
                        }
                    }
                    if (existingLocalsWithSameName != 0) {
                        // need renaming
                        l.setName(l.getName() + "_rjmagiclocal" + (existingLocalsWithSameName+1));
                    }
                    
                    locals.add(new RLocal(this, l));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        this.annotations = fetchAnnotations(internal);
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
    	String ret = "<" + returnType + " " + getKlass().getName() + "." + name + "(";
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
        return body.size() <= 25 && RJavaCompiler.getGeneratorOptions().allowInline();
    }
    
    public boolean hasInlineAnnotation() {
        for (RAnnotation rAnno : annotations)
            if (rAnno.getType().getClassName().equals(Constants.RJAVA_INLINE_ANNOTATION))
                return true;
        
        return false;
    }
    
    /**
     * annotations on this method. 
     * Remember annotations on the declaring class also affect this method. 
     * But they are NOT included in this list
     */
    List<RAnnotation> annotations;
    private List<RAnnotation> fetchAnnotations(SootMethod method) {
        List<RAnnotation> ret = new ArrayList<RAnnotation>();
        for (Tag tag : method.getTags()) {
            if (tag instanceof VisibilityAnnotationTag) {
                VisibilityAnnotationTag annoTag = (VisibilityAnnotationTag) tag;
                for (AnnotationTag t : annoTag.getAnnotations())
                    ret.add(new RAnnotation(t));
            }
        }
        return ret;
    }

    /**
     * is this method overriding some method from its super class?
     * @return
     */
    public boolean isOverridingMethod() {
        if (!klass.hasSuperClass())
            return false;
        
        SootClass superClass = internal.getDeclaringClass().getSuperclass();
        
        while(superClass != null) {
            if (superClass.declaresMethod(internal.getName(), internal.getParameterTypes()))
                return true;
            
            if (superClass.hasSuperclass())
                superClass = superClass.getSuperclass();
            else return false;
        }
        return false;
    }
    
    public boolean isConstructor() {
        return getName().equals("<init>");
    }
    
    public boolean isClassInitializer() {
        return getName().equals("<clinit>");
    }
    
    public boolean isSynchronized() {
        return internal.isSynchronized();
    }
    
    /**
     * are two methods twins. See {@link twin} in this class for details
     * @param possibleTwin
     * @return
     */
    public boolean isTwin(RMethod possibleTwin) {
        if (isConstructor() || possibleTwin.isConstructor())
            return false;
        
        if (!name.equals(possibleTwin.name))
            return false;
        
        if (parameters.size() != possibleTwin.parameters.size())
            return false;
        
        for (int i = 0; i < parameters.size(); i++)
            if (!parameters.get(i).equals(possibleTwin.parameters.get(i)))
                return false;
        
        if (internal.getReturnType().equals(possibleTwin.internal.getReturnType()))
            return false;
        
        // should be a twin, but we need to check if this method is already a twin for other method (that shouldn't happen)
        if (RJavaCompiler.ENABLE_ASSERTION)
            RJavaCompiler.assertion((twinReturnType == null && twinBody == null && twinLocals == null), "twin method already set for " + getName());
        return true;
    }
    
    public void setTwin(RMethod twin) {
        if (RJavaCompiler.ENABLE_ASSERTION)
            RJavaCompiler.assertion((twinReturnType == null && twinBody == null && twinLocals == null), "twin method already set for " + getName());
        this.twinReturnType = twin.returnType;
        this.twinBody = twin.body;
        this.twinLocals = twin.locals;
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
            
            List xhg2 = twinLocals;
            twinLocals = locals;
            locals = xhg2;
        }
    }
    
    /**
     * get all overriding method of this method
     * @return
     */
    public List<RMethod> getOverridingMethod() {
        List<RMethod> ret = new ArrayList<RMethod>();
        
        Tree<RClass> subclasses = SemanticMap.hierarchy.getTree(klass);
        TreeBreadthFirstIterator<RClass> iter = subclasses.getBreadthFirstIterator();
        while(iter.hasNext()) {
            RClass cursor = iter.next();
            RMethod overridingMethod = cursor.getMethodByMatchingNameAndParameters(internal);
            if (overridingMethod != null)
                ret.add(overridingMethod);
        }
        
        return ret;
    }
    
    public static RMethod getFromSootMethod(SootMethod method) {
        RClass rClass = RClass.fromSootClass(method.getDeclaringClass());
        while(rClass.getMethodByMatchingNameAndParameters(method) == null) {
            if (rClass.hasSuperClass())
                rClass = rClass.getSuperClass();
            else RJavaCompiler.error("Trying to get soot method: " + method + ", but we cannot find it");
        }
        return rClass.getMethodByMatchingNameAndParameters(method);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o.getClass().equals(RMethod.class) && internal.equals(((RMethod)o).internal))
            return true;
        else return false;
    }

    @Override
    public void accept(CompilationPass pass) {
        pass.visit(this);
        for (RStatement stmt : getBody())
            stmt.accept(pass);
    }

    @Override
    public boolean isCLInitNode() {
        return isClassInitializer();
    }

    @Override
    public boolean isClassNode() {
        return false;
    }
}
