package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 *
 * @author xiaoling
 */
public class Offer47 {
    private int[][] f;

    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        f = new int[row][column];

        f[0][0] = grid[0][0];

        for (int i = 1; i < row; i++) {
            f[i][0] = grid[i][0] + f[i - 1][0];
        }

        for (int i = 1; i < column; i++) {
            f[0][i] = grid[0][i] + f[0][i - 1];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                int current = grid[i][j];
                f[i][j] = Math.max(f[i - 1][j] + current, f[i][j - 1] + current);
            }
        }

        return f[row - 1][column - 1];
    }
}
