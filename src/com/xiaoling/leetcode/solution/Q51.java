package com.xiaoling.leetcode.solution;

import java.util.*;

/**
 * 51. N 皇后
 * https://leetcode-cn.com/problems/n-queens/
 *
 * @author xiaoling
 */
public class Q51 {
    private List<List<String>> result;
    Set<Integer> columns = new HashSet<Integer>();
    Set<Integer> diagonals1 = new HashSet<Integer>();
    Set<Integer> diagonals2 = new HashSet<Integer>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        result = new LinkedList<>();

        dfs(board, 0, n);

        return result;
    }

    private void dfs(char[][] board, int row, int n) {
        if (row == n) {
            List<String> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }
            result.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) {
                continue;
            }
            int d1 = row - i;
            if (diagonals1.contains(d1)) {
                continue;
            }
            int d2 = row + i;
            if (diagonals2.contains(d2)) {
                continue;
            }

            board[row][i] = 'Q';
            columns.add(i);
            diagonals1.add(d1);
            diagonals2.add(d2);
            dfs(board, row + 1, n);
            board[row][i] = '.';
            columns.remove(i);
            diagonals1.remove(d1);
            diagonals2.remove(d2);
        }
    }
}
