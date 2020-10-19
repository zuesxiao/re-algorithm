package com.xiaoling.leetcode.offer;

/**
 * @author xiaoling
 */
public class Offer63 {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }

        int length = prices.length;

        if (length <= 1) {
            return 0;
        }

        int max = 0;
        int currentMin = prices[0];

        for (int i = 1; i < length; i++) {
            if (currentMin > prices[i]) {
                currentMin = prices[i];
            }

            max = Math.max(prices[i] - currentMin, max);
        }

        return max;
    }
}
