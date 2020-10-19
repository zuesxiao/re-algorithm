package com.xiaoling.leetcode.offer;

/**
 * @author xiaoling
 */
public class Offer66 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length <= 1) {
            return new int[0];
        }

        int length = a.length;
        int temp = 1;
        int[] res = new int[length];
        res[0] = 1;

        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }

        for (int i = length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            res[i] = res[i] * temp;
        }

        return res;
    }
}
