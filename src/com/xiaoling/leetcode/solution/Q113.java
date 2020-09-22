package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @author xiaoling
 */
public class Q113 {
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
