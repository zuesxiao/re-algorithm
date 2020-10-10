package com.xiaoling.leetcode.solution;

/**
 * 167. 两数之和 II - 输入有序数组
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author xiaoling
 */
public class Q167 {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }
}
