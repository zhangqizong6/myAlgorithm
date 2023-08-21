package com.austin.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: 二叉树的最大深度
 * @author: zqz
 * @date: 2023/8/21 10:26
 */

public class 二叉树的最大深度 {

    /**
     * 而根节点的高度就是二叉树的最大深度，所以本题中我们通过后序求的根节点高度来求的二叉树最大深度。
     */

    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //左右中
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 迭代法
     */
    public int maxDepthDD(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            //弹出一个来算一下
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return depth;
    }

}
