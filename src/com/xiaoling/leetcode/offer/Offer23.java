package com.xiaoling.leetcode.offer;

import com.xiaoling.common.ListNode;

import java.util.Stack;

/**
 * 剑指 Offer 24. 反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *
 * @author xiaoling
 */
public class Offer23 {
    /**
     * 指针交换法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = head;
        ListNode current = head.next;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        head.next = null;
        return prev;
    }

    /**
     * 栈
     *
     * @param head
     * @return
     */
    private ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode temp = stack.pop();
        ListNode p = temp;
        while (!stack.isEmpty()) {
            p.next = stack.pop();
            p = p.next;
        }
        p.next = null;
        return temp;
    }
}
