package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 67. 把字符串转换成整数
 * https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 *
 * @author xiaoling
 */
public class Offer67 {
    public int strToInt(String str) {
        boolean isNegative = false;
        str = str.trim();

        if (str.length() == 0) {
            return 0;
        }

        int result = 0;

        for (int index = 0; index < str.length(); index++) {
            char c = str.charAt(index);

            if (index == 0 && (c == '-' || c == '+')) {
                isNegative = c == '-';
            } else if (Character.isDigit(c)) {
                int b = (int) c - (int) '0';
                if (isNegative) {
                    b = -b;
                }

                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && b > 7)) {
                    return Integer.MAX_VALUE;
                }
                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && b < -8)) {
                    return Integer.MIN_VALUE;
                }

                result = result * 10 + b;
            } else {
                return result;
            }
        }

        return result;
    }
}
