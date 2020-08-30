package com.xiaoling.leetcode.solution;

import java.util.Stack;

/**
 * Q155
 * https://leetcode-cn.com/problems/min-stack/
 *
 * @author xiaoling
 */
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

    public int getMin() {
        return min;
    }
}
