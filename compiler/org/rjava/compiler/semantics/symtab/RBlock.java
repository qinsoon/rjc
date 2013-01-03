package org.rjava.compiler.semantics.symtab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RBlock {
    private List<RIdentifier> symbolTable = new ArrayList<RIdentifier>();
    private RBlock upper;
    private List<RBlock> innerBlocks = new ArrayList<RBlock>();
    
    private String type;	//debug use only
    public static final String CLASS_WIDE = "CLASS_BLOCK";
    public static final String STATIC_INITIALIZER = "STATIC_INITIALIZER";
    public static final String METHOD_WIDE = "METHOD_BLOCK";
    public static final String IN_METHOD = "SMALL_BLOCK";
    
    public RBlock(String type) {
	this.type = type;
    }
    
    public void add(RIdentifier id) {
	symbolTable.add(id);
    }
    
    public RIdentifier get(int index) {
	return symbolTable.get(index);
    }
    
    public void setUpper(RBlock upper) {
	this.upper = upper;
    }
    
    public RBlock getUpper() {
	return upper;
    }
    
    public RBlock addInnerBlock(String type) {
	RBlock b = new RBlock(type);
	b.setUpper(this);
	innerBlocks.add(b);
	return b;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void verbose() {
	System.out.println("BLOCK:" + type);
	
	System.out.print("  symbol: {");
	for (RIdentifier id : symbolTable)
	    System.out.print(id + ",");
	System.out.println("}");
	
	System.out.print("  innerBlocks: {");
	for (RBlock b : innerBlocks)
	    System.out.print(b.type + ",");
	System.out.println("}");
	
	for (RBlock b : innerBlocks)
	    b.verbose();
    }
}
