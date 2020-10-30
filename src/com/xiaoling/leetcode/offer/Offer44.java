package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 *
 * @author xiaoling
 */
public class Offer44 {
    public int findNthDigit(int n) {
        int digits = 1;
        while (true) {
            long next = 9 * (long) Math.pow(10, digits - 1) * digits;
            if (n > next) {
                n -= next;
            } else {
                break;
            }
            digits++;
        }

        int nth = n / digits;
        int left = n % digits;

        int value = (int) Math.pow(10, digits - 1) + nth - 1;

        if (left > 0) {
            value += 1;
            value = value / (int) Math.pow(10, digits - left);
        }

        return value % 10;
    }
}
