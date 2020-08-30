package com.xiaoling.leetcode.solution;


/**
 * @author xiaoling
 */
public class Q268 {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return (length * (length + 1) / 2) - sum;
    }
}
