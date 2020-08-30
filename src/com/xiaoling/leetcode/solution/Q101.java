package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

/**
 * @author xiaoling
 */
public class Q101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.left != null && root.right != null && root.left.val != root.right.val) {
            return false;
        } else if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        }

        return isEqual(root.left.right, root.right.left) && isEqual(root.left.left, root.right.right);
    }

    public boolean isEqual(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val == q.val) {
                return isEqual(p.left, q.right) && isEqual(p.right, q.left);
            }
            return false;
        } else {
            return p == null && q == null;
        }
    }
}
