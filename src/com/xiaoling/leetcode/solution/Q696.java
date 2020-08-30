package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q696 {
    public int countBinarySubstrings(String s) {
        int length = s.length();
        int count = 0;

        int i = 0;

        while (i < length - 1) {
            if ((s.charAt(i) == '0' && s.charAt(i + 1) == '1') || (s.charAt(i) == '1' && s.charAt(i + 1) == '0')) {
                count++;
                int j = i - 1;
                int k = i + 2;
                while (j >= 0 && k <= length - 1) {
                    if (s.charAt(j) == s.charAt(i) && s.charAt(k) == s.charAt(i + 1)) {
                        count++;
                        j--;
                        k++;
                    } else {
                        break;
                    }
                }
                i = k - 1;
            } else {
                i++;
            }
        }

        return count;
    }

    public int countBinarySubstrings1(String s) {
        int total = 0;
        int prevCount = 0;
        int index = 0;
        int length = s.length();

        while (index < length) {
            char current = s.charAt(index);
            int count = 0;
            while (index < length && s.charAt(index) == current) {
                index++;
                count++;
            }
            total += Math.min(prevCount, count);
            prevCount = count;
        }

        return total;
    }
}
