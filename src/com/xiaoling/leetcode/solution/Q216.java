package com.xiaoling.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * https://leetcode-cn.com/problems/combination-sum-iii/s
 *
 * @author xiaoling
 */
public class Q216 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1);
        return result;
    }

    private void dfs(int k, int n, int start) {
        if (temp.size() == k && n == 0) {
            result.add(new ArrayList<>(temp));
        }

        for (int i = start; i <= 9; i++) {
            if (i > n) {
                break;
            }

            temp.add(i);
            dfs(k, n - i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
