package org.rjava.compiler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.rjava.compiler.exception.Warning;

public class CompilationTask {
    String path;
    List<String> sources;
    
    public static CompilationTask newTaskFromFile(String file) throws Warning {
	File f = new File(file);
	if (f.exists() && f.isFile())
	    return new CompilationTask(f.getParent(), file);
	
	throw new Warning("File doesn't exist: " + file);
    }
    
    public static CompilationTask newTaskFromDir(String dir) throws Warning {
	File d = new File(dir);
	if (d.exists() && d.isDirectory()) {
	    List<String> sources = new ArrayList<String>();
	    addFileToListRecursively(d, sources);
	    return new CompilationTask(dir, sources);
	}
	
	throw new Warning("Directory doesn't exist: " + dir);
    }
    
    private static void addFileToListRecursively(File dir, List<String> list) {
	File[] all = dir.listFiles();
	for (File f : all) {
	    if (f.isFile())
		list.add(f.getPath());
	    else if (f.isDirectory())
	    	addFileToListRecursively(f, list);
	}
    }

    protected CompilationTask(String path, String file) {
	super();
	this.path = path;
	this.sources = new ArrayList<String>();
	this.sources.add(file);
    }
    
    protected CompilationTask(String path, List<String> sources) {
	super();
	this.path = path;
	this.sources = sources;
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
}
