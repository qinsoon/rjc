package org.rjava.compiler.targets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.exception.*;
import org.rjava.compiler.semantics.SemanticMap;

public abstract class CodeGenerator {

    public abstract void translate(RClass klass, String source) throws RJavaWarning, RJavaError;
    
    /**
     * e.g. copy library files, etc.
     * @throws RJavaWarning
     * @throws RJavaError
     */
    public abstract void postTranslationWork() throws RJavaWarning, RJavaError;

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
