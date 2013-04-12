package org.rjava.compiler.semantics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
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
    
    DefaultDirectedGraph<RClass, DefaultEdge> classGraph = new DefaultDirectedGraph<RClass, DefaultEdge>(DefaultEdge.class);
    
    InitializationDependencyGraph() {
 
    }
    
    public void addDependencyEdge(RClass from, RClass to) {
        addClassWithHierarchy(from);
        addClassWithHierarchy(to);
        
        // get the most parent of from
        RClass mostParent = from.getSuperMostClass();
        // get all leaf children of to class
        List<RClass> childClasses = SemanticMap.hierarchy.getLeafChildrenOf(to);
        for (RClass child : childClasses) {
            //System.out.println("adding " + mostParent + (classGraph.containsVertex(mostParent) ? "(exist)":"(not exist)") + "->" + child + (classGraph.containsVertex(child)? "(exist)":"(not exist)"));
            classGraph.addEdge(mostParent, child);
        }
    }
    
    /**
     * for a RClass 'klass', we add all its children and parents. A child class always depends on parent.
     * @param klass
     * @param returnParent
     * @return return parent if the parameter 'returnParent' is true, otherwise return child
     */
    public void addClassWithHierarchy(RClass klass) {
        List<RClass> childClasses = SemanticMap.hierarchy.getLeafChildrenOf(klass);
        
        if (childClasses.size() == 1 && childClasses.get(0).equals(klass))
            classGraph.addVertex(klass);
        
        // we need to go through type hierarchy to add child->parent dependency
        for (RClass child : childClasses) {
            RClass cursor = child;
            while(cursor.hasSuperClass()) {
                RClass parent = cursor.getSuperClass();
                addEdgeWithVertices(cursor, parent);
                cursor = parent;
            }
        }
    }
    
    private void addEdgeWithVertices(RClass from, RClass to) {
        classGraph.addVertex(from);
        classGraph.addVertex(to);
        classGraph.addEdge(from, to);
    }
    
    public DefaultDirectedGraph<RClass, DefaultEdge> getClassGraph() {
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
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            PrintWriter writer = new PrintWriter(fos);
            writer.append("digraph G {\n");
            for (DefaultEdge edge : classGraph.edgeSet()) {
                String from = classGraph.getEdgeSource(edge).toString().replace('.', '_');
                from = from.replace('$', '_');
                String to = classGraph.getEdgeTarget(edge).toString().replace('.', '_');
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
    
    public void dumpGraph() {
        RJavaCompiler.println("\n---Class Initialization Dependency");
        JGraphTUtils.dumpGraph(classGraph);
        RJavaCompiler.println("");
    }
    
    public List<RClass> getInitializationOrder() {
        System.out.println("Getting initialization order:");
        DefaultDirectedGraph<RClass, DefaultEdge> graphCopy = copyClassGraph();
        List<RClass> ret = new LinkedList<RClass>();
        while (graphCopy.vertexSet().size() != 0) {
            System.out.println("Adding OD=0 vertices");
            // get all vertices that has outdegree 0 (init them first)
            RClass current;
            while ((current = removeOutDegreeZeroVertex(graphCopy)) != null) {
                System.out.println("OD=0: " + current);
                ret.add(current);
            }
            // we do not have any vertices with outdegree 0. Two possbilities here:
            // 1. no vertex left
            // 2. circle
            // we check here
            System.out.println("Consumed all OD=0 vertices");
            if (graphCopy.vertexSet().size() != 0) {
                // circle then
                List<Set<RClass>> stronglyConnectedSets = new StrongConnectivityInspector<RClass, DefaultEdge>(graphCopy).stronglyConnectedSets(); 

                // find the strongly connected components with the least outgoing edges
                // we add them first, then go back to check vertices outdegree
                int candidate = -1;
                int candidateOutgoingTargets = Integer.MAX_VALUE;
                int candidateSize = Integer.MAX_VALUE;
                for (int i = 0; i < stronglyConnectedSets.size(); i++) {
                    Set<RClass> currentSet = stronglyConnectedSets.get(i);
                    // compute its outgoing edges
                    Set<RClass> outgoingTargets = new HashSet<RClass>();
                    for (RClass nodeInSet : currentSet) {
                        for (DefaultEdge edge : graphCopy.outgoingEdgesOf(nodeInSet)) {
                            if (!currentSet.contains(graphCopy.getEdgeTarget(edge)))
                                outgoingTargets.add(graphCopy.getEdgeTarget(edge));
                        }
                    }
                    
                    if ((outgoingTargets.size() < candidateOutgoingTargets) 
                            || (outgoingTargets.size() == candidateOutgoingTargets && currentSet.size() < candidateSize)) {
                        candidate = i;
                        candidateOutgoingTargets = outgoingTargets.size();
                        candidateSize = currentSet.size();
                    }
                }
                
                if (candidate != -1) {
                    System.out.println("Add all classes from strongly connected component[" + candidate + "], size:" + stronglyConnectedSets.get(candidate).size() + ", outgoing target:" + candidateOutgoingTargets);
                    // we add classes, among those classes, the order is arbitrary
                    
                    int smallestInternalOD = Integer.MAX_VALUE;
                    Set<RClass> candidateSet = stronglyConnectedSets.get(candidate);
                    for (RClass klass : candidateSet) {
                        int internalOutgoingEdges = internalOD(klass, candidateSet, graphCopy);
                        if (internalOutgoingEdges < smallestInternalOD)
                            smallestInternalOD = internalOutgoingEdges;
                    }
                    
                    for (RClass klass : stronglyConnectedSets.get(candidate)) {
                        if (graphCopy.outDegreeOf(klass) == smallestInternalOD) {
                            System.out.println(klass + ", OD:" + smallestInternalOD);
                            ret.add(klass);
                            graphCopy.removeVertex(klass);
                        }
                    }
                }
            }
            // circles are removed by now
        }
        return ret;
    }
    
    private int internalOD(RClass node, Set<RClass> set, DefaultDirectedGraph<RClass, DefaultEdge> graph) {
        Set<DefaultEdge> edges = graph.outgoingEdgesOf(node);
        int ret = 0;
        for (DefaultEdge edge : edges) 
            if (set.contains(graph.getEdgeTarget(edge)))
                ret ++;
        return ret;
               
    }
    
    private DefaultDirectedGraph<RClass, DefaultEdge> copyClassGraph() {
        DefaultDirectedGraph<RClass, DefaultEdge> copy = new DefaultDirectedGraph<RClass, DefaultEdge>(DefaultEdge.class);
        for (RClass vertex : classGraph.vertexSet()) {
            copy.addVertex(vertex);
        }
        for (DefaultEdge edge : classGraph.edgeSet()) {
            copy.addEdge(classGraph.getEdgeSource(edge), classGraph.getEdgeTarget(edge));
        }
        return copy;
    }

    /**
     * 
     * @return the removed RClass, or null if no class has outdegree as 0
     */
    private RClass removeOutDegreeZeroVertex(DefaultDirectedGraph<RClass, DefaultEdge> graph) {
        for (RClass klass : graph.vertexSet())
            if (graph.outDegreeOf(klass) == 0) {
                graph.removeVertex(klass);
                return klass;
            }
        return null;
    }
}
