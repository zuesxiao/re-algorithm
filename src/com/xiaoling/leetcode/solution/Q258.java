package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q258 {
    public int addDigits(int num) {
        while (num >= 10) {
            int temp = num;
            int newNum = 0;
            while (temp > 0) {
                newNum += temp % 10;
                temp = temp / 10;
            }
            num = newNum;
        }
        return num;
    }

    public int addDigits1(int num) {
        return (num - 1) % 9 + 1;
    }
}
