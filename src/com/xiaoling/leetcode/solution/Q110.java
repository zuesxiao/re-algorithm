package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

/**
 * @author xiaoling
 */
public class Q110 {
    public boolean isBalanced(TreeNode root) {
        return getInfo(root).balance;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return -1;
        }

        return 1 + Math.max(depth(node.left), depth(node.right));
    }

    public TreeNodeInfo getInfo(TreeNode node) {
        if (node == null) {
            return new TreeNodeInfo(true, -1);
        }

        TreeNodeInfo leftInfo = getInfo(node.left);
        if (!leftInfo.balance) {
            return new TreeNodeInfo(false, -1);
        }

        TreeNodeInfo rightInfo = getInfo(node.right);
        if (!rightInfo.balance) {
            return new TreeNodeInfo(false, -1);
        }

        if (Math.abs(leftInfo.depth - rightInfo.depth) < 2) {
            return new TreeNodeInfo(true, 1 + Math.max(leftInfo.depth, rightInfo.depth));
        }

        return new TreeNodeInfo(false, -1);
    }

    private static class TreeNodeInfo {
        public boolean balance;
        public int depth;

        public TreeNodeInfo(boolean balance, int depth) {
            this.balance = balance;
            this.depth = depth;
        }
    }
}
