package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q154 {
    public int minArray(int[] numbers) {
        int left = 0;
        int tmp = Integer.MIN_VALUE;
        while (left < numbers.length) {
            if (numbers[left] >= tmp) {
                tmp = numbers[left];
            } else {
                break;
            }
            left++;
        }
        if (left >= numbers.length) {
            return numbers[0];
        } else {
            return numbers[left];
        }
    }
}
