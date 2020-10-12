package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 *
 * @author xiaoling
 */
public class Q530 {
    private int prev = -1;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        getMinDiff(root);
        return minDiff;
    }

    private void getMinDiff(TreeNode node) {
        if (node.left != null) {
            getMinDiff(node.left);
        }

        if (prev != -1) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;

        if (node.right != null) {
            getMinDiff(node.right);
        }
    }
}
