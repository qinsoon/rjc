package org.rjava.compiler.targets.c.runtime;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.exception.RJavaError;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.targets.GeneratorOptions;
import org.rjava.compiler.targets.c.CLanguageGenerator;

public class RJavaLangForCGenerator extends CLanguageGenerator {

    public RJavaLangForCGenerator(GeneratorOptions generatorOptions) {
        super(generatorOptions);
    }
}
