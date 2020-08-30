package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        if (needle.length() == 0) {
            return 0;
        }

        int length1 = haystack.length();
        int length2 = needle.length();
        int j = -1;

        for (int i = 0; i <= length1 - length2; i++) {
            if (haystack.substring(i, i + length2).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
