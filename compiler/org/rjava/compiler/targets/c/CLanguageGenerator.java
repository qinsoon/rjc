package org.rjava.compiler.targets.c;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
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
    public static final String VOID = "void";
    public static final String POINTER = "*";
    public static final String FIELD_POINTER = "->";
    public static final String THIS_LOCAL = "this";
    public static final String RETURN = "return";
    public static final String MALLOC = "malloc";       // may use gcmalloc instead
    public static final String SIZE_OF = "sizeof";
    
    public static final String INCLUDE_STDIO = "#include <stdio.h>";
    public static final String RJAVA_CLASS_INIT = "rjava_class_init";
    public static final String RJAVA_LIB_INCLUDE_FILE = "rjava_lib.h";
    public static final String RJAVA_LIB_INCLUDE = "#include \"" + RJAVA_LIB_INCLUDE_FILE + "\"";
    public static final String[] RJAVA_LIB = {
        "java_io_PrintStream",
        "java_lang_Object",
        "java_lang_System",
        "java_lang_StringBuffer"
    };
    public static final String RJAVA_LIB_DIR = "rjava_clib/";
    public static final String MAIN_METHOD_SIGNATURE = "int main (int argc, const char** parameter0)";
    
    public static final String FORMAL_PARAMETER = "parameter";
    public static final String THIS_PARAMETER = "this_parameter";
    public static final String RJAVA_INIT = "rjinit";
    public static final String RJAVA_CLINIT = "rjclinit";
    
    // related with dyanmic dispatching
    public static final String POINTER_TO_CLASS_STRUCT = "class_struct";    // in object, pointing to its class
    public static final String EMBED_SUPER_OBJECT = "embed_super_object";
    public static final String EMBED_SUPER_CLASS  = "embed_super_class";
    public static final String SUPER_CLASS = "super_class";
    public static final String CLASS_STRUCT_SUFFIX = "_class";
    public static final String CLASS_STRUCT_INSTANCE_SUFFIX = "_class_instance";
    
    public static final String INCOMPLETE_IMPLEMENTATION = "***Incomplete Implementation***";
    
    CLanguageNameGenerator name = new CLanguageNameGenerator();
    CLanguageIntrinsicGenerator intrinsic = new CLanguageIntrinsicGenerator();
    
    String cHeaderSource;
    String cCodeSource;
    
    List<String> translatedCSource = new ArrayList<String>();
    String mainSource = "";
    String mainObj = "";
    
    StringBuilder classInit = new StringBuilder();

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
        boolean containsMain = false;
        
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
                containsMain = true;
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
        translatedCSource.add(cCodeSource);
        if (containsMain) {
            mainSource = cCodeSource;
            mainObj = name.get(klass);
        }
    }

    private void generateHeader(RClass klass, String source) throws RJavaError {
        StringBuilder out = new StringBuilder();
        
        cHeaderSource = getSource(source, ".h");
        
        // include guard
        out.append("#ifndef " + name.get(klass).toUpperCase() + "_H" + NEWLINE);
        out.append("#define " + name.get(klass).toUpperCase() + "_H" + NEWLINE);
        
        // include rjava lib
        out.append(RJAVA_LIB_INCLUDE + NEWLINE);
        
        // generate struct for object (e.g. org_rjava_test_poly_Animal)
        out.append("typedef struct " + name.get(klass) + " {" + NEWLINE);
        // we only put void* class_struct in the super class
        // otherwise we contain a struct for its super class object
        if (klass.hasSuperClass()) {
            out.append(commentln("contains super object struct"));
            out.append(name.get(klass.getSuperClass()) + " " + EMBED_SUPER_OBJECT + SEMICOLON + NEWLINE);
        } else {
            out.append(commentln("pointer to its class Struct"));
            out.append(getPointerToClassStruct(klass) + SEMICOLON + NEWLINE);
        }
        out.append(commentln("instance fields"));
        for (RField field : klass.getFields()) {
            out.append(name.get(field.getType()) + " " + name.get(field) + SEMICOLON + NEWLINE);
        }
        out.append("} " + name.get(klass) + SEMICOLON + NEWLINE);
        
        // generate struct for class (e.g. org_rjava_test_poly_Animal_class)
        out.append("typedef struct " + name.get(klass) + CLASS_STRUCT_SUFFIX + " {" + NEWLINE);
        if (klass.hasSuperClass()) {
            // contain a struct for its super class
            out.append(commentln("contains super class struct"));
            out.append(name.get(klass.getSuperClass()) + " " + EMBED_SUPER_CLASS + SEMICOLON + NEWLINE);
            // init super class in class_init()
            classInit.append("((" + name.get(klass.getSuperMostClass()) + CLASS_STRUCT_SUFFIX + "*)(&" + name.get(klass) + CLASS_STRUCT_INSTANCE_SUFFIX + "))");
            classInit.append(" -> " + SUPER_CLASS + " = " + "&" + name.get(klass.getSuperMostClass()) + CLASS_STRUCT_INSTANCE_SUFFIX);
            classInit.append(SEMICOLON + NEWLINE);
        } else {
            // only put void* super_class if this class doesnt have a super class
            out.append(commentln("pointer to super class"));
            out.append(VOID + POINTER + " " + SUPER_CLASS + SEMICOLON + NEWLINE);
        }
        for (RMethod method : klass.getMethods()) {
            // if a method is 
            // 1. not static
            // 2. not overriden (declared in super class)
            // 3. not constructor (this is implementation policy, which may be changed later)
            // then we put it in the class struct
            if (!method.isStatic() && !method.isOverridingMethod() && !method.getName().equals("<init>")) {
                out.append(getFunctionPointerForMethod(method) + SEMICOLON + NEWLINE);
                // init function pointer in class_init()
                
            }
        }
        out.append("} " + name.get(klass) + CLASS_STRUCT_SUFFIX + SEMICOLON + NEWLINE);
        
        // global variable
        out.append(commentln("class instance"));
        out.append(name.get(klass) + CLASS_STRUCT_SUFFIX + " ");
        out.append(name.get(klass) + CLASS_STRUCT_INSTANCE_SUFFIX + SEMICOLON + NEWLINE);
        // TODO: generate other global fields
        
        // functions
        out.append(commentln("function definitions"));
        for (RMethod method : klass.getMethods()) {
            if (!method.isMainMethod()) {
                out.append(getMethodSignature(method) + SEMICOLON + NEWLINE);
            }
        }
        
        out.append("#endif");
        
        if (RJavaCompiler.DEBUG) {
            RJavaCompiler.debug("Header output to: " + cHeaderSource);
            RJavaCompiler.debug(out);
        }
        
        writeTo(out.toString(), Constants.OUTPUT_DIR + cHeaderSource);
    }
    
    private String getFunctionPointerForMethod(RMethod method) {
       StringBuilder out = new StringBuilder();
       // return
       out.append(name.get(method.getReturnType()) + " ");
       // function ptr name
       out.append("(*" + method.getName() + ") ");
       // parameter list
       out.append("(");
       out.append(name.get(method.getKlass()) + POINTER + " " + THIS_PARAMETER);
       for (int i = 0; i < method.getParameters().size(); i++) {
           out.append(", ");
           out.append(name.get(method.getParameters().get(i)) + " " + FORMAL_PARAMETER + i);   
       }
       out.append(")");
       return out.toString();
    }

    private String getPointerToClassStruct(RClass klass) {
        return VOID + POINTER + " " + POINTER_TO_CLASS_STRUCT;
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
        out.append(commentln("locals"));
        for (RLocal local : method.getLocals()) {
            out.append(stmt.get(local) + SEMICOLON + NEWLINE);
        }
        out.append(commentln("stmts"));
        for (RStatement rStmt : method.getBody()) {
            if (rStmt.isIntrinsic())
                out.append(rStmt.getCode());
            else out.append(stmt.get(rStmt));
            
            out.append(SEMICOLON + NEWLINE);
        }
        return out.toString();
    }
    
    public String commentln(String s) {
        return "/* " + s + " */" + NEWLINE;
    }

    @Override
    public void postTranslationWork() throws RJavaWarning, RJavaError {
        // generating lib include
        StringBuilder out = new StringBuilder();
        out.append("#ifndef RJAVA_LIB_H" + NEWLINE);
        out.append("#define RJAVA_LIB_H" + NEWLINE);
        for (String lib : RJAVA_LIB) {
            out.append("#include \"" + lib + ".h\"" + NEWLINE);
        }
        
        out.append("#define RJAVA_STR char *" + NEWLINE);
        out.append("#endif");
        writeTo(out.toString(), Constants.OUTPUT_DIR + RJAVA_LIB_INCLUDE_FILE);
        
        // copy lib files
        try {
            FileUtils.copyDirectory(new File(RJAVA_LIB_DIR), new File(Constants.OUTPUT_DIR), false);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // generate makefile
        StringBuilder makeFile = new StringBuilder();
        makeFile.append("all: ");
        String fileList = "";
        for (String c : translatedCSource)
            fileList += c + " ";
        for (String l : RJAVA_LIB)
            fileList += l + ".c ";
        makeFile.append(NEWLINE);
        makeFile.append("\tgcc -o " + mainObj + " ");
        makeFile.append(fileList);
        makeFile.append(" -I .");
        writeTo(makeFile.toString(), Constants.OUTPUT_DIR + "Makefile");
    }
}
