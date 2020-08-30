package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q6 {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        int index = 0;
        int size = s.length();
        int step = 2 * (numRows - 1);

        StringBuilder sb = new StringBuilder();

        while (index < size) {
            sb.append(s.charAt(index));
            index += step;
        }

        for (int i = 1; i < numRows - 1; i++) {
            index = i;
            while (index < size) {
                sb.append(s.charAt(index));

                int mid = index + 2 * (numRows - i - 1);
                if (mid < size) {
                    sb.append(s.charAt(mid));
                }

                index += step;
            }
        }

        index = numRows - 1;
        while (index < size) {
            sb.append(s.charAt(index));
            index += step;
        }

        return sb.toString();
    }
}
