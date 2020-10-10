package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 *
 * @author xiaoling
 */
public class Offer36 {
    Node prev, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        dfs(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    private void dfs(Node current) {
        if (current == null) {
            return;
        }

        dfs(current.left);

        if (prev == null) {
            head = current;
        } else {
            prev.right = current;
        }
        current.left = prev;
        prev = current;

        dfs(current.right);
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
