package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q0803 {
    public int findMagicIndex(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                return i;
            } else {
                if (nums[i] > i) {
                    i = nums[i];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    /**
     * 二分法
     * @param nums 数组
     * @return 魔术索引
     */
    public int findMagicIndex1(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    public int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        int leftAnswer = getAnswer(nums, left, mid - 1);
        if (leftAnswer != -1) {
            return leftAnswer;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return getAnswer(nums, mid + 1, right);
    }
}
