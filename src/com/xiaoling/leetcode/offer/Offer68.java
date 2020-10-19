package com.xiaoling.leetcode.offer;

import com.xiaoling.common.TreeNode;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * <p>
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 *
 * @author xiaoling
 */
public class Offer68 {
    /**
     * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp = root;

        while (temp != null) {
            if (p.val > temp.val && q.val > temp.val) {
                temp = temp.right;
                continue;
            }

            if (p.val < temp.val && q.val < temp.val) {
                temp = temp.left;
                continue;
            }

            return temp;
        }

        return null;
    }

    /**
     * 剑指 Offer 68 - II. 二叉树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }
}
