package org.rjava.restriction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RRestriction;
import org.rjava.compiler.exception.*;
import static org.rjava.compiler.Constants.*;

public class StaticRestrictionChecker {
    public void comply(RClass klass, SemanticMap semantics) throws RJavaError, RJavaWarning{
	for (RRestriction restriction : klass.getRestrictions()) {
	    System.out.println("Checking " + restriction.getName() + " on " + klass.getName() + "...");
	    try {
		Class checkClass = Class.forName(restriction.getName() + CHECK_RULE_SUFFIX);
		Method checkMethod = checkClass.getDeclaredMethod(CHECK_CLASS_METHOD, CHECK_CLASS_PARA);  
		Object[] para = new Object[] {klass, semantics};
		checkMethod.invoke(null, para);
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
    }

}
