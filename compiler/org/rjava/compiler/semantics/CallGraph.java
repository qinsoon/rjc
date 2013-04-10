package org.rjava.compiler.semantics;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.representation.RMethod;

public class CallGraph {
    DefaultDirectedGraph<RMethod, DefaultEdge> cg = new DefaultDirectedGraph<RMethod, DefaultEdge>(DefaultEdge.class);
    
    public void addCallEdge(RMethod from, RMethod to) {
        if (!cg.containsVertex(from))
            cg.addVertex(from);
        if (!cg.containsVertex(to))
            cg.addVertex(to);
        
        cg.addEdge(from, to);
    }
    
    public boolean containsMethod(RMethod method) {
        return cg.containsVertex(method);
    }
    
    public Set<RMethod> getCallersOf(RMethod method) {
        Set<RMethod> ret = new HashSet<RMethod>();
        Set<DefaultEdge> incomingEdges = cg.incomingEdgesOf(method);
        for (DefaultEdge edge : incomingEdges) 
            ret.add(cg.getEdgeSource(edge));

        return ret;
    }
    
    public Set<RMethod> getCalleesOf(RMethod method) {
        RJavaCompiler.println("Getting callees of " + method);
        Set<RMethod> ret = new HashSet<RMethod>();
        Set<DefaultEdge> outgoingEdges = cg.outgoingEdgesOf(method);
        for (DefaultEdge edge : outgoingEdges) 
            ret.add(cg.getEdgeTarget(edge));
        
        return ret;
    }
}
