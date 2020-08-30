package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q342 {
    public boolean isPowerOfFour(int num) {
        return ((num & (num - 1)) == 0) && num % 3 == 1;
    }
}
