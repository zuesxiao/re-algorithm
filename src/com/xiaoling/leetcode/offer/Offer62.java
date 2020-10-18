package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 *
 * @author xiaoling
 */
public class Offer62 {
    public int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; i++) {
            f = (m + f) % i;
        }
        return f;
        //return f(n, m);
    }

    private int f(int n, int m) {
        if (n == 1) {
            return 0;
        }

        int x = f(n - 1, m);
        return (m + x) % n;
    }
}
