package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q283 {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int count1 = 0;
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] == 0 && count1 > 0) {
                for (int j = i; j < length - count - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[length - count - 1] = 0;
                count++;
            } else {
                count1++;
            }
        }
    }

    public void moveZeroes1(int[] nums) {
        int length = nums.length;
        int lastNonZero = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZero++] = nums[i];
            }
        }

        for (int i = lastNonZero; i < length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        int length = nums.length;
        int lastNonZero = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[lastNonZero];
                nums[lastNonZero] = temp;
                lastNonZero++;
            }
        }
    }
}
