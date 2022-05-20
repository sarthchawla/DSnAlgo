package com.company;


public class Node {
    public Node() {

    }

    public Node(int value) {
        data = value;
    }

    public int data;
    public Node left;
    public Node right;

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}