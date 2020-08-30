package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xiaoling
 */
public class Q107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> leftList = levelOrderBottom(root.left);
        List<List<Integer>> rightList = levelOrderBottom(root.right);

        List<List<Integer>> result = new ArrayList<>(merge(leftList, rightList));

        List<Integer> list = new ArrayList<>();
        list.add(root.val);

        result.add(list);

        return result;
    }

    public List<List<Integer>> bfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int countOfLevel = queue.size();

            List<Integer> list = new ArrayList<>();
            while (countOfLevel > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                countOfLevel--;
            }
            result.add(0, list);
        }

        return result;
    }

    private List<List<Integer>> merge(List<List<Integer>> left, List<List<Integer>> right) {
        List<List<Integer>> result = new ArrayList<>();

        int p1 = left.size() - 1;
        int p2 = right.size() - 1;

        while (p1 >= 0 || p2 >= 0) {
            List<Integer> list = new ArrayList<>();

            if (p1 >= 0) {
                list.addAll(left.get(p1--));
            }

            if (p2 >= 0) {
                list.addAll(right.get(p2--));
            }

            result.add(0, list);
        }

        return result;
    }
}
