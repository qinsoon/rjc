package org.rjava.compiler.semantics.representation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.SootEngine;
import org.rjava.compiler.semantics.symtab.RImport;

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

    public static final List<String> PRIMITIVE_TYPES = Arrays.asList("boolean",
	    "char", "byte", "short", "int", "long", "float", "double");
    public static final String VOID_TYPE = "void";

    private RType() {
    }

    /**
     * init an RType from a type name
     * 
     * @param type
     *            something like Ljava/lang/Integer;
     * @return corresponding RType
     */
    public static RType initWithTypeName(RClass klass, String type) {
    	RType r = new RType();
    	r.type = type;
    
    	r.resolveAndNormalize(klass);
    	return r;
    }

    /**
     * init an RType from a class name
     * 
     * @param className
     *            something like Integer or java.lang.Integer;
     * @return corresponding RType
     */
    public static RType initWithClassName(RClass klass, String className) {
    	RType r = new RType();
    	r.className = className;
    
    	r.resolveAndNormalize(klass);
    	return r;
    }

    private void resolveAndNormalize(RClass klass) {
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
    	// if not, we need to resolve the type
    	else {
    	    primitive = false;
    	    String shortName = className;
    	    SootClass sootClass = resolveType(klass);
    	    resolvedClasses.put(className, sootClass);
    	    fullClassNames.put(shortName, className);
    	}
    }
    
    private SootClass resolveType(RClass klass) {
    	String fullName = fullClassNames.get(className);
    	if (fullName != null) {
    	    className = fullName;
    	}
    	SootClass s = resolvedClasses.get(className);
    	if (s != null){
    	    return s;
    	}
	
    	// actual resolve
    	SootClass sootClass = null;
    
    	try {
    	    sootClass = SootEngine.resolveAndGetClass(className);
    	    return sootClass;
    	} catch (RuntimeException e) {
    	    System.out.println("Failed to find " + className);
    	    // such className is not actually full class name
    	    // check imports first
    	    for (RImport i : klass.getImports()) {
        		if (i.isWildCardImport()) {
        		    // join import(package) with class name
        		    className = i.getImportStatement().replaceAll("*",
        			    className);
        		    try {
        			sootClass = SootEngine.resolveAndGetClass(className);
        			return sootClass;
        		    } catch (RuntimeException e2) {
        			System.out.println("Failed to find " + className);
        			continue;
        		    }
        		} else {
        		    if (i.getImportStatement().endsWith(className)) {
        			className = i.getImportStatement();
            		        try {
                			    sootClass = SootEngine.resolveAndGetClass(className);
                			    return sootClass;
            		        } catch (RuntimeException e2) {
                			    System.out.println("Failed to find " + className);
                			    continue;
            		        }
        		    }
        		}
    	    }

    	    // then check implicit import (i.e. java.lang)
    	    className = "java.lang." + className;
    	    try {
    	        sootClass = SootEngine.resolveAndGetClass(className);
    		return sootClass;
    	    } catch (RuntimeException e2) {
    	        System.out.println("Failed to find " + className);
    	    }
	}

	return null;
    }

    /**
     * Java style type, such as Ljava/lang/Integer;
     */
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
	    className = type;
	    if (className.startsWith("["))
		className = className.substring(1);
	    if (className.startsWith("L"))
		className = className.substring(1);
	    if (className.endsWith(";"))
		className = className.substring(0, className.length() - 1);
	    className = className.replace('/', '.');
	}

	return className;
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
}
