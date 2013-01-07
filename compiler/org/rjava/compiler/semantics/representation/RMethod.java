package org.rjava.compiler.semantics.representation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.rjava.compiler.semantics.symtab.RIdentifier;

import soot.SootMethod;
import soot.Type;
import soot.Unit;

public class RMethod {
    private List<RType> parameters = new ArrayList<RType>();
    private String name;
    private RType returnType;
    private RClass klass;
    private List<RStatement> body = new ArrayList<RStatement>();
    
    SootMethod internal;
    
    public RMethod(RClass rClass, SootMethod m) {
	this.internal = m;
	this.name = m.getName();
	this.klass = rClass;
	this.returnType = RType.initWithTypeName(rClass, m.getReturnType().toString());
	// get parameter
	for (Object o : m.getParameterTypes()) {
	    Type t = (Type)o;
	    parameters.add(RType.initWithTypeName(rClass, t.toString()));
	}
	// get body
	Iterator<Unit> iter = m.retrieveActiveBody().getUnits().iterator();
	while(iter.hasNext()) {
	    body.add(RStatement.from(iter.next()));
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

    public List<RStatement> getBody() {
        return body;
    }
}
