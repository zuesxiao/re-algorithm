package com.xiaoling.leetcode.offer;

/**
 * @author xiaoling
 */
public class Offer15 {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n - 1);
        }
        return sum;
    }
}
