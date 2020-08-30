package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaoling
 */
public class Q257 {
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> list = new LinkedList<>();
        path(root, "", list);
        return list;
    }

    public void path(TreeNode node, String parentPath, LinkedList<String> list) {
        if (node == null) {
            return;
        }

        parentPath += Integer.toString(node.val);
        if (node.left == null && node.right == null) {
            list.add(parentPath);
        } else {
            parentPath += "->";
            path(node.left, parentPath, list);
            path(node.right, parentPath, list);
        }
    }
}
