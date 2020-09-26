package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 *
 * @author xiaoling
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }

        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int start, int end) {
        if(start == end){
            return true;
        }

        int root = postorder[end];
        int left = start;
        int right = end - 1;

        while (left < right && postorder[left] < root) {
            left++;
        }

        while (left < right && postorder[right] > root) {
            right--;
        }

        if (left == right) {
            return verifyPostorder(postorder, start, left) && verifyPostorder(postorder, right, end - 1);
        }

        return false;
    }
}
