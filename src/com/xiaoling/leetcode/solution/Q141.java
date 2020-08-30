package com.xiaoling.leetcode.solution;

import com.xiaoling.common.ListNode;

/**
 * @author xiaoling
 */
public class Q141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (true) {
            if (p1 == p2) {
                return true;
            }

            if (p1.next == null) {
                return false;
            } else {
                p1 = p1.next;
            }

            if (p2.next == null || p2.next.next == null) {
                return false;
            } else {
                p2 = p2.next.next;
            }
        }
    }
}
