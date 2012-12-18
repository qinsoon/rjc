package org.rjava.compiler.targets;

import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.exception.*;
import org.rjava.compiler.exception.RJavaError;
import org.rjava.compiler.semantics.SemanticMap;

public abstract class CodeGenerator {

    public abstract void translate(RClass klass, String source, SemanticMap semantics) throws RJavaWarning, RJavaError;

}
