package com.company;

// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
import java.lang.*;

class ShortestPath {
    static final int numberOfNodes = 9;
    int vertexWithMinimumDistance(int dist[], Boolean known[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int nodeIndex = 0; nodeIndex < numberOfNodes; nodeIndex++)
            if (known[nodeIndex] == false && dist[nodeIndex] <= min) {
                min = dist[nodeIndex];
                min_index = nodeIndex;
            }

        return min_index;
    }

    // A utility function to print the constructed distance array
    void printSolution(int dist[])
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < numberOfNodes; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    void dijkstra(int graph[][], int src)
    {
        int cost[] = new int[numberOfNodes];

        Boolean known[] = new Boolean[numberOfNodes];

        for (int i = 0; i < numberOfNodes; i++) {
            cost[i] = Integer.MAX_VALUE;
            known[i] = false;
        }

        cost[src] = 0;

        for (int count = 0; count < numberOfNodes - 1; count++) {

            int vertexWithMinimumDistance = vertexWithMinimumDistance(cost, known);
            known[vertexWithMinimumDistance] = true;

            for (int connectedNodes = 0; connectedNodes < numberOfNodes; connectedNodes++)
                if (!known[connectedNodes] &&
                        graph[vertexWithMinimumDistance][connectedNodes] != 0 &&
                        cost[vertexWithMinimumDistance] != Integer.MAX_VALUE &&
                        cost[connectedNodes] > cost[vertexWithMinimumDistance] + graph[vertexWithMinimumDistance][connectedNodes] )
                    cost[connectedNodes] = cost[vertexWithMinimumDistance] + graph[vertexWithMinimumDistance][connectedNodes];
        }

        // print the constructed distance array
        printSolution(cost);
    }

    // Driver method
    public static void main(String[] args)
    {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][] {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
    }
}
