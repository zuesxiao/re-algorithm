package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * <p>
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 *
 * @author xiaoling
 */
public class Offer56 {
    public int[] singleNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        int mask = 1;
        while ((mask & result) == 0) {
            mask <<= 1;
        }

        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

    public int singleNumber(int[] nums) {
        int[] counts = new int[32];

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                counts[i] += (num & 1);
                num >>>= 1;
            }
        }

        int res = 0;
        int m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (counts[31 - i] % m);
        }

        return res;
    }
}
