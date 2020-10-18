package com.xiaoling.leetcode.solution;

import com.xiaoling.common.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author xiaoling
 */
public class Q19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            prev = p2;
            p2 = p2.next;
        }

        if (prev == null) {
            head = p2.next;
        } else {
            prev.next = p2.next;
        }

        return head;
    }
}
