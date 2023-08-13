package com.austin.BinaryTree;

/**
 * @ClassName: TreeNode
 * @author: zqz
 * @date: 2023/8/13 20:31
 */

/**
 * 二叉树的基础结构
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
