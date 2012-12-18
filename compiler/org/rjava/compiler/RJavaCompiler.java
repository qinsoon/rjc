package org.rjava.compiler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.rjava.compiler.exception.RJavaError;
import org.rjava.compiler.exception.RJavaWarning;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.targets.CodeGenerator;
import org.rjava.compiler.targets.c.CLanguageGenerator;
import org.rjava.restriction.StaticRestrictionChecker;

public class RJavaCompiler {
    public static final boolean DEBUG = true;

    private CompilationTask task;
    private SemanticMap semantics;
    private CodeGenerator codeGenerator;
    private StaticRestrictionChecker checker;
    
    public RJavaCompiler(CompilationTask task) {
	this.task = task;
    }
    
    /**
     * main logic for compile a {@link CompilationTask}
     * @throws RJavaWarning
     * @throws Error
     */
    public void compile() throws RJavaWarning, RJavaError{
	// collect semantic information (now with soot)
	semantics = new SemanticMap(task);
	
	// initialize Restriction Checker and Code Generator
	checker = new StaticRestrictionChecker();
	codeGenerator = new CLanguageGenerator();
	
	for (RClass klass : semantics.getAllClasses().values()) {
	    if (DEBUG)
		System.out.println("Compiling " + klass.getName() + "...");
	    // for each class, check restriction compliance first
	    try {
		checker.comply(klass, semantics);
	    } catch (RJavaError e) {
		error(e);
	    } catch (RJavaWarning e) {
		warning(e);
	    }
	    
	    // then compiles the class	    
	    try {
		codeGenerator.translate(klass, semantics);
	    } catch (RJavaError e) {
		error(e);
	    } catch (RJavaWarning e) {
		warning(e);
	    }
	}
    }
    
    /**
     * main method for RJava compile
     * @param args @see usage()
     */
    public static void main(String[] args) {
	if (args.length <= 0)
	    usage();
	
	List<CompilationTask> tasks = new ArrayList<CompilationTask>();
	
	// input as source dir, i.e. -dir source_dir
	if (args.length >= 2 && args[0].equals("-dir")) {
	    File sourceDir = new File(args[1]);
	    if (!sourceDir.isDirectory())
		usage();
	    
	    try {
		tasks.add(CompilationTask.newTaskFromDir(args[1]));
	    } catch (RJavaWarning e) {
		warning(e);
	    }
	}
	// input as a list of files
	else {
	    for (String arg : args)
		try {
		    tasks.add(CompilationTask.newTaskFromFile(arg));
		} catch (RJavaWarning e) {
		    warning(e);
		}
	}

	// compile all tasks
	for (CompilationTask t : tasks) {
	    if (DEBUG) debug(t);
	    RJavaCompiler compiler = new RJavaCompiler(t);
	    try {
		compiler.compile();
	    } catch (RJavaWarning e) {
		warning(e);
	    } catch (RJavaError e) {
		error(e);
	    }
	}
    }
    
    public static void debug(Object o) {
	System.out.println(o);
    }
    
    public static void usage() {
	String usage = "RJava compiler usage:\n";
	usage += "1. Compiler file1 file2 ...\n";
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
