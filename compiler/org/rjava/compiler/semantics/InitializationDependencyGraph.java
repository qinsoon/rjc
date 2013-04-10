package org.rjava.compiler.semantics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

import org.jgraph.JGraph;
import org.jgrapht.ListenableGraph;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.ListenableDirectedGraph;
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

            for (RClass klass : cycleDetector.findCycles())
                RJavaCompiler.println(klass);
        }
        RJavaCompiler.println("");
    }
    
    /**
     * it does not work
     * @param fileName
     */
    public void visualize(String fileName) {
        JGraphModelAdapter<RClass, DefaultEdge> adapter = new JGraphModelAdapter<RClass, DefaultEdge>(classGraph);
        JGraph jgraph = new JGraph(adapter);   

        final Color     DEFAULT_BG_COLOR = Color.decode( "#FAFBFF" );
        final Dimension DEFAULT_SIZE = new Dimension( 530, 320 );
        jgraph.setPreferredSize(DEFAULT_SIZE);
        jgraph.setBackground(DEFAULT_BG_COLOR);
        
        try {
        OutputStream out = new FileOutputStream(fileName); // Replace with your output stream
        Color bg = null; // Use this to make the background transparent
        BufferedImage img = jgraph.getImage(bg, 0);
        ImageIO.write(img, ".png", out);
        out.flush();
        out.close();
        } catch (Exception e) {
            RJavaCompiler.fail("Failed to visualize clinit graph: " + e.getMessage());
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
