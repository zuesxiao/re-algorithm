package com.xiaoling.leetcode.offer;

import java.util.Stack;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 *
 * @author xiaoling
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }

        int total = pushed.length;
        Stack<Integer> stack = new Stack<>();

        int index = 0;
        for (int pushNum : pushed) {
            stack.push(pushNum);
            while (!stack.isEmpty() && index < total && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }

        return index == total;
    }
}
