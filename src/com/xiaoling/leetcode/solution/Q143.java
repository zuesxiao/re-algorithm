package com.xiaoling.leetcode.solution;

import com.xiaoling.common.ListNode;

import java.util.Stack;

/**
 * @author xiaoling
 */
public class Q143 {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        p = head;
        while (p != null) {
            ListNode next = p.next;
            if(next == null){
                break;
            }

            ListNode last = stack.pop();
            last.next = p.next;
            p.next = last;
            if (next.next == last) {
                next.next = null;
                break;
            } else {
                p = next;
            }
        }
    }
}
