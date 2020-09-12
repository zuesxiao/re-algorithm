package com.xiaoling;

import com.xiaoling.leetcode.offer.Offer21;

import java.util.Arrays;

/**
 * @author xiaoling
 */
public class Main {

    public static void main(String[] args) {
        Offer21 q = new Offer21();

        int[] nums = new int[]{1, 2, 3, 4, 5, 7};
        System.out.println(Arrays.toString(q.exchange(nums)));
    }
}
