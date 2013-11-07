package org.rjava.compiler.restriction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RAnnotation;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RRestriction;
import org.rjava.compiler.exception.*;

import static org.rjava.compiler.Constants.*;

public class StaticRestrictionChecker {
    public void comply(RClass klass) throws RJavaError, RJavaWarning{
        boolean noRuleset = true;
        for (RAnnotation anno : klass.getAnnotations()) {
            if (anno.isRestrictionRuleset())
                noRuleset = false;
        }
        if (klass.isInnerClass()) {
            for (RAnnotation anno : SemanticMap.getOuterClass(klass).getAnnotations())
                if (anno.isRestrictionRuleset())
                    noRuleset = false;
        }
        if (noRuleset)
            noRulesets.add(klass);
        
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
    	        throw new RJavaError("Fail to invoke restriction checking: " + restriction.getName());
    	    } catch (IllegalAccessException e) {
    	        throw new RJavaError("Fail to invoke restriction checking: " + restriction.getName());
    	    } catch (InvocationTargetException e) {
    	        e.printStackTrace();
    	        throw new RJavaError("Fail to invoke restriction checking: " + restriction.getName());
    	    } catch (ClassNotFoundException e) {
    	        missingCheckingRules.add(restriction.getName());
    	    } catch (SecurityException e) {
    	        throw new RJavaError("Fail to invoke restriction checking: " + restriction.getName());
    	    } catch (NoSuchMethodException e) {
    	        throw new RJavaError("Fail to invoke restriction checking: " + restriction.getName());
    	    }
    	}
    	
    	// should also check methods here
    	
    	if (currentViolations.size() > 0) {
    	    RJavaCompiler.warning("Restriction violations:");
        	for (int i = 0; i < currentViolations.size(); i++) {
        	    RJavaCompiler.warning((i+1) + ". " + currentViolations.get(i).getMessage());
        	}
        	historyViolations.addAll(currentViolations);
            currentViolations.clear();
        }
    }
    
    public static final List<RClass> noRulesets = new ArrayList<RClass>();
    
    public static final Set<String> missingCheckingRules = new HashSet<String>();
    
    public static final List<RJavaRestrictionViolation> currentViolations = new ArrayList<RJavaRestrictionViolation>();
    public static final List<RJavaRestrictionViolation> historyViolations = new ArrayList<RJavaRestrictionViolation>();
    
    public static void addRestrictionViolation(RJavaRestrictionViolation violation) {
        currentViolations.add(violation);
    }
    
    public static boolean needReport() {
        return !historyViolations.isEmpty() || !missingCheckingRules.isEmpty() || !noRulesets.isEmpty();
    }
    
    public static void report() {
        System.err.println("Compilation finished with restriction warnings (generated code might be invalid)");
        
        if (!historyViolations.isEmpty()) {
            System.err.println("Restriction violations:");
            for (int i = 0; i < historyViolations.size(); i++) {
                System.err.println((i+1) + ". " + historyViolations.get(i).getMessage());
            }
        }
        
        if (!missingCheckingRules.isEmpty()) {
            System.err.println("\nMissing checking rules for the following restrictions:");
            for (String r : missingCheckingRules)
                System.err.println(r);
        }
        
        if (!noRulesets.isEmpty()) {
            System.err.println("\nThe following classes do not have any restriction rulesets (any RJava classes should at least belong to @RJavaCore rulesets):");
            for (RClass k : noRulesets)
                System.err.println(k.getName());
        }
    }
}
