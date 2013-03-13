package org.rjava.compiler;

import static org.rjava.compiler.Constants.RJAVA_EXT;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.rjava.compiler.exception.RJavaError;
import org.rjava.compiler.exception.RJavaWarning;

public class CompilationTask {
    String baseDir;
    List<String> sources;
    List<String> classes;
    String main;
    
    public static CompilationTask newTaskFromFile(String dir, String file) throws RJavaError {
    	File f = new File(file);
    	File dirFile = new File(dir);
    	if (f.exists())
    	    f = f.getAbsoluteFile();
    	if (f.exists() && f.isFile())
    	    return new CompilationTask(dirFile.getAbsolutePath(), f.getAbsolutePath());
    	
    	throw new RJavaError("File doesn't exist: " + file);
    }
    
    public static CompilationTask newTaskFromDir(String dir) throws RJavaError {
    	File d = new File(dir);
    	if (d.exists())
    	    d = d.getAbsoluteFile();
    	if (d.exists() && d.isDirectory()) {
    	    List<String> sources = new ArrayList<String>();
    	    addFileToListRecursively(d, sources);
    	    return new CompilationTask(d.getAbsolutePath(), sources);
    	}
    	
    	throw new RJavaError("Directory doesn't exist: " + dir);
    }
    
    public void addSource(String file) {
        File f = new File(file);
        this.sources.add(f.getAbsoluteFile().getAbsolutePath());
        
        buildClassList();
    }
    
    /**
     * assume we will find the class for this class name
     * @param className
     */
    public void addClass(String className) {
        String file = className.replace('.', '/');
        file += Constants.RJAVA_EXT;
        file = baseDir + file;
        
        //addSource(className);
        sources.add(file);
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

    protected CompilationTask(String baseDir, String file) {
    	super();
    	if (!baseDir.endsWith("/"))
    	    baseDir += "/";
    	this.baseDir = baseDir;
    	this.sources = new ArrayList<String>();
    	this.sources.add(file);
    	
    	buildClassList();
    }
    
    protected CompilationTask(String baseDir, List<String> sources) {
    	super();
    	if (!baseDir.endsWith("/"))
    	    baseDir += "/";
    	this.baseDir = baseDir;
    	this.sources = sources;
    	
    	buildClassList();
    }
    
    /**
     * change source files into class names
     */	    
    private void buildClassList() {
    	classes = new ArrayList<String>();
    	for (String source : sources) {
    	    // change test/org/rjava/HelloWorld.java -> org.rjava.HelloWorld
    	    source = source.replaceAll(baseDir, "");
    	    String className = source.substring(0, source.length() - RJAVA_EXT.length());
    	    className = className.replaceAll("/", ".");
    	    classes.add(className);
    	}
    }
    
    public String toString() {
    	String result = "Compilation Task: " + baseDir + "\n";
    	for (String s : sources) {
    	    result += "-" + s + "\n";
    	}
    	result += "\n";
    	return result;
    }
    
    public int size() {
        return sources.size();
    }

    public String getPath() {
        return baseDir;
    }

    public void setPath(String path) {
        this.baseDir = path;
    }

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }
}
