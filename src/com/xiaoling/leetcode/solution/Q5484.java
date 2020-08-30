package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q5484 {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        } else if (k * 2 - 1 == n) {
            return '1';
        }

        String s = buildString(n);
        return s.charAt(k - 1);
    }

    private String buildString(int n) {
        if (n == 1) {
            return "0";
        }

        String sp = buildString(n - 1);
        return sp + "1" + reverseAndInvert(sp);
    }

    private String reverseAndInvert(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }

        return sb.toString();
    }
}
