package com.xiaoling.leetcode.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xiaoling
 */
public class Offer61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);

        int zeroCount = 0;
        int index = 0;
        while (nums[index] == 0) {
            index++;
            zeroCount++;
        }

        int right = nums.length - 2;
        while (right >= index) {
            int distance = nums[right + 1] - nums[right];

            if (distance == 1) {
                right--;
            } else if (distance == 0) {
                return false;
            } else {
                if (zeroCount >= distance - 1) {
                    zeroCount -= distance;
                    right--;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isStraight1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int min = 14;

        for (int num : nums) {
            if (num == 0) {
                continue;
            }

            if (set.contains(num)) {
                return false;
            }

            set.add(num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return max - min < 5;
    }
}
