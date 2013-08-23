package org.rjava.compiler;

import static org.rjava.compiler.Constants.RJAVA_EXT;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.rjava.compiler.exception.RJavaError;
import org.rjava.compiler.exception.RJavaWarning;
import org.rjava.compiler.semantics.SemanticMap;

public class CompilationTask {
    List<String> baseDir;
    //List<String> sources;
    List<String> classes = new ArrayList<String>();
    String main;
    
    public static CompilationTask newTaskFromFile(String dir, String file) throws RJavaError {
        List<String> dirs = new ArrayList<String>();
        dirs.add(dir);
        return newTaskFromFile(dirs, file);
    }
    
    public static CompilationTask newTaskFromFile(List<String> dir, String file) throws RJavaError {
        try {
            // get canonical path of base dir
            for (int i = 0; i < dir.size(); i++) {
                File dirFile = new File(dir.get(i));
                String update = dirFile.getCanonicalPath();
                if (!update.endsWith("/"))
                    update += "/";
                
                // check valid
                for (int j = 0; j < i; j++)
                    if (dir.get(j).contains(update) || update.contains(dir.get(j)))
                        throw new RJavaError("Base directories cannot overlap.");
                
                dir.set(i, update);
            }
            
            // check file
            File f = new File(file);
        	if (f.exists())
        	    f = f.getAbsoluteFile();
        	if (f.exists() && f.isFile())
                return new CompilationTask(dir, f.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RJavaError("Error when creating new Task");
        }
    	
    	throw new RJavaError("File doesn't exist: " + file);
    }
    
    public void addClassBySource(String file) throws RJavaError {
        try {
            File f = new File(file);
            String absPath = f.getCanonicalFile().getCanonicalPath();
            
            String className = null;
            for (String base : baseDir)
                if (absPath.contains(base))
                    className = absPath.replaceAll(base, "");
            if (className == null)
                throw new RJavaError("source file " + file + " is not contained in any named base directory");
            
            className = className.substring(0, className.length() - RJAVA_EXT.length());
            className = className.replaceAll("/", ".");
            classes.add(className);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RJavaError("Error when adding " + file + " to compilation task");
        }
    }
    
    /**
     * Add a class to compilation list. If the list already contains such class name, do nothing.
     * Assume we will find the class for this class name
     * @param className
     */
    public void addClassByClassName(String className) {
        // we are not compiling rjava lib or java lib, then we only compile application class here
        // only application class will be added to the list
        if (RJavaCompiler.isInternalCompiling() == RJavaCompiler.INTERNAL_COMPILE_NONE)
            if (!SemanticMap.isApplicationClass(className))
                return;

        if (!classes.contains(className))
            classes.add(className);
    }
    
    public static void addFileToListRecursively(File dir, List<String> sources2) {
    	File[] all = dir.listFiles();
    	for (File f : all) {
    	    if (f.isFile() && f.getName().endsWith(Constants.RJAVA_EXT))
    	        sources2.add(f.getAbsolutePath());
    	    else if (f.isDirectory())
    	    	addFileToListRecursively(f, sources2);
    	}
    }

    protected CompilationTask(List<String> baseDir, String file) throws RJavaError {
    	super();
    	this.baseDir = baseDir;
    	this.addClassBySource(file);
    }
    
    public String toString() {
    	String result = "Compilation Task: " + baseDir + "\n";
    	for (String s : classes) {
    	    result += "-" + s + "\n";
    	}
    	result += "\n";
    	return result;
    }
    
    public int size() {
        return classes.size();
    }

    public List<String> getPath() {
        return baseDir;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }
}
