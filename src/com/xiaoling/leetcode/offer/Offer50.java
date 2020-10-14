package com.xiaoling.leetcode.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 *
 * @author xiaoling
 */
public class Offer50 {
    public char firstUniqChar1(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }

        int length = s.length();
        int[] mark = new int[26];
        Arrays.fill(mark, -1);

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (mark[c] == -1) {
                mark[c] = i;
            } else {
                mark[c] = length;
            }
        }

        int index = length;
        char res = ' ';
        for (int i = 0; i < 26; i++) {
            if (mark[i] != -1 && mark[i] < index) {
                res = (char) (i + 'a');
                index = mark[i];
            }
        }
        return res;
    }

    public char firstUniqChar(String s) {
        int[] mark = new int[26];

        char[] chars = s.toCharArray();

        for (char c : chars) {
            mark[c - 'a']++;
        }

        for (char character : chars) {
            if (mark[character - 'a'] == 1) {
                return character;
            }
        }

        return ' ';
    }
}
