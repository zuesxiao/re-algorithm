package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 *
 * @author xiaoling
 */
public class Offer64 {
    public int sumNums(int n) {
        //return n == 1 ? 1 : n + sumNums(n - 1);
        boolean b = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
