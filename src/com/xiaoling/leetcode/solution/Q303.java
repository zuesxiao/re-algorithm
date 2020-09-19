package com.xiaoling.leetcode.solution;

/**
 * Q303
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 *
 * @author xiaoling
 */
public class Q303 {
    public class NumArray {
        int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length + 1];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sums[i + 1] = sum;
            }
        }

        public int sumRange(int i, int j) {
            return sums[j + 1] - sums[i];
        }
    }
}
