package com.xiaoling.leetcode.offer;

/**
 * @author xiaoling
 */
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int startRow = 0;
        int endRow = rows - 1;
        while (startRow <= endRow) {
            int middle = (startRow + endRow) / 2;
            if (matrix[middle][0] > target) {
                endRow = middle - 1;
            } else if (matrix[middle][0] < target) {
                startRow = middle + 1;
            } else {
                return true;
            }
        }

        int startRow1 = 0;
        int endRow1 = endRow;
        while (startRow1 <= endRow1) {
            int middle = (startRow1 + endRow1) / 2;
            if (matrix[middle][cols - 1] > target) {
                endRow1 = middle - 1;
            } else if (matrix[middle][cols - 1] < target) {
                startRow1 = middle + 1;
            } else {
                return true;
            }
        }

        for (int i = startRow1; i <= endRow; i++) {
            int start = 0;
            int end = cols - 1;
            while (start <= end) {
                int middle = (start + end) / 2;
                if (matrix[i][middle] > target) {
                    end = middle - 1;
                } else if (matrix[i][middle] < target) {
                    start = middle + 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }
}
