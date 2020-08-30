package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

/**
 * @author xiaoling
 */
public class Q104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return depth(root);
    }

    private int depth(TreeNode node) {
        if (node.left != null && node.right != null) {
            return 1 + Math.max(depth(node.left), depth(node.right));
        } else if (node.left != null) {
            return 1 + depth(node.left);
        } else if (node.right != null) {
            return 1 + depth(node.right);
        } else {
            return 1;
        }
    }
}
