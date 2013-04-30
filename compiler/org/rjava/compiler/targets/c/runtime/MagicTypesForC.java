package org.rjava.compiler.targets.c.runtime;

import java.util.ArrayList;
import java.util.List;

import org.rjava.compiler.CompilationTask;
import org.rjava.compiler.Constants;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.exception.RJavaError;
import org.rjava.compiler.exception.RJavaWarning;
import org.rjava.compiler.semantics.SootEngine;

public class MagicTypesForC {

    public static void main(String[] args) {
        System.out.println("This implementation is broken. Quit");
        System.exit(-1);
        try {
            // unboxed types
            List<String> unboxedTypesFiles = new ArrayList<String>();
            for (String klassName : Constants.MAGIC_TYPES) {
                String file = klassName.replace('.', '/');
                file = Constants.RJAVA_MAGIC_DIR + file + Constants.RJAVA_EXT;
                unboxedTypesFiles.add(file);
            }
            for (String klassName : Constants.MAGIC_ARRAY_TYPES) {
                String file = klassName.replace('.', '/');
                file = Constants.RJAVA_MAGIC_DIR + file + Constants.RJAVA_EXT;
                unboxedTypesFiles.add(file);
            }
            
            // pack to compilation task
            CompilationTask compileUnboxedTypes = null;
            for (int i = 0; i < unboxedTypesFiles.size(); i++) {                
                if (i == 0) {
                    compileUnboxedTypes = CompilationTask.newTaskFromFile(Constants.RJAVA_MAGIC_DIR, unboxedTypesFiles.get(i));
                } else compileUnboxedTypes.addClassBySource(unboxedTypesFiles.get(i));
            }
            
            SootEngine.RUN_SOOT = false;
            
            RJavaCompiler compiler = RJavaCompiler.newRJavaCompiler(compileUnboxedTypes);
            MagicTypesForCGenerator generator = new MagicTypesForCGenerator();
            compiler.setCodeGenerator(generator);
            compiler.internalCompile(RJavaCompiler.INTERNAL_COMPILE_MAGIC_TYPES);
        } catch (RJavaWarning e) {
            e.printStackTrace();
            RJavaCompiler.warning(e.getMessage());
        } catch (RJavaError e) {
            e.printStackTrace();
            RJavaCompiler.error(e.getMessage());
        }
        
    }

}
