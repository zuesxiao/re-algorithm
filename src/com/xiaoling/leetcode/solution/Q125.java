package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int length = s.length();
        if (length <= 1) {
            return true;
        }

        int left = 0, right = length - 1;
        while (left <= right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);

            if (!isLetter(cLeft) && !isLetter(cRight)) {
                left++;
                right--;
            } else if (!isLetter(cLeft)) {
                left++;
            } else if (!isLetter(cRight)) {
                right--;
            } else {
                if (cLeft == cRight) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isLetter(char c) {
        return (c >= 97 && c <= 122) || (c >= 48 && c <= 57);
    }
}
