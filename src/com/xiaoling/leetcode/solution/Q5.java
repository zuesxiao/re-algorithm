package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int right = s.length() - 1;
            while (i <= right) {
                String sub = s.substring(i, right + 1);
                if (isValid(sub)) {
                    if (sub.length() > result.length()) {
                        result = sub;
                    }
                    break;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
