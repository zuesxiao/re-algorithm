package com.xiaoling.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * @author xiaoling
 */
public class Offer38 {
    char[] temp;
    char[] chars;
    int[] vis;
    List<String> strings = new ArrayList<>();

    public String[] permutation(String s) {
        chars = s.toCharArray();
        int length = chars.length;
        temp = new char[length];
        vis = new int[length];

        Arrays.sort(chars);

        permutation(0);

        String[] res = new String[strings.size()];
        strings.toArray(res);
        return res;
    }

    private void permutation(int index) {
        if (index == temp.length) {
            strings.add(new String(temp));
        }

        for (int i = 0; i < chars.length; i++) {
            if (vis[i] == 1 || (i > 0 && chars[i] == chars[i - 1] && vis[i - 1] == 0)) {
                continue;
            }

            temp[index] = chars[i];
            vis[i] = 1;
            permutation(index + 1);
            vis[i] = 0;
        }
    }
}
