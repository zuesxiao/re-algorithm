package com.xiaoling.leetcode.solution;

import java.util.Arrays;

/**
 * @author xiaoling
 */
public class Q343 {
    int[] f;

    public int integerBreak(int n) {
        f = new int[n + 1];
        Arrays.fill(f, -1);
        f[0] = 0;
        f[1] = 1;
        f[2] = 1;

        func(n);
        return f[n];
    }

    private int func(int n) {
        if (f[n] != -1) {
            return f[n];
        }

        int result = -1;
        for (int i = 1; i <= n - 1; i++) {
            int tmm = Math.max(i * func(n - i), i * (n - i));
            result = Math.max(result, tmm);
        }
        f[n] = result;
        return result;
    }
}
