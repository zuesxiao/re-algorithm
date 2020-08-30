package com.xiaoling.leetcode.solution;

import com.xiaoling.common.ListNode;

/**
 * @author xiaoling
 */
public class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0 && l1.next == null) {
            return l2;
        }

        if (l2.val == 0 && l2.next == null) {
            return l1;
        }

        int overBit = 0;
        int value = l1.val + l2.val + overBit;
        ListNode result = new ListNode(value % 10);
        overBit = value / 10;

        l1 = l1.next;
        l2 = l2.next;
        ListNode l3 = result;
        while (l1 != null || l2 != null) {
            value = 0;
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            value += overBit;
            l3.next = new ListNode(value % 10);
            l3 = l3.next;
            overBit = value / 10;
        }

        if (overBit > 0) {
            l3.next = new ListNode(overBit);
        }

        return result;
    }
}
