package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q26 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int i = 0;
        for (int j = 0; j < length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
