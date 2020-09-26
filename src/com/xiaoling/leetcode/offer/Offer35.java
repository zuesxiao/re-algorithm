package com.xiaoling.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoling
 */
public class Offer35 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

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
