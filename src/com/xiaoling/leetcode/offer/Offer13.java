package com.xiaoling.leetcode.offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 *
 * @author xiaoling
 */
public class Offer13 {
    int[][] steps = new int[][]{
            {0, 1},
            {1, 0},
    };

    public int movingCount(int m, int n, int k) {
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(map[i], 0);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        map[0][0] = 1;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] step : steps) {
                int x = cell[0] + step[0];
                int y = cell[1] + step[1];
                if (camMove(map, m, n, x, y, k)) {
                    count ++;
                    map[x][y] = 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return count;
    }

    private boolean camMove(int[][] map, int m, int n, int x, int y, int k) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }

        if (map[x][y] == 1) {
            return false;
        }

        int sum = 0;

        while (x > 0) {
            sum += x % 10;
            x = x / 10;
        }

        while (y > 0) {
            sum += y % 10;
            y = y / 10;
        }

        return sum <= k;
    }
}
