package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q367 {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        long left = 1;
        long right = num;
        while (left < right) {
            long middle = (left + right) / 2;
            long v = middle * middle;
            if (v > num) {
                right = middle;
            } else if (v < num) {
                left = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
