package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 *
 * @author xiaoling
 */
public class Offer29 {
    int[][] steps = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    /**
     * 按顺序模拟
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;

        if (row == 0) {
            return new int[0];
        }

        int col = matrix[0].length;

        if (col == 0) {
            return new int[0];
        }

        int[][] mark = new int[row][col];
        int total = row * col;
        int[] res = new int[row * col];

        int stepIndex = 0;
        int index = 0;
        int x = 0, y = 0;

        while (index < total) {
            res[index++] = matrix[x][y];
            mark[x][y] = 1;

            if (trun(x + steps[stepIndex][0], y + steps[stepIndex][1], row, col, mark)) {
                stepIndex = (stepIndex + 1) % 4;
            }

            x = x + steps[stepIndex][0];
            y = y + steps[stepIndex][1];
        }

        return res;
    }

    private boolean trun(int x, int y, int row, int col, int[][] mark) {
        return x < 0 || x >= row || y < 0 || y >= col || mark[x][y] == 1;
    }

    /**
     * 安层模拟
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
