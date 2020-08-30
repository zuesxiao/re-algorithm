package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q392 {
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int charCount = 26;

        int[][] locations = new int[tLength + 1][charCount];
        for (int i = 0; i < charCount; i++) {
            locations[tLength][i] = tLength;
        }

        for (int i = tLength - 1; i >= 0; i--) {
            for (int j = 0; j < charCount; j++) {
                if (t.charAt(i) == 'a' + j) {
                    locations[i][j] = i;
                } else {
                    locations[i][j] = locations[i + 1][j];
                }
            }
        }

        int index = 0;
        for (int i = 0; i < sLength; i++) {
            if (locations[index][s.charAt(i) - 'a'] == tLength) {
                return false;
            } else {
                index = locations[index][s.charAt(i) - 'a'] + 1;
            }
        }

        return true;
    }

    public boolean isSubsequence1(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        int sLength = s.length();
        int tLength = t.length();

        if (s.equals(t)) {
            return true;
        }

        if (sLength > tLength) {
            return false;
        }

        int si = 0;
        int ti = 0;

        while (si < sLength) {
            if (ti >= tLength) {
                break;
            }

            if (s.charAt(si) == t.charAt(ti)) {
                si++;
            }
            ti++;
        }

        return si == sLength;
    }
}
