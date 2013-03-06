package org.rjava.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.rjava.compiler.exception.RJavaError;
import org.rjava.compiler.exception.RJavaRestrictionViolation;
import org.rjava.compiler.exception.RJavaWarning;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RType;
import org.rjava.compiler.targets.CodeGenerator;
import org.rjava.compiler.targets.GeneratorOptions;
import org.rjava.compiler.targets.c.CLanguageGenerator;
import org.rjava.compiler.targets.c.CLanguageGeneratorOptions;
import org.rjava.restriction.StaticRestrictionChecker;

public class RJavaCompiler {
    public static final boolean DEBUG = true;

    // we use RJavaCompiler to compile its library and vmmagic
    private int internalCompile = INTERNAL_COMPILE_NONE;
    
    public static int INTERNAL_COMPILE_NONE         = 0;
    public static int INTERNAL_COMPILE_MAGIC_TYPES  = 1;
    public static int INTERNAL_COMPILE_LIB          = 2;
    
    private CompilationTask task;
    private CodeGenerator codeGenerator;
    private GeneratorOptions generatorOptions;
    private StaticRestrictionChecker checker;
    
    public static CompilationTask currentTask;
    
    private RJavaCompiler(CompilationTask task) {
    	this.task = task;
    	
        // initialize Restriction Checker and Code Generator
        checker = new StaticRestrictionChecker();
        generatorOptions = new CLanguageGeneratorOptions();
        codeGenerator = new CLanguageGenerator(generatorOptions);
    }
    
    public void internalCompile(int compileType) throws RJavaWarning, RJavaError{
        this.internalCompile = compileType;
        compile();
    }
    
    public void setCodeGenerator(CodeGenerator myCodeGenerator) {
        this.codeGenerator = myCodeGenerator;
    }
    
    /**
     * main logic for compile a {@link CompilationTask}
     * @throws RJavaWarning
     * @throws Error
     */
    public void compile() throws RJavaWarning, RJavaError{
        currentTask = task;
        
    	// collect semantic information (now with soot)
    	SemanticMap.initSemanticMap(task);
    	
    	codeGenerator.preTranslationWork();
    	
    	for (int i = 0; i < task.getSources().size(); i ++) {
    	    System.out.println("Compiling [" + task.getClasses().get(i) + "]: " + task.getSources().get(i));
    	    String source = task.getSources().get(i);
    	    String className = task.getClasses().get(i);
    	    RClass klass = SemanticMap.getAllClasses().get(className);
    	    
    	    // for each class, check restriction compliance first
    	    try {
    		checker.comply(klass);
    	    } catch (RJavaError e) {
    		error(e);
    	    } catch (RJavaWarning e) {
    		warning(e);
    	    } 
    	    
    	    // then compiles the class	    
    	    try {
    		codeGenerator.translate(klass, source);
    	    } catch (RJavaError e) {
    		error(e);
    	    } catch (RJavaWarning e) {
    		warning(e);
    	    }
    	}
    	
    	// copy library etc.
    	if (internalCompile == INTERNAL_COMPILE_NONE)
    	    codeGenerator.postTranslationWork();
    	
    	if (SemanticMap.DEBUG) {
    	    debug("Types:");
    	    for (RType type : SemanticMap.types.values())
    	        debug(type);
    	    debug("Classes:");
    	    for (RClass klass : SemanticMap.classes.values())
    	        debug(klass.getName());
    	}
    }
    
    /**
     * main method for RJava compile
     * @param args @see usage()
     */
    public static void main(String[] args) {
        String baseDir = null;
        Set<String> sources = new HashSet<String>();
        
        int i = 0;
        try{
            while(i < args.length) {
                if (args[i].equals("-dir")) {
                    baseDir = args[i+1];
                    i++;
                } else if (args[i].equals("-l")) {
                    String input = args[i+1];
                    i++;
                    BufferedReader br = new BufferedReader(new FileReader(input));
                    String line = br.readLine();
                    while(line != null) {
                        sources.add(line);
                        line = br.readLine();
                    }
                    br.close();
                } else {
                    sources.add(args[i]);
                }
                
                i++;
            }
            
            // check if args are valid
            if (baseDir == null)
                throw new RuntimeException("Didn't name a base directory. Use -dir");
            
            if (!new File(baseDir).isDirectory())
                throw new RuntimeException("Base directory is not a correct directory name. ");
            
            // add all files in the base directory
            if (sources.size() == 0) {
                List<String> temp = new ArrayList<String>();
                CompilationTask.addFileToListRecursively(new File(baseDir), temp);
                sources.addAll(temp);
                
                if (sources.size() == 0)
                    throw new RuntimeException("Didn't name source list. And base directory doesn't contain any source files");
            }
        } catch (Exception e) {
            e.printStackTrace();
            usage();
        }
        
        CompilationTask task = null;
        try {
            for (String source : sources) {
                if (task == null)
                    task = CompilationTask.newTaskFromFile(baseDir, source);
                else task.addSource(source);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        assert (task != null);
        
        // compile all tasks
	    if (DEBUG) debug(task);
	    
	    RJavaCompiler compiler = newRJavaCompiler(task);
	    try {
	        compiler.compile();
	    } catch (RJavaWarning e) {
	        warning(e);
	    } catch (RJavaError e) {
	        error(e);
	    }
    }
    
    private static RJavaCompiler singleton;
    public static RJavaCompiler newRJavaCompiler(CompilationTask t) {
        singleton = new RJavaCompiler(t);
        return singleton;
    }
    public static GeneratorOptions getCurrentGeneratorOptions() {
        return singleton.generatorOptions;
    }
    public static int isInternalCompiling() {
        return singleton.internalCompile;
    }
    public static void debug(Object o) {
        System.out.println(o);
    }
    
    public static void usage() {
    	String usage = "RJava compiler usage:\n";
    	usage += "1. Compiler -dir base_dir file1 file2 ...\n";
    	usage += "2. Compiler -dir source_dir_to_be_compiled\n";
    	error(usage);
    }

    public static void warning(Object o) {
        System.out.println("RJava compiler warning: " + o);
    }
    
    public static void error(Object o) {
    	System.out.println("RJava compiler error: " + o);
    	System.exit(-1);
    }
}
