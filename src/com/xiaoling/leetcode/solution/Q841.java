package com.xiaoling.leetcode.solution;

import java.util.List;
import java.util.PriorityQueue;

/**
 * 841. 钥匙和房间
 * https://leetcode-cn.com/problems/keys-and-rooms/
 *
 * @author xiaoling
 */
public class Q841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int total = rooms.size();

        if (total == 1) {
            return true;
        }

        int[] mark = new int[total];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int roomIndex = queue.poll();
            if (mark[roomIndex] == 0) {
                mark[roomIndex] = 1;
                for (int key : rooms.get(roomIndex)) {
                    queue.offer(key);
                }
                total--;
            }
        }
        return total == 0;
    }

    private int[] mark;
    private int totalVisited = 0;

    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        int total = rooms.size();

        if (total == 1) {
            return true;
        }

        mark = new int[total];
        dfs(rooms, 0);
        return totalVisited == total;
    }

    private void dfs(List<List<Integer>> rooms, int room) {
        if (mark[room] == 0) {
            mark[room] = 1;
            totalVisited++;
            for (int key : rooms.get(room)) {
                dfs(rooms, key);
            }
        }
    }
}
