package com.xiaoling.leetcode.solution;

import java.util.HashSet;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author xiaoling
 */
public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();

        int length = s.length();
        int result = 0;
        int cursor = -1;

        for (int index = 0; index < length; index++) {
            if (index != 0) {
                hashSet.remove(s.charAt(index - 1));
            }

            while (cursor + 1 < length && !hashSet.contains(s.charAt(cursor + 1))) {
                hashSet.add(s.charAt(cursor + 1));
                cursor++;
            }

            result = Math.max(result, cursor - index + 1);
        }

        return result;
    }
}
