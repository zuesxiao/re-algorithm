package com.xiaoling.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiaoling
 */
public class Q217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
