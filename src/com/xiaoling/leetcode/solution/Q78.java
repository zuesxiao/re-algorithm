package com.xiaoling.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 *
 * @author xiaoling
 */
public class Q78 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int count) {
        if (count == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[count]);
        dfs(nums, count + 1);
        temp.remove(temp.size() - 1);
        dfs(nums, count + 1);
    }
}
