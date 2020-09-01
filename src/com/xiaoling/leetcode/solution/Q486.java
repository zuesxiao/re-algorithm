package com.xiaoling.leetcode.solution;

import com.sun.jmx.snmp.SnmpNull;

/**
 * 486. 预测赢家
 * https://leetcode-cn.com/problems/predict-the-winner/
 *
 * @author xiaoling
 */
public class Q486 {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        return dp[0][nums.length - 1] >= 0;
    }

    public boolean PredictTheWinner1(int[] nums) {
        return total(nums, 0, nums.length - 1, 1) >= 0;
    }

    private int total(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }

        int startScore = nums[start] * turn + total(nums, start + 1, end, -turn);
        int endScore = nums[end] * turn + total(nums, start, end - 1, -turn);
        return Math.max(startScore * turn, endScore * turn) * turn;
    }
}
