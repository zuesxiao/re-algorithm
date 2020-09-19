package com.xiaoling.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Q225
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 *
 * @author xiaoling
 */
public class Q225 {
    public class MyStack {
        Queue<Integer> queue;
        Queue<Integer> temp;
        int top;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue = new LinkedList<>();
            temp = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.offer(x);
            top = x;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            while (queue.size() > 1) {
                temp.offer(queue.poll());
            }
            int result = queue.poll();
            while (!temp.isEmpty()) {
                queue.offer(temp.poll());
            }
            return result;
        }

        /**
         * Get the top element.
         */
        public int top() {
            return top;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
