package com.austin.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: 二叉树的迭代遍历
 * @author: zqz
 * @date: 2023/8/13 20:58
 */

public class 二叉树的迭代遍历 {

    /**
     * 前序遍历顺序：中-左-右 ，入栈：中-右-左
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    /**
     * 中序遍历顺序：左-中-右 入栈：左-右
     * 中序遍历和其他的两个遍历倒是不一样
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    /**
     * 后序遍历 左-右-中 入栈：中-右-左 最后翻转结果
     *
     * 再来看后序遍历，先序遍历是中左右，后续遍历是左右中，
     * 那么我们只需要调整一下先序遍历的代码顺序，就变成中右左的遍历顺序，
     * 然后在反转result数组，输出的结果顺序就是左右中了
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left !=null){
                stack.push(node);
            }
            if (node.right != null){
                stack.push(node);
            }
        }
        Collections.reverse(result);
        return result;
    }

}
