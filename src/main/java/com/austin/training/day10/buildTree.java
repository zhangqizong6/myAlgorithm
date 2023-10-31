package com.austin.training.day10;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName: buildTree
 * @author: zqz
 * @date: 2023/10/30 15:25
 */

public class buildTree {

    /**
     * 前序 左中右
     * 后续 左右中
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (postorder == null || postorder.length == 0) {
            return null;

        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = inorder.length - 2; i >= 0; i--) {

            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }
        }

        return root;
    }

}
