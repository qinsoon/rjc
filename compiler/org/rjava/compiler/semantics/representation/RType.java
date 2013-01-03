package org.rjava.compiler.semantics.representation;

public class RType {
    private String type;
    private String className;
    private String packageName;
    
    private RType() {}
    
    public static RType initWithTypeName(String type) {
	RType r = new RType();
	r.type = type;
	return r;
    }
    
    public static RType initWithClassName(String className) {
	RType r = new RType();
	r.className = className;
	return r;
    }

    /**
     * Java style type, such as Ljava/lang/Integer;
     */
    public String toString() {
	return type;
    }

    /**
     * Java dot style class name, such as java.lang.Integer
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
		className = className.substring(0, className.length()-1);
	    className = className.replace('/', '.');
	}
	
	return className;
    }
    
    /**
     * Java package name, dot style. such as java.lang
     * @return package name
     */
    public String getPackageName() {
	if (packageName == null) {
	    packageName = getClassName();
	    packageName = packageName.substring(0, packageName.lastIndexOf('.'));
	}
	
	return packageName;
    }
}
