package org.rjava.compiler.semantics.representation;

import java.util.ArrayList;
import java.util.List;

import org.rjava.compiler.Constants;
import org.rjava.compiler.RJavaCompiler;

import soot.SootField;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;

public class RField {
    RClass klass;
    SootField internal;
    
    RType type;
    String name;
    
    List<RAnnotation> annos = new ArrayList<RAnnotation>();
    
    /**
     * this field will be updated by DetectInlinableFieldPass
     */
    boolean isInlinable = false;

    public RField(RClass klass, SootField f) {
        this.klass = klass;
        this.internal = f;
        
        this.type = RType.initWithClassName(f.getType().toString());
        this.name = f.getName();
        
        fetchAnnotations(f);
    }

    private void fetchAnnotations(SootField f) {
        for (Tag tag : f.getTags()) {
            if (tag instanceof VisibilityAnnotationTag) {
                VisibilityAnnotationTag annoTag = (VisibilityAnnotationTag) tag;
                for (AnnotationTag t : annoTag.getAnnotations())
                    annos.add(new RAnnotation(t));
            }
        }
    }
    
    public boolean isRegisterField() {
        for (RAnnotation rAnno : annos)
            if (rAnno.getType().getClassName().equals(Constants.RJAVA_REGISTERFIELD_ANNOTATION))
                return true;
        
        return false;
    }

    public RType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public boolean isStatic() {
        return internal.isStatic();
    }
    
    public boolean isInstanceField() {
        return !isStatic();
    }
    
    public boolean isFinal() {
        return internal.isFinal();
    }
    
    /**
     * is this field valid for object inlining?
     * @return
     */
    public boolean isInlinable() {
        return isInlinable;
    }
    
    public void setInlinable(boolean inlinable) {
        this.isInlinable = inlinable;
    }
    
    public RClass getDeclaringClass() {
        return klass;
    }
    
    public boolean equals(Object another) {
        return internal.equals(((RField)another).internal);
    }
    
    public static RField fromSootField(SootField sootField) {
        RClass thisClass = RClass.fromSootClass(sootField.getDeclaringClass());
        for (RField f : thisClass.getFields()) {
            if (f.internal.equals(sootField))
                return f;
        }
        
        RJavaCompiler.fail("cant find RField for " + sootField);
        return null;
    }
}
