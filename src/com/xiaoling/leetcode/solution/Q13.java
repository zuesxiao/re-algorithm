package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q13 {
    public int romanToInt(String s) {
        String[] keys = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Integer[] values = new Integer[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int result = 0;

        int offset = 0;
        while (offset < s.length()) {
            for (int i = 0; i < keys.length; i++) {
                if (s.startsWith(keys[i], offset)) {
                    result += values[i];
                    offset += keys[i].length();
                    break;
                }
            }
        }

        return result;
    }
}
