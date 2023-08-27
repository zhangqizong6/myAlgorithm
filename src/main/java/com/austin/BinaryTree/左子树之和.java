package com.austin.BinaryTree;

import java.util.Stack;

/**
 * @ClassName: 左子树之和
 * @author: zqz
 * @date: 2023/8/27 15:10
 */

public class 左子树之和 {

    //递归左子树求和
    public int sumOfLeftLeaves(TreeNode node) {
        if (node == null) {
            return 0;
        }

        //递归找所有的子树
        int leftValue = sumOfLeftLeaves(node.left); //左
        int rightValue = sumOfLeftLeaves(node.right); //右

        int midValue = 0;
        if (node.left != null && node.left.left == null && node.left.right == null) {
            midValue = node.left.val;
        }

        return midValue + leftValue + rightValue; //中
    }


    //迭代
    public int sumOfLeftLeavesByDD(TreeNode node) {
        if (node == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.left != null && pop.left.left == null && pop.left.right == null) {
                result += pop.left.val;
            }

            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return result;
    }

}
