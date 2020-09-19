package com.xiaoling.leetcode.offer;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 *
 * @author xiaoling
 */
public class Offer30 {
    class MinStack {
        private int min = Integer.MAX_VALUE;
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            min = Math.min(min, x);
            minStack.push(min);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
            if (minStack.isEmpty()) {
                min = Integer.MAX_VALUE;
            } else {
                min = minStack.peek();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min;
        }
    }
}
