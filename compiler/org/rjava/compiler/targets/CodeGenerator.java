package org.rjava.compiler.targets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.exception.*;
import org.rjava.compiler.semantics.SemanticMap;

public abstract class CodeGenerator {

    public abstract void translate(RClass klass) throws RJavaWarning, RJavaError;
    
    /**
     * e.g. clean up output dir
     */
    public void preTranslationWork() throws RJavaError{
        try {
            File outputDir = new File(RJavaCompiler.outputDir);
            if (!outputDir.exists())
                outputDir.mkdir();
            FileUtils.cleanDirectory(outputDir);
        } catch (IOException e) {
            throw new RJavaError("Error when cleaning output dir : " + e.getMessage());
        }
    }
    
    /**
     * e.g. copy library files, etc.
     * @throws RJavaWarning
     * @throws RJavaError
     */
    public abstract void postTranslationWork() throws RJavaWarning, RJavaError;
    
    /**
     * Generate source path for compiled file
     * @param origin source stored in CompilationTask
     * @param ext new extension for compiled file
     * @return
     */
    protected String getSource(String className, String ext) {
        String ret = className.replaceAll("\\.", "_");
        ret += ext;
        return escapeDollarInFileName(ret);
    }   
    
    /**
     * Nested classes has $ in its name. 
     * GNU Make doesn't accept $ sign in file name. We replace $ for _NESTED_
     * This method is called from two places: 
     * 1. getSource() for getting generated file name for classes 
     * 2. referencing() for generating includes 
     * @param fileName
     * @return
     */
    public static final String escapeDollarInFileName(String fileName) {
        return fileName.replaceAll("\\$", "_NESTED_");
    }

    public void writeTo(String out, String file) throws RJavaError {
        FileOutputStream os = null;
        try{
            File f = new File(file);
            if (!f.exists()) {
                f.getParentFile().mkdirs();
                f.createNewFile();
            }
            os = new FileOutputStream(f);
            os.write(out.getBytes());
        } catch (Exception e) {
            throw new RJavaError("Error when writing to file " + file + ". " + e.getMessage());
        } finally {
            if (os != null)
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
