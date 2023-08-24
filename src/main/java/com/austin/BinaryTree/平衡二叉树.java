package com.austin.BinaryTree;

/**
 * @ClassName: 平衡二叉树
 * @author: zqz
 * @date: 2023/8/24 22:54
 */

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class 平衡二叉树 {

    /**
     * 后序遍历 左右中
     * 递归 比迭代的性能好很多
     */
    public boolean isBalanced(TreeNode node) {
        return getTreeHeight(node) != -1;
    }

    public int getTreeHeight(TreeNode node) {
        //没有结点就默认是平衡的了
        if (node == null) {
            return 0;
        }

        //递归左子树
        int leftHeight = getTreeHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        //递归右子树
        int rightHeight = getTreeHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        //比较左右子树的差值
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        //计算出每次递归后的左右子树的长度
        return Math.max(leftHeight, leftHeight) + 1;

    }

}
