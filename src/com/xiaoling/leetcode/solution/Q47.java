package com.xiaoling.leetcode.solution;

import java.util.*;

/**
 * 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 *
 * @author xiaoling
 */
public class Q47 {
    List<Integer> temp = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> contains = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        arrange(nums);
        return res;
    }

    private void arrange(int[] nums) {
        if (temp.size() == nums.length) {
            int hashcode = temp.hashCode();
            if (!contains.contains(hashcode)) {
                contains.add(hashcode);
                res.add(new LinkedList<>(temp));
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited.contains(i)) {
                temp.add(nums[i]);
                visited.add(i);
                arrange(nums);
                temp.remove(temp.size() - 1);
                visited.remove(i);
            }
        }
    }

    boolean[] vis;

    /**
     * 排序原始数组，保证重复的数字只会被加入一次
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}
