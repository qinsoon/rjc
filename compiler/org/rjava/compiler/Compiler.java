package org.rjava.compiler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.rjava.compiler.exception.Warning;

public class Compiler {
    public static final boolean DEBUG = true;

    public static void main(String[] args) {
	if (args.length <= 0)
	    usage();
	
	List<CompilationTask> tasks = new ArrayList<CompilationTask>();
	// input as source dir
	if (args.length >= 2 && args[0].equals("-dir")) {
	    File sourceDir = new File(args[1]);
	    if (!sourceDir.isDirectory())
		usage();
	    
	    try {
		tasks.add(CompilationTask.newTaskFromDir(args[1]));
	    } catch (Warning e) {
		warning(e);
	    }
	} else {
	    for (String arg : args)
		try {
		    tasks.add(CompilationTask.newTaskFromFile(arg));
		} catch (Warning e) {
		    warning(e);
		}
	}

	if (DEBUG)
	    for (CompilationTask t : tasks)
		debug(t);
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
