package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 *
 * @author xiaoling
 */
public class Q538 {
    int total = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            total += root.val;
            root.val = total;
            convertBST(root.left);
        }

        return root;
    }
}
