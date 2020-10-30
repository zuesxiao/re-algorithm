package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 *
 * @author xiaoling
 */
public class Offer46 {
    public int translateNum(int num) {
        String value = Integer.toString(num);

        int r = 1;
        int p = 0;
        int q = 0;

        for (int i = 0; i < value.length(); i++) {
            p = q;
            q = r;
            r = 0;
            r += q;

            if (i == 0) {
                continue;
            }

            String sub = value.substring(i - 1, i + 1);
            if (sub.compareTo("10") >= 0 && sub.compareTo("25") <= 0) {
                r += p;
            }
        }

        return r;
    }
}
