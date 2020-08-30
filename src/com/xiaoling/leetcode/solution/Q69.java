package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q69 {
    public int mySqrt(int x) {
        if (x * x == x) {
            return x;
        }

        int left = 1;
        int right = (x / 2) + 1;
        while (left < right) {
            int middle = (left + right) / 2;
            int middleOne = middle + 1;
            long v1 = (long) middle * (long) middle;
            long v2 = (long) middleOne * (long) middleOne;
            if (v1 <= x && v2 > x) {
                return middle;
            } else if (v1 > x) {
                right = middle;
            } else if (v1 < x) {
                left = middle;
            }
        }
        return 0;
    }

    /**
     * 牛顿迭代
     * x(i+1) = (x(i) + C / x(i))/2
     *
     * @param x 目标值
     * @return 开方结果
     */
    public int mySqrt1(int x) {
        if (x * x == x) {
            return x;
        }

        double x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + (double) x / x0);
            if (Math.abs(xi - x0) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}
