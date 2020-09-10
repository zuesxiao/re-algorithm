package com.xiaoling.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * @author xiaoling
 */
public class Q40 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return result;
    }

    private void dfs(int[] candidates, int target, int start) {
        if (start > candidates.length) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        int prev = -1;
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];

            if (candidate > target) {
                break;
            }

            if (candidate == prev) {
                continue;
            }
            prev = candidate;

            temp.add(candidate);
            dfs(candidates, target - candidate, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
