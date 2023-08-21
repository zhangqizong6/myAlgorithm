package com.austin.BinaryTree;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: N叉树的最大深度
 * @author: zqz
 * @date: 2023/8/21 11:13
 */

public class N叉树的最大深度 {
    public int nDepth(NTreeNode root) {

        if (root == null) {
            return 0;
        }
        int depth = 0;
        if (root.children != null) {
            for (NTreeNode child : root.children) {
                depth = Math.max(depth,nDepth(child));
            }
        }
        return depth + 1;//中节点
    }


    static class NTreeNode {

        int val;
        List<NTreeNode> children;

        public NTreeNode(int val, List<NTreeNode> children) {
            this.val = val;
            this.children = children;
        }

        public NTreeNode() {
        }
    }

}
