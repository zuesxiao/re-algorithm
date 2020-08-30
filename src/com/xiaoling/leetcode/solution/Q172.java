package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q172 {
    public int trailingZeroes(int n) {
        int result = 0;
        long rate = 5;
        while (n >= rate) {
            result += (n / rate);
            rate *= 5;
        }
        return result;
    }
}
