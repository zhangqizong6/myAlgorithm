package com.austin.training.day10;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName: findBottomLeftValue
 * @author: zqz
 * @date: 2023/10/30 10:19
 *
 * 寻找最底下的左子树 leetcode 513
 */

public class findBottomLeftValue {


    public int findBottomLeftValue(TreeNode root) {
        int value = 0;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll.right != null){
                queue.offer(poll.right);
            }
            if (poll.left != null){
                queue.offer(poll.left);
            }
            value = poll.val;
        }

        return value;

    }
}
