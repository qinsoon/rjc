package org.rjava.compiler.semantics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.jgraph.JGraph;
import org.jgrapht.ListenableGraph;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.alg.StrongConnectivityInspector;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.ListenableDirectedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.TopologicalOrderIterator;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.util.JGraphTUtils;
import org.rjava.restriction.rulesets.RJavaCore;

public class InitializationDependencyGraph {
    public static final boolean DEBUG = true && RJavaCompiler.DEBUG;
    
    ListenableDirectedGraph<RClass, DefaultEdge> classGraph = new ListenableDirectedGraph<RClass, DefaultEdge>(DefaultEdge.class);
    
    InitializationDependencyGraph() {
 
    }
    
    // FIXME: one problem is, if from->to, but from and to do not have <clinit>, there is no point to have them here
    // besides, they have much higher possibility to bring circles
    public void addDependencyEdge(RClass from, RClass to) {        
        if (!classGraph.containsVertex(from))
            classGraph.addVertex(from);
        if (!classGraph.containsVertex(to))
            classGraph.addVertex(to);
        
        if (!classGraph.containsEdge(from, to))
            classGraph.addEdge(from, to);
    }
    
    public void addClass(RClass klass) {
        if (!classGraph.containsVertex(klass))
            classGraph.addVertex(klass);
    }
    
    public ListenableGraph<RClass, DefaultEdge> getClassGraph() {
        return classGraph;
    }

    public void checkCycle() {
        CycleDetector<RClass, DefaultEdge> cycleDetector = new CycleDetector<RClass, DefaultEdge>(classGraph);
        if (cycleDetector.detectCycles()) {
            RJavaCompiler.warning("Detected cycles in class initialization graph. Check the following classes (especially their <clinit>):");

            List<Set<RClass>> stronglyConnectedSets = new StrongConnectivityInspector<RClass, DefaultEdge>(classGraph).stronglyConnectedSets(); 
            for (int i = 0; i < stronglyConnectedSets.size(); i++) {
                if (stronglyConnectedSets.get(i).size() <= 1)
                    continue;
                
                RJavaCompiler.println("Set " + i);
                for (RClass klass : stronglyConnectedSets.get(i))
                    RJavaCompiler.println("-" + klass);
                RJavaCompiler.println("");
            }
        }
        RJavaCompiler.println("");
    }
    
    public void visualize(String fileName) {
        BreadthFirstIterator<RClass, DefaultEdge> iter = new BreadthFirstIterator<RClass, DefaultEdge>(classGraph);
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            PrintWriter writer = new PrintWriter(fos);
            writer.append("digraph G {\n");
            while(iter.hasNext()) {
                RClass next = iter.next();
                for (DefaultEdge edge : classGraph.outgoingEdgesOf(next)) {
                    String from = next.toString().replace('.', '_');
                    from = from.replace('$', '_');
                    String to = classGraph.getEdgeTarget(edge).toString().replace('.', '_');
                    to = to.replace('$', '_');
                    writer.append(from + " -> " + to + ";\n");
                }
            }
            writer.append("}\n");
            writer.close();
            fos.close();
        } catch (Exception e) {
            RJavaCompiler.fail("Failed to visualize class graph: " + e.getMessage());
        }
    }
    
    public void dumpGraph() {
        RJavaCompiler.println("\n---Class Initialization Dependency");
        JGraphTUtils.dumpGraph(classGraph);
        RJavaCompiler.println("");
    }
    
    public List<RClass> getInitializationOrder() {
        List<RClass> ret = new LinkedList<RClass>();
        TopologicalOrderIterator<RClass, DefaultEdge> iter = new TopologicalOrderIterator<RClass, DefaultEdge>(classGraph);
        while(iter.hasNext()) {
            ret.add(iter.next());
        }
        Collections.reverse(ret);
        return ret;
    }
}
