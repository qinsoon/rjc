package org.rjava.compiler.util;

import org.jgrapht.DirectedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.rjava.compiler.RJavaCompiler;

public class JGraphTUtils {
    public static <V, E> void dumpGraph(DirectedGraph<V, E> graph) {
        BreadthFirstIterator<V, E> iter = new BreadthFirstIterator<V, E>(graph);
        while (iter.hasNext()) {
            V next = iter.next();
            for (E edge : graph.outgoingEdgesOf(next))
                RJavaCompiler.println(next + "->" + graph.getEdgeTarget(edge));
        }
    }
}
