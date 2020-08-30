package com.xiaoling.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiaoling
 */
public class Q202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = next(n);
        }
        return n == 1;
    }


    /**
     * 通过反复调用 getNext(n) 得到的链是一个隐式的链表。隐式意味着我们没有实际的链表节点和指针，但数据仍然形成链表结构。
     * 起始数字是链表的头 “节点”，链中的所有其他数字都是节点。next 指针是通过调用 getNext(n) 函数获得。
     * 意识到我们实际有个链表，那么这个问题就可以转换为检测一个链表是否有环。
     *
     * @param n 被检测数
     * @return
     */
    public boolean isHappy2(int n) {
        int slowRunner = n;
        int fastRunner = next(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = next(slowRunner);
            fastRunner = next(next(fastRunner));
        }
        return fastRunner == 1;
    }

    private int next(int n) {
        int result = 0;
        while (n > 0) {
            int b = n % 10;
            n = n / 10;
            result += b * b;
        }
        return result;
    }
}
