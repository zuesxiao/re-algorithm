package com.xiaoling.leetcode.solution;

import com.xiaoling.common.ListNode;

/**
 * @author xiaoling
 */
public class Q24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode p1 = head;
        ListNode p2 = p1.next;

        head = head.next;

        while (p1 != null && p2 != null) {
            p1.next = p2.next;
            p2.next = p1;

            if (prev != null) {
                prev.next = p2;
            }

            prev = p1;

            p1 = p1.next;
            if (p1 != null) {
                p2 = p1.next;
            }
        }

        return head;
    }
}
