package org.rjava.compiler;

import org.rjava.compiler.pass.CompilationPass;

public interface CompilationUnit {
    public abstract void accept(CompilationPass pass);
}