package org.rjava.compiler.semantics;

import java.util.ArrayList;
import java.util.List;

import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.util.Tree;

public class TypeHierarchy {
    List<Tree<RClass>> internal;
    
    protected TypeHierarchy() {
        internal = new ArrayList<Tree<RClass>>();
    }

    public static TypeHierarchy init() {
        TypeHierarchy ret = new TypeHierarchy();
        
        for (RClass klass : SemanticMap.classes.values()) 
            ret.add(klass);
        
        return ret;
    }

    private void add(RClass klass) {
        if (contains(klass))
            return;
        
        // we need to add this klass
        
        // if this klass is a root, then directly add to list
        if (!klass.hasSuperClass())
            internal.add(new Tree<RClass>(klass));
        // if we already have its superclass in the list, we add a new leaf then
        else if (klass.hasSuperClass() && contains(klass.getSuperClass())) {
            getTree(klass.getSuperClass()).addLeaf(klass);
        }
        // we dont have its super class yet, add super into hierarchy
        else {
            add(klass.getSuperClass());
        }
    }

    private Tree<RClass> getTree(RClass superClass) {
        for (Tree<RClass> root : internal) {
            Tree<RClass> ret = root.getTree(superClass);
            if (ret != null)
                return ret;
        }
        return null;
    }

    private boolean contains(RClass klass) {
        return getTree(klass) != null;
    }
    
    public void printHierarchy() {
        for (Tree<RClass> root : internal) {
            System.out.println("Tree:" + root.toString());
        }
    }
}
