package com.austin.training.day10;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: hasPathSum
 * @author: zqz
 * @date: 2023/10/30 10:36
 * 路径总和 112 叶子节点 是指没有子节点的节点。
 * 513 112 106 105
 */

public class hasPathSum {

    /**
     * 叶子节点 是指没有子节点的节点。
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        /**
         * 找叶子节点
         */
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

    }
}
