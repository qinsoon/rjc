package org.rjava.compiler.targets.c.runtime;

import java.util.ArrayList;
import java.util.List;

import org.rjava.compiler.CompilationTask;
import org.rjava.compiler.Constants;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.exception.RJavaError;
import org.rjava.compiler.exception.RJavaWarning;
import org.rjava.compiler.semantics.SootEngine;

public class RJavaLangForC {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            List<String> javaLangPackage = new ArrayList<String>();
            for (String klassName : Constants.RJAVA_JAVA_LANG) {
                String file = klassName.replace('.', '/');
                file = Constants.RJAVA_LIB_IMPL_DIR + file + Constants.RJAVA_EXT;
                javaLangPackage.add(file);
            }
            
            // pack to compilation task
            CompilationTask compileJavaLang = null;
            for (int i = 0; i < javaLangPackage.size(); i++) {
                if (i == 0) {
                    compileJavaLang = CompilationTask.newTaskFromFile(Constants.RJAVA_LIB_IMPL_DIR, javaLangPackage.get(i));
                } else compileJavaLang.addClassBySource(javaLangPackage.get(i));
            }
            
            SootEngine.RUN_SOOT = false;
            
            RJavaCompiler compiler = RJavaCompiler.newRJavaCompiler(compileJavaLang);
            RJavaLangForCGenerator generator = new RJavaLangForCGenerator();
            RJavaLangForCIntrinsicGenerator intrinsic = new RJavaLangForCIntrinsicGenerator(generator);
            generator.setIntrinsic(intrinsic);
            compiler.setCodeGenerator(generator);
            compiler.internalCompile(RJavaCompiler.INTERNAL_COMPILE_LIB);
        } catch (RJavaWarning e) {
            e.printStackTrace();
            RJavaCompiler.warning(e.getMessage());
        } catch (RJavaError e) {
            e.printStackTrace();
            RJavaCompiler.error(e.getMessage());
        }
    }

}
