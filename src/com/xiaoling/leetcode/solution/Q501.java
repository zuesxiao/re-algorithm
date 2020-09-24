package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

import java.util.*;

/**
 * 501. 二叉搜索树中的众数
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 *
 * @author xiaoling
 */
public class Q501 {
    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        dfs(root);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        if (list.size() == 0) {
            return new int[0];
        }

        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        int max = list.get(0).getValue();
        int count = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getValue() < max) {
                break;
            }
            count++;
        }
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        dfs(node.left);
        dfs(node.right);
    }
}
