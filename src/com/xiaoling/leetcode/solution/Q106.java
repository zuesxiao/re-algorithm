package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * @author xiaoling
 */
public class Q106 {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        postIndex = postorder.length - 1;

        return buildTree(postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootValue = postorder[postIndex];
        int currentIndex = inorderMap.get(rootValue);

        postIndex--;
        TreeNode node = new TreeNode(rootValue);
        node.right = buildTree(postorder, currentIndex + 1, end);
        node.left = buildTree(postorder, start, currentIndex - 1);

        return node;
    }
}
