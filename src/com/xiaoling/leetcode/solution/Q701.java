package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

/**
 * @author xiaoling
 */
public class Q701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode parent = root;
        TreeNode temp = root;

        while (temp != null) {
            parent = temp;
            if (temp.val > val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        if (val > parent.val) {
            parent.right = new TreeNode(val);
        } else {
            parent.left = new TreeNode(val);
        }

        return root;
    }
}
