package com.xiaoling.leetcode.solution;

import java.util.Arrays;

/**
 * @author xiaoling
 */
public class Q329 {
    private int[][] maxDistances;
    private int row, col;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        row = matrix.length;
        col = matrix[0].length;
        maxDistances = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(maxDistances[i], 0);
        }

        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (maxDistances[i][j] == 0) {
                    maxDistances[i][j] = touchCell(matrix, i, j);
                }
                max = Math.max(max, maxDistances[i][j]);
            }
        }

        return max;
    }

    private int touchCell(int[][] matrix, int i, int j) {
        int current = matrix[i][j];
        int max = 0;
        if (i - 1 >= 0 && matrix[i - 1][j] > current) {
            if (maxDistances[i - 1][j] == 0) {
                maxDistances[i - 1][j] = touchCell(matrix, i - 1, j);
            }
            max = Math.max(max, maxDistances[i - 1][j] + 1);
        }

        if (i + 1 < row && matrix[i + 1][j] > current) {
            if (maxDistances[i + 1][j] == 0) {
                maxDistances[i + 1][j] = touchCell(matrix, i + 1, j);
            }
            max = Math.max(max, maxDistances[i + 1][j] + 1);
        }

        if (j - 1 >= 0 && matrix[i][j - 1] > current) {
            if (maxDistances[i][j - 1] == 0) {
                maxDistances[i][j - 1] = touchCell(matrix, i, j - 1);
            }
            max = Math.max(max, maxDistances[i][j - 1] + 1);
        }

        if (j + 1 < col && matrix[i][j + 1] > current) {
            if (maxDistances[i][j + 1] == 0) {
                maxDistances[i][j + 1] = touchCell(matrix, i, j + 1);
            }
            max = Math.max(max, maxDistances[i][j + 1] + 1);
        }

        return Math.max(max, 1);
    }
}
