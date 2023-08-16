package com.austin.BinaryTree;

import java.util.ArrayDeque;

/**
 * @ClassName: 翻转二叉树
 * @author: zqz
 * @date: 2023/8/16 23:05
 */

public class 翻转二叉树 {

    //DFS递归 前序后序遍历都可以 就是中序不可以 因为中序会换两次的
    public TreeNode reverseThree(TreeNode root) {

        if (root == null) {
            return null;
        }

        reverseThree(root.left);
        reverseThree(root.right);
        swapChildren(root);

        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    //BFS
    public TreeNode invertTreeByBFS(TreeNode root) {
        if (root == null) return null;
        //这里利用队列 弹进弹出来处理
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode pop = deque.pop();
                swap(pop);
                if (pop.left != null) deque.offer(pop.left);
                if (pop.right != null) deque.offer(pop.right);
            }
        }
        return root;
    }


    public void swap(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }


}
