package com.xiaoling.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoling
 */
public class Q290 {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> match1 = new HashMap<>();
        Map<String, Character> match2 = new HashMap<>();
        String[] strings = str.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = strings[i];
            if (!match1.containsKey(c) && !match2.containsKey(word)) {
                match1.put(c, word);
                match2.put(word, c);
            } else {
                if (!match1.containsKey(c) || !match1.get(c).equals(word) || !match2.containsKey(word) || match2.get(word) != c) {
                    return false;
                }
            }
        }
        return true;
    }
}
