package com.xiaoling.leetcode.solution;

import com.xiaoling.common.VersionControl;

/**
 * @author xiaoling
 */
public class Q278 extends VersionControl {
    public int firstBadVersion(int n) {
        long left = 1;
        long right = n;
        while (left < right) {
            long middle = (left + right) / 2;
            if (isBadVersion((int)middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return (int)left;
    }
}