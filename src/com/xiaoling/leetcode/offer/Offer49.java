package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 49. 丑数
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 *
 * @author xiaoling
 */
public class Offer49 {
    public int nthUglyNumber(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] res = new int[n];
        res[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for (int i = 1; i < n; i++) {
            res[i] = Math.min(Math.min(res[p2] * 2, res[p3] * 3), res[p5] * 5);

            if (res[i] == res[p2] * 2) {
                p2++;
            }

            if (res[i] == res[p3] * 3) {
                p3++;
            }

            if (res[i] == res[p5] * 5) {
                p5++;
            }
        }

        return res[n - 1];
    }
}
