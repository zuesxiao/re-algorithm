package com.xiaoling.leetcode.solution;

import com.xiaoling.common.ListNode;

/**
 * 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author xiaoling
 */
public class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        if (p1 == null || p2 == null) {
            return null;
        }

        while (true) {
            if (p1 == p2) {
                return p1;
            }

            if (p1.next == null && p2.next == null) {
                break;
            }

            if (p1.next == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if (p2.next == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }

        return null;
    }
}
