package com.xiaoling.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiaoling
 */
public class Q52 {
    int res = 0;
    Set<Integer> columns = new HashSet<>();
    Set<Integer> cross1 = new HashSet<>();
    Set<Integer> cross2 = new HashSet<>();

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }

        dfs(n, 0);

        return res;
    }

    private void dfs(int n, int row) {
        if (row == n) {
            res++;
            return;
        }

        for (int j = 0; j < n; j++) {
            if (columns.contains(j)) {
                continue;
            }

            int c1 = row - j;
            if (cross1.contains(c1)) {
                continue;
            }

            int c2 = row + j;
            if (cross2.contains(c2)) {
                continue;
            }

            columns.add(j);
            cross1.add(c1);
            cross2.add(c2);
            dfs(n, row + 1);
            columns.remove(j);
            cross1.remove(c1);
            cross2.remove(c2);
        }
    }
}
