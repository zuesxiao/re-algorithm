package com.xiaoling.leetcode.solution;

/**
 * 要得到自然数n以内的全部素数，必须把不大于根号n的所有素数的奇数倍剔除，剩下的奇数就是素数。
 *
 * @author xiaoling
 */
public class Q204 {
    public int countPrimes(int n) {
        int result = 0, sqrtN = (int) Math.sqrt(n);
        // 初始化默认值都为 false，为质数标记
        boolean[] b = new boolean[n];
        if (2 < n) {
            result++; // 如果大于 2 则一定拥有 2 这个质数
        }
        // 从 3 开始遍历，且只遍历奇数
        for (int i = 3; i < n; i += 2) {
            // 是质数
            if (!b[i]) {
                // 是质数
                if (i <= sqrtN) {
                    for (int j = i; i * j < n; j += 2) {
                        // 将当前质数的奇数倍都设置成非质数标记 true
                        b[i * j] = true;
                    }
                }
                // 质数个数 +1
                result++;
            }
        }
        return result;
    }
}
