package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int length = nums.length;
        int[] f = new int[length];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            f[i] = Math.max(f[i - 2] + nums[i], f[i - 1]);
        }

        return f[length - 1];
    }

    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = first;
            first = second;
            second = Math.max(temp + nums[i], first);
        }

        return second;
    }
}
