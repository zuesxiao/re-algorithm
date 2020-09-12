package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 *
 * @author xiaoling
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }

            while (right > left && (nums[right] & 1) == 0) {
                right--;
            }

            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }

        return nums;
    }
}
