package com.xiaoling.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiaoling
 */
public class Q117 {
    Queue<Node> queue = new LinkedList<>();

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                Node node = queue.poll();
                if (count > 0) {
                    node.next = queue.peek();
                } else {
                    node.next = null;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    Node prev = null;
    Node nextStart = null;

    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }

        Node start = root;
        while (start != null) {
            prev = null;
            nextStart = null;

            while (start != null) {
                if (start.left != null) {
                    mark(start.left);
                }

                if (start.right != null) {
                    mark(start.right);
                }

                start = start.next;
            }

            start = nextStart;
        }
        return root;
    }

    private void mark(Node node) {
        if (prev != null) {
            prev.next = node;
        }

        if (nextStart == null) {
            nextStart = node;
        }

        prev = node;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
