package com.xiaoling.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoling
 */
public class Q205 {
    public boolean isIsomorphic(String s, String t) {
        int length = s.length();
        if (length == 1) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>(length);
        int i = 0;
        while (i < length) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (!map.containsKey(c1)) {
                if (map.containsValue(c2)) {
                    return false;
                } else {
                    map.put(c1, c2);
                }
            } else {
                if (map.get(c1) != c2) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}
