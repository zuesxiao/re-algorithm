package com.xiaoling.leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 *
 * @author xiaoling
 */
public class Offer59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) {
            return new int[0];
        }

        int length = nums.length;
        if (length <= 1) {
            return nums;
        }

        int total = length - k + 1;
        int[] res = new int[total];

        for (int i = 0; i < total; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(nums[j], max);
            }
            res[i] = max;
        }

        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null) {
            return new int[0];
        }

        int length = nums.length;
        if (length <= 1) {
            return nums;
        }

        int total = length - k + 1;
        int[] res = new int[total];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0, j = 1 - k; i < length; i++, j++) {
            if (j > 0 && deque.peekFirst() == nums[j - 1]) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }

            deque.addLast(nums[i]);

            if (j >= 0) {
                res[j] = deque.peekFirst();
            }
        }

        return res;
    }

    private static class MaxQueue {
        Queue<Integer> queue;
        Deque<Integer> deque;

        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }

        public int max_value() {
            if (deque.isEmpty()) {
                return -1;
            }
            return deque.peekFirst();
        }

        public void push_back(int value) {
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.pollLast();
            }
            deque.offerLast(value);
            queue.offer(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }

            int ret = queue.poll();
            if (deque.peekFirst() == ret) {
                deque.pollFirst();
            }
            return ret;
        }
    }
}
