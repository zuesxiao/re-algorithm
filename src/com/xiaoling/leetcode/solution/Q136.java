package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = num ^ result;
        }
        return result;
    }
}
