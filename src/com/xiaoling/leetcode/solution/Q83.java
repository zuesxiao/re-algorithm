package com.xiaoling.leetcode.solution;

import com.xiaoling.common.ListNode;

/**
 * @author xiaoling
 */
public class Q83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode p = head;

        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return head;
    }
}
