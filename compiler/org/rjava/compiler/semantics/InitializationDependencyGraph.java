package org.rjava.compiler.semantics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.jgraph.JGraph;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.ListenableDirectedGraph;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.restriction.rulesets.RJavaCore;

public class InitializationDependencyGraph {
    ListenableGraph<RClass, DefaultEdge> classGraph = new ListenableDirectedGraph<RClass, DefaultEdge>(DefaultEdge.class);
    
    InitializationDependencyGraph() {
        
    }
    
    public void addDependencyEdge(RClass from, RClass to) {
        if (!classGraph.containsVertex(from))
            classGraph.addVertex(from);
        if (!classGraph.containsVertex(to))
            classGraph.addVertex(to);
        
        classGraph.addEdge(from, to);
    }
    
    public ListenableGraph<RClass, DefaultEdge> getClassGraph() {
        return classGraph;
    }
    
    public void dumpDependencyGraph() {
        RJavaCompiler.println(classGraph.toString());      
    }
    
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
}
