package com.xiaoling.leetcode.offer;

import com.xiaoling.common.TreeNode;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 *
 * @author xiaoling
 */
public class Offer54 {
    int res;
    int count = 0;

    public int kthLargest(TreeNode root, int k) {
        kth(root, k);
        return res;
    }

    private void kth(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        kth(node.right, k);

        if ((++count) == k) {
            res = node.val;
            return;
        }

        kth(node.left, k);
    }
}
