package com.xiaoling.leetcode.offer;

import java.util.HashMap;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 *
 * @author xiaoling
 */
public class Offer35 {
    public void test() {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//
//        node2.random = node1;
//        node3.random = node5;
//        node4.random = node3;
//        node5.random = node1;

        node1.next = node2;
        node1.random = node1;
        node2.random = node1;

        Node copy = copyRandomList(node1);

    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>(0);

        Node res = null;
        Node p1 = null;
        Node p2 = head;

        while (p2 != null) {
            Node newNext;
            Node newRandom;

            if (map.containsKey(p2)) {
                newNext = map.get(p2);
            } else {
                newNext = new Node(p2.val);
                map.put(p2, newNext);
            }

            Node pr1 = newNext;
            Node pr = p2.random;
            while (pr != null) {
                if (map.containsKey(pr)) {
                    newRandom = map.get(pr);
                    pr1.random = newRandom;
                    break;
                } else {
                    newRandom = new Node(pr.val);
                    map.put(pr, newRandom);
                }

                pr1.random = newRandom;
                pr1 = pr1.random;
                pr = pr.random;
            }

            if (res == null) {
                res = newNext;
                p1 = newNext;
            } else {
                p1.next = newNext;
                p1 = p1.next;
            }

            p2 = p2.next;
        }

        return res;
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
