package com.xiaoling.leetcode.offer;

import java.util.Stack;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * <p>
 * 剑指 Offer 58 - II. 左旋转字符串
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 *
 * @author xiaoling
 */
public class Offer58 {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        String[] strings = s.trim().split(" ");
        for (String string : strings) {
            if (!"".equals(string)) {
                stack.push(string);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public String reverseLeftWords(String s, int n) {
        int length = s.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i < n) {
                sb.append(s.charAt(i));
            } else {
                sb.insert(i - n, s.charAt(i));
            }
        }

        return sb.toString();
        // return s.substring(n + 1) + s.substring(0, n);
    }
}
