package org.rjava.compiler.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.naming.OperationNotSupportedException;

import org.rjava.compiler.semantics.representation.RClass;

public class TreeBreadthFirstIterator<T> implements Iterator<T> {
    Tree<T> tree;
    Queue<T> traverseQueue = new LinkedList<T>();
    
    public TreeBreadthFirstIterator(Tree<T> tree) {
        this.tree = tree;
        traverseQueue.add(tree.getHead());
    }

    @Override
    public boolean hasNext() {
        return !traverseQueue.isEmpty();
    }

    @Override
    public T next() {
        T next = traverseQueue.poll();
        traverseQueue.addAll(tree.getTree(next).getSuccessors(next));
        return next;
    }

    @Override
    public void remove() {
        
    }

}
