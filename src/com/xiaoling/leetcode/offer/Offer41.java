package com.xiaoling.leetcode.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 * <p>
 * 295. 数据流的中位数
 * https://leetcode-cn.com/problems/find-median-from-data-stream/
 *
 * @author xiaoling
 */
public class Offer41 {
    public void test() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(100);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(101);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(99);
        medianFinder.addNum(102);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(98);
        System.out.println(medianFinder.findMedian());
    }

    class MedianFinder1 {
        private List<Integer> list;
        private double median;

        /**
         * initialize your data structure here.
         */
        public MedianFinder1() {
            list = new ArrayList<>();
        }

        public void addNum(int num) {
            int left = 0;
            int right = list.size();

            while (left < right) {
                int middle = (left + right) / 2;
                if (list.get(middle) < num) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            list.add(right, num);

            int size = list.size();
            median = (list.get(size / 2) + list.get((size - 1) / 2)) / 2.0;
        }

        public double findMedian() {
            return median;
        }
    }

    class MedianFinder {
        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Comparator.<Integer>comparingInt(item -> item).reversed());
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            maxHeap.offer(num);

            Integer max = maxHeap.poll();
            minHeap.offer(max);

            if (maxHeap.size() < minHeap.size()) {
                Integer min = minHeap.poll();
                maxHeap.offer(min);
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return (double)maxHeap.peek();
            } else {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
        }
    }
}
