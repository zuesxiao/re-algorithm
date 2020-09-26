package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author xiaoling
 */
public class Q105 {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootValue = preorder[preIndex];
        int rootIndex = inorderMap.get(rootValue);

        preIndex++;

        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(preorder, start, rootIndex - 1);
        root.right = buildTree(preorder, rootIndex + 1, end);

        return root;
    }
}
