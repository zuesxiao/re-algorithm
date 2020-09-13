package com.xiaoling.leetcode.solution;

/**
 * 79. 单词搜索
 * https://leetcode-cn.com/problems/word-search/
 *
 * @author xiaoling
 */
public class Q79 {
    int row, col;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        char[] chars = word.toCharArray();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, i, j, chars, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int x, int y, char[] chars, int index) {
        if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != chars[index]) {
            return false;
        }

        if (index == chars.length - 1) {
            return true;
        }

        char temp = board[x][y];
        board[x][y] = '.';
        boolean res = dfs(board, x + 1, y, chars, index + 1)
                || dfs(board, x - 1, y, chars, index + 1)
                || dfs(board, x, y + 1, chars, index + 1)
                || dfs(board, x, y - 1, chars, index + 1);
        board[x][y] = temp;
        return res;
    }
}
