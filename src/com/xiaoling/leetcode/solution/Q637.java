package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xiaoling
 */
public class Q637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            int countOfLevel = queue.size();
            double sum = 0.0;
            for (int i = 0; i < countOfLevel; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
            res.add(sum / countOfLevel);
        }

        return res;
    }
}
