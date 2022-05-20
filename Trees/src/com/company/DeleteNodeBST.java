package com.company;

public class DeleteNodeBST {
    /**
     * @param root
     * @param key: this needs to be deleted
     * @return
     */
    public Node deleteNode(Node root, int key) {
        if (root == null)
            return null;

        if (key > root.data) {

            root.right = deleteNode(root.right, key); // move right

        } else if (key < root.data) {

            root.left = deleteNode(root.left, key); // move left

        } else if (key == root.data) {

            if (root.left == null && root.right == null) {

                root = null; // leaf node

            } else if (root.right != null) {

                root.data = rightSideWorthyChild(root); //

                root.right = deleteNode(root.right, root.data);

            } else if (root.left != null) {

                root.data = leftSideWorthyChild(root);

                root.left = deleteNode(root.left, root.data);

            }

        }
        return root;
    }

    private int rightSideWorthyChild(Node root) {
        root = root.right;
        while (root.left != null) { // find smallest of right side elements
            root = root.left;
        }
        return root.data;
    }

    private int leftSideWorthyChild(Node root) {
        root = root.left;
        while (root.right != null) { // find largest of left side elements
            root = root.right;
        }
        return root.data;
    }
}
