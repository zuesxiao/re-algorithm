package com.xiaoling.leetcode.offer;

import java.util.Arrays;

/**
 * @author xiaoling
 */
public class Offer14 {
    int[] f;

    public int cuttingRope(int n) {
        f = new int[n + 1];
        Arrays.fill(f, -1);
        f[0] = 0;
        f[1] = 0;
        f[2] = 1;

        cutting(n);

        return f[n];
    }

    private int cutting(int n) {
        if (f[n] != -1) {
            return f[n];
        }

        int result = -1;
        for (int i = 1; i <= n - 1; i++) {
            int temp = Math.max(i * cutting(n - i), i * (n - i));
            result = Math.max(temp, result);
        }
        f[n] = result;
        return result;
    }
}
