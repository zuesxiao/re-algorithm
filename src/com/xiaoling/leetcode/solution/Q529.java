package com.xiaoling.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xiaoling
 */
public class Q529 {
    private int[] xSteps = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    private int[] ySteps = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    private int xLength = 0, yLength = 0;
    private List<int[]> emptyPoints = new ArrayList<>();

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        xLength = board.length;
        yLength = board[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            if (board[point[0]][point[1]] != 'E') {
                continue;
            }
            int mineCount = countMine(board, point);
            if (mineCount == 0) {
                board[point[0]][point[1]] = 'B';
                for (int[] newPoint : emptyPoints) {
                    queue.offer(newPoint);
                }
            } else {
                board[point[0]][point[1]] = (char) (mineCount + 48);
            }
        }

        return board;
    }

    private int countMine(char[][] board, int[] point) {
        emptyPoints.clear();
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int x = point[0] + xSteps[i];
            int y = point[1] + ySteps[i];

            if (x >= 0 && x < xLength && y >= 0 && y < yLength) {
                if (board[x][y] == 'M') {
                    count++;
                } else if (board[x][y] == 'E') {
                    emptyPoints.add(new int[]{x, y});
                }
            }
        }

        if (count > 0) {
            emptyPoints.clear();
        }

        return count;
    }
}
