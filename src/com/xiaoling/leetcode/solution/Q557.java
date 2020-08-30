package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q557 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();

        int start = 0;
        int end = 0;

        while (end < chars.length) {
            if (chars[end] != ' ') {
                end++;
            } else {
                reverseWord(chars, start, end - 1);
                start = ++end;
            }
        }
        reverseWord(chars, start, end - 1);

        return new String(chars);
    }

    private void reverseWord(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}
