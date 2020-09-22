package com.xiaoling.leetcode.offer;

/**
 * @author xiaoling
 */
public class Offer35 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        return null;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
