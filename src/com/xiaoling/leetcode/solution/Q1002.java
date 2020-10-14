package com.xiaoling.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1002. 查找常用字符
 * https://leetcode-cn.com/problems/find-common-characters/
 *
 * @author xiaoling
 */
public class Q1002 {
    public List<String> commonChars(String[] A) {
        int[] freq = new int[26];
        Arrays.fill(freq, Integer.MAX_VALUE);

        for (String a : A) {
            int[] temp = new int[26];
            for (int j = 0; j < a.length(); j++) {
                temp[a.charAt(j) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                freq[i] = Math.min(freq[i], temp[i]);
            }
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                for (int j = 0; j < freq[i]; j++) {
                    res.add(String.valueOf((char) (i + 'a')));
                }
            }
        }

        return res;
    }
}
