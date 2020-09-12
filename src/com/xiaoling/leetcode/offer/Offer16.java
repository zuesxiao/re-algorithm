package com.xiaoling.leetcode.offer;

/**
 * Offer 16 & Questionn 50
 * https://leetcode-cn.com/problems/powx-n/
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 *
 * @author xiaoling
 */
public class Offer16 {
    public double myPow(double x, long n) {
        if (n == 0 || x == 1) {
            return 1;
        }

        return n > 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
    }

    private double quickMul(double x, long n) {
        double res = 1;
        double prev = x;
        while (n > 0) {
            if (n % 2 == 1) {
                res = res * prev;
            }
            prev *= prev;

            n /= 2;
        }

        return res;
    }
}
