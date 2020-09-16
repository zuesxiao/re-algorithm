package com.xiaoling.leetcode.offer;

import com.xiaoling.common.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *
 * @author xiaoling
 */
public class Offer24 {
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
}
