package com.xiaoling.leetcode.solution;

import com.xiaoling.common.ListNode;
import com.xiaoling.common.TreeNode;

/**
 * @author xiaoling
 */
public class Q109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val, null, null);
        }

        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode start, ListNode end) {
        ListNode endOfFirstHalf = endOfFirstHalf(start, end);

        if (endOfFirstHalf == null) {
            return null;
        }

        TreeNode root = new TreeNode(endOfFirstHalf.val);
        root.left = sortedListToBST(start, endOfFirstHalf);
        root.right = sortedListToBST(endOfFirstHalf.next, end);
        return root;
    }

    private ListNode endOfFirstHalf(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }

        ListNode slow = start;
        ListNode fast = start;
        while (fast.next != end && fast.next.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
