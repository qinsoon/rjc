package org.rjava.compiler.semantics;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.rjava.compiler.semantics.representation.RMethod;

public class CallGraph {
    DefaultDirectedGraph<RMethod, DefaultEdge> cg = new DefaultDirectedGraph<RMethod, DefaultEdge>(DefaultEdge.class);
    
    public void addCallEdge(RMethod from, RMethod to) {
        
    }
}
