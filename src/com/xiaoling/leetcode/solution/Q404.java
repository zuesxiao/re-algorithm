package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

/**
 * 404. 左叶子之和
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 *
 * @author xiaoling
 */
public class Q404 {
    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        sumOfLeft(root.left, true);
        sumOfLeft(root.right, false);

        return res;
    }

    private void sumOfLeft(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }

        if (isLeft && root.left == null && root.right == null) {
            res += root.val;
        }

        sumOfLeft(root.left, true);
        sumOfLeft(root.right, false);
    }

    public int sumOfLeftLeaves1(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    public int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            ans += dfs(node.right);
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
