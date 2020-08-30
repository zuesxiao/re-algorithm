package com.xiaoling.leetcode.solution;

import java.util.*;

/**
 * TODO
 *
 * @author xiaoling
 */
public class Qlcp13 {
    int[][] steps = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    private int rows, cols;
    Cell shortestCell = null;
    char[][] map;

    public int minimalSteps(String[] maze) {
        if (maze.length <= 0 || maze[0].length() <= 0) {
            return -1;
        }

        rows = maze.length;
        cols = maze[0].length();
        map = new char[rows][cols];

        Cell s = null;
        Cell t = null;
        List<Cell> o = new ArrayList<>();
        List<Cell> m = new ArrayList<>();

        for (int j = 0; j < rows; j++) {
            String row = maze[j];
            for (int i = 0; i < row.length(); i++) {
                char c = row.charAt(i);
                if (c == 'S') {
                    s = new Cell(j, i);
                } else if (c == 'T') {
                    t = new Cell(j, i);
                } else if (c == 'M') {
                    m.add(new Cell(j, i));
                } else if (c == 'O') {
                    o.add(new Cell(j, i));
                }

                map[j][i] = c;
            }
        }

        if (s == null || t == null || (o.isEmpty() && !m.isEmpty())) {
            return -1;
        }

        if (m.isEmpty()) {
            return shortest(s, t);
        }

        int result = 0;
        Cell current = s;

        int startToO = shortest(current, o);
        if (shortestCell == null) {
            return -1;
        } else {
            current = shortestCell;
            result += startToO;
        }

        while (true) {
            int currentToM = shortest(current, m);
            if (shortestCell == null) {
                return -1;
            } else {
                result += currentToM;
                current = shortestCell;
                m.remove(current);
            }

            if (m.isEmpty()) {
                break;
            }

            int currentToO = shortest(current, o);
            result += currentToO;
            current = shortestCell;
        }

        return result + shortest(current, t);
    }

    private int shortest(Cell start, List<Cell> cells) {
        shortestCell = null;
        int pathLength = Integer.MAX_VALUE;
        for (Cell cell : cells) {
            int tmpLength = shortest(start, cell);
            if (tmpLength > -1 && tmpLength < pathLength) {
                shortestCell = cell;
                pathLength = tmpLength;
            }
        }

        return pathLength;
    }

    private int shortest(Cell start, Cell end) {
        Queue<Cell> openList = new PriorityQueue<>();
        Set<Cell> closeList = new HashSet<>();

        openList.offer(start);

        while (!openList.isEmpty()) {
            Cell current = openList.poll();

            if (current.equals(end)) {
                return current.f;
            }

            closeList.add(current);

            for (int i = 0; i < 4; i++) {
                int[] step = steps[i];
                Cell neighbor = new Cell(current.x + step[0], current.y + step[1]);

                if (!closeList.contains(neighbor) && neighbor.x >= 0 && neighbor.x < rows && neighbor.y >= 0 && neighbor.y < cols && map[neighbor.x][neighbor.y] != '#') {
                    neighbor.g = current.g + 1;
                    neighbor.f = neighbor.g + Math.abs(neighbor.x - end.x) + Math.abs(neighbor.y - end.y);
                    openList.offer(neighbor);
                }
            }
        }

        return -1;
    }

    private static class Cell implements Comparable<Cell> {
        int x;
        int y;
        int f;
        int g;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
            this.f = 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Cell cell = (Cell) o;
            return x == cell.x && y == cell.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public int compareTo(Cell o) {
            return f - o.f;
        }
    }
}
