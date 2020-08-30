package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q263 {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        int[] factors = new int[]{2, 3, 5};

        for (int factor: factors) {
            while (num % factor == 0) {
                num = num / factor;
            }
        }

        return num == 1;
    }
}
