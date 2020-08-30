package com.xiaoling.leetcode.solution;

import com.xiaoling.common.TreeNode;

/**
 * @author xiaoling
 */
public class Q108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return toBST(nums, 0, nums.length - 1);
    }

    public TreeNode toBST(int[] nums, int start, int end) {
        if (end < start) {
            return null;
        }

        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int middle = (start + end + 1) / 2;

        TreeNode root = new TreeNode(nums[middle]);
        root.left = toBST(nums, start, middle - 1);
        root.right = toBST(nums, middle + 1, end);

        return root;
    }
}
