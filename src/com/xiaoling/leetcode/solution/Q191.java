package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q191 {
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) == mask) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

    public int hammingWeight1(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
