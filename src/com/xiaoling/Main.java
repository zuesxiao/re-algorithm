package com.xiaoling;

import com.xiaoling.leetcode.offer.Offer57;

import java.util.Arrays;

/**
 * @author xiaoling
 */
public class Main {

    public static void main(String[] args) {
        Offer57 offer57 = new Offer57();
        int[][] res = offer57.findContinuousSequence(100000);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
