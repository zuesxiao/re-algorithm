package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q67 {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = b;
            b = a;
            a = tmp;
        }

        int offset = a.length() - b.length();

        StringBuilder sb = new StringBuilder();

        int index = a.length() - 1;
        int overBit = 0;
        while (index >= 0) {
            int added;
            if (index - offset >= 0) {
                added = charToInt(a.charAt(index)) + charToInt(b.charAt(index - offset)) + overBit;
            } else {
                added = charToInt(a.charAt(index)) + overBit;
            }

            overBit = added / 2;
            sb.insert(0, added % 2);
            index--;
        }

        if (overBit > 0) {
            sb.insert(0, overBit);
        }

        return sb.toString();
    }

    private int charToInt(char c) {
        return c - '0';
    }
}
