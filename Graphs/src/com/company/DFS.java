package com.company;

import java.util.*;

public class DFS {

    private int numberOfNodes;
//[0] -> list1
//[1] -> list2
//[2] -> list3
//.
//.
//.
//.
//[n] -> listn
    private LinkedList<Integer>[] adjList;

    DFS(int numberOfVertices) {
        this.numberOfNodes = numberOfVertices;
        adjList = new LinkedList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; ++i) {
            adjList[i] = new LinkedList();
        }
    }

    void addEdge(int node1, int node2) {
        adjList[node1].add(node2);
    }

    void DFSUtil(int node, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[node] = true;
        System.out.print(node + " ");

        // Recur for all the vertices adjacent to this
        // vertex
        for (int currentNode : adjList[node]) {
            if (!visited[currentNode]) {
                DFSUtil(currentNode, visited);
            }
        }
    }

    void traverse(int node) {
        boolean[] visited = new boolean[numberOfNodes];
        DFSUtil(node, visited);
    }

    // Driver Code
    public static void main(String args[]) {
        DFS graph = new DFS(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        graph.traverse(2);
    }
}

