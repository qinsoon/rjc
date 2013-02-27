package org.rjava.compiler.util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This data structure is used to describe helper method in the run-time
 * @author Yi
 *
 */
public class HelperMethod {
    public static final String RETURN_VOID = "void";
    
    String methodDescriptor = "";
    String methodName;
    
    String returnType;
    ArrayList<HelperVariable> parameters = new ArrayList<HelperVariable>();
    
    String source;
    
    public HelperMethod(String methodName, String returnType, HelperVariable[] parameters) {
        super();
        this.methodName = methodName;
        this.returnType = returnType;
        if (parameters != null)
            this.parameters.addAll(Arrays.asList(parameters));
    }

    public String getMethodName() {
        return methodName;
    }

    public String getReturnType() {
        return returnType;
    }

    public ArrayList<HelperVariable> getParameters() {
        return parameters;
    }
    
    public HelperVariable getParameter(int i) {
        return parameters.get(i);
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMethodDescriptor() {
        return methodDescriptor;
    }

    public void setMethodDescriptor(String methodDescriptor) {
        this.methodDescriptor = methodDescriptor;
    }
}