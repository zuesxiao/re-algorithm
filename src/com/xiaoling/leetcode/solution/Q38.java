package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q38 {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int index = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(index)) {
                    sb.append(j - index);
                    sb.append(s.charAt(index));
                    index = j;
                }
            }
            sb.append(s.length() - index);
            sb.append(s.charAt(s.length() - 1));
            s = sb.toString();
        }

        return s;
    }
}
