package com.xiaoling.leetcode.offer;

import com.xiaoling.common.TreeNode;

/**
 * 剑指 Offer 28. 对称的二叉树
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 *
 * @author xiaoling
 */
public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a != null && b != null && a.val == b.val) {
            return isMirror(a.left, b.right) && isMirror(a.right, b.left);
        }

        return false;
    }
}
