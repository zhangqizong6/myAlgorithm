package com.austin.training.day9;

/**
 * @ClassName: minDepth
 * @author: zqz
 * @date: 2023/10/26 23:00
 */

/**
 * 二叉树最小深度
 */
public class minDepth {

    public int minDepthInt(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int depth1 = minDepthInt(root.left);
        int depth2 = minDepthInt(root.right);
        if (root.left == null || root.right == null) return depth2 + depth1 + 1;
        return Math.min(depth1,depth2) + 1;

    }

}
