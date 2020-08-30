package com.xiaoling.leetcode.solution;

import java.util.Arrays;

/**
 * @author xiaoling
 */
public class Q647 {
    private int[][] mark;

    public int countSubstrings(String s) {
        if (s == null) {
            return 0;
        }

        int length = s.length();

        if (length <= 1) {
            return 1;
        }

        mark = new int[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(mark[i], 0);
        }

        int count = length;
        for (int i = 0; i < length; i++) {
            mark[i][i] = 1;
        }

        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 1; j >= i + 1; j--) {
                if (mark[i][j] == 0) {
                    if (isValid(s, i, j)) {
                        count += mark(i, j);
                    }
                }
            }
        }

        return count;
    }

    private int mark(int start, int end) {
        int count = 0;
        while (start < end) {
            if (mark[start][end] != 1) {
                mark[start][end] = 1;
                count++;
            }
            start++;
            end--;
        }
        return count;
    }

    private boolean isValid(String s, int start, int end) {
        if (end == start) {
            return true;
        }
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 回文中心算法
     *
     * @param s
     * @return
     */
    public int countSubstrings1(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
}
