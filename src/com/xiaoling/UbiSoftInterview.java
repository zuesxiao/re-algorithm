package com.xiaoling;

/**
 * 成都育碧笔试题
 * 在一个8X8的矩阵中，如果相邻(上下左右)格子的值相差不超过1，称为连续，就最长连续路径的长度
 *
 * @author xiaoling
 */
public class UbiSoftInterview {
    int[][] steps = {
            {-1, 0},   // 上
            {1, 0},    // 下
            {0, -1},   // 左
            {0, 1},    // 右
    };

    public int findLongestPath(int[][] matrix) {
        int maxLength = Integer.MIN_VALUE;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                maxLength = Integer.max(maxLength, findLongestPath(matrix, new int[8][8], row, col));
            }
        }
        return maxLength;
    }

    private int findLongestPath(int[][] matrix, int[][] visits, int row, int col) {
        visits[row][col] = 1;
        int max = 1;
        for (int[] step : steps) {
            if (isConnected(matrix, visits, row, col, step)) {
                max = Integer.max(max, 1 + findLongestPath(matrix, visits, row + step[0], col + step[1]));
            }
        }
        return max;
    }

    private boolean isConnected(int[][] matrix, int[][] visits, int row, int col, int[] step) {
        int newRow = row + step[0];
        int newCol = col + step[1];
        if (newRow < 0 || newRow >= 8 || newCol < 0 || newCol >= 8 || visits[newRow][newCol] == 1) {
            return false;
        }

        return Math.abs(matrix[row][col] - matrix[newRow][newCol]) <= 1;
    }
}
