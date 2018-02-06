package com.ds.AVLTree;

/**
 * Created by deepanshu on 18/09/17, 23:43.
 */
public class AVLTreeNode {
    int data;
    int size;
    AVLTreeNode left;
    AVLTreeNode right;

    public AVLTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public AVLTreeNode(int data, int size) {
        this(data);
        this.size = size;
    }
}
