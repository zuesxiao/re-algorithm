package com.xiaoling.leetcode.offer;

/**
 * @author xiaoling
 */
public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        int length = nums.length;
        int[] mark = new int[length];
        for (int num : nums) {
            if (mark[num] == 0) {
                mark[num]++;
            } else {
                return num;
            }
        }
        return 0;
    }
}
