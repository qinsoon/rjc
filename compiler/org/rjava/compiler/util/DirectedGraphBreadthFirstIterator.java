package org.rjava.compiler.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.rjava.compiler.util.DirectedGraph.GraphNode;

public class DirectedGraphBreadthFirstIterator<T> implements Iterator<T> {
    DirectedGraph<T> graph;
    Queue<GraphNode<T>> traverseQueue = new LinkedList<GraphNode<T>>();
    
    public DirectedGraphBreadthFirstIterator(DirectedGraph<T> graph) {
        this.graph = graph;
        traverseQueue.add(graph.getRoot());
    }

    @Override
    public boolean hasNext() {
        return !traverseQueue.isEmpty();
    }

    @Override
    public T next() {
        GraphNode<T> next = traverseQueue.poll();
        traverseQueue.addAll(next.getPointToSet());
        return next.value;
    }

    @Override
    public void remove() {
        
    }

}
