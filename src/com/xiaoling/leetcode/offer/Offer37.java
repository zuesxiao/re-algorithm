package com.xiaoling.leetcode.offer;

import com.xiaoling.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 37. 序列化二叉树
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 * <p>
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author xiaoling
 */
public class Offer37 {
    public void test() {
        Codec codec = new Codec();
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3,
                        new TreeNode(4),
                        new TreeNode(5)));
        String s = codec.serialize(treeNode);
        System.out.println(s);
//        TreeNode root = codec.deserialize(s);
    }

    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");

            if (root != null) {
                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(root);

                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();

                    if (node == null) {
                        stringBuilder.append("null,");
                    } else {
                        stringBuilder.append(node.val).append(",");
                        queue.offer(node.left);
                        queue.offer(node.right);
                    }
                }
            }

            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.trim().length() <= 2) {
                return null;
            }

            String listStr = data.trim().substring(1, data.length() - 1);
            if (listStr.length() == 0) {
                return null;
            }

            String[] nodeStr = listStr.split(",");
            String nodeValue = nodeStr[0];
            TreeNode root = new TreeNode(Integer.parseInt(nodeValue));

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int index = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (index == nodeStr.length) {
                    break;
                }

                nodeValue = nodeStr[index++];
                if (!nodeValue.equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(nodeValue));
                    queue.offer(node.left);
                }

                if (index == nodeStr.length) {
                    break;
                }
                nodeValue = nodeStr[index++];
                if (!nodeValue.equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(nodeValue));
                    queue.offer(node.right);
                }
            }

            return root;
        }
    }
}
