package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 60. n个骰子的点数
 * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 *
 * @author xiaoling
 */
public class Offer60 {
    public double[] twoSum(int n) {
        int[][] f = new int[n + 1][6 * n + 1];

        for (int i = 1; i <= 6; i++) {
            f[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k < i - 1) {
                        break;
                    }
                    f[i][j] += f[i - 1][j - k];
                }
            }
        }

        double total = Math.pow(6d, n);
        double[] res = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            res[i - n] = ((double) f[n][i]) / total;
        }
        return res;
    }
}
