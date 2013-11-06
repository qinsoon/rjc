package org.rjava.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
import org.rjava.compiler.util.Statistics;
import org.rjava.restriction.StaticRestrictionChecker;

public class RJavaCompiler {
    public static final boolean DEBUG = true;

    // we use RJavaCompiler to compile its library and vmmagic
    private int internalCompile = INTERNAL_COMPILE_NONE;
    
    public static int INTERNAL_COMPILE_NONE         = 0;
    public static int INTERNAL_COMPILE_MAGIC_TYPES  = 1;
    public static int INTERNAL_COMPILE_LIB          = 2;
    
    private CompilationTask task;

    public static String outputDir = "output/";
    
    private static CodeGenerator codeGenerator = new CLanguageGenerator();
    private static StaticRestrictionChecker checker = new StaticRestrictionChecker();
    private static GeneratorOptions options = new CLanguageGeneratorOptions();
    
    public static CompilationTask currentTask;
    
    // the executable will be named under this name, instead of the class name where main method exists
    public static String namedOutput = null;
    // allow the generated code in debug mode (if C is the target, use -g in gcc flags) 
    public static boolean debugTarget = false;
    // compile as 32bits executable
    public static boolean m32 = false;
    
    // rjava restr./ext. annotations' path
    public static String soot_jdk_path = "components/soot/";    // should contain jce.jar and rt.jar
    public static String rjava_ext = "rjava_ext/";
    public static String rjava_rt = "rjava_rt/";
    
    public static final int HOST_MACOSX = 0;
    public static final int HOST_LINUX  = 1;
    // which os the C code will run on
    public static int hostOS = HOST_MACOSX;
    
    /**
     * log how many times each function is executed
     * Turning on this results in extremely slow execution. So be careful to turn it on for large programs
     */
    public static final boolean LOG_FUNCTION_EXECUTION = false;
    
    private RJavaCompiler(CompilationTask task) {
    	this.task = task;
    }
    
    public void internalCompile(int compileType) throws RJavaWarning, RJavaError{
        this.internalCompile = compileType;
        compile();
    }
    
    public void setCodeGenerator(CodeGenerator myCodeGenerator) {
        this.codeGenerator = myCodeGenerator;
    }
    
    public void init() {
        codeGenerator.init();
        
        // collect semantic information (now with soot)
        SemanticMap.initSemanticMap(task);
    }
    
    /**
     * main logic for compile a {@link CompilationTask}
     * @throws RJavaWarning
     * @throws Error
     */
    public void compile() throws RJavaWarning, RJavaError{
        try {
            currentTask = task;
        	
        	codeGenerator.preTranslationWork();
        	
        	for (int i = 0; i < task.getClasses().size(); i ++) {
        	    RJavaCompiler.println("Compiling [" + task.getClasses().toArray()[i] + "]: ");
        	    String className = (String) task.getClasses().get(i);
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
        	        codeGenerator.translate(klass);
        	    } catch (RJavaError e) {
        	        error(e);
        	    } catch (RJavaWarning e) {
        	        warning(e);
        	    }
        	}
        	
        	// copy library etc.
        	if (internalCompile == INTERNAL_COMPILE_NONE)
        	    codeGenerator.postTranslationWork();
    	} catch (RuntimeException e) {
            RJavaCompiler.println("RuntimeException. Check the error message");
            error(e);
        }
    }
    
    public void finish() throws IOException {
        RJavaCompiler.println("");
        if (checker.needReport()) {
            checker.report();
        }
        else {
            RJavaCompiler.println("\nCompilation successful");
        }
        RJavaCompiler.println("\n(output: " + new File(outputDir).getCanonicalPath() + ")");
    }
    
    /**
     * main method for RJava compile
     * @param args @see usage()
     */
    public static void main(String[] args) {
        List<String> baseDir = new ArrayList<String>();
        Set<String> sources = new HashSet<String>();
        
        int i = 0;
        try{
            while(i < args.length) {
                if (args[i].startsWith("-target")) {
                    // dispatch to target specific option process
                    codeGenerator.processCommandlineOptions(args[i]);
                }
                else if (args[i].equals("-dir")) {
                    String[] temp = args[i+1].split(":");
                    for (String t : temp)
                        baseDir.add(t);
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
                } else if (args[i].equals("-m")) {
                    mute = true;
                } else if (args[i].equals("-o")) {
                    namedOutput = args[i+1];
                    i++;
                } else if (args[i].equals("-dt")) {
                    debugTarget = true;
                } else if (args[i].equals("-outdir")) {
                    // FIXME: ignoring this flag
                    //outputDir = args[i+1];
                    //if (!outputDir.endsWith("/"))
                    //    outputDir += "/";
                    i++;
                } else if (args[i].equals("-m32")){
                    m32 = true;
                } else if (args[i].equals("-rjava_ext")) {
                    rjava_ext = args[i+1];
                    i++;
                } else if (args[i].equals("-rjava_rt")) {
                    rjava_rt = args[i+1];
                    i++;
                } else if (args[i].equals("-host_os")) {
                    String os = args[i+1];
                    if (os.equalsIgnoreCase("mac")) {
                        hostOS = HOST_MACOSX;
                    } else if (os.equalsIgnoreCase("linux")) {
                        hostOS = HOST_LINUX;
                    } else {
                        error("Unsupported hosting OS: " + os);
                    }
                    i++;
                } else if (args[i].equals("-soot_jdk")) {
                    soot_jdk_path = args[i+1];
                    i++;
                }
                else {
                    sources.add(args[i]);
                }
                
                i++;
            }
            
            // check if args are valid
            if (baseDir.size() == 0)
                throw new RuntimeException("Didn't name a base directory. Use -dir");
            
            for (int index = 0; index < baseDir.size(); index++) {
                String base = baseDir.get(index);
                if (!new File(base).isDirectory())
                    throw new RuntimeException("Base directory " + base + " is not a correct directory name. ");
                else {
                    // set canonical name
                    String canonical = new File(base).getCanonicalPath();
                    baseDir.set(index, canonical);
                    println("changed base dir from " + base + " to " + canonical);
                }
            }
            
            // add all files in the base directory
            if (sources.size() == 0) {
                List<String> temp = new ArrayList<String>();
                for (String base : baseDir)
                    CompilationTask.addFileToListRecursively(new File(base), temp);
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
                else task.addClassBySource(source);
            }
        } catch (RJavaError e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        
        assert (task != null);
        
        // compile all tasks
	    if (DEBUG) debug(task);
	    
	    RJavaCompiler compiler = newRJavaCompiler(task);
	    try {
	        compiler.init();
	        compiler.compile();
	        compiler.finish();
	    } catch (RJavaWarning e) {
	        warning(e);
	    } catch (RJavaError e) {
	        error(e);
	    } catch (IOException e) {
	        e.printStackTrace();
	        error(e);
	    }
	    
        Statistics.report();
    }
    
    private static RJavaCompiler singleton;
    public static RJavaCompiler newRJavaCompiler(CompilationTask t) {
        singleton = new RJavaCompiler(t);
        return singleton;
    }
    public static int isInternalCompiling() {
        return singleton.internalCompile;
    }
    public static CodeGenerator getCodeGenerator() {
        return codeGenerator;
    }
    public static GeneratorOptions getGeneratorOptions() {
        return options;
    }
    
    public static void usage() {
    	String usage = "RJava compiler usage:\n";
    	usage += "1. Compiler -dir base_dir file1 file2 ...\n";
    	usage += "2. Compiler -dir source_dir_to_be_compiled\n";
    	usage += "\n";
    	usage += "Options:\n";
    	usage += "-m\t\t\tmakes compiler mute (output nothing except warning/error)\n";
    	usage += "-l [file_name]\t\t\ttakes source files from the file named\n";
    	usage += "-o [file_name]\t\t\texecutable name\n";
    	usage += "-m32\t\t\tbuild for 32 bits address\n";
    	usage += "-dt\t\t\tenable debug information during c compilation (-g in gcc)\n";
    	error(usage);
    }

    public static void warning(Object o) {
        err.println("RJava compiler warning: " + o);
    }
    
    public static void error(Object o) {
        err.println("RJava compiler error: " + o);
        if (o instanceof Exception)
            ((Exception)o).printStackTrace();
        else Thread.dumpStack();
    	System.exit(-1);
    }
    
    public static void debug(Object o) {
        RJavaCompiler.println(o);
    }
    
    /*
     * wrap standard out, so the compiler can be completely mute. 
     */
    public static boolean mute = false;
    
    private static final PrintWriter out = new PrintWriter(System.out, true);
    private static final PrintWriter err = new PrintWriter(System.err, true);
    
    public static void print(Object o) {
        if (!mute)
            out.print(o);
    }
    public static void println(Object o) {
        if (!mute)
            out.println(o);
    }
    
    public static final boolean ENABLE_ASSERTION = true;
    public static void assertion(boolean a, String message) {
        if (ENABLE_ASSERTION == false)
            error("Assertion must be guarded by ENABLE_ASSERTION");
        
        if (!a) {
            error("Assertion failed: " + message);
        }
    }
    public static void fail(String message) {
        error("Fail: " + message);
    }
    
    public static void incompleteImplementationError() {
        error("Incomplete implementation, please check source code");
    }
    
    public static final boolean OPT_DEVIRTUALIZATION = true;
    
    /**
     * only works in the simplest testcase (see org.rjava.test.opt.objectinline)
     * and this opt seems not making code faster
     * 
     * with object inlining: 
     *   real    0m3.839s
     *   user    0m4.050s
     *   sys     0m0.750s
     *   
     * without object inlining:
     *   real    0m3.857s
     *   user    0m3.870s
     *   sys     0m0.510s
     *   
     * turned it off. and probably not going to work on it any more
     */
    public static final boolean OPT_OBJECT_INLINING =  false;   
    
    public static final boolean OPT_CONSTANT_PROPAGATION = true;
}
