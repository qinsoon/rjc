package org.rjava.compiler;

import static org.rjava.compiler.Constants.RJAVA_EXT;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.rjava.compiler.exception.RJavaWarning;

public class CompilationTask {
    String path;
    List<String> sources;
    List<String> classes;
    String main;
    
    public static CompilationTask newTaskFromFile(String dir, String file) throws RJavaWarning {
    	File f = new File(file);
    	File dirFile = new File(dir);
    	if (f.exists())
    	    f = f.getAbsoluteFile();
    	if (f.exists() && f.isFile())
    	    return new CompilationTask(dirFile.getAbsolutePath(), f.getAbsolutePath());
    	
    	throw new RJavaWarning("File doesn't exist: " + file);
    }
    
    public static CompilationTask newTaskFromDir(String dir) throws RJavaWarning {
    	File d = new File(dir);
    	if (d.exists())
    	    d = d.getAbsoluteFile();
    	if (d.exists() && d.isDirectory()) {
    	    List<String> sources = new ArrayList<String>();
    	    addFileToListRecursively(d, sources);
    	    return new CompilationTask(d.getAbsolutePath(), sources);
    	}
    	
    	throw new RJavaWarning("Directory doesn't exist: " + dir);
    }
    
    public void addSource(String file) {
        File f = new File(file);
        this.sources.add(f.getAbsoluteFile().getAbsolutePath());
        
        buildClassList();
    }
    
    private static void addFileToListRecursively(File dir, List<String> list) {
    	File[] all = dir.listFiles();
    	for (File f : all) {
    	    if (f.isFile())
    		list.add(f.getAbsolutePath());
    	    else if (f.isDirectory())
    	    	addFileToListRecursively(f, list);
    	}
    }

    protected CompilationTask(String path, String file) {
    	super();
    	if (!path.endsWith("/"))
    	    path += "/";
    	this.path = path;
    	this.sources = new ArrayList<String>();
    	this.sources.add(file);
    	
    	buildClassList();
    }
    
    protected CompilationTask(String path, List<String> sources) {
    	super();
    	if (!path.endsWith("/"))
    	    path += "/";
    	this.path = path;
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
    	    source = source.replaceAll(path, "");
    	    String className = source.substring(0, source.length() - RJAVA_EXT.length());
    	    className = className.replaceAll("/", ".");
    	    classes.add(className);
    	}
    }
    
    public String toString() {
    	String result = "Compilation Task: " + path + "\n";
    	for (String s : sources) {
    	    result += "-" + s + "\n";
    	}
    	result += "\n";
    	return result;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
