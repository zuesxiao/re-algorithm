package com.xiaoling.leetcode.solution;

public class Q171 {
    public int titleToNumber(String s) {
        int result = 0;
        int length = s.length();
        int index = length - 1;
        while (index >= 0) {
            result += (s.charAt(length - index - 1) - 'A' + 1) * Math.pow(26, index);
            index--;
        }
        return result;
    }
}
