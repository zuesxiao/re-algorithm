package com.xiaoling.leetcode.solution;

import com.xiaoling.common.ListNode;

/**
 * @author xiaoling
 */
public class Q237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
