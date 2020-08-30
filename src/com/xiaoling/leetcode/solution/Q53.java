package com.xiaoling.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoling
 */
public class Q53 {
    private static final String LEFT_SUM = "leftSum";
    private static final String RIGHT_SUM = "rightSum";
    private static final String MAX_SUM = "maxSum";
    private static final String SUM = "sum";

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(num, pre + num);
            max = Math.max(max, pre);
        }
        return max;
    }

    public int maxSubArray1(int[] nums) {
        Map<String, Integer> sums = getSums(nums, 0, nums.length - 1);
        return sums.get(MAX_SUM);
    }

    private Map<String, Integer> pushUp(Map<String, Integer> leftSums, Map<String, Integer> rightSums) {
        int leftSum = Math.max(leftSums.get(LEFT_SUM), leftSums.get(SUM) + rightSums.get(LEFT_SUM));
        int rightSum = Math.max(rightSums.get(RIGHT_SUM), rightSums.get(SUM) + leftSums.get(RIGHT_SUM));
        int maxSum = Math.max(Math.max(leftSums.get(MAX_SUM), rightSums.get(MAX_SUM)), leftSums.get(RIGHT_SUM) + rightSums.get(LEFT_SUM));
        int sum = leftSums.get(SUM) + rightSums.get(SUM);
        return createSums(leftSum, rightSum, maxSum, sum);
    }

    private Map<String, Integer> getSums(int[] nums, int start, int end) {
        if (start == end) {
            return createSums(nums[start], nums[start], nums[start], nums[start]);
        }
        int middle = (start + end) / 2;
        Map<String, Integer> leftSums = getSums(nums, start, middle);
        Map<String, Integer> rightSums = getSums(nums, middle + 1, end);
        return pushUp(leftSums, rightSums);
    }

    private Map<String, Integer> createSums(int leftSum, int rightSum, int masSum, int sum) {
        Map<String, Integer> sums = new HashMap<>(4);
        sums.put(LEFT_SUM, leftSum);
        sums.put(RIGHT_SUM, rightSum);
        sums.put(MAX_SUM, masSum);
        sums.put(SUM, sum);
        return sums;
    }
}
