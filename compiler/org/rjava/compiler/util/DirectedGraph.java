package org.rjava.compiler.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DirectedGraph<T> {
    GraphNode<T> root;
    
    GraphNode<T> getRoot() {
        return root;
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
            // 'from' must be root then
            if (root == null) {
                fromNode = new GraphNode<T>(from);
                root = fromNode;
            }
            else throw new RuntimeException("adding an edge(" + from.toString() + " -> " + to.toString() + ") to the graph where its fromNode cannot be found");
        }
        
        // actually add the edge
        fromNode.pointsTo(toNode);
        cacheNode(fromNode);
        cacheNode(toNode);
    }
    
    public boolean isAdjacent(T from, T to) {
        for (T node : pointToSetOf(from))
            if (node.equals(to))
                return true;
        
        return false;
    }
    
    public Set<T> pointToSetOf(T from) {
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
    
    public int indegreeOf(T node) {
        int indegree = 0;
        // traverse through the graph
        DirectedGraphBreadthFirstIterator<T> iter = getBreadthFirstIterator();
        while(iter.hasNext()) {
            T current = iter.next();
            // if 'node' appear in its pointToSet, then indegree++
            for (T to : pointToSetOf(current))
                if (to.equals(node))
                    indegree++;
        }
        return indegree;
    }
    
    public int outDegreeOf(T node) {
        return pointToSetOf(node).size();
    }
    
    /**
     * use depth first iterator, so cycles can be tracked.
     * @return
     */
    @Deprecated
    public DirectedGraphBreadthFirstIterator<T> getBreadthFirstIterator() {
        return new DirectedGraphBreadthFirstIterator<T>(this);
    }
    
    public DirectedGraphDepthFirstIterator<T> getDepthFirstIterator() {
        return new DirectedGraphDepthFirstIterator<T>(this, true);
    }
    
    public void printGraph() {
        System.out.println("Graph:");
        //DirectedGraphBreathFirstIterator<T> iter = getBreathFirstIterator();
        DirectedGraphDepthFirstIterator<T> iter = getDepthFirstIterator();
        while(iter.hasNext()) {
            T current = iter.next();
            for (T to : pointToSetOf(current))
                System.out.println(current + "->" + to);
        }
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
    
    static class GraphNode<T> {
        T value;
        Set<GraphNode<T>> pointToSet = new HashSet<GraphNode<T>>();
        //boolean dfsVisited = false;
        //int dfsNextExploringEdge = 0;
        
        public GraphNode(T value) {
            this.value = value;
        }
        
        public void pointsTo(GraphNode<T> to) {
            pointToSet.add(to);
        }
        
        public void removeFromPointToSet(GraphNode<T> to) {
            Set<GraphNode<T>> newSet = new HashSet<GraphNode<T>>();
            for (GraphNode<T> node : pointToSet)
                if (!node.value.equals(to.value))
                    newSet.add(node);
            
            pointToSet = newSet;
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
        graph.printGraph();
        
        graph.removeEdge("A1", "A3");
        graph.printGraph();
        
        graph.addEdge("A2", "A1");
        graph.printGraph();
    }
}
