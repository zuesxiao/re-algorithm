package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * <p>
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 *
 * @author xiaoling
 */
public class Offer53 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left <= right) {
            int m = (left + right) / 2;
            if (nums[m] == target) {
                count++;

                int i = m - 1;
                int j = m + 1;

                while (i >= 0 && nums[i--] == target) {
                    count++;
                }
                while (j < length && nums[j++] == target) {
                    count++;
                }
                break;
            } else {
                if (nums[m] < target) {
                    left = m + 1;
                } else {
                    right = m - 1;
                }
            }
        }

        return count;
    }

    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int m = (left + right) / 2;
            if (nums[m] == m) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }

        return left ;
    }
}
