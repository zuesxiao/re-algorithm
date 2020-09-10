package com.xiaoling.leetcode.solution;

import java.util.*;

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * @author xiaoling
 */
public class Q39 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return result;
    }

    private void dfs(int[] candidates, int target, int start) {
        if (start == candidates.length) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (candidate > target) {
                break;
            }

            temp.add(candidate);
            dfs(candidates, target - candidate, i);
            temp.remove(temp.size() - 1);
        }
    }
}
