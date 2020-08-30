package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

/**
 * @author xiaoling
 */
public class Q112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
