package com.xiaoling.leetcode.offer;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * <p>
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 *
 * @author xiaoling
 */
public class Offer10 {
    BigInteger[] f;
    BigInteger mode = BigInteger.valueOf(1000000007);

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        f = new BigInteger[n + 1];
        Arrays.fill(f, BigInteger.valueOf(-1));
        f[0] = BigInteger.ZERO;
        f[1] = BigInteger.ONE;
        fib1(n);

        return f[n].mod(mode).intValue();
    }

    private BigInteger fib1(int n) {
        if (f[n].compareTo(BigInteger.ZERO) >= 0) {
            return f[n];
        } else {
            BigInteger vn = fib1(n - 1).add(fib1(n - 2));
            f[n] = vn;
            return vn;
        }
    }

    public int fib2(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public int numWays(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
