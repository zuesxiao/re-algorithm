package com.xiaoling.leetcode.solution;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @author xiaoling
 */
public class Q116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node start = root;

        while (start.left != null) {
            Node p = start;
            Node prev = null;

            while (p != null) {
                if (prev == null) {
                    prev = p.left;
                } else {
                    prev.next = p.left;
                    prev = prev.next;
                }

                prev.next = p.right;
                prev = prev.next;

                p = p.next;
            }

            start = start.left;
        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
