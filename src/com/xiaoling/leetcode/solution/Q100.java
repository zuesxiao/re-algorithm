package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

/**
 * @author xiaoling
 */
public class Q100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
            return false;
        } else {
            return p == null && q == null;
        }
    }
}
