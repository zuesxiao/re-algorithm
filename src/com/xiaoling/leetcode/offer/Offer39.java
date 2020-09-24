package com.xiaoling.leetcode.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 *
 * @author xiaoling
 */
public class Offer39 {

    /**
     * 排序法，中间位置的数一定是过半数字
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement1(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }

        return candidate;
    }
}
