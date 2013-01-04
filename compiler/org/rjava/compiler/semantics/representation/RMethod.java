package org.rjava.compiler.semantics.representation;

import java.util.ArrayList;
import java.util.List;

import org.rjava.compiler.semantics.symtab.RIdentifier;

import soot.SootMethod;
import soot.Type;

public class RMethod {
    private List<RType> parameters = new ArrayList<RType>();
    private String name;
    private RType returnType;
    private RClass klass;
    
    public RMethod(RClass rClass, SootMethod m) {
	this.name = m.getName();
	this.klass = rClass;
	this.returnType = RType.initWithTypeName(rClass, m.getReturnType().toString());
	for (Object o : m.getParameterTypes()) {
	    Type t = (Type)o;
	    parameters.add(RType.initWithTypeName(rClass, t.toString()));
	}
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
}
