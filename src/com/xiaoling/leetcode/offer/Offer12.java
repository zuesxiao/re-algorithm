package com.xiaoling.leetcode.offer;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 *
 * @author xiaoling
 */
public class Offer12 {
    int row, col, length;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        length = word.length();
        char[] chars = word.toCharArray();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, i, j, 0, chars)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int x, int y, int index, char[] chars) {
        if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != chars[index]) {
            return false;
        }

        if (index == length - 1) {
            return true;
        }

        char prev = board[x][y];
        board[x][y] = '-';
        int next = index + 1;
        boolean exists = dfs(board, x + 1, y, next, chars) || dfs(board, x - 1, y, next, chars) || dfs(board, x, y + 1, next, chars) || dfs(board, x, y - 1, next, chars);
        board[x][y] = prev;
        return exists;
    }
}
