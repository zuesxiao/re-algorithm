package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

/**
 * @author xiaoling
 */
public class Q114 {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    private void flattenTree(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;

        if (!isLeaf(left)) {
            flattenTree(left);
        }

        if (!isLeaf(right)) {
            flattenTree(right);
        }

        left.right = right;
        root.right = left;
        root.left = null;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
