package com.xiaoling.leetcode.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 40. 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * @author xiaoling
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int length = arr.length;

        if (k == length) {
            return arr;
        }

        Arrays.sort(arr);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);

        return res;
    }
}
