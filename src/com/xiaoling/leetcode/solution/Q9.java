package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q9 {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0) {
            return false;
        }
        if (x % 10 == 0) {
            return false;
        }

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        return x == rev || x == (rev / 10);
    }
}
