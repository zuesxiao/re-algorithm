package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q459 {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();

        int group = 2;
        while (group <= length) {
            if (length % group != 0) {
                group++;
                continue;
            }

            if (isMatch(s, group, length / group)) {
                return true;
            }
            group++;
        }

        return false;
    }

    private boolean isMatch(String s, int group, int groupLength) {
        int index = 0;

        while (index < groupLength) {
            char charOfFirstGroup = s.charAt(index);

            for (int i = 1; i < group; i++) {
                if (charOfFirstGroup != s.charAt(index + groupLength * i)) {
                    return false;
                }
            }

            index++;
        }
        return true;
    }
}
