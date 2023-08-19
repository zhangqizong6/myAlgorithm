package com.austin.BinaryTree;

/**
 * @ClassName: 对称二叉树_迭代法
 * @author: zqz
 * @date: 2023/8/19 17:28
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * 使用双端队列，相当于两个栈
 */
public class 对称二叉树_迭代法 {

    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if (leftNode == null && rightNode == null) {
                continue;
            }

            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            deque.offerFirst(leftNode.left);
            deque.offerFirst(rightNode.right);
            deque.offerLast(leftNode.right);
            deque.offerLast(rightNode.left);
        }
        return true;
    }

}
