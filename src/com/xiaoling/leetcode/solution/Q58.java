package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int j = -1;
        int i = s.length() - 1;

        while (i >= 0) {
            if (s.charAt(i) != ' ') {
                if (j == -1) {
                    j = i;
                }
            } else if (j != -1) {
                break;
            }
            i--;
        }

        return j - i;
    }
}
