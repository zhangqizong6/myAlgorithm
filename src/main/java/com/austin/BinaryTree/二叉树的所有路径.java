package com.austin.BinaryTree;

/**
 * @ClassName: 二叉树的所有路径
 * @author: zqz
 * @date: 2023/8/25 09:47
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class 二叉树的所有路径 {
    /**
     * 1.回溯
     * 2.前序遍历
     */
    public List<String> binaryTreePaths(TreeNode node) {

        List<String> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(node, paths, res);
        return res;

    }

    private void traversal(TreeNode node, List<Integer> paths, List<String> res) {

        //前序遍历 中左右
        paths.add(node.val);

        //遇到叶子节点的处理
        if (node.left == null && node.right == null) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            //将最后一个传进来
            sb.append(paths.get(paths.size()) - 1);
            res.add(sb.toString());
        }

        //递归和回溯同时进行
        if (node.left != null) {
            //这里递归
            traversal(node.left, paths, res);
            //这里递归完就会走到这一步 就是回溯 回溯到这一步剔除元素
            paths.remove(paths.size() - 1);
        }
        if (node.right != null) {
            //同样原理
            traversal(node.right, paths, res);
            paths.remove(paths.size() - 1);
        }

    }
}
