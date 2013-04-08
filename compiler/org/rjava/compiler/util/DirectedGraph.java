package org.rjava.compiler.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.rjava.compiler.RJavaCompiler;

public class DirectedGraph<T> {
    public DirectedGraph() {
        
    }
    
    public DirectedGraph(DirectedGraph<T> copy) {        
        for (GraphNode<T> node : copy.nodeCache.values()) 
            for (GraphNode<T> toNode : node.getPointToSet())
                this.addEdge(node.value, toNode.value);
    }
    
    /**
     * add an edge from->to
     * @param from if from doesn't exist and root node for the graph is empty, then fromNode will be the root. otherwise throw an exception
     * @param to
     */
    public void addEdge(T from, T to) {
        GraphNode<T> toNode = getNode(to);
        if (toNode == null) {
            toNode = new GraphNode<T>(to);
        }
        
        GraphNode<T> fromNode = getNode(from);
        if (fromNode == null) {
            fromNode = new GraphNode<T>(from);
        }
        
        // actually add the edge
        fromNode.pointsTo(toNode);
        cacheNode(fromNode);
        cacheNode(toNode);
    }
    
    public boolean isAdjacent(T from, T to) {
        for (T node : getPointToSetOf(from))
            if (node.equals(to))
                return true;
        
        return false;
    }
    
    public Set<T> getPointToSetOf(T from) {
        GraphNode<T> fromNode = getNode(from);
        if (fromNode == null)
            throw new RuntimeException("trying to get pointToSet of " + from.toString() + " but the node cannot be found");
        
        Set<T> ret = new HashSet<T>();
        for (GraphNode<T> toNode : fromNode.pointToSet) 
            ret.add(toNode.value);
        
        return ret;
    }
    
    /**
     * remove edge from->to
     * @param from
     * @param to if the edge is the last edge for toNode (indegree is 0 after removing), toNode will be deleted
     */
    public void removeEdge(T from, T to) {
        GraphNode<T> fromNode = getNode(from);
        if (fromNode == null)
            throw new RuntimeException("trying to delete edge(" + from.toString() + "->" + to.toString() + ") but cannot find fromNode");
        
        GraphNode<T> toNode = getNode(to);
        if (toNode == null)
            throw new RuntimeException("trying to delete edge(" + from.toString() + "->" + to.toString() + ") but cannot find toNode");
        
        fromNode.removeFromPointToSet(toNode);
        // if the toNode is no longer linked in the graph, we 1. remove its outedges 2. delete it from the cache
        if (indegreeOf(to) == 0) {
            T nodeToBeDeleted = to;
            // remove its out edges
            for (GraphNode<T> childOfDeadNode : toNode.getPointToSet())
                removeEdge(nodeToBeDeleted, childOfDeadNode.value);
            
            // delete from the cache
            deleteFromCache(toNode);
        }
    }
    
    public void removeNode(T node) {
        Set<GraphNode<T>> outGoingNodes = new HashSet<GraphNode<T>>(getNode(node).pointToSet);
        // 1. remove all the edges coming out of this node
        for (GraphNode<T> to : outGoingNodes)
            removeEdge(node, to.value);
        
        // 2. remove all the incoming edges
        if (indegreeOf(node) == 0) {
            // no edges pointing to this node, we just delete it
            deleteFromCache(getNode(node));
        } else {
            // traverse through the graph
            // find nodes that point to this node, and delete the edges
            DirectedGraphIterator<T> iter = getSimpleIterator();
            while(iter.hasNext()) {
                T current = iter.next();
                // if it is an incoming edge, we delete it
                for (T to : getPointToSetOf(current))
                    if (to.equals(node))
                        removeEdge(current, to);
            }
        }
    }
    
    public int indegreeOf(T node) {
        int indegree = 0;
        // traverse through the graph
        DirectedGraphIterator<T> iter = getSimpleIterator();
        while(iter.hasNext()) {
            T current = iter.next();
            // if 'node' appear in its pointToSet, then indegree++
            for (T to : getPointToSetOf(current))
                if (to.equals(node))
                    indegree++;
        }
        return indegree;
    }
    
    public int outDegreeOf(T node) {
        return getPointToSetOf(node).size();
    }
    
    /*public DirectedGraphDepthFirstIterator<T> getDepthFirstIterator() {
        return new DirectedGraphDepthFirstIterator<T>(this, true);
    }*/
    
    public DirectedGraphIterator<T> getSimpleIterator() {
        return new DirectedGraphIterator<T>(this);
    }
    
    public DirectedGraphSinkNodeFirstIterator<T> getSinkNodeFirstIterator() {
        return new DirectedGraphSinkNodeFirstIterator<T>(this);
    }
    
    public void printGraph() {
        System.out.println("Graph:");
        DirectedGraphIterator<T> iter = getSimpleIterator();
        while(iter.hasNext()) {
            T current = iter.next();
            for (T to : getPointToSetOf(current))
                System.out.println(getNode(current) + "->" + getNode(to));
        }
    }
    
    public boolean contains(T value) {
        return getNode(value) != null;
    }
    
    public int size() {
        return nodeCache.size();
    }
    
    Map<T, GraphNode<T>> nodeCache = new HashMap<T, GraphNode<T>>();
    GraphNode<T> getNode(T value) {
        return nodeCache.get(value);
    }
    private void cacheNode(GraphNode<T> node) {
        nodeCache.put(node.value, node);
    }
    private void deleteFromCache(GraphNode<T> node) {
        nodeCache.remove(node.value);
    }
    boolean isValidNode(GraphNode<T> node) {
        return node != null && nodeCache.containsKey(node.value);
    }
    
    static class GraphNode<T> {
        T value;
        private Set<GraphNode<T>> pointToSet = new HashSet<GraphNode<T>>();
        boolean dead = false;   // in sinkNodeFirstIterator, we cannot remove a node, so we mark it dead
        
        public GraphNode(T value) {
            this.value = value;
        }
        
        public void pointsTo(GraphNode<T> to) {
            pointToSet.add(to);
        }
        
        public void removeFromPointToSet(GraphNode<T> to) {
            pointToSet.remove(to);
        }
        
        @Override 
        public String toString() {
            return value.toString() + "(OD:" + pointToSet.size() + ")";
        }
        
        @Override
        public boolean equals(Object o) {
            return this.value.equals(((GraphNode<T>)o).value);
        }

        public Set<GraphNode<T>> getPointToSet() {
            return pointToSet;
        }
    }
    
    public static void main(String[] args) {
        DirectedGraph<String> graph = new DirectedGraph<String>();
        graph.addEdge("A1", "A3");
        graph.addEdge("A1", "A2");
        graph.addEdge("A3", "A2");
        graph.addEdge("A3", "A4");
        graph.addEdge("A3", "A5");
        graph.addEdge("A6", "A3");
        graph.printGraph();
        
        DirectedGraph<String> graph2 = new DirectedGraph<String>(graph);
        graph2.printGraph();
        
        graph2.removeNode("A3");
        graph2.printGraph();
        
        System.out.println("Sink node first traverse:");
        DirectedGraphSinkNodeFirstIterator<String> iter = graph.getSinkNodeFirstIterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        
        graph.printGraph();
    }
}
