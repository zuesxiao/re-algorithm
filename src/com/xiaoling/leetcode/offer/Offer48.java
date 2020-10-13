package com.xiaoling.leetcode.offer;

import java.util.HashMap;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 *
 * @author xiaoling
 */
public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        int length = s.length();

        if (length <= 1) {
            return length;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int res = 0;
        int max = 0;

        for (int i = 0; i < length; i++) {
            int prev = hashMap.getOrDefault(s.charAt(i), -1);
            hashMap.put(s.charAt(i), i);
            max = max < i - prev ? max + 1 : i - prev;
            res = Math.max(res, max);
        }

        return res;
    }
}
