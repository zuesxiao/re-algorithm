package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q27 {
    public int removeElement(int[] nums, int val) {
        int removedCount = 0;
        int length = nums.length;
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                int tmp = nums[i];
                int swapIndex = length - 1 - removedCount;
                nums[i] = nums[swapIndex];
                nums[swapIndex] = tmp;

                removedCount++;
            }
        }

        return length - removedCount;
    }
}
