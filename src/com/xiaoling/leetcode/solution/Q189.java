package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q189 {
    int length = 0;

    public void rotate(int[] nums, int k) {
        length = nums.length;

        if (length == 1) {
            return;
        }

        k = k % length;
        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                rotate(nums);
            }
        }
    }

    private void rotate(int[] nums) {
        int temp = nums[length - 1];
        for (int i = length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = temp;
    }
}
