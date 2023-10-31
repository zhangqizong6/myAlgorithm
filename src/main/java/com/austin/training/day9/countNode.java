package com.austin.training.day9;

/**
 * @ClassName: countNode
 * @author: zqz
 * @date: 2023/10/26 23:45
 */

public class countNode {

    public int countNode(TreeNode root){
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = countNodeLevel(root.left);
        int right = countNodeLevel(root.right);
        if (left == right){
            return countNode(root.right) + (1<<left);
        }else {
            return countNode(root.right) + (1<<right);
        }
    }
    public int countNodeLevel(TreeNode root){
        int level = 0;
        while (root != null){
            level++;
            root = root.left;
        }
        return level;
    }
}
