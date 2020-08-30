package com.xiaoling.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoling
 */
public class Q5483 {
    public String makeGood(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        List<Character> sc = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            sc.add(s.charAt(i));
        }

        while (true) {
            boolean flag = true;
            int length = sc.size();
            for (int i = 0; i < length - 1; i++) {
                if (Math.abs(sc.get(i) - sc.get(i + 1)) == 32) {
                    sc.remove(i + 1);
                    sc.remove(i);
                    flag = false;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : sc) {
            sb.append(c);
        }
        return sb.toString();
    }
}
