package com.xiaoling.leetcode.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaoling
 */
public class Q37 {
    private boolean[][] lines = new boolean[9][9];
    private boolean[][] columns = new boolean[9][9];
    private boolean[][][] blocks = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> emptyCell = new LinkedList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int value = board[i][j] - '0' - 1;
                    lines[i][value] = true;
                    columns[value][j] = true;
                    blocks[i / 3][j / 3][value] = true;
                } else {
                    emptyCell.add(new int[]{i, j});
                }
            }
        }

        dfs(board, 0);
    }

    private void dfs(char[][] board, int index) {
        if (index == emptyCell.size()) {
            valid = true;
            return;
        }

        int[] cell = emptyCell.get(index);
        int x = cell[0];
        int y = cell[1];

        for (int i = 0; i < 9 && !valid; i++) {
            if (!lines[x][i] && !columns[i][y] && !blocks[x / 3][y / 3][i]) {
                lines[x][i] = true;
                columns[i][y] = true;
                blocks[x / 3][y / 3][i] = true;
                board[x][y] = (char)(i + '0' + 1);
                dfs(board, index + 1);
                lines[x][i] = false;
                columns[i][y] = false;
                blocks[x / 3][y / 3][i] = false;
            }
        }
    }
}
