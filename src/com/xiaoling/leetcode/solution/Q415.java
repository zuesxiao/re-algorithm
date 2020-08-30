package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q415 {
    private static final String ZERO = "0";
    private static final char C_ZERO = '0';

    public String addStrings(String num1, String num2) {
        if (ZERO.equals(num1)) {
            return num2;
        }
        if (ZERO.equals(num2)) {
            return num1;
        }

        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;

        int overBit = 0;
        StringBuilder sb = new StringBuilder();
        while (index1 >= 0 && index2 >= 0) {
            int v = num1.charAt(index1--) + num2.charAt(index2--) - 2 * C_ZERO + overBit;
            overBit = v / 10;
            v = v % 10;
            sb.insert(0, v);
        }

        while (index1 >= 0) {
            int v = num1.charAt(index1--) - C_ZERO + overBit;
            overBit = v / 10;
            v = v % 10;
            sb.insert(0, v);
        }

        while (index2 >= 0) {
            int v = num2.charAt(index2--) - C_ZERO + overBit;
            overBit = v / 10;
            v = v % 10;
            sb.insert(0, v);
        }

        if (overBit > 0) {
            sb.insert(0, overBit);
        }

        return sb.toString();
    }
}
