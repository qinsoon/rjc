package org.rjava.compiler.util;

import java.util.Iterator;

import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.util.DirectedGraph.GraphNode;

public class DirectedGraphSinkNodeFirstIterator<T> implements Iterator<T> {
    DirectedGraph<T> graph;
    
    DirectedGraphSinkNodeFirstIterator(DirectedGraph<T> graph) {
        this.graph = new DirectedGraph<T>(graph);
    }

    @Override
    public boolean hasNext() {
        int live = 0;
        for (GraphNode<T> node : graph.nodeCache.values())
            if (!node.dead)
                live++;
        
        return live != 0;
    }

    @Override
    public T next() {
        DirectedGraphIterator<T> iter = graph.getSimpleIterator();
        while(iter.hasNext()) {
            T node = iter.next();
            if (graph.outDegreeOf(node) == 0 && !graph.getNode(node).dead) {
                // this node will be returned
                
                // 1. remove all the incoming edges from it
                for (GraphNode<T> from : graph.nodeCache.values()) {
                    if (graph.isAdjacent(from.value, node))
                        from.removeFromPointToSet(graph.getNode(node));
                }
                
                // 2. mark it dead
                graph.getNode(node).dead = true;
                
                return node;
            }
        }

        RJavaCompiler.fail("cannot get next graph node. (Did hasNext() get called?)");
        return null;
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub
        
    }

}
