package org.rjava.compiler.targets.c;

import org.rjava.compiler.Constants;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.exception.RJavaError;
import org.rjava.compiler.exception.RJavaWarning;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RField;
import org.rjava.compiler.semantics.representation.RLocal;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.semantics.representation.RStatement;
import org.rjava.compiler.targets.CodeGenerator;

public class CLanguageGenerator extends CodeGenerator {
    public static final String NEWLINE = "\n";
    public static final String SEMICOLON = ";";
    public static final String POINTER = "*";
    public static final String THIS_LOCAL = "this";
    
    public static final String INCLUDE_STDIO = "#include <stdio.h>";
    public static final String MAIN_METHOD_SIGNATURE = "int main (int argc, const char* parameter0[])";
    
    public static final String FORMAL_PARAMETER = "parameter";
    public static final String THIS_PARAMETER = "this_parameter";
    public static final String RJAVA_INIT = "rjinit";
    public static final String RJAVA_CLINIT = "rjclinit";
    
    public static final String INCOMPLETE_IMPLEMENTATION = "***Incomplete Implementation***";
    
    CLanguageNameGenerator name = new CLanguageNameGenerator();
    
    String cHeaderSource;
    String cCodeSource;

    @Override
    public void translate(RClass klass, String source, SemanticMap semantics)
	    throws RJavaWarning, RJavaError {
        if (RJavaCompiler.DEBUG)
            for (RMethod method : klass.getMethods()) {
                RJavaCompiler.debug(method + "{");
                RJavaCompiler.debug("Locals:");
                for (RLocal local : method.getLocals()) {
                    RJavaCompiler.debug(local);
                }
                RJavaCompiler.debug("Locals end. ");
                for (RStatement stmt : method.getBody()) {
                    RJavaCompiler.debug("  " + stmt);
                }
                RJavaCompiler.debug("}");
            }
        
        generateHeader(klass, source, semantics);
        generateCode(klass, source, semantics);
    }

    private void generateCode(RClass klass, String source, SemanticMap semantics) {
        StringBuilder out = new StringBuilder();
        cCodeSource = source.replace(Constants.RJAVA_EXT, ".c");
        
        // include its own header
        out.append("#include \"" + cHeaderSource + "\"" + NEWLINE);
        // include c std
        out.append(INCLUDE_STDIO + NEWLINE);
        // TODO: include other
        
        out.append(NEWLINE);
        
        for (RMethod method : klass.getMethods()) {
            if (method.isMainMethod()) {
                out.append(MAIN_METHOD_SIGNATURE + " {" + NEWLINE);
                out.append(getMethodBody(method));
                out.append("}" + NEWLINE);
            } else {
                out.append(getMethodSignature(method) + " {" + NEWLINE);
                out.append(getMethodBody(method));
                out.append("}" + NEWLINE);
            }
        }
        
        if (RJavaCompiler.DEBUG) {
            RJavaCompiler.debug("Code output to: " + cCodeSource);
            RJavaCompiler.debug(out);
        }
    }

    private void generateHeader(RClass klass, String source,
            SemanticMap semantics) {
        StringBuilder out = new StringBuilder();
        cHeaderSource = source.replace(Constants.RJAVA_EXT, ".h");
        
        // TODO: generate global fields
        
        // generate struct for such class
        out.append("typedef struct " + name.get(klass) + " {" + NEWLINE);
        for (RField field : klass.getFields()) {
            out.append(name.get(field.getType()) + " " + name.get(field) + SEMICOLON + NEWLINE);
        }
        out.append("} " + name.get(klass) + SEMICOLON + NEWLINE);
        
        for (RMethod method : klass.getMethods()) {
            if (!method.isMainMethod()) {
                out.append(getMethodSignature(method) + SEMICOLON + NEWLINE);
            }
        }
        
        if (RJavaCompiler.DEBUG) {
            RJavaCompiler.debug("Header output to: " + cHeaderSource);
            RJavaCompiler.debug(out);
        }
    }
    
    
    public String getMethodSignature(RMethod method) {
        StringBuilder out = new StringBuilder();
        out.append(name.get(method.getReturnType()) + " ");
        out.append(name.get(method) + " (");
        // if not static, the first parameter will be 'this'
        if (!method.isStatic()) {
            out.append(name.get(method.getKlass()) + POINTER + " " + THIS_PARAMETER); 
        }
        for (int i = 0; i < method.getParameters().size(); i++) {
            out.append(", ");
            out.append(name.get(method.getParameters().get(i)) + " " + FORMAL_PARAMETER + i);                        
        }
        out.append(")");
        return out.toString();
    }
    
    public String getMethodBody(RMethod method) {
        StringBuilder out = new StringBuilder();
        CLanguageStatementGenerator stmt = new CLanguageStatementGenerator();
        out.append(comment("locals") + NEWLINE);
        for (RLocal local : method.getLocals()) {
            out.append(stmt.get(local) + SEMICOLON + NEWLINE);
        }
        out.append(comment("stmts") + NEWLINE);
        for (RStatement rStmt : method.getBody()) {
            out.append(stmt.get(rStmt) + SEMICOLON + NEWLINE);
        }
        return out.toString();
    }
    
    public String comment(String s) {
        return "/* " + s + " */";
    }
}
