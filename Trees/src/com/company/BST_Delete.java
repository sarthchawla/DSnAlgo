package com.company;


import java.util.LinkedList;
import java.util.Queue;

public class BST_Delete {

    private BstNode root;

    public boolean isEmpty() {

        return (this.root == null);
    }

    public BstNode getRoot() {
        return this.root;
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }

        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }

        return insertNode(tmpNode, data);
    }

    public void delete(Integer data) {

        deleteNode(this.root, data);
    }

    private BstNode deleteNode(BstNode root, Integer data) {

        if (root == null) return root;

        if (data < root.getData()) {
            root.setLeft(deleteNode(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(deleteNode(root.getRight(), data));
        } else {
            // node with no leaf nodes
            if (root.getLeft() == null && root.getRight() == null) {
                System.out.println("deleting " + data);
                return null;
            } else if (root.getLeft() == null) {
                // node with one node (no left node)
                System.out.println("deleting " + data);
                return root.getRight();
            } else if (root.getRight() == null) {
                // node with one node (no right node)
                System.out.println("deleting " + data);
                return root.getLeft();
            } else {
                // nodes with two nodes
                // search for min number in right sub tree
                Integer minValue = minValue(root.getRight());
                root.setData(minValue);
                root.setRight(deleteNode(root.getRight(), minValue));
                System.out.println("deleting " + data);
            }
        }

        return root;
    }

    private Integer minValue(BstNode node) {

        if (node.getLeft() != null) {
            return minValue(node.getLeft());
        }
        return node.getData();
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {

        if (root == null) return;
        doInOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        doInOrder(root.getRight());
    }

    public static void main(String a[]) {

        BST_Delete bst = new BST_Delete();
        bst.insert(8);
        bst.insert(10);
        bst.insert(14);
        bst.insert(3);
        bst.insert(6);
        bst.insert(7);
        bst.insert(1);
        bst.insert(4);
        bst.insert(13);
        System.out.println("-------------------");
        System.out.println("In Order Traversal");
        bst.inOrderTraversal();
        System.out.println();
        bst.delete(13);
        bst.inOrderTraversal();
        System.out.println();
        bst.delete(14);
        bst.inOrderTraversal();
    }
}
