package org.rjava.compiler.targets.c;

import org.rjava.compiler.targets.GeneratorOptions;

public class CLanguageGeneratorOptions extends GeneratorOptions{
    @Override
    public final boolean allowInline() {
        return false;
    }

    @Override
    public boolean allowArrayBoundCheck() {
        return true;
    }

    @Override
    public boolean allowNullCheck() {
        return false;
    }
    
}
