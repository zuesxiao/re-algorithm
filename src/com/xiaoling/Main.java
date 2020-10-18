package com.xiaoling;

import com.xiaoling.leetcode.offer.Offer61;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 *
 * @author xiaoling
 */
public class Main {

    public static void main(String[] args) {
        Offer61 q = new Offer61();
        System.out.println(q.isStraight(new int[]{0, 0, 2, 2, 5}));
    }
}
