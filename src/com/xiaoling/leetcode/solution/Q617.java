package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

/**
 * 617. 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * @author xiaoling
 */
public class Q617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);

        return root;
    }
}
