package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int index = 0;
        while (true) {
            if (strs[0].length() == 0) {
                return "";
            }

            if (index >= strs[0].length()) {
                return strs[0];
            }

            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || strs[i].charAt(index) != c) {
                    return strs[0].substring(0, index);
                }
            }
            index++;
        }
    }
}
