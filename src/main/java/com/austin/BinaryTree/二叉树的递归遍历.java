package com.austin.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 二叉树的递归遍历
 * @author: zqz
 * @date: 2023/8/13 20:40
 */

public class 二叉树的递归遍历 {

    /**
     * 前序遍历 递归
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preoder(root, result);
        return result;
    }

    public void preoder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preoder(root.left, result);
        preoder(root.right, result);
    }

    /**
     * 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        preoder(root.left, result);
        result.add(root.val);
        preoder(root.right, result);
    }


    /**
     * 后序遍历
     *
     * @param root
     */

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);             // 注意这一句
    }

}
