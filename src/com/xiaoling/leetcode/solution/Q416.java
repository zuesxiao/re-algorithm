package com.xiaoling.leetcode.solution;

/**
 * 416. 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * @author xiaoling
 */
public class Q416 {
    public boolean canPartition(int[] nums) {
        if (nums.length == 1) {
            return false;
        }

        int total = 0;
        int max = 0;
        for (int num : nums) {
            total += num;
            max = Math.max(num, max);
        }

        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;
        if (max > target) {
            return false;
        }

        return dfs(nums, 0, total / 2);
    }

    private boolean dfs(int[] nums, int start, int sum) {
        if (sum < 0 || start >= nums.length) {
            return false;
        }

        if (sum == 0) {
            return true;
        }

        boolean res1 = dfs(nums, start + 1, sum - nums[start]);
        boolean res2 = dfs(nums, start + 1, sum);
        return res1 || res2;
    }

    public boolean canPartition1(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return false;
        }

        int total = 0;
        int max = 0;
        for (int num : nums) {
            total += num;
            max = Math.max(num, max);
        }

        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;
        if (max > target) {
            return false;
        }

        boolean[] f = new boolean[target + 1];
        f[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                f[j] |= f[j - num];
            }
        }

        return f[target];
    }
}
