package com.xiaoling.leetcode.solution;

/**
 * @author xiaoling
 */
public class Q64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        int[][] distance = new int[row][col];
        distance[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            distance[i][0] = distance[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            distance[0][i] = distance[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                distance[i][j] = Math.min(distance[i - 1][j], distance[i][j - 1]) + grid[i][j];
            }
        }

        return distance[row - 1][col - 1];
    }
}
