package com.xiaoling.leetcode.offer;

/**
 * @author xiaoling
 */
public class Offer05 {
    private static final String REPLACE = "%20";
    private static final char SPACE = ' ';

    public String replaceSpace(String s) {
        if (s.indexOf(SPACE) == -1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == SPACE) {
                sb.append(REPLACE);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
