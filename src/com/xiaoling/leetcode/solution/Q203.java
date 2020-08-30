package com.xiaoling.leetcode.solution;

import com.xiaoling.common.ListNode;

/**
 * @author xiaoling
 */
public class Q203 {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        ListNode p = head.next;
        while (p != null) {
            if (p.val == val) {
                p = p.next;
                prev.next = p;
            } else {
                prev = p;
                p = p.next;
            }
        }
        return head;
    }
}
