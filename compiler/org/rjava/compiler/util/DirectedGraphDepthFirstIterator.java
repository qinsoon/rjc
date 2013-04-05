package org.rjava.compiler.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import org.rjava.compiler.util.DirectedGraph.GraphNode;

public class DirectedGraphDepthFirstIterator<T> implements Iterator<T> {
    DirectedGraph<T> graph;
    Stack<GraphNode<T>> stack = new Stack<GraphNode<T>>();
    
    final boolean checkCycle;
    
    public DirectedGraphDepthFirstIterator(DirectedGraph<T> graph, boolean throwExceptionIfCyclic) {
        this.graph = graph;
        this.checkCycle = throwExceptionIfCyclic;
        
        initAndPushNode(graph.getRoot());
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        GraphNode<T> retNode = stack.peek();
        
        // find next node
        while(!stack.isEmpty()) {
            GraphNode<T> top = stack.peek();
            // if we have done exploring top element, pop it
            if (isFullyExplorered(top))
                stack.pop();
            else {
                // otherwise continue exploring top element
                while(nextExploringEdge(top) < top.pointToSet.size()) {
                    int currentExploringEdge = nextExploringEdge(top);
                    incNextExploringEdge(top);
                    GraphNode<T> exploring = (GraphNode<T>) top.getPointToSet().toArray()[currentExploringEdge];
                    
                    // check cycle
                    if (checkCycle)
                        if (stack.contains(exploring))
                            throw new RuntimeException("Cycle in directed graph");
                    
                    // if this edge is visited before, ignore it
                    if (isVisited(exploring))
                        continue;
                    else {
                        // otherwise push it (it will be next element)
                        initAndPushNode(exploring);
                        return retNode.value;
                    }
                }
            }
        }
        
        return retNode.value;
    }
    
    public boolean checkCycleOnStack() {
        for (int i = 0; i < stack.size(); i++) {
            GraphNode<T> current = stack.get(i);
            for (int j = i + 1; j < stack.size(); j++) {
                if (stack.get(j).value.equals(current.value))
                    return true;
            }
        }
        
        return false;
    }
    
    private void initAndPushNode(GraphNode<T> node) {
        visit(node);
        stack.push(node);
    }
    
    private boolean isFullyExplorered(GraphNode<T> node) {
        return nextExploringEdge(node) >= node.pointToSet.size();
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub
        
    }
    
    Map<GraphNode<T>, DFSInfo> dfsInfo = new HashMap<GraphNode<T>, DFSInfo>();
    private int nextExploringEdge(GraphNode<T> node) {
        if (dfsInfo.get(node) == null)
            dfsInfo.put(node, new DFSInfo());
        
        return dfsInfo.get(node).nextExploringEdge;
    }
    private void incNextExploringEdge(GraphNode<T> node) {
        dfsInfo.get(node).nextExploringEdge++;
    }
    private boolean isVisited(GraphNode<T> node) {
        if (dfsInfo.get(node) == null)
            dfsInfo.put(node, new DFSInfo());
        
        return dfsInfo.get(node).visited;
    }
    private void visit(GraphNode<T> node) {
        if (dfsInfo.get(node) == null)
            dfsInfo.put(node, new DFSInfo());
        
        dfsInfo.get(node).visited = true;
    }
    
    class DFSInfo {
        boolean visited = false;
        int nextExploringEdge = 0;
    }
}
