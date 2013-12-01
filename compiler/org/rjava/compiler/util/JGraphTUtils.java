package org.rjava.compiler.util;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.alg.StrongConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.representation.RClass;

public class JGraphTUtils {
    public static <V, E> void dumpGraph(DirectedGraph<V, E> graph) {
        RJavaCompiler.println("Dumping graph <<<<<<<<<<<");
        BreadthFirstIterator<V, E> iter = new BreadthFirstIterator<V, E>(graph);
        while (iter.hasNext()) {
            V next = iter.next();
            for (E edge : graph.outgoingEdgesOf(next))
                RJavaCompiler.println(next + "->" + graph.getEdgeTarget(edge));
        }
        RJavaCompiler.println(">>>>>>>>>>");
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
    
    public static <V, E> void checkCycle(DirectedGraph<V, E> graph, String graphName) {
        CycleDetector<V, E> cycleDetector = new CycleDetector<V, E>(graph);
        if (cycleDetector.detectCycles()) {
            RJavaCompiler.warning("Detected cycles in " + graphName + ". Check the following elements:");

            List<Set<V>> stronglyConnectedSets = new StrongConnectivityInspector<V, E>(graph).stronglyConnectedSets(); 
            for (int i = 0; i < stronglyConnectedSets.size(); i++) {
                if (stronglyConnectedSets.get(i).size() <= 1)
                    continue;
                
                RJavaCompiler.println("Set " + i);
                for (V klass : stronglyConnectedSets.get(i))
                    RJavaCompiler.println("-" + klass);
                RJavaCompiler.println("");
            }
            
            RJavaCompiler.fail("Found bad cycle in graph " + graphName);
        }
    }
    
    public static <V, E> boolean isBiconnected(DirectedGraph<V, E> graph, V node1, V node2) {
        List<Set<V>> stronglyConnectedSets = new StrongConnectivityInspector<V, E>(graph).stronglyConnectedSets();
        for (Set<V> set : stronglyConnectedSets) {
            if (set.contains(node1) && set.contains(node2))
                return true;
        }
        
        return false;
    }
}
