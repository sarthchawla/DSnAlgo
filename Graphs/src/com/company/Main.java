package com.company;

import java.util.*;

public class Main {


    public static void main(String[] args) {
//        List<Edge> edgeList = new LinkedList<>();
//
//        edgeList.add(new Edge(1, 5));
//        edgeList.add(new Edge(1, 2));
//        edgeList.add(new Edge(1, 3));
//        edgeList.add(new Edge(1, 4));
//        edgeList.add(new Edge(2, 4));
//        edgeList.add(new Edge(3, 4));
//        edgeList.add(new Edge(5, 4));
//
//        List<Integer> nodeList = new LinkedList<>();
//        nodeList.add(1);
//        nodeList.add(2);
//        nodeList.add(3);
//        nodeList.add(4);
//        nodeList.add(5);
//        nodeList.add(6);
//
//        for(int node : nodeList)
//        {
//            System.out.print(node + ": ");
//            for(Edge edge: edgeList)
//            {
//                if(edge.node1 == node || edge.node2 == node)
//                {
//                    System.out.print(edge.node1 + "--" + edge.node2 + " , ");
//                }
//            }
//
//            System.out.println();
//        }

        boolean[][] adjUnWeightedGraph = new boolean[5][];
        for (int i = 0; i < adjUnWeightedGraph.length; i++) {
            adjUnWeightedGraph[i] = new boolean[5];
        }


        //
        // 0th index = 1 and 4th index = 5
        adjUnWeightedGraph[0][4] = true;
        adjUnWeightedGraph[4][0] = true;

        adjUnWeightedGraph[0][3] = true;
        adjUnWeightedGraph[3][0] = true;

        adjUnWeightedGraph[0][2] = true;
        adjUnWeightedGraph[2][0] = true;

        adjUnWeightedGraph[0][1] = true;
        adjUnWeightedGraph[1][0] = true;


        adjUnWeightedGraph[1][3] = true;
        adjUnWeightedGraph[3][1] = true;


        adjUnWeightedGraph[2][4] = true;
        adjUnWeightedGraph[4][2] = true;

        adjUnWeightedGraph[2][3] = true;
        adjUnWeightedGraph[3][2] = true;


        adjUnWeightedGraph[3][4] = true;
        adjUnWeightedGraph[4][3] = true;


        System.out.print("* ");
        for (int i = 0; i < adjUnWeightedGraph.length; i++) {
            System.out.print(" " + (i + 1) + " ");
        }

        System.out.println();

        int counter = 1;
        for (boolean[] arr : adjUnWeightedGraph) {
            System.out.print(counter++);
            for (boolean value : arr) {
                System.out.print(value + "  ");
            }

            System.out.println();
        }


    }
}
