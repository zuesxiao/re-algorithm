package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || nums[0] > target) {
            return 0;
        }

        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return 0;
    }
}
