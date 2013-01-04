package org.rjava.compiler.semantics.symtab;

import org.rjava.compiler.semantics.SemanticMap;

public class RImport {
    String importStatement;
    boolean wildCardImport = false;
    boolean staticImport   = false;
    
    public RImport(String statement) {
	this.importStatement = statement;
	
	if (importStatement.startsWith("import")) {
	    importStatement = importStatement.replaceFirst("import", "").trim();
	}
	if (importStatement.startsWith("static")) {
	    importStatement = importStatement.replaceFirst("static", "").trim();
	    staticImport = true;
	}
	if (importStatement.endsWith(";"))
	    importStatement = importStatement.replace(";", "").trim();
	if (importStatement.endsWith("*"))
	    wildCardImport = true;
    }

    public String getImportStatement() {
        return importStatement;
    }

    public boolean isWildCardImport() {
        return wildCardImport;
    }

    public boolean isStaticImport() {
        return staticImport;
    }    
    
    public String toString() {
	return importStatement;
    }
}
