package org.rjava.compiler.semantics;

import java.util.ArrayList;
import java.util.List;

import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.util.DirectedGraph;
import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class DependencyGraph {
    DirectedGraph<RClass> classGraph = new DirectedGraph<RClass>();
    
    DependencyGraph() {
        
    }
    
    public void addEdge(RClass from, RClass to) {
        classGraph.addEdge(from, to);
    }
    
    public DirectedGraph<RClass> getClassGraph() {
        return classGraph;
    }
    
    public void dumpDependencyGraph() {
        classGraph.printGraph();      
    }
}
