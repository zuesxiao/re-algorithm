package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        int p1 = 0, p2 = 0, p = 0;

        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = nums1Copy[p1] < nums2[p2] ? nums1Copy[p1++] : nums2[p2++];
        }

        if (p1 < m) {
            System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }

        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }
}
