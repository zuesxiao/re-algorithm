package com.xiaoling.leetcode.offer;


import com.xiaoling.common.ListNode;

import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author xiaoling
 */
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int[] result = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }
        return result;
    }

    public int[] reversePrint1(ListNode head) {
        int size = -1;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int[] result = new int[size + 1];
        while (head != null) {
            result[size--] = head.val;
            head = head.next;
        }
        return result;
    }
}
