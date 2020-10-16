package com.xiaoling.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * <p>
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 *
 * @author xiaoling
 */
public class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1) {
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int remain = target - current;
            if (remain == 0) {
                return new int[0];
            }

            boolean exists = findRemain(nums, remain, i + 1, Math.min(i + remain, nums.length - 1));

            if (exists) {
                return new int[]{current, remain};
            }
        }

        return new int[0];
    }

    private boolean findRemain(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int m = (start + end) / 2;
            if (nums[m] == target) {
                return true;
            }

            if (nums[m] < target) {
                start = m + 1;
            }

            if (nums[m] > target) {
                end = m - 1;
            }
        }

        return false;
    }

    public int[] twoSum1(int[] nums, int target) {
        if (nums.length <= 1) {
            return new int[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }

        return new int[0];
    }

    public int[][] findContinuousSequence(int target) {
        if (target <= 2) {
            return new int[0][0];
        }

        int end = target / 2 + 1;
        int p = 1;

        List<int[]> list = new ArrayList<>();
        while (p < end && ((long)(p + end) * (long)end / 2L >= target)) {
            for (int i = 2; i <= end; i++) {
                int sum = (2 * p + i - 1) * i / 2;
                if (sum == target) {
                    int[] temp = new int[i];
                    for (int j = 0; j < i; j++) {
                        temp[j] = p + j;
                    }
                    list.add(temp);
                    p++;
                }

                if (sum > target) {
                    p++;
                    break;
                }
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
