package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

/**
 * 应为是二叉搜索树，所有对于一个节点，左子树的所有值都小于该节点，右子树的所有值都大于该节点
 * 因此最近公共父节点有以下算法得到：
 * 从根节点开始遍历，
 * 1. 如果两个节点都在右子树，那么以右子节点继续遍历
 * 2. 如果两个节点都在左子树，那么以左子接待继续遍历
 * 3. 如果两个节点一个在左子树，一个在右子树，那么意味着当前节点为他们的公共最近父节点
 *
 * @author xiaoling
 */
public class Q235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
