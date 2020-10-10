package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 *
 * @author xiaoling
 */
public class Offer42 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int pre = 0;

        for (int num : nums) {
            pre = Math.max(num, pre + num);
            max = Math.max(max, pre);
        }

        return max;
    }
}
