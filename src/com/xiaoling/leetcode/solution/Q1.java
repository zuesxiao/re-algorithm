package com.xiaoling.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoling
 */
public class Q1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> locations = new HashMap<>(1);

        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (!locations.containsKey(remain)) {
                locations.put(nums[i], i);
            } else {
                return new int[]{locations.get(remain), i};
            }
        }

        return new int[0];
    }
}
