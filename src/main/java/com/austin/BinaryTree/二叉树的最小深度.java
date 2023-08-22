package com.austin.BinaryTree;

/**
 * @ClassName: 二叉树的最小深度
 * @author: zqz
 * @date: 2023/8/22 09:23
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 求最小深度用前序后序都可以 有点要注意的点是 根节点的最小深度不是1
 */
public class 二叉树的最小深度 {

    /**
     * 递归法
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (root.left == null) {
            return rightDepth + 1;
        }

        if (root.right == null) {
            return leftDepth + 1;
        }

        //左右节点都不为空的时候比价最小即可
        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * 迭代法
     */
    public int minDepthByDD(TreeNode root) {

        if (root == null) {
            return 0;
        }
        //创建一个队列
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left == null && poll.right == null) {
                    //是叶子节点 直接返回depth就行
                    return depth;
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        return depth;
    }

}
