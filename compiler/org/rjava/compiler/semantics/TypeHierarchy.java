package org.rjava.compiler.semantics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.util.Tree;
import org.rjava.compiler.util.TreeBreadthFirstIterator;

/**
 * This class stores the type hierarchy. This info is used to generate class_init(), since parent class should be inited before child. 
 * @author Yi
 *
 */
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
        
        if (klass.isInterface())
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
            getTree(klass.getSuperClass()).addLeaf(klass);
        }
    }
    
    public List<Tree<RClass>> getRoots() {
        return internal;
    }
    
    /**
     * is possibleChild the descendance of possibleParent
     * @param possibleParent
     * @param possibleChild
     * @return
     */
    public boolean isDescendanceOf(RClass possibleChild, RClass possibleParent) {
        Tree<RClass> parentTree = getTree(possibleParent);
        TreeBreadthFirstIterator<RClass> iter = parentTree.getBreadthFirstIterator();
        while(iter.hasNext()) {
            RClass curr = iter.next();
            if (curr.equals(possibleChild))
                return true;
        }
        return false;
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
            System.out.println("Tree:");
            System.out.println(root.printTree(0));
        }
        System.out.println();
    }
}
