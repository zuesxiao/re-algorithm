package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q122 {
    public int maxProfit(int[] prices) {
        int result = 0;

        if (prices.length <= 1) {
            return result;
        }

        int prev = prices[0];
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < prev){
                result += (prev - min);
                min = prices[i];
            }
            prev = prices[i];
        }

        result += (prev - min);

        return result;
    }
}
