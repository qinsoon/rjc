package org.rjava.compiler.targets;

public abstract class GeneratorOptions {
    public abstract boolean allowInline();
    public abstract boolean allowArrayBoundCheck();
    public abstract boolean allowNullCheck();
}
