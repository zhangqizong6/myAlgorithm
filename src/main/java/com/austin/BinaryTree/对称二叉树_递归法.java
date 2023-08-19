package com.austin.BinaryTree;

/**
 * @ClassName: 对称二叉树
 * @author: zqz
 * @date: 2023/8/19 17:07
 */

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class 对称二叉树_递归法 {

    /**
     * 这里的解决思路就是 后序排序 解决外侧 内侧的比对
     *
     * @param root
     * @return
     */

    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        return this.compare(root.left, root.right);

    }

    private boolean compare(TreeNode left, TreeNode right) {

        if (left == null && right != null) {
            return false;
        }

        if (right == null && left != null) {
            return false;
        }

        if (right == null && left == null) {
            return true;
        }

        if (right.val == left.val) {
            return true;
        }

        //比较外侧
        boolean compareOutside = compare(left.left, right.right);

        //比较内侧
        boolean compareInside = compare(left.right, right.left);

        //通过递归来比较最后两边的两个结果
        return compareInside && compareOutside;

    }

}
