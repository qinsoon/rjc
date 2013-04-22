package org.rjava.compiler.semantics;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.jgrapht.alg.CycleDetector;
import org.jgrapht.alg.StrongConnectivityInspector;
import org.jgrapht.alg.TransitiveClosure;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.traverse.TopologicalOrderIterator;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.util.JGraphTUtils;

/**
 * This class is to build initialization dependency 
 * based on 'Eager Class initialization for Java' paper by Dexter Kozen
 * @author yi
 *
 */
public class DependencyGraph {
    /**
     * the first part of the algorithm: to build a edge relation -> whose vertices are classes and methods. 
     * It is decided by:
     * 1) if A is app class and A has <clinit>, then A -> A.<clinit>
     * 2) if f is a static or virtual method of app class, and f calls another static or virtual method g, then f->g.
     *    In addition, if g is virtual method and is overriden as g', then f->g'
     * 3) if f is a static or virtual method of app class, f uses static field B.a, then f->B 
     */
    SimpleDirectedGraph<DependencyEdgeNode, DefaultEdge> edgeRelation = new SimpleDirectedGraph<DependencyEdgeNode, DefaultEdge>(DefaultEdge.class);
    
    /**
     * based on edge relation, classGraph is a transitive closure A => B
     * where it starts from A.<clinit> and ends with getstatic/putstatic B.a
     */
    DefaultDirectedGraph<RClass, DefaultEdge> classGraph;
    
    DependencyGraph() {
 
    }
    
    public void addEdgeRelation(DependencyEdgeNode from, DependencyEdgeNode to) {
        if (!edgeRelation.containsVertex(from))
            edgeRelation.addVertex(from);
        
        if (!edgeRelation.containsVertex(to))
            edgeRelation.addVertex(to);
        
        if (!edgeRelation.containsEdge(from, to))
            edgeRelation.addEdge(from, to);
    }
    
    public void generateClassDependencyGraph() {
        // init class graph
        classGraph = new DefaultDirectedGraph<RClass, DefaultEdge>(DefaultEdge.class);
        
        // compute transitive closure on edge relation
        try {
            SimpleDirectedGraph<DependencyEdgeNode, DefaultEdge> edgeRelationCopy = copyEdgeRelationGraph();
            TransitiveClosure.INSTANCE.closeSimpleDirectedGraph(edgeRelationCopy);
            
            for (DefaultEdge edge : edgeRelationCopy.edgeSet()) {
                DependencyEdgeNode from = edgeRelationCopy.getEdgeSource(edge);
                DependencyEdgeNode to = edgeRelationCopy.getEdgeTarget(edge);
                
                if (from.isClassNode() && to.isCLInitNode()) {
                    RClass fromClass = (RClass) from;
                    RClass toClass = ((RMethod)to).getKlass();
                    
                    if (!fromClass.equals(toClass)) {
                        if (!classGraph.containsVertex(fromClass))
                            classGraph.addVertex(fromClass);
                        if (!classGraph.containsVertex(toClass))
                            classGraph.addVertex(toClass);
                        if (!classGraph.containsEdge(fromClass, toClass))
                            classGraph.addEdge(fromClass, toClass);
                    } else {
                        if (!classGraph.containsVertex(fromClass))
                            classGraph.addVertex(fromClass);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            RJavaCompiler.fail(e.getMessage());
        }
        
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
            
            RJavaCompiler.fail("Found bad circularity in initialization graph");
        }
    }
    
    public List<RClass> getClassInitializationOrder() {
        if (classGraph == null)
            RJavaCompiler.error("generate class initialization graph first. ");
        
        List<RClass> ret = new LinkedList<RClass>();
        
        TopologicalOrderIterator<RClass, DefaultEdge> iter = new TopologicalOrderIterator<RClass, DefaultEdge>(classGraph);
        while (iter.hasNext()) {
            ret.add(iter.next());
        }
        
        Collections.reverse(ret);
        
        return ret;
    }
    
    public DefaultDirectedGraph<RClass, DefaultEdge> getClassGraph() {
        return classGraph;
    }
    
    public void visualizeClassGraph(String fileName) {
        JGraphTUtils.visualizeGraph(classGraph, fileName);
    }
    
    public void visualizeEdgeRelationGraph(String fileName) {
        JGraphTUtils.visualizeGraph(edgeRelation, fileName);
    }
    
    public void dumpGraph() {
        RJavaCompiler.println("\n---Class Initialization Dependency");
        JGraphTUtils.dumpGraph(classGraph);
        RJavaCompiler.println("");
    }
    
    private SimpleDirectedGraph<DependencyEdgeNode, DefaultEdge> copyEdgeRelationGraph() {
        SimpleDirectedGraph<DependencyEdgeNode, DefaultEdge> copy = new SimpleDirectedGraph<DependencyEdgeNode, DefaultEdge>(DefaultEdge.class);
        for (DependencyEdgeNode vertex : edgeRelation.vertexSet()) {
            copy.addVertex(vertex);
        }
        for (DefaultEdge edge : edgeRelation.edgeSet()) {
            copy.addEdge(edgeRelation.getEdgeSource(edge), edgeRelation.getEdgeTarget(edge));
        }
        return copy;
    }
}
