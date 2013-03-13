package org.rjava.restriction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RRestriction;
import org.rjava.compiler.exception.*;

import static org.rjava.compiler.Constants.*;

public class StaticRestrictionChecker {
    public void comply(RClass klass) throws RJavaError, RJavaWarning{
	for (RRestriction restriction : klass.getRestrictions()) {
	    //System.out.print("Checking " + restriction.getName() + " on " + klass.getName() + "...");
	    try {
		Class checkClass = Class.forName(restriction.getName() + CHECK_RULE_SUFFIX);
		Method checkMethod = checkClass.getDeclaredMethod(CHECK_CLASS_METHOD, CHECK_CLASS_PARA);  
		Object[] para = new Object[] {klass};
		Boolean pass = (Boolean) checkMethod.invoke(null, para);
	    }
	    
	    // reflection exception
	    catch (IllegalArgumentException e) {
		throw new RJavaError("Fail to invoke restriction checking: " + e.getMessage());
	    } catch (IllegalAccessException e) {
		throw new RJavaError("Fail to invoke restriction checking: " + e.getMessage());
	    } catch (InvocationTargetException e) {
		throw new RJavaError("Fail to invoke restriction checking: " + e.getMessage());
	    } catch (ClassNotFoundException e) {
		throw new RJavaError("Didn't find restriction class: " + e.getMessage());
	    } catch (SecurityException e) {
		throw new RJavaError("Fail to invoke restriction checking: " + e.getMessage());
	    } catch (NoSuchMethodException e) {
		throw new RJavaError("Fail to invoke restriction checking: " + e.getMessage());
	    }
	}
	
	if (violations.size() > 0) {
	    RJavaCompiler.warning("Restriction violations:");
    	for (int i = 0; i < violations.size(); i++) {
    	    RJavaCompiler.warning((i+1) + ". " + violations.get(i).getMessage());
    	}
        // throw new RJavaError("Static check failed on " + klass.getName() + ", please check output log. ");	
    }
}

    
    public static final List<RJavaRestrictionViolation> violations = new ArrayList<RJavaRestrictionViolation>();
    
    public static void addRestrictionViolation(RJavaRestrictionViolation violation) {
        violations.add(violation);
    }
}
