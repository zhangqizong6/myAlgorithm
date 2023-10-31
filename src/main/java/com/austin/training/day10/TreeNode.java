package com.austin.training.day10;

/**
 * @ClassName: TreeNode
 * @author: zqz
 * @date: 2023/10/26 23:01
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
