package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q11 {
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int total = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                total = Math.max(total, height[left] * (right - left));
                left++;
            } else {
                total = Math.max(total, height[right] * (right - left));
                right--;
            }
        }

        return total;
    }
}
