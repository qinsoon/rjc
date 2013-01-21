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
import org.rjava.compiler.semantics.representation.RType;
import org.rjava.compiler.targets.CodeGenerator;

public class CLanguageGenerator extends CodeGenerator {
    public static final String NEWLINE = "\n";
    public static final String SEMICOLON = ";";
    public static final String POINTER = "*";
    public static final String THIS_LOCAL = "this";
    
    public static final String INCLUDE_STDIO = "#include <stdio.h>";
    public static final String MAIN_METHOD_SIGNATURE = "int main (int argc, const char** parameter0)";
    
    public static final String FORMAL_PARAMETER = "parameter";
    public static final String THIS_PARAMETER = "this_parameter";
    public static final String RJAVA_INIT = "rjinit";
    public static final String RJAVA_CLINIT = "rjclinit";
    
    public static final String INCOMPLETE_IMPLEMENTATION = "***Incomplete Implementation***";
    
    CLanguageNameGenerator name = new CLanguageNameGenerator();
    CLanguageIntrinsicGenerator intrinsic = new CLanguageIntrinsicGenerator();
    
    String cHeaderSource;
    String cCodeSource;

    @Override
    public void translate(RClass klass, String source)
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
        
        generateIntrinsic(klass, source);
        generateHeader(klass, source);
        generateCode(klass, source);
    }

    private void generateIntrinsic(RClass klass, String source) {
        // translate intrinsic types, e.g. java.lang.String/Integer, or org.vmmagic.unboxed.Address
        for (RType type : SemanticMap.types.values()) {
            intrinsic.generate(type);
        }
        
        // translate intrinsic statement
        for (RMethod method : klass.getMethods()) {
            intrinsic.generate(method);
            
            if (!method.isIntrinsic()) {
                for (RStatement stmt : method.getBody()) {
                    intrinsic.generate(stmt);
                }
            }
        }
    }

    private void generateCode(RClass klass, String source) throws RJavaError {
        StringBuilder out = new StringBuilder();

        // get code source
        cCodeSource = getSource(source, ".c");
        
        // include its own header
        out.append("#include \"" + cHeaderSource + "\"" + NEWLINE);
        // include c std
        out.append(INCLUDE_STDIO + NEWLINE);
        // TODO: include other
        
        out.append(NEWLINE);
        
        for (RMethod method : klass.getMethods()) {
            if (method.isMainMethod()) {
                out.append(MAIN_METHOD_SIGNATURE + " {" + NEWLINE);
            } else {
                out.append(getMethodSignature(method) + " {" + NEWLINE);
            }
            
            if (method.isIntrinsic()) {
                out.append(method.getCode());
            } else out.append(getMethodBody(method));
            
            out.append("}" + NEWLINE);
        }
        
        if (RJavaCompiler.DEBUG) {
            RJavaCompiler.debug("Code output to: " + cCodeSource);
            RJavaCompiler.debug(out);
        }
        
        writeTo(out.toString(), Constants.OUTPUT_DIR + cCodeSource);
    }

    private void generateHeader(RClass klass, String source) throws RJavaError {
        StringBuilder out = new StringBuilder();
        
        cHeaderSource = getSource(source, ".h");
        
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
        
        writeTo(out.toString(), Constants.OUTPUT_DIR + cHeaderSource);
    }
    
    private String getSource(String origin, String ext) {
        String ret = origin.replace(RJavaCompiler.currentTask.getPath(), "");
        ret = ret.replace(Constants.RJAVA_EXT, ext);
        ret = ret.replaceAll("/", "_");
        return ret;
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
            if (rStmt.isIntrinsic())
                out.append(rStmt.getCode());
            else out.append(stmt.get(rStmt));
            
            out.append(SEMICOLON + NEWLINE);
        }
        return out.toString();
    }
    
    public String comment(String s) {
        return "/* " + s + " */";
    }
}
