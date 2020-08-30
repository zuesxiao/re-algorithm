package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q66 {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{};
        }

        int length = digits.length;
        int overBit = 1;
        for (int i = length - 1; i >= 0; i--) {
            int added = digits[i] + overBit;
            if (added < 10) {
                digits[i] = added;
                overBit = 0;
                break;
            } else {
                overBit = added / 10;
                digits[i] = added % 10;
            }
        }

        if (overBit == 1) {
            int[] result = new int[length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, length);
            return result;
        } else {
            return digits;
        }
    }
}
