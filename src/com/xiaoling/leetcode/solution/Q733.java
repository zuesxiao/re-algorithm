package com.xiaoling.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiaoling
 */
public class Q733 {
    int[][] steps = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0 || image[0].length == 0) {
            return image;
        }

        int xLength = image.length;
        int yLength = image[0].length;
        int color = image[sr][sc];
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{sr, sc});

        while (!queue.isEmpty()) {
            Integer[] position = queue.poll();
            if (image[position[0]][position[1]] != newColor) {
                image[position[0]][position[1]] = newColor;
                for (int[] step : steps) {
                    int x = position[0] + step[0];
                    int y = position[1] + step[1];
                    if (x >= 0 && x < xLength && y >= 0 && y < yLength && image[x][y] == color) {
                        queue.offer(new Integer[]{x, y});
                    }
                }
            }
        }

        return image;
    }
}
