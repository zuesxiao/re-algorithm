package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q121 {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }

        int result = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int price : prices) {
            min = Math.min(min, price);
            result = Math.max(price - min, result);
        }

        return result;
    }
}
