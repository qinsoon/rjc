package org.rjava.compiler.semantics;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.restriction.rulesets.RJavaCore;

public class InitializationDependency {
    DefaultDirectedGraph<RClass, DefaultEdge> classGraph = new DefaultDirectedGraph<RClass, DefaultEdge>(DefaultEdge.class);
    
    InitializationDependency() {
        
    }
    
    public void addDependencyEdge(RClass from, RClass to) {
        if (!classGraph.containsVertex(from))
            classGraph.addVertex(from);
        if (!classGraph.containsVertex(to))
            classGraph.addVertex(to);
        
        classGraph.addEdge(from, to);
    }
    
    public DefaultDirectedGraph<RClass, DefaultEdge> getClassGraph() {
        return classGraph;
    }
    
    public void dumpDependencyGraph() {
        RJavaCompiler.println(classGraph.toString());      
    }
    
    public void visualize() {

    }
}
