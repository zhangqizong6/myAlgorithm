package com.austin.BinaryTree;

/**
 * @ClassName: 完全二叉树的节点数
 * @author: zqz
 * @date: 2023/8/22 09:40
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 对于完全二叉树分为 1、满二叉树 2、最后一层叶子节点没有满
 */
public class 完全二叉树的节点数 {

    /**
     * 递归法
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //根节点也算上
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public int countNodeByDD(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int result = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode cur = deque.poll();
                result++;
                if (cur.left != null) {
                    deque.offer(cur.left);
                }
                if (cur.right != null) {
                    deque.offer(cur.right);
                }
            }
        }
        return result;
    }

    /**
     * 针对完全二叉树
     * 满二叉树的节点 2^depth - 1
     */
    public int countNodeByAll(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0;
        //求左子树深度
        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        //如果相等就是满二叉树
        if (leftDepth == rightDepth) {
            // 注意(2<<1) 相当于2^2，所以leftDepth初始为0
            return (2 << leftDepth) - 1;
        }
        return countNodeByAll(root.left) + countNodeByAll(root.right) + 1;
    }

}
