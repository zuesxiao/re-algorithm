package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 *
 * @author xiaoling
 */
public class Offer17 {
    public int[] printNumbers(int n) {
        int max = (int)Math.pow(10, n) - 1;

        int[] result = new int[max];
        for (int i = 0; i < max; i++) {
            result[i] = i + 1;
        }

        return result;
    }
}
