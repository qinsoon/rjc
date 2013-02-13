package org.rjava.compiler.semantics.representation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.SootEngine;

import soot.SootClass;

public class RType {
    // full class name <-> soot classes
    public static Map<String, SootClass> resolvedClasses = new HashMap<String, SootClass>();
    // class name <-> full class name
    public static Map<String, String> fullClassNames = new HashMap<String, String>();
    
    private String type;
    private String className;
    private String packageName;
    private boolean primitive = false;
    private boolean array = false;
    private boolean voidType = false;
    
    private boolean intrinsicType = false;

    public static final List<String> PRIMITIVE_TYPES = Arrays.asList(
            "boolean",
            "char",
            "byte",
            "short",
            "int",
            "long",
            "float",
            "double");
    public static final List<String> BOXED_PRIMITIVE_TYPES = Arrays.asList(
            "java.lang.Boolean",
            "java.lang.Character",
            "java.lang.Byte",
            "java.lang.Short",
            "java.lang.Integer",
            "java.lang.Long",
            "java.lang.Float",
            "java.lang.Double"
            ); 
    public static final String VOID_TYPE = "void";

    private RType() {
    }
    
    public boolean equals(Object o) {
        RType another = (RType) o;
        if (voidType && another.voidType)
            return true;
        return className.equals(another.className) && primitive == another.primitive && array == another.array;
    }

    /**
     * init an RType from a type name
     * 
     * @param type
     *            something like Ljava/lang/Integer;
     * @return corresponding RType
     */
    public static RType initWithTypeName(String type) {
        String classNameTmp = getClassNameFromType(type);
        if (SemanticMap.types.get(classNameTmp) != null) {
            return SemanticMap.types.get(classNameTmp);
        }
        
    	RType r = new RType();
    	r.type = type;
      	r.resolveAndNormalize();
      	
      	saveToSemanticMap(classNameTmp, r);

    	return r;
    }

    /**
     * save to semantic map. If it is an array type, find base type and save as well.
     * @param classNameTmp
     * @param r
     */
    private static void saveToSemanticMap(String className, RType r) {
        SemanticMap.types.put(className, r);
        
        if (r.isArray()) {
            String baseClassName = r.getClassName();
            RType.initWithClassName(baseClassName);
        }
    }

    /**
     * init an RType from a class name
     * 
     * @param className
     *            something like Integer or java.lang.Integer;
     * @return corresponding RType
     */
    public static RType initWithClassName(String className) {
        if (SemanticMap.types.get(className) != null) {
            return SemanticMap.types.get(className);
        }
        
    	RType r = new RType();
    	r.className = className;    
    	r.resolveAndNormalize();
    	
    	// store back to types map
    	saveToSemanticMap(className, r);
    	return r;
    }

    private void resolveAndNormalize() {
    	className = getClassName();
    
    	// check if the type is array type
    	if (className.endsWith("[]")) {
    	    array = true;
    	    className = className.replaceAll("\\[\\]", "");
    	}
    
    	if (className.equals(VOID_TYPE))
    	    voidType = true;
    	// check if the type is primitive
    	else if (PRIMITIVE_TYPES.contains(className)) {
    	    primitive = true;
    	}
    }

    public String toString() {
        return className + (array ? "[]":"");
    }

    /**
     * Java dot style class name, such as java.lang.Integer
     * 
     * @return class name
     */
    public String getClassName() {
    	if (className == null) {
    	    className = getClassNameFromType(type);
    	}
    
    	return className;
    }
    
    private static String getClassNameFromType(String type) {
        String ret = type;
        if (ret.startsWith("["))
            ret = ret.substring(1);
        if (ret.startsWith("L"))
            ret = ret.substring(1);
        if (ret.endsWith(";"))
            ret = ret.substring(0, ret.length() - 1);
        ret = ret.replace('/', '.');
        return ret;
    }
    
    /**
     * Java type name, such as Ljava/lang/Integer;
     * 
     * @return type
     */
    public String getType() {
	if (type == null) {
	    type = className;
	    type = (array ? "[" : "") + "L" + type.replace('.', '/') + ";";
	}
	
	return type;
    }

    /**
     * Java package name, dot style. such as java.lang
     * 
     * @return package name
     */
    public String getPackageName() {
	if (packageName == null) {
	    packageName = getClassName();
	    packageName = packageName
		    .substring(0, packageName.lastIndexOf('.'));
	}

	return packageName;
    }

    public boolean isPrimitive() {
	return primitive;
    }

    public void setPrimitive(boolean primitive) {
	this.primitive = primitive;
    }

    public boolean isArray() {
	return array;
    }

    public void setArray(boolean array) {
	this.array = array;
    }

    public boolean isVoidType() {
        return voidType;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setVoidType(boolean voidType) {
        this.voidType = voidType;
    }
    
    public boolean isReferenceType() {
        return (!primitive && !voidType);
    }

    public boolean isIntrinsicType() {
        return intrinsicType;
    }

    public void setIntrinsicType(boolean intrinsicType) {
        this.intrinsicType = intrinsicType;
    }
    
    public boolean isBoxedPrimitiveType() {
        return BOXED_PRIMITIVE_TYPES.contains(className);
    }
    
    public static boolean boxedTypeMatchesPrimitiveType(RType boxed, RType primitive) {
        int index1 = BOXED_PRIMITIVE_TYPES.indexOf(boxed);
        int index2 = PRIMITIVE_TYPES.indexOf(primitive);
        
        return index1 != -1 && index1 == index2;
    }
}
