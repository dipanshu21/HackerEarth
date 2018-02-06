package com.ds.AVLTree;

/**
 * Created by deepanshu on 18/09/17, 23:43.
 */
public class AVLTree {
    private AVLTreeNode root;

    public AVLTree() {
        root = null;
    }

    public void insert(int data) {
        if (root == null) {
            root = new AVLTreeNode(data, 1);
        }
    }

    public boolean find(int data) {
        return find(root, data);
    }

    private boolean find(AVLTreeNode node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        }

        return find(node.left, data) || find(node.right, data);
    }

    public void delete(int data) {

    }
}
