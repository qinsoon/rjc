package org.rjava.compiler.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.rjava.compiler.util.DirectedGraph.GraphNode;

public class DirectedGraphIterator<T> implements Iterator<T> {
    DirectedGraph<T> graph;
    Iterator<T> internal;
    
    public DirectedGraphIterator(DirectedGraph<T> graph) {
        this.graph = graph;
        this.internal = graph.nodeCache.keySet().iterator();
    }

    @Override
    public boolean hasNext() {
        return internal.hasNext();
    }

    @Override
    public T next() {
        return internal.next();
    }

    @Override
    public void remove() {
        
    }

}
