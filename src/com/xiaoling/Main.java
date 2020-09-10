package com.xiaoling;

import com.xiaoling.leetcode.solution.Q40;

/**
 * @author xiaoling
 */
public class Main {

    public static void main(String[] args) {
        Q40 q = new Q40();

        int[] nums = new int[]{1, 1, 2, 5, 6, 7, 10};
        System.out.println(q.combinationSum2(nums, 8));
    }
}
