package org.rjava.compiler.util;

import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
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
    
    public static <V, E> void visualizeGraph(DirectedGraph<V, E> graph, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            PrintWriter writer = new PrintWriter(fos);
            writer.append("digraph G {\n");
            for (E edge : graph.edgeSet()) {
                String from = graph.getEdgeSource(edge).toString().replace('.', '_');
                from = from.replace('$', '_');
                String to = graph.getEdgeTarget(edge).toString().replace('.', '_');
                to = to.replace('$', '_');
                writer.append(from + " -> " + to + ";\n");
            }
            writer.append("}\n");
            writer.close();
            fos.close();
        } catch (Exception e) {
            RJavaCompiler.fail("Failed to visualize class graph: " + e.getMessage());
        }
    }
}
