package com.company;

public class BST {

    Node insert(Node node, int key) {
        if (node == null) {
            node = new Node(key);
            return node;
        }
        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);
        return node;
    }

    boolean search(Node node, int key) {
        if (node == null)
            return false;
        if (key == node.data)
            return true;
        if (key < node.data)
            return search(node.left, key);
        else
            return search(node.right, key);
    }

    Node lca(Node node, int n1, int n2) {
        if (node == null)
            return null;

        if (n1 < node.data && n2 < node.data) // lesser then both
            return lca(node.left, n1, n2); // move left
        if (n1 > node.data && n2 > node.data) // greater than both
            return lca(node.right, n1, n2); // move right

        return node; // neither lesser nor greater than both -> lca
    }

    public static void main(String[] args) {
        BST bst = new BST();
//        Node root = bst.insert(null, 12);
//        bst.insert(root, 6);
//        bst.insert(root, 16);
//        bst.insert(root, 2);
//        bst.insert(root, 8);
//        bst.insert(root, 14);
//        bst.insert(root, 18);
//        bst.insert(root, 4);
//        bst.insert(root, 10);
//        bst.insert(root, 9);
//        bst.insert(root, 11);
//
//
//        boolean is9Present = bst.search(root, 9);
//        boolean is14Present = bst.search(root, 14);
//        boolean is15Present = bst.search(root, 15);

        Node root = bst.insert(null, 799);
        bst.insert(root, 469);
        bst.insert(root, 1049);
        bst.insert(root, 399);
        bst.insert(root, 499);
        bst.insert(root, 1799);
        bst.insert(root, 199);
        bst.insert(root, 200);
        bst.insert(root, 639);
        bst.insert(root, 1399);

        DeleteNodeBST deleteNodeBST = new DeleteNodeBST();
        deleteNodeBST.deleteNode(root, 1399); // no child
        deleteNodeBST.deleteNode(root, 1049); // one child -> right

        deleteNodeBST.deleteNode(root, 399);  // one child -> right
        deleteNodeBST.deleteNode(root, 1000);  // one child -> right

//        Node root = bst.insert(null, 8);
//        bst.insert(root, 3);
//        bst.insert(root, 10);
//        bst.insert(root, 1);
//        bst.insert(root, 6);
//        bst.insert(root, 14);
//        bst.insert(root, 4);
//        bst.insert(root, 7);
//        bst.insert(root, 13);
//
//        Node ans = bst.lca(root, 1, 7);
//        System.out.println(ans.data);
    }
}

