package org.rjava.compiler.semantics;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.util.JGraphTUtils;

public class CallGraph {
    public static final boolean DEBUG = true && RJavaCompiler.DEBUG;
    DefaultDirectedGraph<RMethod, DefaultEdge> cg = new DefaultDirectedGraph<RMethod, DefaultEdge>(DefaultEdge.class);
    
    public void addCallEdge(RMethod from, RMethod to) {
        if (!cg.containsVertex(from))
            cg.addVertex(from);
        if (!cg.containsVertex(to))
            cg.addVertex(to);
        
        if (!cg.containsEdge(from, to))
            cg.addEdge(from, to);
    }
    
    public boolean containsMethod(RMethod method) {
        return cg.containsVertex(method);
    }
    
    /**
     * get methods that directly calls this method
     * @param method
     * @return
     */
    public Set<RMethod> getCallersOf(RMethod method) {
        Set<RMethod> ret = new HashSet<RMethod>();
        
        if (!cg.containsVertex(method))
            return ret;
        
        Set<DefaultEdge> incomingEdges = cg.incomingEdgesOf(method);
        for (DefaultEdge edge : incomingEdges) 
            ret.add(cg.getEdgeSource(edge));

        return ret;
    }
    
    public Set<RMethod> getCalleesOf(RMethod method) {
        Set<RMethod> ret = new HashSet<RMethod>();
        
        if (!cg.containsVertex(method))
            return ret;
        
        Set<DefaultEdge> outgoingEdges = cg.outgoingEdgesOf(method);
        for (DefaultEdge edge : outgoingEdges) 
            ret.add(cg.getEdgeTarget(edge));
        
        return ret;
    }
    
    public boolean isTransitivelyCalledByCLInit(RMethod method) {
        for (RMethod caller : getAllTransitiveCallersOf(method)){
            if (caller.isClassInitializer())
                return true;
        }
        return false;
    }
    
    /**
     * get methods that directly or transitivly calls this method
     * @param method
     * @return
     */
    public Set<RMethod> getAllTransitiveCallersOf(RMethod method) {
        Set<RMethod> ret = new HashSet<RMethod>();
        
        Queue<RMethod> traverseQueue = new LinkedList<RMethod>();
        traverseQueue.addAll(getCallersOf(method));
        
        while(!traverseQueue.isEmpty()) {
            RMethod current = traverseQueue.poll();
            ret.add(current);
            for (RMethod m : getCallersOf(current))
                // for recursive call
                if (!m.equals(current))
                    traverseQueue.add(m);
        }
        
        return ret;
    }
    
    public void dumpGraph() {
        RJavaCompiler.println("\n---Call Graph---");
        JGraphTUtils.dumpGraph(cg);
        RJavaCompiler.println("");
    }
}
