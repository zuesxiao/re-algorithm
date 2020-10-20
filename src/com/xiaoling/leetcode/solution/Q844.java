package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q844 {
    public boolean backspaceCompare(String S, String T) {
        return build(S).toString().equals(build(T).toString());
    }

    private StringBuilder build(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }

        return sb;
    }

    public boolean backspaceCompare1(String S, String T) {
        int p1 = S.length() - 1;
        int p2 = T.length() - 1;

        int count1 = 0;
        int count2 = 0;

        while (p1 >= 0 || p2 >= 0) {
            while (p1 >= 0) {
                if (S.charAt(p1) == '#') {
                    count1++;
                    p1--;
                } else if (count1 > 0) {
                    count1--;
                    p1--;
                } else {
                    break;
                }
            }

            while (p2 >= 0) {
                if (T.charAt(p2) == '#') {
                    count2++;
                    p2--;
                } else if (count2 > 0) {
                    count2--;
                    p2--;
                } else {
                    break;
                }
            }

            if (p1 >= 0 && p2 >= 0) {
                if (S.charAt(p1) != T.charAt(p2)) {
                    return false;
                }
            } else {
                if (p1 >= 0 || p2 >= 0) {
                    return false;
                }
            }

            p1--;
            p2--;
        }

        return true;
    }
}
