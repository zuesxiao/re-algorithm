package com.xiaoling.leetcode.offer;

import com.xiaoling.common.ListNode;

/**
 * @author xiaoling
 */
public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return head.next;
        }

        ListNode prev = head;
        ListNode temp = head.next;

        while (temp != null) {
            if (temp.val == val) {
                prev.next = temp.next;
                break;
            }

            prev = temp;
            temp = temp.next;
        }

        return head;
    }
}
