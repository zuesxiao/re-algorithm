package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q977 {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }

        int length = A.length;
        int separate = 0;
        while (separate < length && A[separate] < 0) {
            separate++;
        }

        int[] res = new int[length];
        int index = 0;
        int left = separate - 1;
        int right = separate;

        while (left >= 0 && right < length) {
            int candidate;
            if (Math.abs(A[left]) < A[right]) {
                candidate = A[left--];
            } else {
                candidate = A[right++];
            }

            res[index++] = candidate * candidate;
        }

        while (left >= 0) {
            res[index++] = A[left] * A[left];
            left--;
        }

        while (right < length) {
            res[index++] = A[right] * A[right];
            right++;
        }

        return res;
    }
}
