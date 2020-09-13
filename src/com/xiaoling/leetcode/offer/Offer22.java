package com.xiaoling.leetcode.offer;

import com.xiaoling.common.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 *
 * @author xiaoling
 */
public class Offer22 {
    /**
     * 计数法
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        int total = 0;
        ListNode temp = head;
        while (temp != null) {
            total++;
            temp = temp.next;
        }

        while (total > k) {
            head = head.next;
            total--;
        }
        return head;
    }

    /**
     * 快慢指针法
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd1(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (k-- > 0 && fast != null) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
