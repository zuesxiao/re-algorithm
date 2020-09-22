package com.xiaoling.leetcode.offer;

import com.xiaoling.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 *
 * @author xiaoling
 */
public class Offer34 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (sum == node.val) {
                temp.add(node.val);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }
            return;
        }

        temp.add(node.val);

        dfs(node.left, sum - node.val);
        dfs(node.right, sum - node.val);
        temp.remove(temp.size() - 1);
    }
}
