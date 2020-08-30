package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q214 {
    public String shortestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        int length = s.length();
        int endIndex = length - 1;
        while (endIndex >= 0) {
            if (isPalindrome(s, endIndex)) {
                break;
            }
            endIndex--;
        }

        if (endIndex == length - 1) {
            return s;
        } else {
            StringBuilder sb = new StringBuilder(s.substring(endIndex + 1)).reverse();
            sb.append(s);
            return sb.toString();
        }
    }

    private boolean isPalindrome(String s, int end) {
        int start = 0;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
