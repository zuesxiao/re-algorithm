package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q7 {
    public int reverse(int x) {
        int tmp = x;
        long result = 0;
        while (tmp != 0) {
            int b = tmp % 10;
            tmp = tmp / 10;
            result = result * 10 + b;
        }

        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int) result;
    }
}
