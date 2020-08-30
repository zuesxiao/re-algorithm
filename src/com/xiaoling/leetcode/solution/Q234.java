package com.xiaoling.leetcode.solution;

import com.xiaoling.common.ListNode;

/**
 * 如果限制空间复杂度，可以通过额外的的数组空间把值拷贝出来后，通过双指针进行比较
 * 如果限制空间复杂度为O(1),可以通过翻转后半部分列表，在比较前后半部分列表得到答案，最后应该需要回复原链表
 *
 * @author xiaoling
 */
public class Q234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }

        ListNode endOfFirstHalf = endOfFirstHalf(head);
        ListNode secondHalf = reverseList(endOfFirstHalf.next);

        ListNode p1 = head;
        ListNode p2 = secondHalf;
        boolean result = true;
        while (result && p2 != null) {
            result = p1.val == p2.val;
            p1 = p1.next;
            p2 = p2.next;
        }
        endOfFirstHalf.next = reverseList(secondHalf);

        return result;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

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
