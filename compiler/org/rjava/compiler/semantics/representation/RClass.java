package org.rjava.compiler.semantics.representation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.SootEngine;
import org.rjava.compiler.semantics.symtab.RBlock;
import org.rjava.compiler.semantics.symtab.RIdentifier;
import org.rjava.compiler.semantics.symtab.RImport;

import soot.SootClass;
import soot.SootMethod;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;

public class RClass {
    SootClass internal;
    private String name;
    
    // 'annotations' are what are declared with source
    private List<RRestriction> restrictions;
    // 'restrictions' are RJava restriction rules, including those unfolded from rulesets
    private List<RAnnotation> annotations;
    
    // blocks in such class
    private RBlock topBlock;
    private RBlock currentBlock = null;
    
    // imports
    private List<RImport> imports = new ArrayList<RImport>();
    
    // methods
    private List<RMethod> methods = new ArrayList<RMethod>();
    
    public RClass(SootClass sootClass) {
	this.internal = sootClass;
	this.name = internal.getName();
	
	this.annotations = fetchAnnotations(internal);
	
	topBlock = new RBlock(RBlock.CLASS_WIDE);
	
	fetchMethods();
    }

    private void fetchMethods() {
	for (SootMethod m : internal.getMethods()) {
	    methods.add(new RMethod(this, m));
	}
	
	if (SemanticMap.DEBUG) {
	    System.out.println("---Methods for " + name + "---");
	    for (RMethod m : methods)
		System.out.println(m);
	}
    }

    /**
     * get annotations from SootClass Tag
     * @param klass
     * @return list of RAnnotation
     */
    private List<RAnnotation> fetchAnnotations(SootClass klass) {
	List<RAnnotation> result = new ArrayList<RAnnotation>();
	for (Tag tag : klass.getTags()) {
	    // only deal with VisibilityAnnotationTag
	    if (tag instanceof VisibilityAnnotationTag) {
		VisibilityAnnotationTag annoTag = (VisibilityAnnotationTag) tag;
		for (AnnotationTag t : annoTag.getAnnotations()) {
		    result.add(new RAnnotation(t, this));  
		}
	    }
	}
	
	return result;
    }

    /**
     * get a list of restrictions on such class. Build restriction list when first executed
     * @return list of {@link RRestriction}
     */
    public List<RRestriction> getRestrictions() {
	if (restrictions == null)
	    restrictions = fetchRestrictions();		// build from annotations

	return restrictions;
    }    

    // fetch restrictions
    private List<RRestriction> fetchRestrictions() {
	List<RRestriction> result = new ArrayList<RRestriction>();
	for (RAnnotation anno : annotations) {
	    List<RRestriction> restrictions = RRestriction.unfold(anno);
	    if (restrictions != null)
		result.addAll(restrictions);
	}
	return result;
    }

    /**
     * get class name
     * @return class name
     */
    public String getName() {
        return name;
    }

    /**
     * get a list of annotations on such class
     * @return list of {@link RAnnotation}
     */
    public List<RAnnotation> getAnnotations() {
        return annotations;
    }

    public RBlock getTopBlock() {
        return topBlock;
    }

    public void setTopBlock(RBlock topBlock) {
        this.topBlock = topBlock;
    }

    public RBlock getCurrentBlock() {
        return currentBlock;
    }

    public void setCurrentBlock(RBlock currentBlock) {
        this.currentBlock = currentBlock;
    }
    
    public void newBlock(String type) {
	RBlock newCurrent = this.currentBlock.addInnerBlock(type);
	this.currentBlock = newCurrent;
    }
    
    public void backToUpperBlock() {
	this.currentBlock = this.currentBlock.getUpper();
    }
    
    public void newIdToCurrentBlock(RIdentifier id) {
	this.currentBlock.add(id);
    }
    
    public void printSymbolTalbe() {
	System.out.println("---Symbol Table for " + name + "---");
	topBlock.verbose();
    }
    
    public void printImports() {
	for (RImport i : imports)
	    System.out.println(i);
    }
    
    public void addNewImport(String statement) {
	this.imports.add(new RImport(statement));
    }

    public List<RImport> getImports() {
        return imports;
    }
}
