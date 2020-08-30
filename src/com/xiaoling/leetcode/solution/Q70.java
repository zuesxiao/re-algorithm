package com.xiaoling.leetcode.solution;

import java.util.Arrays;

/**
 * @author xiaoling
 */
public class Q70 {
    int[] f;

    public int climbStairs(int n) {
        f = new int[n + 1];
        Arrays.fill(f, -1);

        func(n);
        return f[n];
    }

    private int func(int n) {
        if (f[n] != -1) {
            return f[n];
        }

        if (n <= 2) {
            f[n] = n;
        } else {
            f[n] = func(n - 1) + func(n - 2);
        }

        return f[n];
    }

    /**
     * 滚动数组
     * f(n) = f(n-1) + f(n-2)
     *
     * @param n 阶层
     * @return 组合
     */
    public int climbStairs1(int n) {
        int a = 0, b = 0, c = 1;
        for (int i = 1; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}
