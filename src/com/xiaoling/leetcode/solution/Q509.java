package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q509 {
    public int fib(int N) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < N; i++){
            sum = (a + b);
            a = b;
            b = sum;
        }
        return a;
    }
}
