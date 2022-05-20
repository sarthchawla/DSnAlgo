package com.company;

import jdk.internal.util.xml.impl.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {




    private Node CreateTree() {
        Node root = new Node();
        root.data = 8;
        CreateBranch(root, 3, 10);

        CreateBranch(root.left, 1, 6);
        CreateBranch(root.left.right, 4, 7);

        CreateBranch(root.right, -1, 14);
        CreateBranch(root.right.right, 13, -1);

        return root;
    }

    private void CreateBranch(Node node, int leftData, int rightData) {
        if (leftData != -1) {
            node.left = new Node();
            node.left.data = leftData;
        }
        if (rightData != -1) {
            node.right = new Node();
            node.right.data = rightData;
        }
    }


    void preOrderDFS(Node node) {
        if (node == null)
            return;

        // visit the parent node and perform the ACTION
        System.out.print(node.data + " ");

        // recursively go to left subtree
        preOrderDFS(node.left);

        // recursively go to right subtree
        preOrderDFS(node.right);
    }

    int height(Node root) {
        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight > rightHeight)
            return leftHeight + 1;
        else
            return rightHeight + 1;
    }

    void levelOrderOrBFS(Node root) {
        int h = height(root); // step 1: calculate height
        for (int i = 1; i <= h; i++)
            printNodesAtLevel(root, i, 1);
    }

    void printNodesAtLevel(Node currentNode, int levelToPrint, int currentNodeLevel) {
        if (currentNode == null)
            return;
        if (levelToPrint == currentNodeLevel)
            System.out.print(currentNode.data + " ");
        else {
            printNodesAtLevel(currentNode.left, levelToPrint, currentNodeLevel + 1);
            printNodesAtLevel(currentNode.right, levelToPrint, currentNodeLevel + 1);
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        Node root = main.CreateTree();
        System.out.println(main.height(root));
        //main.preOrderDFS(root);

//        Node A = null, B = null;
//
//        // step 1 find level of both nodes
//        int levelA = main.level(root, 4, 1);
//        A = main.result;
//
//        int levelB = main.level(root, 7, 1);
//        B = main.result;
//
//        if (levelA == levelB && !main.isSibling(root, A, B)) {
//            System.out.println("Yes");
//        } else {
//            System.out.println("No");
//        }

    }

//    boolean isCousin(Node node, Node a, Node b){
//        if(node == null) return false;
//
//        Node parA = null;
//        Node parB = null;
//        Queue<Pair> q = new LinkedList<>();
//        Node tmp = new Node(-1);
//
//        Pair ele;
//        q.add(new Pair(node, tmp));
//
//        int levelSize;
//
//        while(!q.isEmpty()) {
//            levelSize = q.size();
//            while(levelSize != 0) {
//                ele = q.peek();
//                q.remove();
//                if(ele.getKey().data == a.data) parA = ele.getValue();
//
//                if(ele.getKey().data == b.data)   parB = ele.getValue();
//                if(ele.getKey().left != null)  q.add(new Pair<Node, Node>(ele.getKey().left, ele.getKey()));
//
//                if(ele.getKey().right != null)  q.add(new Pair<Node, Node>(ele.getKey().right, ele.getKey()));
//                levelSize--;
//
//                if(parA != null && parB != null)                    break;
//            }
//
//            if(parA != null && parB != null)                return parA != parB;
//            if ((parA!=null && parB==null) || (parB!=null && parA==null))                return false;
//        }
//        return false;
//    }



        boolean isSibling(Node node, Node a, Node b) {
        if (node == null)
            return false;

        return ((node.left == a && node.right == b)
                || (node.left == b && node.right == a)
                || isSibling(node.left, a, b)
                || isSibling(node.right, a, b));
    }
    Node result = null;
    int level(Node root, int desiredNodeValue, int currentLevel) {
        if (root == null)
            return 0;

        if (root.data == desiredNodeValue) {
            result = root;
            return currentLevel;
        }

        int l = level(root.left, desiredNodeValue, currentLevel + 1);
        if (l != 0)
            return l;

        return level(root.right, desiredNodeValue, currentLevel + 1);
    }


    void spiralOrder(Node root) {
        int h = height(root);
        boolean ltr = false;
        for (int i = 1; i <= h; i++) {
            printNodesAtLevel(root, i, 1, ltr);
            ltr = !ltr;
        }
    }

    void printNodesAtLevel(Node root, int level, int currentLevel, boolean ltr) {
        if (root == null)
            return;
        if (level == currentLevel)
            System.out.print(root.data + " ");
        else {
            if (ltr) {
                printNodesAtLevel(root.left, level, currentLevel + 1, ltr);
                printNodesAtLevel(root.right, level, currentLevel + 1, ltr);
            } else {
                printNodesAtLevel(root.right, level, currentLevel + 1, ltr);
                printNodesAtLevel(root.left, level, currentLevel + 1, ltr);
            }
        }
    }

    void printSpiral(Node node) {
        if (node == null)
            return;

        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        s1.push(node); // Step 1: root is put in stack 1

        while (!s1.empty() || !s2.empty()) { // step 2: until both stacks aren't empty

            while (!s1.empty()) { // step 3: until first stack is not empty
                Node temp = s1.pop();

                System.out.print(temp.data + " ");// print that element

                if (temp.right != null)
                    s2.push(temp.right); // push right child first to stack 2

                if (temp.left != null)
                    s2.push(temp.left); // then left child
            }

            while (!s2.empty()) {
                Node temp = s2.pop();

                System.out.print(temp.data + " ");

                if (temp.left != null)
                    s1.push(temp.left); // left child first

                if (temp.right != null)
                    s1.push(temp.right); // then right child
            }

        }
    }
}
