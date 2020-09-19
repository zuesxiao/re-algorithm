package com.xiaoling.leetcode.solution;

import java.util.Stack;

/**
 * Q232
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/¬
 *
 * @author xiaoling
 */
public class Q232 {
    public class MyQueue {
        Stack<Integer> stack;
        Stack<Integer> swap;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new Stack<>();
            swap = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            while (!stack.isEmpty()) {
                swap.push(stack.pop());
            }
            swap.push(x);
            while (!swap.isEmpty()) {
                stack.push(swap.pop());
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return stack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return stack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.empty();
        }
    }
}
