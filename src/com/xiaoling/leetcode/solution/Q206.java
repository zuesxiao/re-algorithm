package com.xiaoling.leetcode.solution;

import com.xiaoling.common.ListNode;

/**
 * @author xiaoling
 */
public class Q206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode temp;

        head.next = null;
        while (true) {
            temp = p2.next;
            p2.next = p1;

            if (temp == null) {
                break;
            }
            p1 = p2;
            p2 = temp;
        }
        return p2;
    }
}
