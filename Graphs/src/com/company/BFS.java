package com.company;

import java.util.*;

public class BFS {

    private int noOfNodes;
    private LinkedList<Integer> adjList[];

    BFS(int v) {
        noOfNodes = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjList[i] = new LinkedList();
    }

    void addEdge(int node1, int node2) {
        adjList[node1].add(node2);
    }

    void traverse(int startNode) {
        boolean[] visited = new boolean[noOfNodes];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            // Dequeue a node from queue and print it
            startNode = queue.poll();
            System.out.print(startNode + " ");

            for (int n : adjList[startNode]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }

        }
    }

    // Driver method to
    public static void main(String args[]) {
        BFS graph = new BFS(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        graph.traverse(2);
    }
}
